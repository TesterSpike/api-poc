@mortgage_service
Feature: A the mortgage service I will be able to request indicative mortgage quotes using various user date
    Background:
        Given I am using the "Mortgage Service"

    Scenario: A single user with insufficient funds will not be given an indicative mortgage quote
        Given I have the data for a user with insufficient funds
        When I POST the user data to mortgage-service "/v1/quote/mortgage"
        Then I will receive a prompt and valid response with no quote data

    Scenario: A single user with sufficient funds to get an indicative remortgage quote
        Given I have the data for a user with sufficient funds
        When I POST the user data to mortgage-service "/v1/quote/mortgage"
        Then I will receive a prompt and valid response with valid quote data