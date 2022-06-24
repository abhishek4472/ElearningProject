Feature: Compose Message

  Background: 
    Given click on messages tab

  @valid
  Scenario Outline: Enter valid information
    When enter valid data username "<username>" and subject"<subject>"
    And click on send message
    Then verify the message username "<username>"

    Examples: 
      | username           | subject |
      | Meghna Chakraborty | hello   |
      | Abcd Pqrs          | hola    |
      | Anamika Anamika    | bonjour |

  @invalid
  Scenario Outline: Enter invalid information
    When enter invalid data username "<username>" and subject"<subject>"
    And click on send message
    Then verify the output message

    Examples: 
      | username | subject |
      |          | hello   |
      |          | hola    |

  @mandatory
  Scenario: Dont enter mandatory field
    When enter valid data username
    And click on send message
    Then verify the error message
