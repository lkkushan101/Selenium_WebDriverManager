Feature: Create company
  Scenario: Create company

    Given When I'm in the add company page

    When I add "Kushan" as the name "ABC" as the headoffice and "32" as employees 

    Then the record should get added