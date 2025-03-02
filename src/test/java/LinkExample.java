import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {
    WebDriver driver;

    @BeforeMethod
    public void openLikPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTest(){
        //Take me to the Dashboard
        WebElement homelink = driver.findElement(By.linkText("Go to Dashboard"));
        homelink.click();
        driver.navigate().back();

        //find my destination
        WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = wheretoGo.getAttribute("href");
        System.out.println("This is link going to:" + path);

        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if (title.contains("404")) {
            System.out.println("The Link is Broken");
        } else {
            System.out.println("not Broken");
        }
        driver.navigate().back();

        //Duplicate Links
        WebElement homelink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homelink1.click();
        driver.navigate().back();

        //count links
       List<WebElement> countElements = driver.findElements(By.tagName("a"));
       int pagecount = countElements.size();
        System.out.println("count of links:" + pagecount);

        //count logout links
        WebElement lauoytelement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countLayoutLinks = lauoytelement.findElements(By.tagName("a"));
        System.out.println("Count of lauout Links:" + countLayoutLinks.size());
    }
}
