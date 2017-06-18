package com.myrbshoetests.util;

import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverHelper 
{
	public static WebDriver createDriver(String browser, String windowsChromeDriver, String windowsIEDriver, 
			String windowsGeckoDriver, String windowsEdgeDriver, String macChromeDriver, String macIEDriver, String macGeckoDriver, 
			String remoteHubURL, String remoteWindowsURL, String parallel, String browserRemote) throws MalformedURLException
		{
			String osName = System.getProperty("os.name");
			System.out.println(System.getProperty("os.name"));		
			WebDriver driver = null;		
			if(osName.contains("Windows")) {
				
				if(parallel.equalsIgnoreCase("parallelTests")) {
					
					if(browserRemote.equalsIgnoreCase("chromeRemote")) {
					/*	System.out.println("Opening Chrome Driver");					
						DesiredCapabilities capability = DesiredCapabilities.chrome();
						capability.setBrowserName("chrome");
						capability.setPlatform(Platform.ANY);
						driver = new RemoteWebDriver(new URL(remoteHubURL), capability); */
						
						System.setProperty("webdriver.chrome.driver",windowsChromeDriver);				
					 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			            ChromeOptions options = new ChromeOptions();
			            capabilities.setCapability("chrome.binary",windowsChromeDriver);  
			            capabilities.setCapability(ChromeOptions.CAPABILITY, options); 
			            driver = new ChromeDriver(capabilities);  
						
					}
					else if(browserRemote.equalsIgnoreCase("firefoxRemote")) {
					/*	System.out.println("Opening IE Driver");					
						DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
						capability.setBrowserName("internetExplorer");
						capability.setPlatform(Platform.ANY);
						driver = new RemoteWebDriver(new URL(remoteHubURL), capability); */
						
						 System.setProperty("webdriver.gecko.driver",windowsGeckoDriver);
							DesiredCapabilities capabilities = DesiredCapabilities.firefox();
						    capabilities.setCapability("marionette",true);
							driver = new FirefoxDriver(capabilities);
						
					}
					
					else if(browserRemote.equalsIgnoreCase("edgeRemote")) {
						/*	System.out.println("Opening IE Driver");					
							DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
							capability.setBrowserName("internetExplorer");
							capability.setPlatform(Platform.ANY);
							driver = new RemoteWebDriver(new URL(remoteHubURL), capability); */
							
						System.setProperty("webdriver.edge.driver",windowsEdgeDriver);
						EdgeOptions options = new EdgeOptions();
						options.setPageLoadStrategy("eager");
						driver = new EdgeDriver();
							
						}
					
					else
					{
						throw new InvalidParameterException(browserRemote + "- is not a valid web browser for remote driver.");
					}
				}
				
			else {
					
						if(browser.equalsIgnoreCase("Firefox")) {
					
						//driver = new FirefoxDriver();							
						//To run Firefox profile
						/*ProfilesIni profile = new ProfilesIni(); 
						FirefoxProfile myprofile = profile.getProfile("profileAutomationQA"); 
						driver = new FirefoxDriver(myprofile); */				
				    // to run newer version of firefox	     
					    System.setProperty("webdriver.gecko.driver",windowsGeckoDriver);
						DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					    capabilities.setCapability("marionette",true);
						driver = new FirefoxDriver(capabilities);
						
					}
					else if(browser.equalsIgnoreCase("Chrome"))
					{
						System.setProperty("webdriver.chrome.driver",windowsChromeDriver);				
					 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			            ChromeOptions options = new ChromeOptions();
			            capabilities.setCapability("chrome.binary",windowsChromeDriver);  
			            capabilities.setCapability(ChromeOptions.CAPABILITY, options); 
			            driver = new ChromeDriver(capabilities);     
			            //	driver = new ChromeDriver();
					}
					else if(browser.equalsIgnoreCase("IE"))
					{
						System.setProperty("webdriver.ie.driver",windowsIEDriver);			
						driver = new InternetExplorerDriver();			
					}
					else if(browser.equalsIgnoreCase("Edge"))
					{
						System.setProperty("webdriver.edge.driver",windowsEdgeDriver);
						EdgeOptions options = new EdgeOptions();
						options.setPageLoadStrategy("eager");
						driver = new EdgeDriver();
					}
					else if(browser.equalsIgnoreCase("ChromeRemoteMAC"))
					{			
						DesiredCapabilities capability = DesiredCapabilities.chrome();
						capability.setBrowserName("chrome");
						capability.setPlatform(Platform.MAC);
						driver = new RemoteWebDriver(new URL(remoteHubURL), capability);
					}
					else if(browser.equalsIgnoreCase("FirefoxRemoteMAC"))
					{	
						DesiredCapabilities capability = DesiredCapabilities.firefox();
						capability.setBrowserName("firefox");
						capability.setPlatform(Platform.MAC);
						driver = new RemoteWebDriver(new URL(remoteHubURL), capability);		
					}
					else if(browser.equalsIgnoreCase("ChromeRemoteWindows"))
					{	
						DesiredCapabilities capability = DesiredCapabilities.chrome();
						capability.setBrowserName("chrome");
						capability.setPlatform(Platform.WINDOWS);
						driver = new RemoteWebDriver(new URL(remoteHubURL), capability);
					}	
						
					else
					{
						throw new InvalidParameterException(browser + "- is not a valid web browser for web driver.");
					}
				}
				
			}	
			
			if(osName.contains("Mac")) {
				
				if(parallel.equalsIgnoreCase("parallelTests")) {
					
					if(browserRemote.equalsIgnoreCase("chromeRemote")) {
						System.out.println("Opening Chrome Driver");					
						DesiredCapabilities capability = DesiredCapabilities.chrome();
						capability.setBrowserName("chrome");
						capability.setPlatform(Platform.ANY);
						driver = new RemoteWebDriver(new URL(remoteHubURL), capability);
					}
					else if(browserRemote.equalsIgnoreCase("ieRemote")) {
						System.out.println("Opening IE Driver");					
						DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
						capability.setBrowserName("internetExplorer");
						capability.setPlatform(Platform.ANY);
						driver = new RemoteWebDriver(new URL(remoteHubURL), capability);
					}
					else
					{
						throw new InvalidParameterException(browserRemote + "- is not a valid web browser for remote driver.");
					}
				}
				
				else {
				
					if(browser.equalsIgnoreCase("Firefox"))
					{				
						/* to use older version of firefox driver
						driver = new FirefoxDriver();
						*/			
						
						System.setProperty("webdriver.gecko.driver",macGeckoDriver);
						DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					    capabilities.setCapability("marionette",true);
						driver = new FirefoxDriver(capabilities);
					}
					else if(browser.equalsIgnoreCase("Chrome"))
					{
						System.setProperty("webdriver.chrome.driver", macChromeDriver);
						driver = new ChromeDriver();								
					}
					else if(browser.equalsIgnoreCase("IE"))
					{
						System.setProperty("webdriver.ie.driver", macIEDriver);
						driver = new InternetExplorerDriver();
						
					/*	DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
						capability.setBrowserName("ie");
						capability.setPlatform(Platform.WINDOWS);
						driver = new RemoteWebDriver(new URL("http://10.1.2.99:"), capability); */
					}
					else if(browser.equalsIgnoreCase("ChromeRemoteWindows"))
					{
						DesiredCapabilities capability = DesiredCapabilities.chrome();
						capability.setBrowserName("chrome");
						capability.setPlatform(Platform.WINDOWS);
						driver = new RemoteWebDriver(new URL(remoteWindowsURL), capability);
					}
					else if(browser.equalsIgnoreCase("FirefoxRemoteWindows"))
					{	
						DesiredCapabilities capability = DesiredCapabilities.firefox();
						capability.setBrowserName("firefox");
						capability.setPlatform(Platform.WINDOWS);
						driver = new RemoteWebDriver(new URL(remoteWindowsURL), capability);		
					}
					else
					{
						throw new InvalidParameterException(browser + "- is not a valid web browser for web driver.");
					}		
				}
			}	
			
			if(osName.contains("Linux")) {
				
				if(parallel.equalsIgnoreCase("parallelTests")) {
					
					if(browserRemote.equalsIgnoreCase("chromeRemote")) {
						System.out.println("Opening Chrome Driver");					
						DesiredCapabilities capability = DesiredCapabilities.chrome();
						capability.setBrowserName("chrome");
						capability.setPlatform(Platform.ANY);
						driver = new RemoteWebDriver(new URL(remoteHubURL), capability);
					}
					else if(browserRemote.equalsIgnoreCase("ieRemote")) {
						System.out.println("Opening IE Driver");					
						DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
						capability.setBrowserName("internetExplorer");
						capability.setPlatform(Platform.ANY);
						driver = new RemoteWebDriver(new URL(remoteHubURL), capability);
					}
					else
					{
						throw new InvalidParameterException(browserRemote + "- is not a valid web browser for remote driver.");
					}
				}
				
			else {
				
					if(browser.equalsIgnoreCase("Firefox"))
					{				
						/* to use older version of firefox driver
						driver = new FirefoxDriver();
						*/						
						System.setProperty("webdriver.gecko.driver",macGeckoDriver);
						DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					    capabilities.setCapability("marionette",true);
						driver = new FirefoxDriver(capabilities);
					}
					else if(browser.equalsIgnoreCase("Chrome"))
					{
						System.setProperty("webdriver.chrome.driver", macChromeDriver);
						driver = new ChromeDriver();								
					}
					else if(browser.equalsIgnoreCase("IE"))
					{
						System.setProperty("webdriver.ie.driver", macIEDriver);
						driver = new InternetExplorerDriver();
						
					/*	DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
						capability.setBrowserName("ie");
						capability.setPlatform(Platform.WINDOWS);
						driver = new RemoteWebDriver(new URL("http://10.1.2.99:"), capability); */
					}
					else if(browser.equalsIgnoreCase("ChromeRemoteLinux"))
					{
						DesiredCapabilities capability = DesiredCapabilities.chrome();
						capability.setBrowserName("chrome");
						capability.setPlatform(Platform.LINUX);
						
						System.out.println(capability);
						driver = new RemoteWebDriver(new URL(remoteHubURL), capability);
					}
					else if(browser.equalsIgnoreCase("FirefoxRemoteWindows"))
					{	
						DesiredCapabilities capability = DesiredCapabilities.firefox();
						capability.setBrowserName("firefox");
						capability.setPlatform(Platform.WINDOWS);
						driver = new RemoteWebDriver(new URL(remoteWindowsURL), capability);		
					}
					else
					{
						throw new InvalidParameterException(browser + "- is not a valid web browser for web driver.");
					}		
				}
			
			}	
			
			//Set implicityWait time to 15 seconds
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			//Set to full screen
			driver.manage().window().maximize();
			return driver;
		}
		
		public static void quitDriver(WebDriver driver)
		{
			driver.quit();
		}	
}