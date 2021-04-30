package test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import pages.LeaguePage;
import pages.MainActivityPage;

public class ScoreTest extends BaseClass {
	MainActivityPage mainPage;
	LeaguePage league;

	@Test
	public void verifyTeamLeague() {
		String[] dataPlayers = { "Stephen Curry (NBA)",
				"Kevin Durant (NBA)","Lionel Messi (Soccer)"};
					
		mainPage = new MainActivityPage(driver);
		league = new LeaguePage(driver);
		mainPage.getStartedBttn().click();
		Assert.assertEquals(league.leagueTitle().getText(), "Choose your favorite leagues");

		// Select league By name using dataProvider
		league.getListItemsByName("NHL Hockey").click();
		league.continueBttn().click();
		league.dissAllowBttn().click();

		// Select teams By name using dataProvider
		league.getListItemsByName("Toronto Maple Leafs").click();
		league.continueBttn().click();

		// click done
		league.continueBttn().click();
		List<MobileElement> icons = league.leagueTeamIcon();

		// select players
		icons.get(0).click();
		league.playersTab().click();
		league.getListItemsByName("LeBron James (NBA)").click();
		league.navigateBackBttn().click();
	
		//navigate to league page 
		league.leagueIcon().click();
		Assert.assertEquals(league.leagueName().getText(), "NHL Hockey".toUpperCase());
		league.navigateBackBttn().click();
		
		//Navigate to Player page
		league.playerIcon().click();
		Assert.assertTrue("LeBron James (NBA)".contains(league.playerName().getText()));
		league.navigateBackBttn().click();
				
		//Navigate to team page
		league.teamIcon().click();
		Assert.assertEquals(league.teamName().getText(), "Toronto Maple Leafs");
		
		//select player status subtab on Team page
		league.playerStats().click();

		//select team status subtab on Team page
		league.teamStats().click();

		//Navigate back to Add favourite
		league.navigateBackBttn().click();
		
		 /*add Players from String Array
		 * verify player is added and navigate to right page
		 */
		for(int i = 0;i<dataPlayers.length;i++ ) {
			List<MobileElement> icon = league.leagueTeamIcon();
			
			// select players
			icon.get(0).click();
			league.playersTab().click();
			league.getListItemsByName(dataPlayers[i]).click();
			league.navigateBackBttn().click();
			
			//Navigate to Player page
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.fivemobile.thescore:id/player_headshot_image_view']")));
			league.playerIcon().click();
			Assert.assertTrue(dataPlayers[i].contains(league.playerName().getText()));
			league.navigateBackBttn().click();
	    }
	}
	

	@DataProvider(name = "leagues")
	public Object[][] dataLeagues() {
		return new Object[][] { 
				{ 0, "NFL Football", "Toronto Raptors", "Stephen Curry (NBA)" },
				{ 1, "MLB Baseball", "Toronto Blue Jays", "Kevin Durant (NBA)" },
				{ 2, "NBA Basketball", "Toronto FC", "Lionel Messi (Soccer)" },
				{ 3, "NCAAFootball", "Canada", "Tom Brady (NFL)" },
				{ 4, "CFL Football", "Montreal Canadiens", "Cristiano Ronaldo (Soccer)" } };
	}
	
	@DataProvider(name = "players")
	public Object[][] dataPlayers() {
		return new Object[][] { 
				{ 0, "Stephen Curry (NBA)" },
				{ 1, "Kevin Durant (NBA)" },
				{ 2,  "Lionel Messi (Soccer)" },
				{ 3,  "Tom Brady (NFL)" },
				{ 4, "Cristiano Ronaldo (Soccer)" } };
	}
}
