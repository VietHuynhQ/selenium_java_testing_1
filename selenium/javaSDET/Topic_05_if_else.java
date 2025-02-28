package javaSDET;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_if_else {
    WebDriver driver;
    @BeforeClass
    public  void initialBrowser() {


    }

    @Test
    public void TC_1_ (){
        String osName = System.getProperty("os.name");
        String browserName = "Chrome";

        if(browserName.equals("IE")) {
            System.out.println("Click to submit button");
        }

        // if else
        if(osName.contains("Window os")){
            System.out.println("Window OS");
        } else {
            System.out.println("Mac or Linux OS");
        }
        System.out.println(osName);

        // if-else if-else

        if (browserName.equals("Chrome"))
        {
            driver = new ChromeDriver();
        } else if(browserName.equals("Firefox")){
            driver = new FirefoxDriver();
        } else  {
            driver = new EdgeDriver();
        }

        // switch-case
        switch (browserName) {
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Chrome" :
                driver = new ChromeDriver();
            default:
                driver = new EdgeDriver();
                break;
        }

    }


}
