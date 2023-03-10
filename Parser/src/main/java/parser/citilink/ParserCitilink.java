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
        options.addArguments("--no-startup-window");

        WebDriver driver = new ChromeDriver();

        parseVideocard(connection, driver);
        parseMotherboard(connection, driver);
        parsePowerSupply(connection, driver);
        parseProcessor(connection, driver);
        parseRAM(connection, driver);
        parseROM(connection, driver);

        driver.quit();
    }

    public void parseVideocard(@NotNull Connection connection, @NotNull WebDriver driver) {

        final String URL = "https://www.citilink.ru/catalog/videokarty/";
        driver.get(URL);

        try {
            List<WebElement> req = driver.findElements(By.cssSelector(".app-catalog-1bogmvw"));
            for (int i = 0; i < req.size(); i++) {
                WebElement element = req.get(i);
                String cost = element.findElement(By.cssSelector("span.app-catalog-j8h82j")).getText();
                List<WebElement> li = element.findElements(By.cssSelector("li"));

                if (i == 0) {
                    deleteRaw(connection, this.count);
                }

                insert.addVideocard(mapper.getVideocard(li), Double.parseDouble(cost.replaceAll("\\s+","")), connection, URL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseMotherboard(@NotNull Connection connection, @NotNull WebDriver driver) {

        final String URL = "https://www.citilink.ru/catalog/materinskie-platy";

        try {
            driver.get(URL);
            this.count++;

            List<WebElement> req = driver.findElements(By.cssSelector(".app-catalog-1bogmvw"));

            for (int i = 0; i < req.size(); i++) {
                WebElement element = req.get(i);
                String cost = element.findElement(By.cssSelector("span.app-catalog-j8h82j")).getText();
                String name = element.findElement(By.cssSelector(".app-catalog-9gnskf")).getText();
                List<WebElement> li = element.findElements(By.cssSelector("li"));

                name = name.substring(18);

                if (i == 0) {
                    deleteRaw(connection, this.count);
                }

                insert.addMotherboard(mapper.getMotherboard(li), Double.parseDouble(cost.replaceAll("\\s+","")), connection, URL, name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseProcessor(@NotNull Connection connection, @NotNull WebDriver driver) {

        final String URL = "https://www.citilink.ru/catalog/processory";

        try {
            driver.get(URL);
            this.count++;

            List<WebElement> req = driver.findElements(By.cssSelector(".app-catalog-1bogmvw"));

            for (int i = 0; i < req.size(); i++) {
                WebElement element = req.get(i);
                String cost = element.findElement(By.cssSelector("span.app-catalog-j8h82j")).getText();
                String name = element.findElement(By.cssSelector(".app-catalog-9gnskf")).getText();
                List<WebElement> li = element.findElements(By.cssSelector("li"));

                name = name.substring(10);

                if (i == 0) {
                    deleteRaw(connection, this.count);
                }

                insert.addProcessor(name, connection, URL, Double.parseDouble(cost.replaceAll("\\s+","")), mapper.getProcessor(li));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parsePowerSupply(@NotNull Connection connection, @NotNull WebDriver driver) {

        final String URL = "https://www.citilink.ru/catalog/bloki-pitaniya";

        try {
            driver.get(URL);
            this.count++;

            List<WebElement> req = driver.findElements(By.cssSelector(".app-catalog-1bogmvw"));

            for (int i = 0; i < req.size(); i++) {
                WebElement element = req.get(i);
                String cost = element.findElement(By.cssSelector("span.app-catalog-j8h82j")).getText();
                String name = element.findElement(By.cssSelector(".app-catalog-1tp0ino")).getText();

                name = name.substring(13, name.indexOf(","));

                List<WebElement> li = element.findElements(By.cssSelector("li"));

                if (i == 0) {
                    deleteRaw(connection, this.count);
                }

                insert.addPowerSupply(name, connection, URL, Double.parseDouble(cost.replaceAll("\\s+","")), mapper.getPowerSupply(li));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseRAM(@NotNull Connection connection, @NotNull WebDriver driver) {

        final String URL = "https://www.citilink.ru/catalog/moduli-pamyati";

        try {
            driver.get(URL);
            this.count++;

            List<WebElement> req = driver.findElements(By.cssSelector(".app-catalog-1bogmvw"));

            for (int i = 0; i < req.size(); i++) {
                WebElement element = req.get(i);

                String cost = element.findElement(By.cssSelector(".app-catalog-175fskm")).getText();
                String title = element.findElement(By.cssSelector("a")).getAttribute("title");

                if (i == 0) {
                    deleteRaw(connection, this.count);
                }

                if (!title.contains("DDR2")) {
                    insert.addRAM(mapper.getRAM(title), connection, URL, Double.parseDouble(cost.replaceAll("\\s+","")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseROM(@NotNull Connection connection, @NotNull WebDriver driver) {
        this.count = 5;
        deleteRaw(connection, this.count);
        getHDD(connection, driver);
        getSSD(connection, driver);
    }

    private void getHDD(@NotNull Connection connection, @NotNull WebDriver driver) {
        final String URL = "https://www.citilink.ru/catalog/zhestkie-diski";

        try {
            driver.get(URL);

            List<WebElement> req = driver.findElements(By.cssSelector(".app-catalog-1bogmvw"));

            for (WebElement element : req) {
                String name = element.findElement(By.cssSelector("a.app-catalog-9gnskf")).getText();
                String cost = element.findElement(By.cssSelector("span.app-catalog-j8h82j")).getText();
                List<WebElement> li = element.findElements(By.cssSelector("li"));

                name = name.substring(13);

                insert.addROM(name, mapper.getRomHDD(li), connection, URL, Double.parseDouble(cost.replaceAll("\\s+","")), "HDD");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getSSD(@NotNull Connection connection, @NotNull WebDriver driver) {

    }

    private void deleteRaw(@NotNull Connection connection, int count) {
        String request = "DELETE FROM " + names.get(count);

        try {
            PreparedStatement statement = connection.prepareStatement(request);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
