package test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	AppiumDriver<MobileElement> driver;
	
	@BeforeClass
	public void setUp() {
		try {
			DesiredCapabilities desired = new DesiredCapabilities();
			desired.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			desired.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		    desired.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
			desired.setCapability(MobileCapabilityType.DEVICE_NAME, "Andoid Emulator");
			desired.setCapability("appPackage", "com.fivemobile.thescore");
			desired.setCapability("appActivity", "com.fivemobile.thescore.ui.MainActivity");

			// for ios device
//			desired.setCapability("deviceName","iPhone 5");
//			desired.setCapability("deviceOrientation", "portrait");
//			desired.setCapability("platformName","iOS");
//			desired.setCapability("platformVersion","10.3");
			
	        URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url,desired);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}catch(Exception e) {
			System.out.println("Cause is" + e.getClass());
			System.out.println("Message is "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
		
	}

}
