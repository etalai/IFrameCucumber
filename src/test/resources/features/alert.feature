@alert
Feature: Accept, get text (if exists), input text and decline alert

Background: 
	Given user is on https://the-internet.herokuapp.com/

Scenario: user tries to manipulate above indicated ones
	When user clicks on JavaScript Alerts
	Then user sees 3 types of alert
	When user clicks on JS Alert, user sees JavaScript Alerts pop up
	And once user clicks on JS Confirm, user should be able to confirm/cancel
	And once user clicks on JS Prompt, user should be able to manipulate the pop up
	And user should be able to send "i'm inside alert"
	
	
	