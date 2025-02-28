package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_WebElement_exercise_I {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();

    }

    @Test
        public void TC_1_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement mailTextBox = driver.findElement(By.cssSelector("input#mail"));

        if(mailTextBox.isDisplayed()) {
            System.out.println("Element mail is displayed");

            mailTextBox.sendKeys("Automation Testing");
        } else {
            System.out.println("Element mail is not displayed");
        }

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));

        if(ageUnder18Radio.isDisplayed()) {
            System.out.println("Element age is displayed");

            ageUnder18Radio.click();
        } else {
            System.out.println("Element age is not displayed");
        }

        WebElement educationTextErea = driver.findElement(By.cssSelector("textarea#edu"));

        if(educationTextErea.isDisplayed()) {
            System.out.println("Element age is displayed");

            educationTextErea.sendKeys("Automation Testing");
        } else {
            System.out.println("Element age is not displayed");
        }

        WebElement user5Text = driver.findElement(By.xpath("//h5[text()='Name: User5']"));

        if(educationTextErea.isDisplayed()) {
            System.out.println("Element  is displayed");

        } else {
            System.out.println("Element  is not displayed");
        }

        }
    @Test
    public void TC_2_Enebled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement mailTextBox = driver.findElement(By.cssSelector("input#mail"));

        if(mailTextBox.isEnabled()) {
            System.out.println("mailTextBox mail is Enable");

        } else {
            System.out.println("mailTextBox mail is displayed");
        }

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));

        if(ageUnder18Radio.isEnabled()) {
            System.out.println("ageUnder18Radio age is isEnabled");

        } else {
            System.out.println("ageUnder18Radio age is displayed");
        }

        WebElement passwordTextBox = driver.findElement(By.cssSelector("input#disable_password"));

        if(passwordTextBox.isEnabled()) {
            System.out.println("passwordTextBox age is isEnabled");

        } else {
            System.out.println("passwordTextBox age is displayed");
        }

        WebElement biographyTextErea = driver.findElement(By.cssSelector("textarea#bio"));

        if(biographyTextErea.isEnabled()) {
            System.out.println("biographyTextErea age is isEnabled");

        } else {
            System.out.println("biographyTextErea age is displayed");
        }
    }
    @Test
    public void TC_3_Selected() {
    // isSelected : kiểm  1 element được chọn thành  ( Radio / checkBox / dropDown )
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));

        if(ageUnder18Radio.isSelected()) {
            System.out.println("ageUnder18Radio age is isSelected");

        } else {
            System.out.println("ageUnder18Radio age is not isSelected");
        }

        WebElement interestCheckBox = driver.findElement(By.cssSelector("input#development"));

        if(interestCheckBox.isSelected()) {
            System.out.println("interestCheckBox age is isSelected");

        } else {
            System.out.println("interestCheckBox age is not isSelected");
        }

        ageUnder18Radio.click();
        interestCheckBox.click();

        if(ageUnder18Radio.isSelected()) {
            System.out.println("ageUnder18Radio age is isSelected");

        } else {
            System.out.println("ageUnder18Radio age is not isSelected");
        }


        if(interestCheckBox.isSelected()) {
            System.out.println("interestCheckBox age is isSelected");

        } else {
            System.out.println("interestCheckBox age is not isSelected");
        }


    }
    @Test
    public void TC_4_MailChimp_Register_Validate() {
        driver.get("https://login.mailchimp.com/signup/");

        driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc.vn@gmail.com");
        driver.findElement(By.cssSelector("input#email")).sendKeys(Keys.TAB);

        // Only Number
        driver.findElement(By.id("new_password")).sendKeys("12345");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue( driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // Only lowercase
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("testing");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue( driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // Only uppercase
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("TESTING");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue( driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // Only speacial char
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("!@#$%");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue( driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // Contains username
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("automation");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue( driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());

        // Full
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("Test123!@#");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);

        Assert.assertFalse( driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse( driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse( driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse( driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse( driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertFalse( driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());



    }

    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
