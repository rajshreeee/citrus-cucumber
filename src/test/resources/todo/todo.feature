Feature: Todo app

  Scenario: Add todo entry
    Given Todo list is empty
    When I add entry "Code something"
    Then the number of todo entries should be 1
