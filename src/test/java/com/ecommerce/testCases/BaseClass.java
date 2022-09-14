package com.ecommerce.testCases;

import com.ecommerce.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseClass {
    ReadConfig rc = new ReadConfig();

    public String baseURL = rc.getBaseUrl();
    public String username = rc.getUsername();
    public String password = rc.getPassword();
    public static WebDriver driver;
    public static Logger logger;

    @BeforeTest
    @Parameters("browser")
    public void setup(String br) {

        if(br.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + rc.getChromePath());
            driver = new ChromeDriver();
        }
        else if(br.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + rc.getFirefoxPath());
            driver = new FirefoxDriver();
        }
        else if(br.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + rc.getIEPath());
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Comment for log
        logger = LogManager.getLogger(this.getClass());

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
