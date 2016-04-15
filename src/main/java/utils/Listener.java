package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class Listener extends TestListenerAdapter{
	
	public static final String PNG=".png";
	private Logger logger=LogManager.getRootLogger();
	
	@Override
    public void onTestFailure(ITestResult testResult) {
        logger.error(testResult.getName()+ " screenshot " + takeScreenshot());
    }

    private String takeScreenshot() {
        String path;
        try {
            File source = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            path = "./target/screenshots/" + getTimestamp() + PNG;
            FileUtils.copyFile(source, new File(path));
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }

    public String getTimestamp(){
        DateTime dateTime = new DateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy_dd-MMM_HH_mm_sss");
        return dateTime.toString(dateTimeFormatter);
    }
}
