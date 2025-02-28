package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_11_Dropdown_exercise {
    WebDriver driver;

    Select select;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();

    }

    @Test
        public void TC_1_dropdown_verify() {
        driver.get("https://rode.com/en/support/where-to-buy");

        select = new Select(driver.findElement(By.id("country")));

        Assert.assertFalse(select.isMultiple());

        select.selectByVisibleText("Vietnam");

        driver.findElement(By.id("map_search_query")).sendKeys("HO CHI MINH");

        driver.findElement(By.xpath("//button[text()='Search']")).click();

        List<WebElement> dealers = driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div/div[@class='col-lg-6 p-1 overflow-hidden']"));
        Assert.assertEquals(dealers.size(), 16);

        }
    @Test
    public void TC_2_() {

    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
