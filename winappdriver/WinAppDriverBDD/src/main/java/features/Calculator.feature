Feature: Sending BDD Request with ApacheHTTPClient
  Scenario: Send Get request in ApacheHTTPClient

    Given I have opened up calculator application

    When I add two plus three

    Then I should answer as five