Feature: Sending BDD Request with ApacheHTTPClient
  Scenario: Send Get request in ApacheHTTPClient

    Given I have a URL for Get request

    When I send a GET request 

    Then I should get a success response with a body 