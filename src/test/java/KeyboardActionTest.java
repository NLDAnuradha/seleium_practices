import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class KeyboardActionTest {
    WebDriver driver;

    @BeforeMethod
    public void openLikPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("130");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void keyboardActionTest() throws InterruptedException{
        driver.get("https://www.google.com");

        WebElement searchBar = driver.findElement(By.name("q"));
        //searchBar.sendKeys("welcome");

        Actions actions = new Actions(driver);
        //select the text
        //actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

       // Thread.sleep(5000);

//        actions.keyDown(Keys.SHIFT)
//                .sendKeys("writing capital sentence").perform();
//
//        Thread.sleep(5000);
//
//        actions.keyUp(Keys.SHIFT)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("a")
//                .keyUp(Keys.CONTROL)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("x")
//                .build().perform();

        //to write in capital in a text box
        actions.keyDown(searchBar, Keys.SHIFT)
                .sendKeys("learn with me").perform();
    }

    @Test
    public void keyBoardActionTest1() throws InterruptedException {

        driver.get("https://www.leafground.com/list.xhtml");
        Thread.sleep(3000);

        List<WebElement> list = driver.findElements(By.xpath("//ul[@aria-label='From'/li]"));
        int size = list.size();
        System.out.println(" List size :" +size);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(list.get(0))
                .click(list.get(1))
                .perform();
    }
}
