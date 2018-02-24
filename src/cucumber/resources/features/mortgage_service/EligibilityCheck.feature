@mortgage_service @mortgage_eligibility
Feature: Mortgage service will indicate a primary user's ineligibility

  Scenario: Score < 200 will register as ineligible

  Scenario: Score > 200 will register as eligible

  Scenario: CCJ within 24 months will register as ineligible

  Scenario: CCJ over 24 months will register as eligible

  Scenario: CCJ within 24 months and for an unmatched person will register as eligible

  Scenario: Recent default within 24 months will register as ineligible

  Scenario: Recent default over 24 months will register as eligible

  Scenario: Recent default within 24 months and for an unmatched person will register as eligible

  Scenario: Bankruptcy will register as ineligible

  Scenario: Bankruptcy for an unmatched person will register as eligible

  Scenario: IVA will register as ineligible

  Scenario: IVA for an unmatched person will register as eligible

  Scenario: User meeting multiple ineligible criteria will be ineligible

  Scenario: User meeting no ineligible criteria will be eligible
