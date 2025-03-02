import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameiFrameTest {
    WebDriver driver;

    @BeforeMethod
    public void openLikPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("130");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void frameTest(){

//        Frame --> driver.switchTo().frame();
//        Window --> driver.switchTo().window();
//        Alert --> driver.switchTo().alert();

        driver.switchTo().frame(0);
        WebElement clickMe = driver.findElement(By.xpath("//*[@id='Click']"));
        clickMe.click();

        String afterClickButton = clickMe.getText();
        System.out.println("After click inside frame button text :" + afterClickButton);

        //click me (inside nested frames)
        driver.switchTo().defaultContent(); //back to main html page
        driver.switchTo().frame(2); //inside into 3rd frame --> child frame
        driver.switchTo().frame("frame2");

        WebElement button3 = driver.findElement(By.id("click"));
        button3.click();

        String afterClickButton1 = button3.getText();
        System.out.println("After click inside nested frame button text :" + afterClickButton1);

        //how many frames in this page
        driver.switchTo().defaultContent();
        List<WebElement> getIframeCount = driver.findElements(By.tagName("iframe"));
        int size = getIframeCount.size();
        System.out.println("Iframe count :" + size);

        for (WebElement iframeElement :getIframeCount){
            String frameCRSAttributeCount = iframeElement.getAttribute("src");
            System.out.println("Frame src attribute value :" + frameCRSAttributeCount);
        }
    }
}
