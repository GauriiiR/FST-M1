@activity5
Feature: Data driven test with Example

Scenario Outline: Testing with Data from Scenario
    Given User is Present on Login pages
    When User intert "<Usernames>" and "<Passwords>"
    Then Captured page title and heading
    And quite the Browser
    
Examples:
    | Usernames | Passwords |
    | admin     | password  |
    | adminUser | Password  |