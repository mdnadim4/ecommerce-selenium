package com.ecommerce.testCases;

import com.ecommerce.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    WebDriver driver;

    @Test
    public void login() {
        LoginPage lp = new LoginPage(driver);

        logger.info("Open the url");
        driver.get(baseURL);

        logger.info("Set the username");
        lp.setUsername(username);

        logger.info("Set the password");
        lp.setPassword(password);

        logger.info("Click to login button");
        lp.clickLogin();

        if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
            Assert.assertTrue(true);
        }else {
            Assert.assertFalse(false);
        }

        logger.info("Click to logout button");
        lp.clickLogout();
    }
}
