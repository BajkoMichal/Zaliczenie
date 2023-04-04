Feature: Correct add a new address in the user account
  Scenario Outline: Adding a new address to the account usnig correct data and verifying it.
    Given The User is on the home page
    When The User selects option SignIn
    And The User enters the correct "<email>" address and "<password>" and then confirms the login details
    And The user is taken to their account information page and selects Addresses
    And The User selects Create new address
    And The User enters a correct "<alias>", "<address>", "<city>", "<postcode>", country, "<phone>" and confirms the data
    Then The User is informed about the correct addition of the address to the user account
    And The browser is closed
    Examples:
    |email|password| |alias|address|city|postcode|phone|
    |michal.bajko@o2.pl|CodersLab||Tak|Prosta|Poland|15774|123456789|





