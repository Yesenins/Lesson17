package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Typos {

    @Test
    public void typosTest(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/typos");

        WebElement paragraph1 = driver.findElement(By.tagName("p"));
        String firstActualText = paragraph1.getText();
        String firstExpectedText = "This example demonstrates a typo being introduced. It does it randomly on each page load.";
        Assert.assertEquals(firstActualText, firstExpectedText);

        WebElement paragraph2 = driver.findElement(By.xpath("//*/p[2]"));
        String secondActualText = paragraph2.getText();
        String secondExpectedText = "Sometimes you'll see a typo, other times you won't.";
        Assert.assertEquals(secondActualText, secondExpectedText);
    }
}
