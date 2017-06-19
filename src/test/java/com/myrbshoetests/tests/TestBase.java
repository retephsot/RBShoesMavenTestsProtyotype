package com.myrbshoetests.tests;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.myrbshoetests.pages.HomePage;
import com.myrbshoetests.util.DataDrivenHelper;
import com.myrbshoetests.util.WebDriverHelper;

public class TestBase {

	protected WebDriver driver;
	protected HomePage homepage;
	protected static Properties testConfig;
	public String baseUrl;

	@BeforeSuite()
	public void beforSuite() throws FileNotFoundException, IOException {
		testConfig = new Properties();
		testConfig.load(new FileInputStream("TestConfig.properties"));
	}

	@BeforeMethod
	@Parameters({"browserRemote"})

	  public void beforeMethod(@Optional String browserRemote) throws MalformedURLException
	  {
	
		driver = WebDriverHelper.createDriver(testConfig.getProperty("browser"), testConfig.getProperty("windowsChromeDriver"), 
				testConfig.getProperty("windowsIEDriver"), testConfig.getProperty("windowsGeckoDriver"), 
				testConfig.getProperty("windowsEdgeDriver"), testConfig.getProperty("macChromeDriver"), 
				testConfig.getProperty("macIEDriver"), testConfig.getProperty("macGeckoDriver"), testConfig.getProperty("remoteHubURL"),
				testConfig.getProperty("remoteWindowsURL"), testConfig.getProperty("parallel"), browserRemote);
		
		baseUrl = testConfig.getProperty("baseUrl");	
		driver.get(baseUrl);

		homepage = new HomePage(driver);

	}

	@DataProvider()
	public Object[][] dataProvider(Method method) {

		DataDrivenHelper ddh = new DataDrivenHelper(testConfig.getProperty("mastertestdatafile"));
		Object[][] testData = ddh.getTestCaseDataSets(testConfig.getProperty("testdatasheet"), method.getName());


		
		return testData;
	}

	@AfterMethod
	public void afterMethod() {
		
		WebDriverHelper.quitDriver(driver);
		
		
	}

}
