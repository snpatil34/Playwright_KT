Feature: Search in Playwright Page

  Scenario Outline: Search topic in playwright
    Given User navigate to Playwright URL
    When user select Java from dropdown and able to see expected page
    And  click on the search box and enter "<topic>" in the search box
    Then entered topic page should open with "<header>"
    And browser should close
    Examples:
      | topic       | header     |
      | Locators    | Locators   |
      |Screenshots  |Screenshots |

