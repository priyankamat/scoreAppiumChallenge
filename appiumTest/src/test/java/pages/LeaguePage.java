package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class LeaguePage {
	protected final AppiumDriver driver;
		
		public LeaguePage(AppiumDriver driver) {
	        this.driver =driver;
	    }
		
		public MobileElement leagueTitle() {
			return (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[2]/android.widget.TextView[1]");
		}
		
		public MobileElement continueBttn() {
			return (MobileElement) driver.findElementById("action_button_text");
		}
		
		public MobileElement dissAllowBttn() {
			return (MobileElement) driver.findElementById("btn_disallow");
		}
		
		public String leagueTitleText() {
			return driver.findElementById("titleTextView").getText();
		}
		
		public List<MobileElement> leagueTeamIcon() {
			List<MobileElement> leagueList = driver.findElementsByXPath("//*[@resource-id='com.fivemobile.thescore:id/icon_container']");
			return leagueList;
		}
		
		public MobileElement getListItemsByName(String name){
			return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.fivemobile.thescore:id/txt_name'][@text='"+name+"']");
			
		}
		
		public List<MobileElement> getTeamListItems(){
			List<MobileElement> leagueList = driver.findElementsByXPath("//*[@resource-id='com.fivemobile.thescore:id/follow_icon']");
			return leagueList;
		}

		public MobileElement teamStats() {
			return (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc='Team Stats']");
		}
		
		public MobileElement playersTab() {
			return (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc='Players']");
			
		}
		
		public MobileElement playerStats() {
			return (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc='Player Stats']");
		}
		
		public MobileElement navigateBackBttn() {
			return (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']");
		}
		
		public MobileElement playerIcon() {
			return (MobileElement) driver.findElementsByXPath("//*[@resource-id='com.fivemobile.thescore:id/player_headshot_image_view']").get(0);
		}
		
		public MobileElement teamIcon() {
			return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.fivemobile.thescore:id/icon_team_logo']");
		}
		
		public MobileElement leagueIcon() {
			return (MobileElement) driver.findElementsByXPath("//*[@resource-id='com.fivemobile.thescore:id/icon']").get(1);
		}
		
		public MobileElement playerName() {
			return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.fivemobile.thescore:id/txt_player_name']");
		}
		
		public MobileElement teamName() {
			return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.fivemobile.thescore:id/team_name']");
		}
		
		public MobileElement leagueName() {
			return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.fivemobile.thescore:id/titleTextView']");
		}
		
		
		
		
		

}
