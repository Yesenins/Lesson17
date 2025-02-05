package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortableDataTables {

    @Test
    public void sortableDataTablesTest(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/tables");

        Assert.assertEquals(driver.findElement(By.xpath("//table//tr[1]//td[1]")).getText(), "Smith");
        Assert.assertEquals(driver.findElement(By.xpath("//table//tr[1]//td[2]")).getText(), "John");
        Assert.assertEquals(driver.findElement(By.xpath("//table//tr[3]//td[1]")).getText(), "Doe");
        Assert.assertEquals(driver.findElement(By.xpath("//table[2]//tr[1]//td[3]")).getText(), "jsmith@gmail.com");
    }
}
