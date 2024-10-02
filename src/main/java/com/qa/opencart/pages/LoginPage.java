package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.ui.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private By locators: Page Objects
	private By username = By.id("input-email");
	private By userPwd = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By logo = By.cssSelector(".img-responsive");

	// 2. public page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	// public page Action/Method
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.LOGIN_PAGE_TITLE,
				AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Login page title : " + title);
		return title;
	}

	public String getLoginPageUrl() {
		String url = eleUtil.waitForURLContainsAndReturn(AppConstants.LOGIN_PAGE_FRACTION_URL,
				AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Login page title : " + url);
		return url;
	}

	public boolean isForgotPwdLinkDisplayed() {
		return eleUtil.isElementDisplayed(forgotLink);
	}

	public boolean isLogoDisplayed() {
		return eleUtil.isElementDisplayed(logo);
	}

	public String doLogin(String userName, String pwd) {
		eleUtil.waitForElementVisible(username, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.doSendKeys(userPwd, pwd);
		eleUtil.doClick(loginBtn);
		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.ACCOUNTS_PAGE_TITLE,
				AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Account page title : " + title);
		return title;

	}
	
	public RegisterPage navigateToRegisterPage() {
		eleUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}

}
