Feature: Create a bank customer
  Scenario: Create new cutomer

    Given I have a user name and password

    When I successfully login

    Then I should be able to go to home page