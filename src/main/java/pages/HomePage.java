package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSearchText(String value) {
        String Loc = "//input[@aria-label='Phone number, username, or email']";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.sendKeys(value);
    }

    public void setSearchText1(String value) {
        String Loc = "(//input[@aria-label='Password'])";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.sendKeys(value);
    }

    public void clickSearchButton() {
        String Loc = "//button[@class='_acan _acap _acas _aj1-']";
        ;
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickAccount() {
        String Loc = "(//span[@class='xnz67gz x14yjl9h xudhj91 x18nykt9 xww2gxu x9f619 x1lliihq x2lah0s x6ikm8r x10wlt62 x1n2onr6 x1ykvv32 xougopr x159fomc xnp5s1o x194ut8o x1vzenxt xd7ygy7 xt298gk x1xrz1ek x1s928wv x1n449xj x2q1x1w x1j6awrg x162n7g1 x1m1drc7'])";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickSetting() {
        String Loc = "((//button[@class='_abl-'])[1])";

        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickSettings1() {
        String Loc = ("//button[contains(text(),'Settings and privacy')]");
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();

    }

    /*public void clickEditProfile(){
      String Loc = "(//div[@class='_ad7z'])[0]";
      WebElement ele = this.driver.findElement(By.xpath(Loc));
      ele.click();
    }*/

    public void clickPersonalDetails(){
      String Loc = "(//span[@class='x1lliihq x1plvlek xryxfnj x1n2onr6 x193iq5w xeuugli x1fj9vlw x13faqbe x1vvkbs x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x1i0vuye x1fhwpqd xo1l8bm x5n08af x1yc453h x1s3etm8 x676frb x10wh9bi x1wdrske x8viiok x18hxmgj'])[1]";
      WebElement ele = this.driver.findElement(By.xpath(Loc));
      ele.click();
    }
    public void clickProfile() {
        //String Loc="(//*[@id='mount_0_0_Q+']/div/div/div[1]/div/div/div/div[1]/div[1]/div[2]/section/main/div/ul/div[1]/div/div/div[3]/div[1]/div[2]/span/text())";
        // driver.findElement(By.xpath(("//div[@class='x9f619 x1n2onr6 x1ja2u2z x1qjc9v5 x78zum5 xdt5ytf xl56j7k xeuugli xdl72j9 x1iyjqo2 x2lah0s x1mq37bv x1pi30zi x1swvt13 x1gw22gp x188425o']"))).click();
        String Loc = "((//div[@class='_aav4 _aav5'])/div[1]/div[1]/div[3]/div[1])";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickName() {
        String Loc = "(//div[@class='x16n37ib xq8finb'])";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void nameValue() {

        String path = "/html/body/div/div/div/div/div/div/div/div/span[contains(@class, 'x1lliihq')][contains(text(), 'Name')]";

        WebElement name = this.driver.findElement(By.xpath(path));
        name.click();
        name.clear();
        name.sendKeys("chandini");
    }

    public void selectDone() {
        WebElement done = driver.findElement(By.xpath(("//div[@class='x6s0dn4 x78zum5 xl56j7k x1e0frkt x3fpzix xxdpisx']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", done);

    }

    public void clickPersonalDetails1() {
        String Loc = "//span[contains(text(),'Personal details')]";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickContactDetails() {
        String Loc = "//span[contains(text(),'Contact Info')]";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickMail() {
        String Loc = "";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickDeleteMail() {
        String Loc = "//span[contains(text(),'Delete email')]";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void clickDelete() {
        String Loc = "//span[contains(@class,'x1lliihq x193iq5w x6ikm8r x10wlt62 xlyipyv xuxw1ft') and text()='Delete']";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }
}
