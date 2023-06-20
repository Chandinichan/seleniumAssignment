package testcases;

import org.asynchttpclient.Response;
import org.openqa.selenium.WebDriver;


public class RestAssuredClass {
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = null;
        String chromeDriverPath = "C:\\Software\\chromedriver_ver113\\chromedriver\\chromedriver.exe";
        System.setProperty("WebDriver.chrome.driver", chromeDriverPath);
        driver.get("https://www.instagram.com");
        String currentUrl = driver.getCurrentUrl();
        Thread.sleep(2000);
        Response response;
        response = RestAssured.get(currentUrl);
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        driver.quit();

    }
}
