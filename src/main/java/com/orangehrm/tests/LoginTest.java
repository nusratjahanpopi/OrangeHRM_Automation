package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ConfigReader;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        ConfigReader config = new ConfigReader();

        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password")
        );

        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }
    @Test
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "wrongUser",
                "wrongPassword"
        );

        Assert.assertTrue(
                loginPage.isLoginErrorDisplayed(),
                "Login error message was not displayed"
        );
    }
}