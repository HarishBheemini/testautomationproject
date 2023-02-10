package com.auto.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.auto.qa.constants.Constants;
import com.auto.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	@SuppressWarnings("deprecation")
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		try { 
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\pavan\\selenium-workspace\\"
					+ "Test\\src\\main\\java\\com\\auto\\qa\\config\\Config.properties");
			prop.load(ip);
		} catch(FileNotFoundException fe) {
			fe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void initiliaseWebDriver() {
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("WebDriver.chrome.driver", "C:\\Users\\pavan\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
	}
}
