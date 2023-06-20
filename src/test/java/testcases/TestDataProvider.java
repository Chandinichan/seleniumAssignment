package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestDataProvider {
    WebDriver driver = null;

    @DataProvider(name = "SearchCriteria")
    public Object[][] getData() {
        Object[][] obj = {
                {"chandinimatta99@gmail.com", "Chandini@5", "valid username and valid password"},
                {"chandnimatta@gmail", "Chandini@5", "invalid username and valid password"},
                {"chandnimatta@gmail", "", "blank password"},
                {"", "Chandini@5", "blank username "},
                {"supraja2592", "Lakshmi@259", "valid username and valid password "},
                {"", "", "blank username and blank password "},
                {"supraja2592", "Lakshmi@", "valid username and invalid password"}
        };
        return obj;
    }

    @BeforeMethod
    public void setUp() throws IOException, ParseException {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Integer> consentSettings = new HashMap<>();
        HashMap<String, Object> profile = new HashMap<>();
        HashMap<String, Object> prefs = new HashMap<>();

        consentSettings.put("notifications",2);
        profile.put("managed_default_content_settings",consentSettings);
        prefs.put("profile",profile);
        options.setExperimentalOption("prefs",prefs);
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
        String chromeDriverPath="C:\\Software\\chromedriver_ver113\\chromedriver\\chromedriver.exe";
        String loginDataPath="src/main/resources/LoginData.json";
        System.setProperty("WebDriver.chrome.driver",chromeDriverPath);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        FileReader fr=new FileReader(loginDataPath);
        JSONParser parser= new JSONParser();
        Object obj= parser.parse(fr);
        org.json.simple.JSONObject jsonObject=(org.json.simple.JSONObject) obj;
        String url=(String) jsonObject.get("url");
        System.out.println(url);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();

    }

    @Test(dataProvider = "SearchCriteria")
    public void verifyLogin(String found, String pass, String ExpectedMessage) throws IOException, ParseException {
        System.out.println("username= " + found + " " + "password=" + pass + " " + "type=" + ExpectedMessage);
        driver.findElement(By.xpath("//input[@aria-label='Phone number, username, or email']")).sendKeys(found);
        driver.findElement(By.xpath("(//input[@aria-label='Password'])")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@class='_acan _acap _acas _aj1-']")).click();
        String TestCases = "src/main/resources/ValidLogin.json";
        FileReader fr = new FileReader(TestCases);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        if (ExpectedMessage.equals("valid username and valid password")) {

            System.out.println("login success");

        } else if (ExpectedMessage.equals("invalid username and valid password")) {
            System.out.println("Enter correct username");
        } else if (ExpectedMessage.equals("blank password")) {
            System.out.println("Enter password");
        } else if (ExpectedMessage.equals("blank username")) {
            System.out.println("Enter username");
        } else if (ExpectedMessage.equals("blank username and blank password ")) {
            System.out.println("Enter username and password");

        } else {
            System.out.println("Enter valid password");
        }

    }
}
