package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveElements {

    @Test
    public void addAndRemoveElementsTest(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElement = driver.findElement(By.xpath("//*[@onclick=\"addElement()\"]"));
        addElement.click();
        addElement.click();
        WebElement deleteElementButton = driver.findElement(By.xpath("//*[@id=\"elements\"]/*[1]"));
        deleteElementButton.click();
        int countOfDeleteElement = driver.findElements(By.xpath("//*[@id=\"elements\"]")).size();
        Assert.assertEquals(countOfDeleteElement, 1);
    }
}

