Feature: outbox


  Background: click on outb
    Given click on outboxs

  @delete
  Scenario: delete a message
    When click on delete message
    And select the alert
    Then check for validation message

  @select
  Scenario: select some messages
    When select any given message
    Then check if the message is selected

  @open
  Scenario Outline: open a message
    When open a message using title title "<title>"
    Then check if message is opened

    Examples: 
      | title   |
      | hello   |
      | hola    |
      | bonjour |
