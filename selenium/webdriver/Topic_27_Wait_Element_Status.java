package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_27_Wait_Element_Status {
    WebDriver driver;

    WebDriverWait explicitWait;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
        public void TC_1_Visible() {
        driver.get("https://www.facebook.com/");

        // 1 - element có trên UI và có trong cây HTML

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));


        }
    @Test
    public void TC_2_Invisible() {
        driver.get("https://www.facebook.com/");


        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();

        // Wait cho textbox được visible
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='reg_email__']")));

        // 2- element khong có trên UI và có trong cây HTML
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='reg_email_confirmation__']")));

         driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();

        // 3 - element khong có trên UI và khong có trong cây HTML
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='reg_email_confirmation__']")));



    }
    @Test
    public void TC_3_Presence() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();

        // Wait cho textbox được visible
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='reg_email__']")));

        // Điều kiện  cho confirm Email được xuất hiện trên UI
        driver.findElement(By.cssSelector("input#email")).sendKeys("viet@gmail.com");

        // 1 - element có trên UI và có trong cây HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='reg_email_confirmation__']")));

        // Điều kiện  cho confirm Email được xuất hiện trên UI
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();

        // 2- element khong có trên UI và có trong cây HTML

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='reg_email_confirmation__']")));

    }
    @Test
    public void TC_4_Staleness() {
        driver.get("https://www.facebook.com/");
        // Click mở ra
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();

        // Wait cho textbox được visible
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='reg_email__']")));

        // Tại thời điểm này confirm Email đang có trong HTML
        WebElement confirmEmail = driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']"));

        // CLick đóng lại
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();

        // 3 - element khong có trên UI và khong có trong cây HTML
        explicitWait.until(ExpectedConditions.stalenessOf(confirmEmail));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='reg_email_confirmation__']")));


    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
