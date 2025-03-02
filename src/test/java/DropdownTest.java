import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void openLikPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("130");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");
    }

    @Test
    public void dropDownTest(){
        //ways of select values in basic dropdown
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(2);

        //get the no of dropdown options
        List<WebElement> listofOptions = select.getOptions();
        int size = listofOptions.size();
        System.out.println("Number of options:" + size);
        for (WebElement element:listofOptions){
            System.out.println(element.getText());
        }

        //using sendkeys select dropdwon
        dropdown.sendKeys("Cypress");

        //boostrap dropdown
        WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> listOfDropdowns = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element:listOfDropdowns){
            String dropdownValue = element.getText();
            if (dropdownValue.equals("USA")){
                element.click();
                break;
            }
        }
    }
}
