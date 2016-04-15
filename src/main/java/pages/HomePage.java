package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

	private Logger logger = LogManager.getRootLogger();
	private WebDriver driver;

	@FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
	private WebElement newEmailButton;

	@FindBy(xpath = "//input[@id='gbqfq']")
	private WebElement searchBar;

	@FindBy(xpath = "//button[@id='gbqfb']")
	private WebElement searchButton;

	@FindBy(xpath = "//span[@class='gb_1a gbii']")
	private WebElement photoIcon;

	@FindBy(xpath = "//a[@id='gb_71']")
	private WebElement logoutButton;

	@FindBy(xpath = "//div[@class='asa']")
	private WebElement toSpamButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public LoginPage logout() {
		photoIcon.click();
		logoutButton.click();
		return new LoginPage(driver);
	}

	public NewEmail openNewEmail() {
		logger.info("Writing");
		newEmailButton.click();
		return new NewEmail(driver);
	}

	public Spam goToSpam() {
		logger.info("go to spam");
		searchBar.sendKeys("in:spam");
		searchButton.click();
		return new Spam(driver);

	}

	public ReadEmail findEmailByTopic(String topicLine) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement topic = driver.findElement(By.xpath("//span//b[contains(text(),'" + topicLine + "')]/.."));
		wait.until(ExpectedConditions.elementToBeClickable(topic));
		topic.click();
		return new ReadEmail(driver);
	}

}
