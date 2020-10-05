Feature: Execution of CMF18MR10 scripts

  Background: 
    Given : User loads the "CMF18MR10" json file

  Scenario Outline: GSAP_CMF adding Merchant Currencies
    Given User execute testcaseId 'TC_26161538' for testcasename 'CMF_AP_Zero to 100 currencies could be assigned to the merchant' and module 'TestCases->Subject->CMF->2018 Test Cases->18.10 Test Cases->Multiple Currencies - BCR323->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Multiple Currencies to Merchant

    Examples: 
      | ExecuteScenario | UserName | Region |
      | Yes             | qatest10 | AP     |

##############EOF#############
