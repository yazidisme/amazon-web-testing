Feature: As a customer, I want to find registry or gift list

  Scenario: Find a Birthday Gift List
    Given Home page of Amazon website
    And Navigate to Registry tab
    And Registry and Gifting page should be displayed
    When Input registrant name with "John"
    And Select a registry or gift list type with "Birthday Gift List"
    And Click search button
    And Search result with name is "John" should be displayed
    And Edit date range from "January 2021" to "April 2021"
    Then The search result is in accordance with the date range from "January 2021" to "April 2021"
