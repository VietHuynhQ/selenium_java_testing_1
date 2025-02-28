package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Default_DropDown {
    WebDriver driver;

    Select select;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
        public void TC_1_Facebook_SignUp() {
        driver.get("https://www.facebook.com/r.php?entry_point=login");

        select = new Select(driver.findElement(By.cssSelector("select#day")));

        // Chọn 1 item
        select.selectByVisibleText("25");

        // chọn xong verify đã chọn thành công
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"25");

        // Verify cái dropdown có phải là multiple select hay chưa
        // Nếu là  multipe trả về true
        // Nếu là single trả về false
        Assert.assertFalse(select.isMultiple());

        // verify xem tổng số lượng  trong dropdown là bao nhiêu
        Assert.assertEquals(select.getOptions().size(),31);

        // Month
        select = new Select(driver.findElement(By.cssSelector("select#month")));

        select.selectByVisibleText("Jun");

        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Jun");

        // Years
        select = new Select(driver.findElement(By.cssSelector("select#year")));

        select.selectByVisibleText("2006");

        Assert.assertEquals(select.getFirstSelectedOption().getText(),"2006");

        }
    @Test
    public void TC_2_() {

    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
