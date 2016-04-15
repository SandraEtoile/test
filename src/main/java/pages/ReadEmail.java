package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ReadEmail {

	private Logger logger = LogManager.getRootLogger();
	private WebDriver driver;
	
	@FindBy(xpath = "//img[@class='hA T-I-J3']")
	private WebElement optionsMenu;
	
	@FindBy(xpath = "//div[@class='cj' AND @act='9']")
	private WebElement toSpamButton;

	public ReadEmail(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}

	public void sendEmailToSpam() {
		logger.info("email marked as spam");
		optionsMenu.click();
		toSpamButton.click();
	}

}
