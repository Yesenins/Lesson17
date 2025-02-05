package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Inputs {

    @Test
    public void inputsHerokuAppTest(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.xpath("//*[@type=\"number\"]"));
        inputField.sendKeys(Keys.ARROW_UP);
        String actualTextUp = inputField.getDomProperty("value");
        Assert.assertEquals(actualTextUp, "1");
        inputField.sendKeys(Keys.ARROW_DOWN);
        String actualTextDown = inputField.getDomProperty("value");
        Assert.assertEquals(actualTextDown, "0");
    }
}
