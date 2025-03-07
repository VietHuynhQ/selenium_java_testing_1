package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_29_Static {
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/dynamic-loading/");
    }
    @Test
    public void TC_1_Dont_Set() {
       driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");

    }
    @Test
        public void TC_2_Less_Than() throws InterruptedException {
      Thread.sleep(3);

        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");


    }
    @Test
    public void TC_3_Equal() throws InterruptedException {
        Thread.sleep(5);

        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

    }
    @Test
    public void TC_4_Greater_Than() throws InterruptedException {
        Thread.sleep(10);

        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
