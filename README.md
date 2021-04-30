# scoreAppiumChallenge

#rationale used to decide test approach
#I extracted the apk file from zip folder and using appium server i tried to install apk in an android emulator
#For this I added desiredCapabilities required so that appium server can locate android emulator and install the apk file with package name and main activity details given
#To achieve abstraction I have added all mobile page element locators in a seperate page object file and all the methods to perform operations such as click , type etc are in test file
#In my project ScoreTest.java is a main test file used to run the all test method. It extend Baseclass.java that has all the setup and terdown method.

#In this suite I am trying to test the league, team and player page navigations
#I have added assert statements to enter on button click action navigates to correct page by verifying the title of the page
#and similarly I have added back navigation verification steps too.

In my test i have tried to add different players from add favourite page . Also I have verified players page sub tab operations

