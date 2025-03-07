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
import java.util.Date;

public class Topic_33_Mix {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
        public void TC_1_Element_Found() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        explicitWait =new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        // Wait vs Explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

        // Wait vs Explicit
        driver.findElement(By.cssSelector("input#email"));
        }
    @Test
    public void TC_2_Element_Not_Found_Only_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        // Wait vs Explicit
        driver.findElement(By.cssSelector("input#automaticfc"));

    }

    @Test
    public void TC_3_Element_Not_Found_Only_Explicit() {

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");


        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));


    }

    @Test
    public void TC_4_Element_Not_Found_Mix_Explicit_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(1));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        System.out.println("Start =" + getDateTimeNow());

        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
        } catch (Exception e) {
            System.out.println("End =" + getDateTimeNow());
                throw new RuntimeException(e);
        }
    }

    public String getDateTimeNow() {
        Date date = new Date();
        return date.toString();
    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
