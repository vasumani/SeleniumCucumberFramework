Feature: Execution of CMF18MR10HF2 scripts

  Background: 
    Given : User loads the "CMF18MR10HF2" json file

  Scenario Outline: GSAP_CMF Discover SE number
    Given User execute testcases Id "<TC_Mul_DiscoverCard>" for testcasename 'CMF_Add discover_UPI Default_verify SE number_US' and module 'TestCases->Subject->CMF->2018 Test Cases->18.10.2->Functional->US154116-Merchant-Automate CMF Card Type Acceptance - Add-Update - UPI - CR352' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    Then User Validating Customer CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status

    Examples: 
      | TC_Mul_DiscoverCard | ExecuteScenario | UserName | Region |
      | TC_27739109         | Yes             | qatest10 | US     |
      | TC_27740964         | Yes             | qatest10 | US     |

      