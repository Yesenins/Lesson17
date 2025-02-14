package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload {
    public static final String PATH_TO_THE_FILE = System.getProperty("user.dir") + "\\src\\test\\resources\\Screenshot_3.png";
    public static final By INPUT_FILE_BUTTON = By.id("file-upload");
    public static final By UPLOAD_BUTTON = By.id("file-submit");

    @Test(description = "Verify that the file name on the page matches the name of the of the uploaded file")
    public void checkTheNameOfUploadedFileTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(INPUT_FILE_BUTTON).sendKeys(PATH_TO_THE_FILE);
        driver.findElement(UPLOAD_BUTTON).click();

        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),"Screenshot_3.png");
        driver.quit();
    }
}
