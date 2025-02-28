package webdriver;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_07_WebElement_Commands {
    WebDriver driver;

    WebElement element;


    @Test
        public void TC_1_() {
            driver.findElement(By.xpath("")).click();

            element =  driver.findElement(By.xpath(""));

            element.click();

            //
            element.clear();
            element.sendKeys("viet@gmail.com");
            element.sendKeys(Keys.ENTER);

            //
            driver.findElement(By.cssSelector("div.login-page"))
                    .findElement(By.cssSelector("div.customer-blocks"))
                    .findElement(By.id("Email"));

            driver.findElement(By.cssSelector("div.login-page div.customer-blocks input#Email"));

            // Tác dụng với Form
            // thẻ form
            driver.findElement(By.id("Email")).sendKeys("");
            driver.findElement(By.id("Password")).sendKeys("");
            driver.findElement(By.id("Password")).submit();

            // Áp dụng cho tất cả các loại eleme
            // Kiểm tra element có hiển thị hay không
            // Có Size > 0 : weight/height > 0
            // Nhìn thấy thao tác được
            element.isDisplayed();

            Assert.assertTrue(element.isDisplayed());
            Assert.assertFalse(element.isDisplayed());

            // Kiểm tra 1 element đã được chọn hay chưa
            element.isSelected();

            // Áp dụng cho tất cả các loại
            // Kiểm tra 1 element có bị disable hay không
            element.isEnabled();

            element.getCssValue("background-color");

            element.getText();

            element.getAttribute("placeholder");



            driver.manage().window().getSize();

            element.getSize();

            driver.manage().window().getPosition();

            element.getLocation();

            Rectangle rectangle = element.getRect();

            // Size
            rectangle.getWidth();
            rectangle.getHeight();
            rectangle.getDimension();

            // Location
            rectangle.getX();
            rectangle.getY();
            rectangle.getPoint();

            // Lấy ra thẻ HTML của element đó
            // element A
            String tagname =   driver.findElement(By.cssSelector("FirstName")).getTagName();

            // element B
            driver.findElement(By.xpath("//" +tagname + "[@id='LastName']"));

            // Popup
            element.getShadowRoot();

            // Framework : HTML report
            element.getScreenshotAs(OutputType.BYTES);
            element.getScreenshotAs(OutputType.FILE);
            element.getScreenshotAs(OutputType.BASE64);



        }



}
