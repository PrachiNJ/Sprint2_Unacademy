#Author: sanikdesai39@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login functionality
  Verify the Login button
	Check the Create account and continue with email link functionality
	Verify the Login page functionality for Valid and Invalid Login attempts
 

  @tag1
  Scenario: Verify Login button
    Given user is on unacademy page
		When Click on the Login button
		Then Login page should be displayed

 @tag2
  Scenario: Verify Login functionality with blank Mobile no
    Given user is on Login Page
		When enter blank entry for mobile no 
		Then user should not be able to click login button
		
		
  @tag3
  Scenario Outline: Verify Login functionality with valid mobile no
    Given user is on Login Page
		When enter valid <mobileno>
		Then user should be able to click login button

    Examples: 
      | mobileno  | 
      | 8983777777 |

  @tag4
  Scenario Outline: Verify Login functionality with Invalid mobile no
    Given user is on Login Page
		When enter invalid <mobileno>
		Then user should not be able to click login button

    Examples: 
      | mobileno  | 
      | 897777 |
      
	@tag5
  Scenario: Verify Create account link
    Given user is on Login Page
		When Click on Create your account link
		Then Join Unacademy Page for creating new account should be displayed
      
  @tag6
  Scenario: Verify Login functionality with blank Mobile no.
    Given user is on Join Unacademy page
		When enter blank entry for mobile no.
		Then user should not be able to click continue button
		
  @tag7
  Scenario Outline: Verify Create account functionality with valid mobile no.
    Given user is on Join Unacademy page
		When enter valid <mobileno>
		Then user should be able to click continue button

    Examples: 
      | mobileno  | 
      | 8983777777 | 
      
  @tag8
  Scenario Outline: Verify Create account functionality with Invalid mobile no.
    Given user is on Join Unacademy page
		When enter invalid <mobileno>
		Then user should not be able to click continue button

    Examples: 
      | mobileno  | 
      | 898377	 | 
      
  @tag9
  Scenario: Verify Continue with Email link
    Given user is on Login Page
		When Click on Continue with Email
		Then Page to login with Email should be displayed
		
 @tag10
  Scenario: Verify Continue with Email functionality with blank Email
    Given user is on Login Page
		When enter blank entry for email id
		Then user should not be able to click login button
		
	@tag11
  Scenario Outline: Verify Continue with Email functionality with valid Email
    Given user is on Login Page
		When enter valid <emailid>
		And Click Login button
		Then Page to enter Otp should be displayed

    Examples: 
      | emailid  | 
      | abc@gmail.com	 | 
      
  @tag12
  Scenario Outline: Verify Continue with Email functionality with Invalid Email
    Given user is on Login Page
		When enter invalid <emailid>
		And Click Login button
		Then Page should display This email is not registered with us

    Examples: 
      | emailid  | 
      | abc@gmaicom	 | 
      