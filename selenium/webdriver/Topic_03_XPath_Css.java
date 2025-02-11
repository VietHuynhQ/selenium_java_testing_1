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


        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Biden");
        driver.findElement(By.id("txtEmail")).sendKeys("123@345@321");
        driver.findElement(By.id("txtCEmail")).sendKeys("123@345@32q1");

        driver.findElement(By.xpath("//button[@type='submit']")).click();


        Assert.assertEquals( driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals( driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập email hợp lệ");



    }
    @Test
    public void Register_3_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Biden");
        driver.findElement(By.id("txtEmail")).sendKeys("Joebien@gmail.vn");
        driver.findElement(By.id("txtCEmail")).sendKeys("Joebien@gmail.us");

        driver.findElement(By.xpath("//button[@type='submit']")).click();


        Assert.assertEquals( driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");


    }
    @Test
    public void Register_4_Invalid_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Biden");
        driver.findElement(By.id("txtEmail")).sendKeys("Joebien@gmail.vn");
        driver.findElement(By.id("txtCEmail")).sendKeys("Joebien@gmail.vn");
        driver.findElement(By.id("txtPassword")).sendKeys("1234");
        driver.findElement(By.id("txtCPassword")).sendKeys("1234");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals( driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals( driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");


    }
    @Test
    public void Register_5_Incorrect_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");


        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Biden");
        driver.findElement(By.id("txtEmail")).sendKeys("Joebien@gmail.vn");
        driver.findElement(By.id("txtCEmail")).sendKeys("Joebien@gmail.vn");
        driver.findElement(By.id("txtPassword")).sendKeys("1234567");
        driver.findElement(By.id("txtCPassword")).sendKeys("1234765");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals( driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");

    }
    @Test
    public void Register_6_Invalid_Phone_Number() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Biden");
        driver.findElement(By.id("txtEmail")).sendKeys("Joebien@gmail.vn");
        driver.findElement(By.id("txtCEmail")).sendKeys("Joebien@gmail.vn");
        driver.findElement(By.id("txtPassword")).sendKeys("1234567");
        driver.findElement(By.id("txtCPassword")).sendKeys("1234567");
        driver.findElement(By.id("txtPhone")).sendKeys("213123908");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
//
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("091234");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");
//
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("09122309878766");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
