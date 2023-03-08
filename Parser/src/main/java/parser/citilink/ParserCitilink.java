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
import java.util.ArrayList;
import java.util.List;

public class ParserCitilink {
    private final List<String> names;
    private final Mapper mapper;
    private final Insert insert;
    private Integer count = 0;

    public ParserCitilink() {
        this.mapper = new Mapper();
        this.insert = new Insert();
        this.names = new ArrayList<>();

        this.names.add("videocard");
        this.names.add("motherboard");
        this.names.add("power_supply");
        this.names.add("processor");
        this.names.add("ram");
        this.names.add("rom");
    }

    public void parsAll() throws SQLException {
        Connection connection = ConfigDB.connection();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver();

        parseVideocard(connection, driver);
        parseMotherboard(connection, driver);

        driver.quit();
    }

    public void parseVideocard(@NotNull Connection connection, @NotNull WebDriver driver) {

        String URL = "https://www.citilink.ru/catalog/videokarty/";

        try {
            driver.get(URL);

            List<WebElement> req = driver.findElements(By.cssSelector(".app-catalog-1bogmvw"));

            deleteRaw(connection);

            for (WebElement element: req) {
                String cost = element.findElement(By.cssSelector("div div span span span")).getText();
                List<WebElement> li = element.findElements(By.cssSelector("li"));

                insert.addVideocard(mapper.getVideocard(li), Double.parseDouble(cost.replaceAll("\\s+","")), connection, URL, driver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseMotherboard(@NotNull Connection connection, @NotNull WebDriver driver) {

        String URL = "https://www.citilink.ru/catalog/materinskie-platy";

        try {
            driver.get(URL);

            List<WebElement> req = driver.findElements(By.cssSelector(".app-catalog-1bogmvw"));

            deleteRaw(connection);

            for (WebElement element: req) {
                String cost = element.findElement(By.cssSelector("div div span span span")).getText();
                String name = element.findElement(By.cssSelector(".app-catalog-1tp0ino")).getText();
                List<WebElement> li = element.findElements(By.cssSelector("li"));

                insert.addMotherboard(mapper.getMotherboard(li), Double.parseDouble(cost.replaceAll("\\s+","")), connection, URL, driver, name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteRaw(@NotNull Connection connection) {
        String request = "DELETE FROM " + names.get(count);
        count++;

        try {
            PreparedStatement statement = connection.prepareStatement(request);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
