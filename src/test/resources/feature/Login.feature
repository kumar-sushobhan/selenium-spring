Feature: User login to automation test store

  @login
  Scenario Outline: I should be able to login
    Given I am on the homepage
    Then I click on SignIn button on Homepage
    And I enter username as "<username>", password as "<password>" and click on SignIn button
    Then I am on the personalized page

    Examples:
      | username                 | password     |
      | sushobhanworld@gmail.com | amigoscode@1 |
      | abcd@gmail.com           | qwerty       |

  @firstrepo
  Scenario: Open the first repository
    Given I am logged in and on the personalized page
    Then I click on the first repository
    And I print the title of the page