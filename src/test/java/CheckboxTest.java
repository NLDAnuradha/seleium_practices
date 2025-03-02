import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;
import java.util.List;

public class CheckboxTest {
    WebDriver driver;

    @BeforeMethod
    public void openLikPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("130");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/radio.xhtml");
    }

    @Test
    public void radiobuttonTest(){
        //find the default select radio button
        driver.get("https://www.leafground.com/radio.xhtml");

        boolean chromeRadioOption = driver.findElement(By.id("j_idt87:console1:0")).isSelected();
        boolean firefoxRadioOption = driver.findElement(By.id("j_idt87:console1:1")).isSelected();
        boolean safariRadioOption = driver.findElement(By.id("j_idt87:console1:2")).isSelected();
        boolean edgeRadioOption = driver.findElement(By.id("j_idt87:console1:3")).isSelected();

        if (chromeRadioOption){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console1:0']")).getText();
            System.out.println("Default select button is:" + chromeText);
        } else if (firefoxRadioOption){
            String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console1:1']")).getText();
            System.out.println("Default select button is:" + firefoxText);
        } else if (safariRadioOption){
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console1:2']")).getText();
            System.out.println("Default select button is:" + safariText);
        } else if (edgeRadioOption){
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console1:3']")).getText();
            System.out.println("Default select button is:" + edgeText);
        }

        //good way
//        List<WebElement> radioElements = driver.findElements(By.xpath("//table[@id='j_idt87:console2']//td//input"));
//        int radioCount = radioElements.size();
//        System.out.println("Radio size:" + radioCount);
//
//        int index = -1;
//
//        for (WebElement radioElement: radioElements){
//            index--;
//            if (radioElement.isSelected()){
//                WebElement defaultSelectedradioButton = driver.findElement(By.xpath("//table[@id='j_idt87:console2" + index + "']"));
//                String defaultSelectedText = defaultSelectedradioButton.getText();
//                System.out.println("Default selected radio butoon text:" + defaultSelectedText);
//                break;
//            }
//        }

        //select age group if not selected
         WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = myAgeGroup.isSelected();
        if (!isChecked){
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }
    }

    //best way
//    String myAge = "1-20 Years";
//
//    List<WebElement> ageGroups = driver.findElements(By.xpath("//div[@id='c']//label"));
//
//    for (WebElement element:ageGroups){
//        String ageText = element.getText();
//        if (ageText.equals(myAge)){
//            WebElement myAgeRadioOption = driver.findElement(By.xpath("//label[text()='"+ageText+"']/parent::div//input"));
//            if (myAgeRadioOption.isSelected()){
//                element.click();
//            }
//            break;
//        }
//    }

    @Test
    public void checkboxTest(){
        driver.get("https://www.leafground.com/checkbox.xhtml");
        List<WebElement> checkboxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element:checkboxList){
            if (!(element.getText().equals("Others"))){
                element.click();
            }
        }

        for (int i=1; i<=checkboxList.size(); i++){
            boolean checkboxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + i + "]")).isSelected();
            System.out.println("Checkbox status is :" + checkboxStatus);
        }
    }
}
