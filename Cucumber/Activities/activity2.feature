@activity2
Feature: Login Test

Scenario: Testing Login
    Given User is on Login pages
    When User enters a username and password
    Then Read the page title and confirmation message
    And Close the Browser
