@tag
Feature: Search google

  @tag1
  Scenario Outline: Search Selenium in Google
    Given I im in the google search
    When I type <search_word> and click search
    Then I should be navigated to the <search_url>

    Examples: 
      | search_word | search_url                        |
      | selenium    | Selenium - Web Browser Automation |
