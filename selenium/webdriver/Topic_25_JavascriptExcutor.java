package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_25_JavascriptExcutor {
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("");
    }

    @Test
        public void TC_1_() {
        // Lấy domain
       WebElement emailTextbox = (WebElement) jsExecutor.executeScript("return document.querySelector(input#Email);");

       // Click vào 1 element nó chẳng quan tâm ẩn / hiện
        // Sai hành vi của End User => Giả lập lại hành vi của End User đang thao tác
               jsExecutor.executeScript("",driver.findElement(By.cssSelector("ul.top-menu.notmobile a[href='/desktops']")));

        emailTextbox.sendKeys("automation@gmail.com");

        WebElement passwordTextbox = driver.findElement(By.cssSelector("input#Password"));

        String loginPageUrl = (String) jsExecutor.executeScript("return document.querySelectorAll(\"input[type=''email]\");");
        }
    @Test
    public void TC_2_() {

    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
