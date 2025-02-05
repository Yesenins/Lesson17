package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkboxes {

    @Test
    public void firstCheckboxCheckTest(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]"));
        if(!checkbox1.isSelected()){
            Assert.assertFalse(checkbox1.isSelected(), "Test passed.First checkbox is unchecked.");
            checkbox1.click();
        }
        Assert.assertTrue(checkbox1.isSelected(),"Test passed.First checkbox is checked.");
    }

    @Test
    public void secondCheckboxUncheckTest(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox2 = driver.findElement(By.xpath("//*[@type=\"checkbox\"][2]"));
        boolean checkboxStatus = checkbox2.isSelected();
        if(checkboxStatus){
            Assert.assertTrue(checkbox2.isSelected(), "Test passed.Second checkbox is checked.");
            checkbox2.click();
        }
        Assert.assertFalse(checkbox2.isSelected(), "Test passed.Second checkbox is unchecked.");
    }
}
