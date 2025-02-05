package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.datatype.Duration;
import java.util.concurrent.TimeUnit;

public class NotificationMessages {

    @Test
    public void checkNotificationMessageTest(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");

        WebElement clickHereButton = driver.findElement(By.xpath("//*[@href=\"/notification_message\"]"));
        clickHereButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement actualText = driver.findElement(By.xpath("//div[contains(text(),'Action successful')]"));
        Assert.assertTrue(actualText.getText().contains("Action successful"));
    }
}
