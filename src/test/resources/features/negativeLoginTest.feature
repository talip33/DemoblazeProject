Feature: Negative Login Test - the user should NOT be able to login with invalid credentials


  Background: Go to home page login
    Given The user is on the login page

  @negativeScenario
  Scenario Outline: Negative scenario - the user should NOT be able to login with invalid credentials
    When The user enters "<invalidUsername>" and "<invalidPassword>" and click login button
    Then verify that invalid "<message>"
    Examples:
      | invalidUsername | invalidPassword | message                                |
      | talip33         |                 | Please fill out Username and Password. |
      |                 | 981314          | Please fill out Username and Password. |
      | talip33333333   | 55555           | User does not exist.                   |
      | llllll          | 981314          | Wrong password.                        |
      |                 |                 | Please fill out Username and Password. |
      | talip33         | 1331323         | Wrong password.                        |

