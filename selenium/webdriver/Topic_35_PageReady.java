package webdriver;

import chromedriver.ChromeDriverBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_35_PageReady {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();





        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
        public void TC_1_PageReady_Invisible() {

        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

        driver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("admin");

        driver.findElement(By.cssSelector("button.login-button")).click();

        // Dashboard page
        Assert.assertTrue(isPageLoadedSuccess());

        // Product page
        //    Assert.assertTrue(isPageLoadedSuccess());

        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div.login-page form")).isDisplayed());


        }
    @Test
    public void TC_2_PageReady_Function() {


        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

        driver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("admin");

        driver.findElement(By.cssSelector("button.login-button")).click();

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy>span"))));

        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div.login-page form")).isDisplayed());

    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }


    public boolean isPageLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }
}
