package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_WebElement_exercise_II {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();

    }

    @Test
        public void Login_1_Empty_Email_Password() {
        driver.get("https://live.techpanda.org/");


        driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field.");

    }

    @Test
    public void Login_2_Invalid_Email() {
        driver.get("https://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

        driver.findElement(By.cssSelector("input#email")).sendKeys("123@123.123");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test
    public void Login_3_Invalid_Password() {
        driver.get("https://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

        driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc.vn@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123");

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");


    }

    @Test
    public void Login_4_Incorrect_Email_Password() {


        driver.get("https://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

        driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc.12345754@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456789");

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(),"Invalid login or password.");


    }




    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
