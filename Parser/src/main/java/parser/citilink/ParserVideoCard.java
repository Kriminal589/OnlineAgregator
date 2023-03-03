package parser.citilink;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class ParserVideoCard {
    public void parser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.citilink.ru/catalog/videokarty/");
        List<WebElement> req = driver.findElements(By.cssSelector(".app-catalog-1bogmvw"));
        for (WebElement element: req) {
            String cost = element.findElement(By.cssSelector("div div span span span")).getText();

            List<WebElement> li = element.findElements(By.cssSelector("li"));
            System.out.println(get(li) + " " + cost);
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
}
