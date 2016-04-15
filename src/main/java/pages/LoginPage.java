package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.UserGenerator;

public class LoginPage {

	private Logger logger = LogManager.getRootLogger();
	private WebDriver driver;
	
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


	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}

	public HomePage login(String userName) {
		logger.info("Loggin");
		email.sendKeys(UserGenerator.getUserFromMap(userName).getEmail());
		nextButton.click();
		password.sendKeys(UserGenerator.getUserFromMap(userName).getPassword());
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
