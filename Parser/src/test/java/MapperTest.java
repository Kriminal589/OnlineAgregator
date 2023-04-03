import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import parser.citilink.Mapper;

import java.util.ArrayList;
import java.util.List;

public class MapperTest {
    static Mapper mapper;
    static WebDriver driver;
    static List<WebElement> motherboard;
    static List<WebElement> videocard;
    static List<WebElement> processor;
    static List<WebElement> powerSupply;
//    static List<WebElement> ram;
//    static List<WebElement> rom;

    @BeforeAll
    public static void setMapper() {
        mapper = new Mapper();
    }

    @BeforeAll
    public static void setDriver() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-startup-window");

        driver = new ChromeDriver();
    }

    @BeforeAll
    public static void getWebElementMotherboard() {
        setDriver();

        final String urlMotherboard = "https://www.citilink.ru/catalog/materinskie-platy";
        driver.get(urlMotherboard);
        motherboard = driver.findElement(By.cssSelector(".app-catalog-1bogmvw")).findElements(By.cssSelector("li"));
        driver.quit();
    }

    @BeforeAll
    public static void getWebElementProcessor() {
        setDriver();

        final String urlProcessor = "https://www.citilink.ru/catalog/processory";
        driver.get(urlProcessor);
        processor = driver.findElement(By.cssSelector(".app-catalog-1bogmvw")).findElements(By.cssSelector("li"));
        driver.quit();
    }

    @BeforeAll
    public static void getWebElementVideocard() {
        setDriver();

        final String urlVideocard = "https://www.citilink.ru/catalog/videokarty";
        driver.get(urlVideocard);
        videocard = driver.findElement(By.cssSelector(".app-catalog-1bogmvw")).findElements(By.cssSelector("li"));
        driver.quit();
    }

//    @BeforeAll
//    public static void getWebElementROM() {
//        setDriver();
//
//        final String urlROM = "https://www.citilink.ru/catalog/zhestkie-diski";
//        driver.get(urlROM);
//        rom = driver.findElement(By.cssSelector(".app-catalog-1bogmvw")).findElements(By.cssSelector("li"));
//    }

    @BeforeAll
    public static void getWebElementPower() {
        setDriver();

        final String urlPower = "https://www.citilink.ru/catalog/bloki-pitaniya";
        driver.get(urlPower);
        powerSupply = driver.findElement(By.cssSelector(".app-catalog-1bogmvw")).findElements(By.cssSelector("li"));
        driver.quit();
    }

//    @BeforeAll
//    public static void getWebElementRAM() {
//        setDriver();
//
//        final String urlRAM = "https://www.citilink.ru/catalog/moduli-pamyati";
//        driver.get(urlRAM);
//        ram = driver.findElement(By.cssSelector(".app-catalog-1bogmvw")).findElements(By.cssSelector("li"));
//    }

    @Test
    void getVideocardTest() {
        List<String> res = mapper.getVideocard(videocard);

        List<String> check = new ArrayList<>();
        check.add("Palit NVIDIA GeForce RTX 3060");
        check.add("1320 MHz");
        check.add("12");

        Assertions.assertEquals(res, check);
    }
}
