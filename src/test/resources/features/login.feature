Feature: SwagLabs Login


  Scenario Outline: User logs in
    Given the user is in the login page
    When the user logs in with <username> and <password>
    Then reaches the inventory page
      And logs out

    Examples:
        | username                | password     |
        | standard_user           | secret_sauce |
        | locked_out_user         | secret_sauce |
        | problem_user            | secret_sauce |
        | performance_glitch_user | secret_sauce |
