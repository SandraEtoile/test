package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

	private Logger logger = LogManager.getRootLogger();
	private WebDriver driver;

	@FindBy(xpath = "//a[@href='https://mail.google.com/mail/#settings/fwdandpop']")
	private WebElement forwardingAndPopLink;
	
	@FindBy(xpath = "//input[@type='button' and @act='add']")
	private WebElement addEmailForForwardingButton;
	

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void forwardInSettings() {
		forwardingAndPopLink.click();
	}
}
