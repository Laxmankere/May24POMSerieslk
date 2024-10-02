package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.ui.constants.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPagetitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE, "Login title didnt matched");
	}

	@Test
	public void loginPageUrlTest() {
		String actualUrl = loginPage.getLoginPageUrl();
		Assert.assertTrue(actualUrl.contains(AppConstants.LOGIN_PAGE_FRACTION_URL), "Login page url didnt matched");
	}

	@Test
	public void forgotPwdLinkIsPresentTest() {

		Assert.assertTrue(loginPage.isForgotPwdLinkDisplayed(), "forgot password link not displayed");
	}

	@Test
	public void logoIsPresentTest() {

		Assert.assertTrue(loginPage.isLogoDisplayed(), "logo not displayed");
	}

	@Test
	public void loginTest() {
		String accPagetitle = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPagetitle, AppConstants.ACCOUNTS_PAGE_TITLE, "Account page title didnt matched");

	}

}
