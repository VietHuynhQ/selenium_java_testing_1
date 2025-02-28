package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

public class Topic_13_Button {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {

    }

    @Test
        public void TC_1_() {
        driver = new FirefoxDriver();
        driver.get("https://www.fahasa.com/customer/account/create");

        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();

        By loginButton = By.cssSelector("button.fhs-btn-login");


        // Nếu enabled trả về true / disable trả về
        // mong đợi là disable
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());

        String backgroundColor = driver.findElement(loginButton).getCssValue("background-color");

        System.out.println(backgroundColor);

        Color loginColor = Color.fromString(backgroundColor);

        Assert.assertEquals(loginColor.asHex().toUpperCase(), "#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("viet@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456789");


        // mong đợi là enable
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());

        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(), "#C92127");

        driver.findElement(loginButton).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.fhs-login-msg")).getText(), "Số điện thoại/Email hoặc mật khẩu sai!");


        }
    @Test
    public void TC_2_() {

    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
