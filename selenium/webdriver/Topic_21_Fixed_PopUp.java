package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_21_Fixed_PopUp {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
        public void TC_1_NgoaiNgu24h() {
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

        By loginPopUp = By.cssSelector("div#custom-dialog");

        Assert.assertTrue(driver.findElement(loginPopUp).isDisplayed());

        driver.findElement(By.xpath("//input[@placeholder='Tài khoản đăng nhập']")).sendKeys("automationfc");
        driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']")).sendKeys("automationfc");

        driver.findElement(By.cssSelector("div.auth-form>form>div>button")).click();

        Assert.assertTrue(driver.findElement(loginPopUp).isDisplayed());

        driver.findElement(By.cssSelector("h2#mui-224>button")).click();
        }
    @Test
    public void TC_2_Kyna() throws InterruptedException {
        driver.get("https://skills.kynaenglish.vn/dang-nhap");

        By loginPopUp = By.cssSelector("div#k-popup-account-login-mb>div.modal-dialog");

        Assert.assertTrue(driver.findElement(loginPopUp).isDisplayed());

        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");

        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");

    }

    @Test
    public void TC_3_Tiki() throws InterruptedException {
        driver.get("https://tiki.vn/");

        By markettingPopUp = By.cssSelector("div#VIP_BUNDLE");

        Assert.assertTrue(driver.findElement(markettingPopUp).isDisplayed());

        driver.findElement(By.cssSelector("div#VIP_BUNDLE img[alt='close-icon']")).click();
        Thread.sleep(3000);

        Assert.assertFalse(driver.findElement(markettingPopUp).isDisplayed());

    }

    @Test
    public void TC_4_FaceBook() throws InterruptedException {
        driver.get("https://www.facebook.com/");

        driver.findElement(By.cssSelector("//a[@data-testid='open-registration-form-button']")).click();

      By SignupPopupBy = By.xpath("//div[text()='Create a new account']/parent::div/parent::div");
      Thread.sleep(3000);

      Assert.assertTrue(driver.findElement(SignupPopupBy).isDisplayed());

    }
        @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
