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

public class Topic_22_Random_Popup {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
        public void TC_1_Javacodegeeks() throws InterruptedException {
            driver.get("https://www.javacodegeeks.com/");

            By newLetterPopupBy = By.xpath("//div[@data-title='Newsletter Free eBooks'" +
                    " and not(contains(@style,'display:none'))]");



            if(driver.findElements(newLetterPopupBy).size() > 0 && driver.findElements(newLetterPopupBy).get(0).isDisplayed()){
                driver.findElement(By.xpath("//div[@data-title='Newsletter Free eBooks'" +
                        " and not(contains(@style,'display:none'))]//a[contains(@onclick,'lepopup_close')]")).click();
                Thread.sleep(3000);
            }
            driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile");
            driver.findElement( By.cssSelector("form#search span.tie-search-icon")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("header>h1.page-title")).isDisplayed());
        }
    @Test
    public void TC_2_VNK() throws InterruptedException {
        driver.get("https://vnk.edu.vn/");

        By maketingPopupBy = By.cssSelector("div.popmake-content");

        if(!driver.findElements(maketingPopupBy).isEmpty()
                && driver.findElements(maketingPopupBy).get(0).isDisplayed()){
            System.out.println("____GO TO IF_____");
            driver.findElement(By.cssSelector("div.popnake-content-button")).click();
            Thread.sleep(3000);
        }
        //
        driver.findElement(By.xpath("//ul[@id='mega-menu-primary']//a[text()='Liên hệ']")).click();


        Assert.assertTrue(driver.findElement(By.cssSelector("div.title-content>h1")).isDisplayed());

    }
    @Test
    public void TC_3_dehieu() throws InterruptedException {
        driver.get("https://dehieu.vn/");

        By contentPopupBy = By.cssSelector("div.modal-content");

        if(!driver.findElements(contentPopupBy).isEmpty()
                && driver.findElements(contentPopupBy).get(0).isDisplayed()){
            System.out.println("____GO TO IF_____");
            driver.findElement(By.cssSelector("div.modal-content button.close")).click();
            Thread.sleep(3000);
        }
        System.out.println("____GO TO IF_____");
        driver.findElement(By.cssSelector("input.search-form")).sendKeys("khoá học Lập dự toán M&E");
        driver.findElement(By.cssSelector("button.header-search")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.course-item-detail a")).getAttribute("title"),"khoá học Lập dự toán M&E");



    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
