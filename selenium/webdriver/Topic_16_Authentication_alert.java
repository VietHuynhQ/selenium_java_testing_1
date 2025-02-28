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

public class Topic_16_Authentication_alert {
    WebDriver driver;
   String username = "";
    String password = "";


    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
        public void TC_1_Authentication_Url() {
        // http or https:// + username + : + password + @ url
        driver.get("https:// " + username + ":" + "password" + "@" + "the-internet.herokuapp.com/basic_auth");

        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(), "Congratulations! You must have the proper credentials.");

        }


    @Test
    public void TC_2_TC_1_Authentication_Navigate() {
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        String basicAuthlink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");

        driver.get(getAuthenticationUrl(basicAuthlink, username, password));

        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(), "Congratulations! You must have the proper credentials.");

    }

    public String getAuthenticationUrl(String link, String username, String password) {
            String[] linkArray = link.split("//");
            return linkArray[0] + "//" + username + ":" + password + "@" +linkArray[1];
    }

    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
