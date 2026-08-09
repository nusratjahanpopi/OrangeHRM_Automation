package com.orangehrm.pages;

import com.orangehrm.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[@type='submit']");

    public void login(String user, String pass) {

        waitUtils.waitForElementVisible(username)
                .sendKeys(user);

        waitUtils.waitForElementVisible(password)
                .sendKeys(pass);

        waitUtils.waitForElementClickable(loginBtn)
                .click();
    }
}