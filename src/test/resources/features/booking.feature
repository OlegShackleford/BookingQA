Feature: Search hotel
  Scenario: Looking for 'Akra Hotel'
    Given booking search page is opened
    When user searches for "Akra Kemer"
    Then "Akra Kemer - Ultra All Inclusive" hotel is shown
    And "Akra Kemer - Ultra All Inclusive" hotel has a rating of "9,1"


  Scenario: Looking for 'Meraki'
    Given booking search page is opened
    When user searches for "Meraki"
    Then "Meraki Resort - Adults Only" hotel is shown
