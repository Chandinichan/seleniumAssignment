package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class VerTestCase1 {
    WebDriver driver=null;

    @BeforeMethod
    public void setup(){
        String url = "https://www.instagram.com/";
        String chromeDriverPath = "C:\\Software\\chromeDriver_v113\\chromeDriver\\chromedriver.exe";
        System.setProperty("WebDriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void searchComputerUsingAlphabet() throws InterruptedException {
        String found ="supraja2592";
        String pass="Lakshmi@259";
        Thread.sleep(3000);
        String expectedMessage = "valid username and invalid password";
        HomePage hp = new HomePage(driver);
        hp.setSearchText(found);
        hp.setSearchText1(pass);
        hp.clickSearchButton();
        Thread.sleep(5000);
    }

}
