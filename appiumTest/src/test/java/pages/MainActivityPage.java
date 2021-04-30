package pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainActivityPage {
	protected final AppiumDriver driver;
	
	public MainActivityPage(AppiumDriver driver) {
        this.driver =driver;
    }
	
	public MobileElement getStartedBttn() {
		return (MobileElement) driver.findElementById("action_button_text");
	}
	

}
