Feature: Search google 

  Scenario: Search selenium in google
    Given I'm in the google search page 
    When user search Selenium
   Then I should get selenium HQ link in search