Feature: Searching of Wikipedia

	Background:
		Given The user is on the Wikipedia Home Page
		
	Scenario Outline: User tries to search for a SSBU Character
		Given The user types in "<character>"
		When The user presses Enter
		Then The title of the article should be "<title>"
	
	Examples:
		|	character	|	title				|
		|	Luigi		|	Luigi - Wikipedia	|
		|	Wario		|	Wario - Wikipedia	|
	