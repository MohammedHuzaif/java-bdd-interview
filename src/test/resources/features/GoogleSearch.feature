@GoogleSearch

Feature: Search on google

  Scenario Outline: FE - Search for "covid 19 in Malaysia"
    Given Go to google webpage "https://www.google.com/"
    When Enter Search Text: <searchText> and press ENTER Key
    Then Verify "Top stories" section is available
    Then Verify "Common Questions" section is available
    And Click on MOH Website in search result
    Then Verify MOH Website is displayed "https://covid-19.moh.gov.my/"

    Examples:
      | searchText            |
      | covid 19 in Malaysia  |