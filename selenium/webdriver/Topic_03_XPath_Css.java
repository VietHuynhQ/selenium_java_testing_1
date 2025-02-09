package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_XPath_Css {
    WebDriver driver;
// 1
    @BeforeClass
    public void initialBrowser() {
        // Arange
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
// 2
    @Test
    public void Register_1_Empty_Data() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // action
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        // Assert
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");


        }
    @Test
    public void Register_2_Invalid_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname-error")).sendKeys("Joe Biden");
        driver.findElement(By.id("txtEmail-error")).sendKeys("123@345@321");
        driver.findElement(By.id("txtCEmail-error")).sendKeys("123@345@321");
        driver.findElement(By.id("txtPassword-error")).sendKeys("Joe Biden");
        driver.findElement(By.id("txtCPassword-error")).sendKeys("Joe Biden");
        driver.findElement(By.id("txtPhone-error")).sendKeys("Joe Biden");

        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }
    @Test
    public void Register_3_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

    }
    @Test
    public void Register_4_Invalid_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

    }
    @Test
    public void Register_5_Incorrect_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

    }
    @Test
    public void Register_6_Invalid_Phone_Number() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
