Feature: Functional
  As a user
  I want to test some site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check log in with incorrect email address
    Given User opens '<homePage>' page
    When User clicks to 'Sign In' button
    And User enters '<userEmail>' email address in 'Email or username' field
    And User clicks to 'Continue' button
    Then User checks that error massage '<message>' appears

    Examples:
      | homePage                | userEmail       | message                                           |
      | https://www.amazon.com/ | dfvcddc@ddd.ddd | We cannot find an account with that email address |


  Scenario Outline: Check log in with incorrect password
    Given User opens '<homePage>' page
    And User clicks to 'Sign In' button
    And User enters '<userEmail>' email address in 'Email or username' field
    When User clicks to 'Continue' button
    And User checks that emailAddress is visible
    And User enters invalid password '<password>' in password field
    And User clicks to 'Sign in' button on the login Page
    Then User checks that error massage '<message>' appears

    Examples:
      | homePage                | userEmail      | password   | message                                                                                                                           |
      | https://www.amazon.com/ | lola@gmail.com | ffffffffff | To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below. |


  Scenario Outline: Check log in with correct credentials
    Given User opens '<homePage>' page
    And User clicks to 'Sign In' button
    And User enters '<userEmail>' email address in 'Email or username' field
    When User clicks to 'Continue' button
    And User checks that emailAddress is visible
    And User enters valid password '<password>' in password field
    And User clicks to 'Sign in' button on the login Page


    Examples:
      | homePage                | userEmail            | password      | welcomeMessage   |
      | https://www.amazon.com/ | opr.helena@gmail.com | Alexandr_2004 | Deliver to Olena |


  Scenario Outline: Check that search result contains search word
    Given User opens '<homePage>' page
    And User checks that search field visibility
    When User enters the search word '<enteredKeyword>' in to search field
    And User clicks to search icon
    And User checks that filter menu is visible
    Then User checks that search result contains search word '<keyword>'

    Examples:
      | homePage                | enteredKeyword | keyword |
      | https://www.amazon.com/ | Crocs women    | Crocs   |


  Scenario Outline: Select product items with needed size
    Given User opens '<homepage>' page
    And User enters the search word '<keyword>' in to search field
    And User clicks to search icon
    And User checks that filter menu is visible
    When User clicks to needed product item <numberItem> on page
    And User clicks to size select button
    And User clicks to size <size> in size list
    Then User check that 'Buy Now' button is visible

    Examples:
      | homepage                | keyword     | numberItem | size |
      | https://www.amazon.com/ | Crocs women | 0          | 4    |


  Scenario Outline: User checks the header dropdown menu
    Given User opens '<homepage>' page
    And User clicks to the 'All' button on the header menu
    And User checks that the header dropdown menu is visible
    And User clicks to the arrow below 'See All' text from 'Shop By Department' catalog
    When User clicks to catalog item <catalogItem>
    Then User checks that catalog menu is visible

    Examples:
      | homepage                | catalogItem |
      | https://www.amazon.com/ | 5           |


  Scenario Outline: User checks the Gift Cards menu
    Given User opens '<homepage>' page
    And User clicks to 'Gift Cards' button on header menu
    And User clicks to 'Mail' section on the gift cards page
    When User clicks to selected gift card <number> from the product items page
    And User checks that the images of selected item is visible
    Then User checks that the price of selected item is visible

    Examples:
      | homepage                | number |
      | https://www.amazon.com/ | 3      |

  Scenario Outline: User checks the number of purchased items is displayed correctly above the cart icon
    Given User opens '<homepage>' page
    And User enters the search word '<keyword>' in to search field
    And User clicks to search icon
    And User checks that filter menu is visible
    When User clicks to needed product item <numberItem> on page
    And User clicks to size select button
    And User clicks to size <size> in size list
    And User clicks to 'Add To Cart' button
    And User checks that 'Add To Cart' text is visible
    Then User checks the number of purchased items '<count>' above the cart icon

    Examples:
      | homepage                | keyword     | numberItem | size | count |
      | https://www.amazon.com/ | Crocs women | 0          | 4    | 1     |

  Scenario Outline: Check add product to card
    Given User opens '<homepage>' page
    And User enters the search word '<keyword>' in to search field
    And User clicks to search icon
    And User checks that filter menu is visible
    When User clicks to needed product item <numberItem> on page
    And User clicks to size select button
    And User clicks to size <size> in size list
    And User clicks to 'Add To Cart' button
    Then User checks that 'Add To Cart' text is visible

    Examples:
      | homepage                | keyword     | numberItem | size |
      | https://www.amazon.com/ | Crocs women | 0          | 4    |
