Feature: Santander

  Background:
    Given  Go to the "Santander_URL"
    Then Verify true page

  @BugReport1
  Scenario: Bug Report 1
    Then Click to Banking tab
    And  Select to Santander Select Checking tab
    Then Go to bottom of the page to see unreadable symbols

  @BugReport2
  Scenario: Bug Report 2
    When  Click to About Us
    Then  Go to bottom of the page
    And   Click to Account set-up
    Given Click to Santander Private Client
    Then  Go to bottom of the page
    And   Verify Meaningless Sentences

@BugReport3
  Scenario: Bug Report 3
    Then Click to Small Business
    When Click to Santander Safety Net
    And  Page scroll down to Overdraft fee details to see Invisible Images

