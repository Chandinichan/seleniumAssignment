package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class UpdateTestCase {
    WebDriver driver=null;
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
        JSONObject jsonObject=(JSONObject) obj;
        String url=(String) jsonObject.get("url");
        System.out.println(url);
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void updateCred() throws InterruptedException, IOException, ParseException {
        String searchComputerDataPath="src/main/resources/ValidLogin.json";
        FileReader fr =new FileReader(searchComputerDataPath);
        JSONParser parser=new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc=(JSONObject) jsonObject.get("tco1");
        String searchText =(String) tc.get("found");
        String searchText1 =(String) tc.get("pass");
        String expectedMessage = "valid";
        System.out.println(expectedMessage + " " +searchText + " " +searchText1);
        HomePage hp=new HomePage(driver);
        hp.setSearchText(searchText);
        hp.setSearchText1(searchText1);
        hp.clickSearchButton();
        Thread.sleep(3000);
        hp.clickAccount();
        hp.clickSetting();
        hp.clickSettings1();
        //hp.clickEditProfile();
        hp.clickProfile();
        hp.clickName();
        Thread.sleep(3000);
        hp.nameValue();
        hp.selectDone();
        System.out.println("passed");
        Thread.sleep(20000);



    }

}
