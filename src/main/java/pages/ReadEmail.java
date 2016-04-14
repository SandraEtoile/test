package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;

public class ReadEmail {

	private Logger logger = LogManager.getRootLogger();
	private WebDriver driver = DriverManager.getDriver();

	public ReadEmail(WebDriver driver) {
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//div[@class='asl T-I-J3 J-J5-Ji']")
	private WebElement toSpamButton;

	public void sendEmailToSpam() {
		logger.info("email marked as spam");
		toSpamButton.click();
	}

}
