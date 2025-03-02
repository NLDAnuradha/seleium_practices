import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest {
    WebDriver driver;

    @BeforeMethod
    public void openLikPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("130");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void alertExampleTest() throws InterruptedException {
        //Simple dialog alert
        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

        //Confirm alert dialog
        WebElement alertConfirmBox = driver.findElement(By.id("j_idt88:j_idt93"));
        alertConfirmBox.click();
        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(3000);
        alert1.dismiss();

        //prompt alert dialog
        WebElement alertPropmtBox = driver.findElement(By.id("j_idt88:j_idt104"));
        alertPropmtBox.click();
        Alert alert2 = driver.switchTo().alert();
        String alertText = alert2.getText();
        System.out.println("Alert text is :" +alertText);
        alert2.sendKeys("My name is A");
        Thread.sleep(3000);
        alert2.accept();
    }
}
