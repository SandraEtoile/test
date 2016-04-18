package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TopicGenerator;
import utils.UserGenerator;

public class NewEmail {

	private Logger logger = LogManager.getRootLogger();
	private WebDriver driver;

	@FindBy(xpath = "//textarea[@name='to']")
	private WebElement toWho;

	@FindBy(xpath = "//input[@name='subjectbox']")
	private WebElement topic;

	@FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
	private WebElement body;

	@FindBy(css = ".aoO")
	private WebElement sendButton;

	public NewEmail(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public String fillInAndSendNewEmail(String userName, String bodyWords) {
		TopicGenerator tp = new TopicGenerator();
		tp.generateTopic();
		String topicLine = TopicGenerator.getTopics();
		logger.info("Loggin");
		toWho.click();
		toWho.sendKeys(UserGenerator.getUserFromMap(userName).getEmail());
		topic.sendKeys(topicLine);
		body.sendKeys(bodyWords);
		sendButton.click();
		return topicLine;
	}
}
