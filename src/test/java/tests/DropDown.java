package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropDown {

    @Test
    public void UserProfileRedirectionTest(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropDownField = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropDownField);

        WebElement element1 = dropdown.getFirstSelectedOption();
        Assert.assertEquals(element1.getText(), "Please select an option");

        List<WebElement> options = dropdown.getOptions();
        for (WebElement option : options){
            if (option.getText().equals("Option 1")){
                System.out.println("Option 1 exist");
            }
            if (option.getText().equals("Option 2")){
                System.out.println("Option 2 exist");
            }
        }
        dropdown.selectByValue("1");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1");

        dropdown.selectByValue("2");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2");
    }
}
