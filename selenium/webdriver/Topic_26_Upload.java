package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_26_Upload {
    WebDriver driver;
    String uploadFilePath = System.getProperty("user.dir") + File.separator +"uploadFiles" + File.separator;

    String haGiang ="ha giang.png";
    String hoiAn ="hoi an.png";
    String phuQuoc ="phu quoc.png";

    String hoiAnPath = uploadFilePath + hoiAn;
    String haGiangPath = uploadFilePath + haGiang;
    String phuQuocPath = uploadFilePath + phuQuoc;

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
        public void TC_1_Single_file() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        WebElement uploadFileElement = driver.findElement(By.xpath("//input[@type='file']"));

        uploadFileElement.sendKeys(hoiAnPath);
        Thread.sleep(5000);

        uploadFileElement.sendKeys(haGiangPath);
        Thread.sleep(5000);

        uploadFileElement.sendKeys(phuQuocPath);
       Thread.sleep(2000);

        // Verify
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + hoiAn + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + haGiang + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + phuQuoc + "']")).isDisplayed());

        // CLick upload cho từng file
        List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));

        for (WebElement startButton : startButtons) {
            startButton.click();
            Thread.sleep(2000);
        }
        //Verify các file upload thành công
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ haGiang +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ hoiAn +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ phuQuoc +"']")).isDisplayed());


        }
    @Test
    public void TC_2_Multiple_File() throws InterruptedException {

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFileElement = By.xpath("//input[@type='file']");

        driver.findElement(uploadFileElement).sendKeys(hoiAnPath + "\n" + haGiangPath + "\n" + phuQuocPath);
        Thread.sleep(5000);



        // Verify
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + hoiAn + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + haGiang + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + phuQuoc + "']")).isDisplayed());

        // CLick upload cho từng file
        List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));

        for (WebElement startButton : startButtons) {
            startButton.click();
            Thread.sleep(5000);
        }
        //Verify các file upload thành công
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ hoiAn +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ haGiang +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ phuQuoc +"']")).isDisplayed());


    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
