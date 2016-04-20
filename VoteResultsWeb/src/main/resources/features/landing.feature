Feature: Landing page
	The user makes a get petition	
	Scenario: Enter Application
	  Given three votings available, one with description: 'Voting 1'; 
	  And another one with description 'Voting 2'
	  And another one with description 'Voting 3'
	When the user access the main page of the application
	Then a list of 3 votings must be shown
	  And Voting 1 must have the description 'Voting 1'
	  And Voting 2 must have the description 'Voting 2'
	  And Voting 3 must have the description 'Voting 3'