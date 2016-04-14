package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;
import utils.UserGenerator;

public class LoginPage {

	private Logger logger = LogManager.getRootLogger();

	@FindBy(id = "Email")
	private WebElement email;

	@FindBy(id = "next")
	private WebElement nextButton;

	@FindBy(id = "Passwd")
	private WebElement password;

	@FindBy(id = "signIn")
	private WebElement signInButton;

	@FindBy(id = "account-chooser-link")
	private WebElement goToAnotherAccount;

	@FindBy(id = "account-chooser-add-account")
	private WebElement addAccountButton;

	private WebDriver driver = DriverManager.getDriver();

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(this.driver, this);
	}

	public HomePage login(int userNumber) {
		UserGenerator us = new UserGenerator();
		logger.info("Loggin");
		email.sendKeys(us.getUser(userNumber).getEmail());
		nextButton.click();
		password.sendKeys(us.getUser(userNumber).getPassword());
		signInButton.click();
		logger.info("Login finished");
		return new HomePage(driver);
	}

	public LoginPage logoutFromAccount() {
		goToAnotherAccount.click();
		addAccountButton.click();
		return new LoginPage(driver);
	}

}
