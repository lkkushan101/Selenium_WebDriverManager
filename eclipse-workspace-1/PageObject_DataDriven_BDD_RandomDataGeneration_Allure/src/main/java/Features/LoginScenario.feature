Feature: Create a bank customer
  Scenario: Create new cutomer

    Given I have a user name and password

    When I successfully login and fill forms to create a customer 

    Then I should be able to create a new customer