package WaitTypes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {
    WebDriver driver;

    @BeforeMethod
    public void openLikPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("130");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.leafground.com/waits.xhtml");
    }

    @Test
    public void fluentWaitTest(){

        //declaration (default fluent wait)
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))  //maximum time to wait
                .pollingEvery(Duration.ofSeconds(5))  //frequency to check the condition
                .ignoring(NoSuchElementException.class);   //ignore specific expectations

        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();

        WebElement fluentElement = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span"));
            }
        });

        String newButton = fluentElement.getText();
        System.out.println("New Button is :" +newButton);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
