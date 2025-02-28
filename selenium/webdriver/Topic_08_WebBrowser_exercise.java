package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_WebBrowser_exercise {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
        public void TC_1_Url() {
            driver.get("https://live.techpanda.org/");

            driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

            Assert.assertEquals( driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/login/");

             driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

            Assert.assertEquals( driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/create/");

        }
    @Test
    public void TC_2_Title() {
        driver.get("https://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

        Assert.assertEquals( driver.getTitle(), "Customer Login");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        Assert.assertEquals( driver.getTitle(), "Create New Customer Account");

    }
    @Test
    public void TC_3_Navigate() {

        driver.get("https://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        Assert.assertEquals( driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/create/");

        driver.navigate().back();

        Assert.assertEquals( driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/login/");

        driver.navigate().forward();

        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

    }
    @Test
    public void TC_4_Title() {
        driver.get("https://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));


    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
