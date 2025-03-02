import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {
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
    public void webTableTest() throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com/");
        //how many rows in the table
        int rowCount = driver.findElements(By.xpath(" //table[@id='productTable']/tbody/tr")).size();
        System.out.println("Row count is : " + rowCount);

        //how many columns in the table
        int columnCount = driver.findElements(By.xpath(" //table[@id='productTable']/thead/th")).size();
        System.out.println("Column count is : " + columnCount);

        //retrieve specific row/column data
        String value = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println("Select data value is : " + value);

        //retrieve all data
        for (int i = 1; i<=rowCount; i++){   //Rows
            for (int j=1; j<columnCount; j++){    //Columns
                String tabelData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.println(tabelData + "  ");
            }
        }

        //print ID and names only
        //find product price, which name related to product 3
        for (int i = 1; i<rowCount; i++){
            String tableID = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
            String tableName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();

            System.out.println("Tabel ID : " + tableID + "\t\t" + "Product Name : " + tableName);

            if (tableName.equals("Product 3")){
                String productPrice = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();
                System.out.println("Relavent Product price is : " + productPrice);
                break;

            }
        }

        //select all checkboxes
        int pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for (int k=0; k<pageCount; k++){
            pages.get(k).click();
            Thread.sleep(3000);
            for (int i=1; i<=rowCount; i++){
                Boolean attribute = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[4]/input")).isSelected();
                if (!attribute){
                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[4]/input")).click();
                    Thread.sleep(3000);
                }
            }
        }

        //select one checkbox
        int tabelRow = 1;
        driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+tabelRow+"]/td[4]/input")).click();
    }
}
