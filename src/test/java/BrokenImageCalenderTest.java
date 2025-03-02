import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImageCalenderTest {
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
    public void brokenImageTest(){
        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> listImage = driver.findElements(By.xpath("//div[@class='example']/img"));

        // "naturalWidth" = '0'
        int i = 1;
        for (WebElement image:listImage){
            if (image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image " + i + "is Broken");
            } else {
                System.out.println("Image " + i + "is not Broken");
            }
            i++;
        }
    }

    @Test
    public void brokenTest(){
        driver.get("https://demoqa.com/broken");

        WebElement listImage = driver.findElement(By.xpath("//*[text()='Valid image']/parent::div/img[2]"));

        // "naturalWidth" = '0'

        if (listImage.getAttribute("naturalWidth").equals("0")){
            System.out.println("Image is Broken");
        } else {
            System.out.println("Image is not Broken");
        }

    }

    @Test
    public void calenderTest(){
        //method one
        driver.get("https://jqueryui.com/datepicker/");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
//        WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
//        date.sendKeys("01/07/2025");

        //method two
        WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
        date.click();

        selectFutureDate("2025","May", "5");
        //selectPastDate("2024", "May", "5");

    }

    public void selectFutureDate(String year, String month, String day){
        while (true){
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if (actualYear.equals(year) && actualMonth.equals(month)){
                break;
            }else {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }

        List<WebElement> dateList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement dateElement:dateList){
            if (dateElement.getText().equals(day)){
                dateElement.click();
                break;
            }
        }
    }

    public void selectPastDate(String year, String month, String day){
        while (true){
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if (actualYear.equals(year) && actualMonth.equals(month)){
                break;
            }else {
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            }
        }

        List<WebElement> dateList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement dateElement:dateList){
            if (dateElement.getText().equals(day)){
                dateElement.click();
                break;
            }
        }
    }

}
