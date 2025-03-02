import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.CodeSource;

public class MouseActionTest {
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
    public void mouseActionTest() throws InterruptedException {
        driver.get("https://www.leafground.com/drag.xhtml");

        System.out.println("1. <<<<<<<<<<<<<move to an element operation>>>>>>>>>>");
        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
//        Thread.sleep(2000);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
//        Thread.sleep(2000);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();
//        Thread.sleep(2000);

        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37")))
                .moveToElement(driver.findElement(By.id("menuform:j_idt38")))
                .moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();

        System.out.println("2. <<<<<<<<<<<drag and drop operation>>>>>>>>>>>>>>");
        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drag"));

        // actions.clickAndHold(from).moveToElement(to).release().perform(); //1st way
        actions.dragAndDrop(from, to).perform(); //2nd way
        Thread.sleep(3000);

        System.out.println("3. <<<<<<<<<<slider operation>>>>>>>>>>>>>");
        WebElement sliderPoint1 = driver.findElement(By.xpath("//*[@id='form:j_idt125']/span[1]"));
        System.out.println("Location of slider point 1 before moving :" + sliderPoint1.getLocation());
        actions.dragAndDropBy(sliderPoint1, 50, 0).perform();
        System.out.println("Location of slider point 1 after moving :" + sliderPoint1.getLocation());

    }

    @Test
    public void mouseOperationTest() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        System.out.println("4. <<<<<<<<<<<<<right click operation>>>>>>>>>>");

        WebElement rightClick = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions actions1 = new Actions(driver);
        actions1.contextClick(rightClick).perform(); //right click --> contextClick
        //actions1.doubleClick(rightClick).perform();    // double-click
        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        Alert popup = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println("Alert shows the text as : " + popup.getText());
        popup.accept();

    }
}
