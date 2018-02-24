@mortgage_service
Feature: Mortgage service will request and display indicative quotes from Habito using various user data

  Scenario: A single user with insufficient funds will not be given an indicative mortgage quote
    Given I have the data for a user with insufficient funds
    When I POST the user data to mortgage-service "/quote/mortgage"
    Then I will receive a prompt and valid response with no quote data

  Scenario: A single user with sufficient funds will be given an indicative remortgage quote for Residential
    Given I have the data for a user with sufficient funds
    When I POST the user data to mortgage-service "/quote/mortgage"
    Then I will receive a prompt and valid response with valid quote data

  Scenario: A joint user with an ineligible partner will receive an indicative remortgage quote

  Scenario: A user can request a Buy To Let indicative remortgage quote

  Scenario: A user can request an indicative remortgage quote for an existing mortgage