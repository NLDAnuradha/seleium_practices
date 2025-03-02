import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextInputTest {

    WebDriver driver;

    @BeforeMethod
    public void openLikPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("130");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void textBoxTests(){
        //type your name
        driver.findElement(By.id("j_idt88:name")).sendKeys("AnuJ");
        driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("India");
        boolean enabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is text box enables " + enabled);
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();
        WebElement testElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = testElement.getAttribute("value");
        System.out.println(value);
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("abc@gmail.com" + Keys.TAB + "Confirmed control moved to next element");
        
    }

}
