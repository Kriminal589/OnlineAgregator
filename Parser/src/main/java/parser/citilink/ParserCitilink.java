package parser.citilink;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ParserCitilink {
    public void parser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.citilink.ru/catalog/videokarty/");
        WebElement element = driver.findElement(By.className("//div[contains(text(),'Send')]")); //"e1lmhh4u0 app-catalog-15ltso4 e1loosed0"
        System.out.println(element);
        driver.quit();
    }
}
