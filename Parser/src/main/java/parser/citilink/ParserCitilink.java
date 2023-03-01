package parser.citilink;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ParserCitilink {
    public void parser() {
//        Document document = Jsoup.connect("https://www.citilink.ru/catalog/videokarty/")
//                .userAgent("Chrome/81.0.4044.138")
//                .referrer("http://www.google.com")
//                .get();
//
//        Elements videocards = document.select("div.app-catalog-1o4umte.eevw8x70"); //div.e12wdlvo0.app-catalog-1bogmvw.e1loosed0      span.e4qu3681.e106ikdt0.app-catalog-5wkwgp.e1gjr6xo0
//
//        for (Element videocard:videocards) {
//            System.out.println(videocard);
//        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.citilink.ru/catalog/videokarty/");
        driver.quit();
    }
}
