package webdriver;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_10_Textbox_Textarea {
    WebDriver driver;

    String firstname, lastname, emailaddress, password, fullName;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        Random random = new Random();

        firstname = "joe";
        lastname = "biden";
        fullName = firstname + random.nextInt() + lastname;
        emailaddress = "joebiden" + random.nextInt(99999)  +"@gmail.com";
        password = "123456789";


    }

    @Test
        public void TC_1_() throws InterruptedException {

        driver.get("https://live.techpanda.org/");


        driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

        driver.findElement(By.xpath("//div[@class='buttons-set']//a[@class='button']")).click();

        driver.findElement(By.id("firstname")).sendKeys(firstname);
        Thread.sleep(3000);
        driver.findElement(By.id("lastname")).sendKeys(lastname);
        Thread.sleep(3000);
        driver.findElement(By.id("email_address")).sendKeys(emailaddress);
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(By.id("confirmation")).sendKeys(password);

        driver.findElement(By.xpath("//button[@title='Register']")).click();




        // tuyênt đối
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
               "Thank you for registering with Main Website Store.");

        String contactinformationText = driver.findElement(By.xpath(
                "//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        System.out.println(contactinformationText);

        // Tương đối
        Assert.assertTrue(contactinformationText.contains(fullName) && contactinformationText.contains(emailaddress));

        driver.findElement(By.xpath("//h3[text()='Contact Information']/following-sibling::a")).click();

        Assert.assertEquals(driver.findElement(By.id("firstname")).getAttribute("value"), firstname);
        Assert.assertEquals(driver.findElement(By.id("lastname")).getAttribute("value"), lastname);
        Assert.assertEquals(driver.findElement(By.id("emailaddress")).getAttribute("value"), emailaddress);

        // Product revview
        driver.findElement(By.xpath("//a[text()='Mobile']"));

        driver.findElement(By.xpath("//h2[@title='Samsung Galaxy']']")).click();

        driver.findElement(By.xpath("//a[text()=''Add Your Review]")).click();

        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys(
                "Good application\nPretyy easy to navigate.");

        driver.findElement(By.cssSelector("input#summary_field")).sendKeys("Good phone");
        driver.findElement(By.cssSelector("input#summary_field")).clear();
        driver.findElement(By.cssSelector("input#summary_field")).sendKeys("AutomationC");

        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Your review has been accepted for moderation.");

        // logout
        driver.findElement(By.cssSelector("div.account-cart-wrapper>a")).click();
        driver.findElement(By.xpath("//div[@title='Log Out']")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/");


    }

    @AfterClass
    public void cleanBrowser () {

        driver.quit();
    }

}
