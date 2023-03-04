package parser.citilink;

import app.config.ConfigDB;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ParserVideoCard {
    public void parser() throws SQLException {
        ChromeOptions options = new ChromeOptions();
        String URL = "https://www.citilink.ru/catalog/videokarty/";

        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        List<WebElement> req = driver.findElements(By.cssSelector(".app-catalog-1bogmvw"));

        deleteRaw();

        for (WebElement element: req) {
            String cost = element.findElement(By.cssSelector("div div span span span")).getText();
            List<WebElement> li = element.findElements(By.cssSelector("li"));

            add(get(li), Double.parseDouble(cost.replaceAll("\\s+","")), ConfigDB.connection(), URL, driver);
        }
        driver.quit();
    }

    @NotNull
    private List<String> get(@NotNull List<WebElement> webElementList) {
        final List<String> output = new ArrayList<>();
        String nameAndFreq = webElementList.get(0).getAttribute("innerText");
        String memory = webElementList.get(1).getAttribute("innerText");

        nameAndFreq = nameAndFreq.substring(nameAndFreq.indexOf(":") + 1);

        String[] params = nameAndFreq.split(", ");

        output.add(params[0].trim().substring(1));
        output.add(params[1].split(" ")[0] + " MHz");
        output.add(memory.split(":")[1].split(" ")[0].substring(1));

        return output;
    }

    private void add(@NotNull List<String> info, Double cost, @NotNull Connection connection, @NotNull String url, @NotNull WebDriver driver) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO videocard " +
                    "(name, cost, url, memory, frequency) VALUES (?, ?, ?, ?, ?)");

            statement.setString(1, info.get(0));
            statement.setDouble(2, cost);
            statement.setString(3, url);
            statement.setString(4, info.get(2));
            statement.setString(5, info.get(1));

            statement.executeUpdate();
        } catch (SQLException e) {
            driver.quit();
            throw new RuntimeException(e);
        }
    }

    private void deleteRaw() {
        try {
            String SQLDelete = "DELETE FROM videocard";
            Statement delete = ConfigDB.connection().createStatement();

            delete.executeUpdate(SQLDelete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
