Feature: User can login to existing mailbox

  As a User
  I want to be able to login into existing mailbox
  So that I would perform operations with my mail


  Scenario: User can login to existing mailbox account
    Given User is logged in into mailbox account
    When I do login into my mailbox account
    And I create new letter
    And I close letter without saving it
    Then I find this letter in a draft folder



