import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultiTabsWindowsTest {
    WebDriver driver;

    @BeforeMethod
    public void openLikPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("130");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void windowsTest() throws InterruptedException {
        //click and confirm new windows open

        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent window:" + oldWindow);

        WebElement openWindow = driver.findElement(By.xpath("//*[@id='j_idt88:new']"));
        openWindow.click();
        Thread.sleep(3000);

        Set<String> handles = driver.getWindowHandles();
        System.out.println("Handles size : " + handles.size());

//        //first method - using fetch loop
//
//        for (String newWindow :handles){
//            System.out.println(newWindow);
//            driver.switchTo().window(newWindow);
//            System.out.println("page title is: " + driver.getTitle());
//        }
//        driver.close();
//
//        driver.switchTo().window(oldWindow);
//        WebElement findButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
//        boolean openButtonVisibility = findButton.isDisplayed();
//        System.out.println("Open button is visibale: " +openButtonVisibility);

        //second method - using list
        List<String> list = new ArrayList<String>(handles); //converting set to list
        if (list.size() > 1){
            driver.switchTo().window(list.get(1));
            System.out.println("child page title is: " + driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow);
        }
        WebElement findButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean openButtonVisibility = findButton.isDisplayed();
        System.out.println("Open button is visibale: " +openButtonVisibility);


        //Find the number of opened tabs

        WebElement multiWindow = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span"));
        multiWindow.click();
        Thread.sleep(3000);

        Set<String> multiWindows = driver.getWindowHandles();
        int noOfWindows = multiWindows.size();
        System.out.println("No of windows : " + noOfWindows);

        //close all windows except primary
        WebElement dontCloseButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt93']/span"));
        dontCloseButton.click();
        Thread.sleep(3000);
        Set<String> newWindowHandles = driver.getWindowHandles();
        for(String allWindows : newWindowHandles){
            if (!allWindows.equals(oldWindow)){
                driver.switchTo().window(allWindows);
                driver.close();
            }
        }
//        driver.switchTo().window(oldWindow);
//        driver.close(); //close single browser window which on focused
    }

    @AfterMethod
    public void close(){
        driver.quit(); // close all the windows
    }
}
