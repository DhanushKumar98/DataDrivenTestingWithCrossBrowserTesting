Feature: FoundIt Web Application Testing Using Automation Testing


Scenario: Successful login with valid credentials
Given User is on Login Page
When User enters valid username and password
And clicks on Login button
Then User should be Navigated to Home Page


Scenario: Login with invalid creadentials
Given User is on Login Page
When User Enters invalid username and password
And clicks on Login button
Then User should see error message "Invaild Creadentials"




