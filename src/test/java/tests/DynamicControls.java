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
import java.util.List;

public class DynamicControls {
    public static final By REMOVE_BUTTON = By.xpath("//*[text()='Remove']");
    public static final By ENABLE_BUTTON = By.xpath("//*[text()='Enable']");
    public static final By CHECKBOX = By.id("checkbox");
    public static final By INPUT_FIELD = By.cssSelector("[type=\"text\"]");

    @Test(description = "Check the work of expectations")
    public void dynamicControlsTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(REMOVE_BUTTON);
        removeButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        List<WebElement> checkboxList = driver.findElements(CHECKBOX);
        Assert.assertTrue(checkboxList.isEmpty());
        WebElement inputField = driver.findElement(INPUT_FIELD);
        Assert.assertTrue(inputField.isDisplayed());
        driver.findElement(ENABLE_BUTTON).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"It's enabled!\"]")));
        Assert.assertTrue(inputField.isEnabled());
    }
}
