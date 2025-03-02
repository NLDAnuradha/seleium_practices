package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenshotTest1 {

    WebDriver driver;

    @BeforeMethod
    public void openLikPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("130");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void takeScreenShotTests() throws IOException, AWTException {

        //capture screenshot of the full page
        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
        File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
        //create an image file any destination
        File destinationFile = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_full_wep_page.png");
        FileHandler.copy(sourceFile, destinationFile);


        //capture screenshot of section of a Web page
        WebElement section1 = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]"));
        File source = section1.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\Screenshots\\" + "alert_section_of_the_page.png");
        FileUtils.copyFile(source,target);

        //capture screenshot of an Element on a Web page
        WebElement element1 = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]/div[1]"));
        File source1 = element1.getScreenshotAs(OutputType.FILE);
        File target1 = new File(System.getProperty("user.dir") + "\\Screenshots\\" + "alert_element_of_the_page.png");
        FileUtils.copyFile(source1,target1);

        //capture screenshot of full entire screen (robot class)
        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);
        BufferedImage screen2 = robot.createScreenCapture(rectangle);
        File destinationFile2 = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_page_entirescreen.png");
        ImageIO.write(screen2,"png",destinationFile2);


    }
}
