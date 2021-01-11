#Author: prachijain1443@gmail.com

@tag
Feature: Validate netbanking Payment methods
  To check for different payment methods
@tag1 
 Scenario: Validate to open url and goto payment page
    Given the user is on payment page
    
 @tag1
 Scenario: Validate to change duration
   When user clicks on change duration option
   Then subscription page will be displayed
   
@tag1
  Scenario Outline: Validate payment by card
    When clicked on Card Option
    And entered any value for <cardno>,<mm>,<yy>,<cvv> and <cardname>
    And click on cardpay
    Then the user should be directed to further steps
      
	Examples:
 		| cardno | mm | yy | cvv | cardname |
 		| 2222 333 4444 5555 | 12 | 22 | 234 | Akshay Madne |
 		| 2222 3333 4444 1111 | 10 | 28 | 733 | Chirag Jain |	

 @tag1
  Scenario: Validate payment by netbanking
    When clicked on Netbanking option
    And click on any bank
    And click on pay
    Then the user should be directed to the respective bank page

 @tag1
 Scenario Outline: Validate payment by UPI
   When clicked on UPI option
   And enter the <phoneno>
   And click on upiPay
   Then a new page will be displayed for further steps
      
	Examples:
 		| phoneno | 
 		| 9004846177 |
 		| edkwcmc |

@tag1
 Scenario Outline: Validate payment by Wallet
   When clicked on Wallet option
   And select any wallet ,enter the <phno>
   And click on Wallet Pay button
   Then a Wallet page will be displayed for further steps
      
	Examples:
 		| phno | 
 		| 9004846177 |
 		| 9987467156 |	
   