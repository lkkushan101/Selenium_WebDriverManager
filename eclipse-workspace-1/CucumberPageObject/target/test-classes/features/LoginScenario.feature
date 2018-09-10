Feature: Search Google
  Scenario: Search Selenide Word in Google

    Given User goes to google

    When User search 'Selenium'

    Then User should get the 'Selenium HQ site' in the results page