package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class Topic_04_exercise {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser () {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void Login_01_Account_Empty_Data () {
        driver.get("https://live.techpanda.org");

        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();


        driver.findElement(By.id("send2")).click();

       Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(),"This is a required field.");
       Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(),"This is a required field.");
    }

    @Test
    public void Login_02_Account_Invalied_Email () {
        driver.get("https://live.techpanda.org");

        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();


        driver.findElement(By.id("email")).sendKeys("joebiden@gmailcon");
        // driver.findElement(By.id("pass")).sendKeys("123@123456@");

        driver.findElement(By.id("send2")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
       // Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(),"This is a required field.");
    }

    @Test
    public void Login_03_Account_Invalied_Password () {
        driver.get("https://live.techpanda.org");

        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();


        driver.findElement(By.id("email")).sendKeys("joebiden@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("1");

        driver.findElement(By.id("send2")).click();


        Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void Create_Account_01_Empty_Data () {
        driver.get("https://live.techpanda.org");

        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();

        driver.findElement(By.xpath("//div[@class='buttons-set']//a[@class='button']")).click();

         driver.findElement(By.xpath("//button[@class='button']")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-firstname")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-lastname")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email_address")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-password")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-confirmation")).getText(),"This is a required field.");


         }
    @Test
    public void Create_Account_02_Invalied_Email () {
        driver.get("https://live.techpanda.org");

        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        driver.findElement(By.xpath("//div[@class='buttons-set']//a[@class='button']")).click();


        driver.findElement(By.id("firstname")).sendKeys("Huynh");
        driver.findElement(By.id("middlename")).sendKeys("Huynh");
        driver.findElement(By.id("lastname")).sendKeys("Huynh");
        driver.findElement(By.id("email_address")).sendKeys("joebien@gmailcon");

        driver.findElement(By.xpath("//button[@class='button']")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email_address")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");


    }
    @Test
    public void Create_Account_03_Invalied_Password () {
        driver.get("https://live.techpanda.org");

        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        driver.findElement(By.xpath("//div[@class='buttons-set']//a[@class='button']")).click();

        driver.findElement(By.id("firstname")).sendKeys("Huynh");
        driver.findElement(By.id("middlename")).sendKeys("Huynh");
        driver.findElement(By.id("lastname")).sendKeys("Huynh");
        driver.findElement(By.id("email_address")).sendKeys("joebien@gmail.com");
        driver.findElement(By.id("password")).sendKeys("1");


        driver.findElement(By.xpath("//button[@class='button']")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-validate-password-password")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");


    }
    @Test
    public void Create_Account_04_Invalied_Confirm_Password  () {
        driver.get("https://live.techpanda.org");

        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        driver.findElement(By.xpath("//div[@class='buttons-set']//a[@class='button']")).click();

        driver.findElement(By.id("firstname")).sendKeys("Huynh");
        driver.findElement(By.id("middlename")).sendKeys("Huynh");
        driver.findElement(By.id("lastname")).sendKeys("Huynh");
        driver.findElement(By.id("email_address")).sendKeys("joebien@gmail.com");
        driver.findElement(By.id("password")).sendKeys("1");
        driver.findElement(By.id("confirmation")).sendKeys("1234");


        driver.findElement(By.xpath("//button[@class='button']")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-validate-cpassword-confirmation")).getText(),"Please make sure your passwords match.");


    }
    @Test
    public void Create_Account_05_Empty_Data () {
        driver.get("https://live.techpanda.org");

        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        driver.findElement(By.xpath("//div[@class='buttons-set']//a[@class='button']")).click();



    }


    @AfterClass
    public void cleanBrowser() {
            driver.quit();
    }
}
