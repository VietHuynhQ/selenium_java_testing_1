package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_31_Explicit_Ajax {
    WebDriver driver;
    WebDriverWait explicitWait;

    String uploadFilePath = System.getProperty("user.dir") + File.separator +"uploadFiles" + File.separator;

    String haGiang ="ha giang.png";
    String hoiAn ="hoi an.png";
    String phuQuoc ="phu quoc.png";


    String haGiangPath = uploadFilePath + haGiang;
    String hoiAnPath = uploadFilePath + hoiAn;
    String phuQuocPath = uploadFilePath + phuQuoc;

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
    }

    @Test
        public void TC_1_Calendar() {
            driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

            // Wait and Verify carlendar is displayed
        Assert.assertTrue(explicitWait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1"))).isDisplayed());

        // Wait and Verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions
                .textToBe(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1"), "No Selected Dates to display.")));

        // Wait and click element
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[text()='22']"))).click();

        // Wait ajax loading invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions
                .invisibilityOfElementLocated(By.cssSelector("div[id$='RadCalendar1']>div.raDiv"))));

        // Wait and Verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions
                .textToBe(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1"), "Saturday, March 22, 2025")));

        }
    @Test
    public void TC_2_BaiTap_7() {

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


        driver.get("https://gofile.io/home");


        // Wait loading icon ở màn hình biến mất
//        Assert.assertTrue(explicitWait.until(ExpectedConditions
//                .invisibilityOfElementLocated(By.cssSelector("main>div#index_loader>div.animate-spin"))));


        // Wait cho icon ở màn hình tiếp theo không còn hiển thị
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("span#destinationFolder>div.animate-spin")));


        By uploadInput = By.cssSelector("input[type='file']");
        driver.findElement(uploadInput).sendKeys(hoiAnPath + "\n" + haGiangPath + "\n" + phuQuocPath);

        // Wait spin loading khi gui anh
        Assert.assertTrue(explicitWait.until(ExpectedConditions
                .invisibilityOfElementLocated(By.cssSelector("span#destinationFolder>div.animate-spin"))));

        // thanh loading file anh
       explicitWait.until(ExpectedConditions
               .invisibilityOfAllElements(driver.findElements(By.cssSelector("div.rounded-full>div.file-progressbar")) ));


        // click link anh
       //  Wait and click element
       explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='https://gofile.io/d/WRCHYC']"))).click();

        // Wait spin loading khi gui anh
    //    Assert.assertTrue(explicitWait.until(ExpectedConditions
        //        .invisibilityOfElementLocated(By.cssSelector("span#destinationFolder>div.animate-spin"))));


//        // spin loading link anh khi click
     //  Assert.assertTrue(explicitWait.until(ExpectedConditions
         //       .invisibilityOfElementLocated(By.cssSelector("main>div#index_loader>div.animate-spin"))));


    }
    @AfterClass
    public void cleanBrowser () {
      driver.quit();
    }

}
