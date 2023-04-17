Feature: Buying items on a website
  Scenario Outline: Correct login, adding items to the cart, and completing the transaction.
    Given The user is on the main page, logs into their account by providing their "<Email>" and "<Password>" and goes to the clothing section.
    When  The user selects the desired product, selects the size, adds the selected numbers od items to the cart and proceeds to checkout.
    And The user confirms the delivery address, selects the delivery method, chooses the appropriate payment method, accepts the terms and conditions, and clicks the button to confirm the order.
    Then The user receives confirmation of the successful purchase of the item and takes a screenshot of the information.
    And The browser is closed
    Examples:
    |Email|Password|
    |michal.bajko@o2.pl|CodersLab|
