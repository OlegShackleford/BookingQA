Feature: Search hotel
  Scenario: Looking for 'Akra Hotel'
    Given booking search page is opened
    When user searches for "Akra Kemer"
    Then "Akra Kemer - Ultra All Inclusive" hotel is shown

  Scenario: Looking for 'Meraki'
    Given booking search page is opened
    When user searches for "Meraki"
    Then "Meraki Resort - Adults Only" hotel is shown
