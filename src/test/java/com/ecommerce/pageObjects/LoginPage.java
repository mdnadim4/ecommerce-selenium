package com.ecommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id="Email")
    WebElement textEmail;

    @FindBy(id="Password")
    WebElement textPassword;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logoutBtn;

    public void setUsername(String uname) {
        textEmail.sendKeys(uname);
    }

    public void setPassword(String pwd) {
        textPassword.sendKeys(pwd);
    }

    public void clickLogin() {
        loginBtn.click();
    }

    public void  clickLogout() {
        logoutBtn.click();
    }
}
