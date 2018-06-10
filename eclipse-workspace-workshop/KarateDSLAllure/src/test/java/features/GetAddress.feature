Feature: Send request for google maps with location
Scenario: Verify that map data are received when sending address to the google map service
Given url 'http://maps.googleapis.com/maps/api/geocode/xml?'
And params {address: '75, Perera Mawatha, Pellawatte, Batharamulla'}
When method get
Then status 200
And match response.GeocodeResponse.status contains 'OK'