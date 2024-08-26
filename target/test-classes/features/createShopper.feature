Feature: Create and Validate New Shopper

  Scenario: Successfully create a new shopper and validate the user details
  
    Given I set the request body as "createShopperPayload.json"
    When I send a POST request to the ShoppersStack API with "/shoppers" as endpont
    Then the response status code should be 201
    And the response content type should be "text/html;charset=iso-8859-1"
    And the response body should contain "gender"