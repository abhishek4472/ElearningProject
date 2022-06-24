Feature: Search

  Background: click on outb
    Given click on outboxs

  @search
  Scenario Outline: enter in valid search data
    When click on search and enter values value "<value>"
    When click on search button
    Then check if message are avilable value"<value>"

    Examples: 
      | value              |
      | hello              |
      | hola               |
      | bonjour            |
      | Meghna Chakraborty |
