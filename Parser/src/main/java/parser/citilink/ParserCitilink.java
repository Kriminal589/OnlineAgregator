package parser.citilink;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.IOException;

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

        WebDriver driver = new OperaDriver();
        driver.get("https://www.citilink.ru/catalog/videokarty/");
    }
}
