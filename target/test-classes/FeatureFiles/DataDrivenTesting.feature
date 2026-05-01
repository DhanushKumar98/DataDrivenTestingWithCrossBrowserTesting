Feature: Login With multiple credentials

Given User is on Login Page
When User enters username "<username>" and "<password>"
And clicks on Login button
Then User should see "<result>"

Example:

|username|password|result|
|admin|admin123|Home Page|
|user1|wrong123|Invaild Credentials|
|test|test123|Home Page|


