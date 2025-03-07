package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_32_Explicit_Loading {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://automationfc.github.io/dynamic-loading/");

    }

    @Test
    public void TC_1_Dont_Set() {

        driver.findElement(By.cssSelector("div#start>button")).click();

        // điều kiện
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");

    }
    @Test
    public void TC_2_Less_Than()  {
        explicitWait = new WebDriverWait(driver ,Duration.ofSeconds(3));


        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");


    }
    @Test
    public void TC_3_Equal()  {
        explicitWait = new WebDriverWait(driver ,Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

    }
    @Test
    public void TC_4_Greater_Than()  {
        explicitWait = new WebDriverWait(driver ,Duration.ofSeconds(30));


        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void TC_5()  {
        explicitWait = new WebDriverWait(driver ,Duration.ofSeconds(30));


        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        // Vísible (dành cho 1 element sắp xuất hiện)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));
        // Invisible (dành cho 1 element sắp biến mất)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
        // Text
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div#finish>h4"), "Hello World!"));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");


    }

    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
