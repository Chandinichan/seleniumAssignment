package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AssertClass {
    public static void main(String args[]) {
        WebDriver driver = null;
        WebDriverManager.chromedriver().setup();
        String ExpectedTitle = "Instagram";
        String chromeDriverPath = "C:\\Software\\chromedriver_ver113\\chromedriver\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.get("https://www.instagram.com/");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        String ActualTitle = driver.getTitle();
        System.out.println("The actual title is:" +  ActualTitle);
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        driver.quit();

    }
}
