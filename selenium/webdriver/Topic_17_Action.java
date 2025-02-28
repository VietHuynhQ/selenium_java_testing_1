package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class Topic_17_Action {
    WebDriver driver;
    Actions action;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
         action = new Actions(driver);

         action.moveByOffset(0,0).perform();

         // Set browser tại vị trí 0x0
         driver.manage().window().setPosition(new Point(0,0));
         driver.manage().window().setSize(new Dimension(1920,1080));


    }

    @Test
        public void TC_1_Hover() {
            driver.get("https://automationfc.github.io/jquery-tooltip/");

        WebElement ageTextBox = driver.findElement(By.cssSelector("input#age"));

        action.moveToElement(ageTextBox).perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");

        }
    @Test
    public void TC_2_Hover_myntra() throws InterruptedException {
        driver.get("https://www.myntra.com/");

        action.moveToElement(driver.findElement(By.xpath("//a[@class='desktop-main' and text()='Kids']"))).perform();
        Thread.sleep(2000);

        action.click(driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Home & Bath']"))).perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("span.breadcrumbs-crumb")).getText(), "Kids Home Bath");

    }

    @Test
    public void TC_3_Hover_() throws InterruptedException {
        driver.get("https://www.fahasa.com/");

        action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform(); ;
        Thread.sleep(2000);

        action.moveToElement(driver.findElement(By.xpath("//span[text()='Hành Trang Đến Trường']"))).perform();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text()='Luyện Thi Môn Toán']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Toán']")).isDisplayed());

    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
