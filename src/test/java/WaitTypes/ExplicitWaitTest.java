package WaitTypes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitTest {
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
    public void explicitWaitTest(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();

        By newbtnLocator = By.xpath("//button[@id='j_idt87:j_idt90']/span");

        WebElement NewBtnElement = wait.until(ExpectedConditions.visibilityOfElementLocated(newbtnLocator));

        String newButton = NewBtnElement.getText();

        System.out.println("New Button is :" +newButton);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
