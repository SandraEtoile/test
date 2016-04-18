package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class Listener extends TestListenerAdapter{
	
	public static final String PNG=".png";
	
	@Override
    public void onTestFailure(ITestResult testResult) {
        takeScreenshot();
    }

    private void takeScreenshot() {
        String path;
        try {
            File source = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            path = "./target/screenshots/" + PNG;
            FileUtils.copyFile(source, new File(path));
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
    }

}
