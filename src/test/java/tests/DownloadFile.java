package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.util.HashMap;


public class DownloadFile {
    public static final String PATH_TO_THE_FILE = System.getProperty("user.dir") + "\\src\\test\\resources\\";
    public static final By LINK_NAME = By.linkText("test.jpg");

    @Test(description = "Check for the presence of the file on the file system")
    public void checkTheAvailabilityOfTheDownloadedFileInSystemTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);       ;
        chromePrefs.put("download.default_directory",PATH_TO_THE_FILE);
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(LINK_NAME).click();
        Thread.sleep(15000);
        File file = new File(PATH_TO_THE_FILE);
        File[] listOfFiles = file.listFiles();
        boolean found = false;
        File f = null;
        for(File files : listOfFiles){
            if(files.isFile()){
                String fileName = files.getName();
                System.out.println("File " + fileName);
                if (fileName.matches("test.jpg")){
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        Assert.assertTrue(found,"File is not downloaded");
        f.deleteOnExit();
    }
}
