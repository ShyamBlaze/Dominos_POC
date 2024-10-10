Feature: Domino's POC Scenarios

  Scenario: Launch Browser and URL and enter pincode
    Given Launch "Chrome" browser and URL "https://www.dominos.co.in/"
    When User clicks on order online now button
    And User enters pincode "600077"
    And User selects the first suggestion area
    Then User should navigate to the product page
    When User adds two quantities of Margherita Pizza
    And User adds two quantities of Peppy Paneer Pizza
    And User adds two quantities of Farmhouse Pizza
    And User verifies subtotal value and sum of all pizza value are same
    And User adds tweleve quantities of pepsi
    And User verifies subtotal value and sum of all product value are same
    And User removes one quantity of Margherita Pizza
    And User removes six quanties of pepsi
    And User verifies subtotal value and sum of all product value are same
    When User clicks on checkout
    And User verifies the checkout subtotal and place order subtotal are same
    Then Quit browser