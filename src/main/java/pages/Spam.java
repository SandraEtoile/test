package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Spam {

	private Logger logger = LogManager.getRootLogger();
	private WebDriver driver;

	@FindBy(xpath = "")
	private WebElement searchBar;

	public Spam(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public boolean findEmailInSpam(String topicLine){
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement topic = driver.findElement(By.xpath("//span//b[contains(text(),'" + topicLine + "')]/.."));
		//wait.until(ExpectedConditions.visibilityOf(topic));
		if(ExpectedConditions.visibilityOf(topic) != null){
			return true;
		}
		else{
			return false;
		}
	}

}
