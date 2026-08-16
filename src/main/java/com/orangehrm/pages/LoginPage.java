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
    By dashboard = By.xpath("//h6[normalize-space()='Dashboard']");

    public void login(String user, String pass) {

        waitUtils.waitForElementVisible(username)
                .sendKeys(user);

        waitUtils.waitForElementVisible(password)
                .sendKeys(pass);

        waitUtils.waitForElementClickable(loginBtn)
                .click();
    }
    public boolean isLoginSuccessful() {
        try {
            waitUtils.waitForElementVisible(dashboard);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isDashboardDisplayed() {
        return waitUtils.waitForElementVisible(dashboard).isDisplayed();
    }
    public boolean isLoginErrorDisplayed() {
        try {
            By errorMessage = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");
            waitUtils.waitForElementVisible(errorMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isUsernameRequiredDisplayed() {
        try {
            By usernameError = By.xpath("//input[@name='username']/following::span[contains(@class,'oxd-input-field-error-message')][1]");

            waitUtils.waitForElementVisible(usernameError);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isPasswordRequiredDisplayed() {
        try {
            By passwordError = By.xpath("//input[@name='password']/following::span[contains(@class,'oxd-input-field-error-message')][1]");

            waitUtils.waitForElementVisible(passwordError);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
