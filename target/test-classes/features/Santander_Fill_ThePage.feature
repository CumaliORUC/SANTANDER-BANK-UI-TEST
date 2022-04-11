Feature: Fill the Buss lead Form

  Scenario Outline: Fill the page
    Given Go to the "Santander_URL"
    Then Click to Small Business
    Given Move To Borrowing Tap
    Then Move Borrowing Option
    And Click to Business Term Loan
    Then Click to Get in Touch
    And Fill the Firstname "<name>"

    Examples:
    |name|
    |John|
    |Charlie|


