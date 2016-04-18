package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.NewEmail;
import pages.ReadEmail;
import pages.Spam;
import utils.DriverManager;
import utils.PropertyProvider;
import utils.UserGenerator;

public class Example {

	private WebDriver driver;
	private final String gmail = PropertyProvider.getProperty("url");
	private final String bodyEmail = "hello";

	@BeforeTest
	public void setUp() {
		driver = DriverManager.getDriver();
		driver.get(gmail);
	}

	@Test
	public void test() {
		// login u1
		LoginPage page = new LoginPage(driver);
		UserGenerator.userGenerate("user1");
		HomePage home = page.login("user1");
		// send email to u2
		NewEmail email = home.openNewEmail();
		UserGenerator.userGenerate("user2");
		String topic = email.fillInAndSendNewEmail("user2", bodyEmail);
		// logout u1
		home.logout();
		page.logoutFromAccount();
		// login u2
		home = page.login("user2");
		// find email, mark spam
		home.sendLetterToSpam(topic);
		// logout
		home.logout();
		page.logoutFromAccountSecondTime();
		// login u1
		page.login("user1");
		// send email u2
		home.openNewEmail();
		String topicRepeat = email.fillInAndSendNewEmail("user2", bodyEmail);
		// logout
		home.logout();
		page.logoutFromAccountSecondTime();
		// login u2
		home = page.login("user2");
		// go to spam
		Spam spam= home.goToSpam();
		// find email
		Assert.assertTrue(spam.findEmailInSpam(topicRepeat));

	}

	// @AfterTest
	/// public void tearDown() {
	// DriverManager.closeDriver();
	// }

}
