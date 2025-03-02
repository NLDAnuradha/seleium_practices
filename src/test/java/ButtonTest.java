import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonTest {
    WebDriver driver;

    @BeforeMethod
    public void openLikPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("130");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonTests(){
        //click and confirm title
        driver.findElement(By.xpath("//*[@id='j_idt88:j_idt90']/span")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
//        if (expectedTitle.equals(actualTitle)){
//            System.out.println("Actual Title same as expected");
//        } else {
//            System.out.println("Actual Title not same as expected");
//        }
        Assert.assertEquals(actualTitle,expectedTitle,"Title miss matched");
        driver.navigate().back();
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPath = getPosition.getLocation();
        int x = xyPath.getX();
        int y = xyPath.getY();
        System.out.println("x position is: " + x + "Y position is: " + y);
        WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt96"));
        String color = buttonColor.getCssValue("background");
        System.out.println("Button color:" + color);


        WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("Heidht:" + height + "Width:" + width);
    }
}
