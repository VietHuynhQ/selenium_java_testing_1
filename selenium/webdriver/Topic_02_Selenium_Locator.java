package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_02_Selenium_Locator {
    WebDriver driver;

    String fullName = "Selenium Locator";

    @BeforeClass
    public void initialBrowser() {
        // Mở brower
        driver = new FirefoxDriver();
        // Mở app đến màn hình login
        driver.get("https://demo.nopcommerce.com/register");
    }

    @Test
    public void TC_1_ID()  {
        driver.findElement(By.id("small-searchterms"));


        driver.findElement(By.id("FirstName"));

        }
    @Test
    public void TC_2_Class()  {
        driver.findElement(By.className("register-next-step-button"));

    }
    @Test
    public void TC_3_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
        driver.findElement(By.name("DateOfBirthMonth"));
        driver.findElement(By.name("DateOfBirthYear"));
    }
    @Test
    public void TC_4_LinkText() {
        // Lấy toàn bộ text
        driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Log in"));
        driver.findElement(By.linkText("Wishlist"));
    }
    @Test
    public void TC_5_Partial_Link_Text() {
// Lấy 1 phần hoặc toàn bộ text
        driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Digital"));
        driver.findElement(By.linkText("downloads"));
    }
    @Test
    public void TC_6_TagName() {
        // Tên thẻ HTML
        // Tìm tất cả các element giống nhau
        driver.findElements(By.tagName("button"));
        driver.findElements(By.tagName("input"));

    }
    @Test
    public void TC_7_Css() {
driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("#Company"));
        driver.findElement(By.cssSelector("input[id='Company']"));
    }
    @Test
    public void TC_8_XPath() {
    driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//input[@id='Password']"));
        driver.findElement(By.xpath("//input[@id='Company']"));
    }

    @Test
    public void TC_9_Relative_Locator() {
        driver.get("https://demo.nopcommerce.com/login");

       // Element / By A
        By passwordTextboxBy = By.cssSelector("input#Password");

        WebElement passwordTextbox = driver.findElement(By.cssSelector("input#Password"));

        // Element / By B
        By remberMeCheckBoxBy = By.id("RememberMe");

        // Element / By C
        By forgotPasswordLinkBy = By.cssSelector("span.forgot-password");

        // Element / By D
        By loginButton = By.cssSelector("button.login-button");

        // Element / By E
        WebElement rememberMeLabelText = driver.findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButton) // Label đang nằm trên login Button
                .below(passwordTextbox) // Label nằm dưới password textbox
                .toRightOf(remberMeCheckBoxBy)// Label bên phải so với Remember me checkbox
                .toLeftOf(forgotPasswordLinkBy) // Label nằm bên trái so với forgotPasswordLink
        );


        driver.findElement(By.xpath("//input[@id='small]"));
    }



    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
