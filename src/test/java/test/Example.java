package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.NewEmail;
import pages.ReadEmail;
import pages.Spam;
import utils.DriverManager;
import utils.PropertyProvider;

public class Example {
	private WebDriver driver;
	private final String gmail = PropertyProvider.getProperty("url");

	@BeforeTest
	public void setUp() {
		driver = DriverManager.getDriver();
		driver.get(gmail);
	}

	@Test
	public void test() { // mark spam not working
		// login u1
		LoginPage page = new LoginPage(driver);
		HomePage home = page.login(0);
		// send email to u2
		NewEmail email = home.createEmail();
		String topic = email.write(1);
		// logout u1
		home.logout();
		page.logoutFromAccount();
		// login u2
		home = page.login(1);
		// find email, mark spam
		ReadEmail read = home.findEmailByTopic(topic);
		read.sendEmailToSpam();
		// logout
		home.logout();
		page.logoutFromAccount();
		// login u1
		page.login(0);
		// send email u2
		home.createEmail();
		email.write(1);
		// logout
		home.logout();
		page.logoutFromAccount();
		// login u2
		home = page.login(1);
		// go to spam
		Spam spam = home.goToSpam();
		// find email
		// spam.findEmailByTopic(topic);
		// Assert.assertTrue(condition);

	}

	// @AfterTest
	// public void tearDown(){
	// DriverManager.closeDriver();
	// }

}
