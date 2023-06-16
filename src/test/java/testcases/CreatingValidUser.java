package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CreatingValidUser {
    public static void main(String[] args) {
        String ChromeDriverPath = "C:\\Software\\chromedriver_ver113\\chromedriver\\chromedriver.exe";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        System.setProperty("webdriver.chrome.driver", "ChromeDriverPath");
        driver.get("https://www.instagram.com/");
        driver.findElement(By.xpath(("//span[@class='_aacl _aaco _aacw _aad0 _aad7']"))).click();
        // String loc_mail= "//input[@name='emailOrPhone']";
        driver.findElement(By.xpath(("//input[@name='emailOrPhone']"))).sendKeys("7780617897");
        driver.findElement(By.xpath(("//input[@name='fullName']"))).sendKeys("chandni");
        driver.findElement(By.xpath(("//input[@name='username']"))).sendKeys("c_h_a_nd1934");
        driver.findElement(By.xpath(("//input[@name='password']"))).sendKeys("Chandini");
        driver.findElement(By.xpath(("//button[text()='Sign up']"))).click();
        driver.findElement(By.xpath(("//option[text()='January']"))).click();
        driver.findElement(By.xpath(("//option[text()='26']"))).click();
        driver.findElement(By.xpath(("//option[text()='2002']"))).click();
        driver.findElement(By.xpath(("//button[text()='Next']"))).click();
    }
}

