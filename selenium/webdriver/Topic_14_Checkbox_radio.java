package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;

public class Topic_14_Checkbox_radio {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();

        jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
        public void TC_1_tele() throws InterruptedException {
            driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
              driver.manage().window().fullscreen();
            Thread.sleep(3000);

            // verify checkbox/ radio enabled / disabled
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isEnabled());

        // verify checkbox/ radio selected / diselected
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isSelected());

        // Select to Dual-zone air conditioning checkbox
        By dualZoneBy = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        // cuộn trang xuống
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0.300)");

        // nếu chưa chọn mới click
        if(!driver.findElement(dualZoneBy).isSelected()){
            driver.findElement(dualZoneBy).click();
        }
        Assert.assertTrue( driver.findElement(dualZoneBy).isSelected());

        // De-select to dual-zone air conditioning checkbox (bỏ chọn )
        if(driver.findElement(dualZoneBy).isSelected()){
            driver.findElement(dualZoneBy).click();
        }
        Assert.assertFalse( driver.findElement(dualZoneBy).isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0.300)");

        By twoPertrolBy = By.xpath("//label[text()='1.4 Petrol, 92kW']/preceding-sibling::span/input");

        if (!driver.findElement(twoPertrolBy).isSelected()) {
            driver.findElement(twoPertrolBy).click();
        }
        Assert.assertTrue( driver.findElement(dualZoneBy).isSelected());


    }
    @Test
    public void TC_2_Multiple() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        // Select all checkbox
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("span.form-checkbox-item>input"));

        // click all
        for(WebElement checkbox : checkboxes){
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }
        // Verify all checkbox isSelected
      for (WebElement checkbox: checkboxes) {
        Assert.assertTrue(checkbox.isSelected());
      }

        // Deselect all checkbox
        for(WebElement checkbox : checkboxes){
            if(checkbox.isSelected()){
                checkbox.click();
            }
        }
        //Verify all checkbos Deselect
        for (WebElement checkbox: checkboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }
        // Select 1 in all + verify
        driver.findElement(By.cssSelector("input[value='Liver Disease']")).click();
        driver.findElement(By.cssSelector("input[value='High Blood Pressure']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Liver Disease']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='High Blood Pressure']")).isSelected());

        //
        for(WebElement checkbox : checkboxes){
            if(!checkbox.isSelected() && checkbox.getAttribute("value").equals("Heart Attack")){
                checkbox.click();
            }
        }
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Heart Attack']")).isSelected());
    }
    @Test
    public  void TC_3_Unbutu() {
        driver.get("https://login.ubuntu.com/");
       // By newUserRadioLabel = By.cssSelector("label.new-user");
        // driver.findElement(newUserRadioLabel).click() ;
      //  Assert.assertTrue(driver.findElement(newUserRadioInput).isSelected());
        //
        By newUserRadioInput = By.cssSelector("input#id_new_user");
        jsExecutor.executeScript("arguments[0].click();",  driver.findElement(newUserRadioInput));
        Assert.assertTrue(driver.findElement(newUserRadioInput).isSelected());

        By termCheckbox = By.cssSelector("input#id_accept_tos");
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(termCheckbox));
        Assert.assertTrue((driver.findElement(termCheckbox).isSelected()));

    }
    @Test
    public  void TC_4_Docs(){
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");

        By hcmRadio = By.xpath("//div[@aria-label='Hồ Chí Minh']");
        By quangNoodleCheckbox = By.xpath("//div[@aria-label='Mì Quảng']");

        driver.findElement(hcmRadio).click();
        Assert.assertEquals(driver.findElement(hcmRadio).getAttribute("aria-checked"), "true");

//check
        if(driver.findElement(quangNoodleCheckbox).getAttribute("aria-checked").equals("false")) {
            driver.findElement(quangNoodleCheckbox).click();

        }
        Assert.assertEquals(driver.findElement(quangNoodleCheckbox).getAttribute("aria-checked"), "true");
// Uncheck
        if(driver.findElement(quangNoodleCheckbox).getAttribute("aria-checked").equals("true")) {
            driver.findElement(quangNoodleCheckbox).click();

        }
        Assert.assertEquals(driver.findElement(quangNoodleCheckbox).getAttribute("aria-checked"), "false");

    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
