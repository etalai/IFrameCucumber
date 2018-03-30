@iframe
Feature: Practice iframe

Background: 
	Given user is on https://the-internet.herokuapp.com/

Scenario: Verify the user can manipulate iframe
	When user clicks on Frames link
	Then user should see Nested Frames & iFrame
	And when user clicks iFrame
	Then user should see iFrame
	When user enters in iFrame
	Then user must be able to type in
	And user must be able to exit iFrame
	
	
	
	
	