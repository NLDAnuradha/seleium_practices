import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadDownloadTest {
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
    public void fileDownloadTest() throws InterruptedException, AWTException {
        driver.get("https://www.leafground.com/file.xhtml");

        //basic upload
//        WebElement uploadButton = driver.findElement(By.id("j_idt88:j_idt89"));
//        uploadButton.click();
//        Thread.sleep(3000);
//
//        //windows control begin here
//        String data = "C:\\Users\\Anuradha\\Downloads\\girl.jpeg";
//        StringSelection selection = new StringSelection(data);
//
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//
//        Thread.sleep(4000);
//
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

        //2nd way -  Using send keys (Applicable only element type is File
        String data = "C:\\Users\\Anuradha\\Downloads\\girl.jpg";
        WebElement uploadFileButton = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadFileButton.sendKeys(data);

    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");

        //basic download
        WebElement downloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadButton.click();
        Thread.sleep(3000);

        File file = new File("C:\\Users\\Anuradha\\Downloads");
        File[] totalFiles = file.listFiles();

        for (File findFile:totalFiles){
            if (findFile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is Downloaded.");
                break;
            }
        }

    }
}
