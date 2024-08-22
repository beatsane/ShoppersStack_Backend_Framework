Feature: Create and Validate New Shopper

  Scenario: Successfully create a new shopper and validate the user details
    Given I have the ShoppersStack API endpoint "/shoppers"
    And I set the request content type to "application/json"
    And I set the request body to "createShopperPayload.json"
    When I send a POST request to the ShoppersStack API
    Then the response status code should be 201
    And the response content type should be "application/json"
    And the response body should contain "new_shopper_validation_payload"