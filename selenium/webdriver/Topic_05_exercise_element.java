package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {
    WebDriver driver;
// 1
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com");
    }
// 2
    @Test
        public void TC_1_() {

        }
    @Test
    public void TC_2_() {

    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
