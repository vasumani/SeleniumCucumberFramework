Feature: Execution of CMF18MR10 scripts

  Background: 
    Given : User loads the "CMF18MR10" json file

  Scenario Outline: GSAP_CMF Merchant Currencies
    Given User execute testcaseId 'TC_26161840' for testcasename 'CMF_AP_Zero to 100 currencies could be assigned to the merchant' and module 'TestCases->Subject->CMF->2018 Test Cases->18.10 Test Cases->Multiple Currencies - BCR323->US' Execute "<ExecuteScenario>"
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
      | Yes             | qatest10 | US     |

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

  Scenario Outline: GSAP_CMF adding Merchant Currencies
    Given User execute testcases Id "<TC_Mul_AddCurrencies>" for testcasename 'CMF_AP_Zero to 100 currencies could be assigned to the merchant' and module 'TestCases->Subject->CMF->2018 Test Cases->18.10 Test Cases->Multiple Currencies - BCR323->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding More than 100 Currencies to Merchant Error

    Examples: 
      | TC_Mul_AddCurrencies | ExecuteScenario | UserName | Region |
      | TC_26161555          | Yes             | qatest10 | AP     |
      | TC_26161714          | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF adding Merchant Currencies
    Given User execute testcases Id "<TC_Mul_AddCurrencies1>" for testcasename 'CMF_AP_Zero to 100 currencies could be assigned to the merchant' and module 'TestCases->Subject->CMF->2018 Test Cases->18.10 Test Cases->Multiple Currencies - BCR323->US' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding More than 100 Currencies to Merchant Error

    Examples: 
      | TC_Mul_AddCurrencies1 | ExecuteScenario | UserName | Region |
      | TC_26161838           | Yes             | qatest10 | US     |
      | TC_26161839           | Yes             | qatest10 | US     |
