Feature: Displaying recipes

  Scenario: Display a list of recipes based on a query
    Given I make a request to display recipes with the query "chicken"
    Then I should see a list of recipes related to "chicken"

  Scenario: Display details of a specific recipe
    Given I make a request for the details of recipe with id 3289
    Then I should see the details of the recipe
