package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Frames {
    public static final By LINK_IFRAME = By.linkText("test.jpg");
    public static final By CLOSE_BUTTON = By.xpath("//*[@class=\"tox-icon\"]");
    public static final By IFRAME = By.cssSelector(".tox-edit-area__iframe");
    public static final By IFRAME_TEXT = By.cssSelector("#tinymce");

    @Test(description = "Check that the text inside the paragraph  is 'Your content goes here.'")
    public void validationOfTheParagraphTextTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(LINK_IFRAME).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(CLOSE_BUTTON)).click();
        WebElement iFrame = driver.findElement(IFRAME);
        driver.switchTo().frame(iFrame);
        String actualText = driver.findElement(IFRAME_TEXT).getText();
        Assert.assertEquals(actualText,"Your content goes here.");
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
