Feature: Accept Policy on BlankFactor Website

  Background: Interacting on the Blankfactor page
    Given the user navigates to "https://blankfactor.com"


  Scenario: User navigates to the BlankFactor website and accepts the policy
    When the user accepts the website policy
    Then the website should be accessible without further prompts

  Scenario: Scroll until a specific text appears on the page
    Given the user navigates to the insights page
    And click on the Blog section
    And Scroll until the article "Why Fintech in Latin America Is Booming" is visible
    When the article is found and user access the "Sofia Gonzalez" post
    Then The user can see Sofia Gonzales Page

  Scenario: registers on the Become a Client form
    Given the user go to the Become a Client form
    When the user enters "Test" in the first name field
    And the user enters "Test" in the last name field
    And the user enters "Test" in the company field
    And the user enters "test@gmail.com" in the email field
    And the the user enters "317892345" in the phone field
    And the user enters "Test" in the project field
    And the user check the Privacy Policy
    And the user clicks Get Started button
    Then user gets registration success message

  Scenario: Extracting and Listing Blog Post Titles with Links
    Given the user navigates to the insights page
    And click on the Blog section
    When User scrolls the blog page and captures all the posts on the page

