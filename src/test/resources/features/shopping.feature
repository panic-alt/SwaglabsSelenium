Feature: Swaglabs Shopping

   Scenario Outline: User buys things
       Given The user has logged in with <username> and <password>
       When They order the price from low to high
       And Selects an item
       And Visits the item's page
       And goes back
       And They add things to the shopping cart
       And checks the shopping cart
       And removes an item
       And checks out
   Then the total should match the sum of the items plus taxes
       And completes the process

   Examples:
       | username      | password     |
       | standard_user | secret_sauce |
       | problem_user  | secret_sauce |
