package WaitTypes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitTest {
    WebDriver driver;

    @BeforeMethod
    public void openLikPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("130");
        driver = new ChromeDriver(chromeOptions);
        //implicit-wait is affected to every element. no need to add sleep step by step
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.leafground.com/waits.xhtml");
    }

    @Test
    public void implicitWaitTest(){

        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();

        String newButton = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span")).getText();
        System.out.println("New Button is :" +newButton);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
