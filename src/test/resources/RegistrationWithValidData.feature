Feature: Registration to web site

  Scenario: Registration with valid data
    Given I am on the Main page of application
    When I click SIGN_IN
    And from the Login page I go to Registration page
    And  I fill registration fields with 'Inna', 'Bezbakh', 'email', '999qwe', '06/20/2000'
    Then I see that 'Inna Bezbakh' appears in the header navigation menu near cart