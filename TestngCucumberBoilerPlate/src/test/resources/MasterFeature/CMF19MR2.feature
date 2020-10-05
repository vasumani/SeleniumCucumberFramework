Feature: Execution of CMF19MR2 scripts

  Background: 
    Given : User loads the "CMF19MR2" json file

  Scenario Outline: GSAP_CMF Merchant cards Accepted_Removed_Private Label card indicator
    Given User execute testcases Id "<TC_Mul_PrivateVerify>" for testcasename 'CMF_Merchant_Merchant cards Accepted_Removed_Private Label card indicator' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152257-Folder - Merchant Private Label Card Indicator BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    Then User verify Privatelabels not present in UI

    Examples: 
      | TC_Mul_PrivateVerify | ExecuteScenario | UserName | Region |
      | TC_28998827          | Yes             | qatest10 | AP     |
      | TC_28998582          | Yes             | qatest10 | US     |

  Scenario Outline: GSAP _Merchant cards Accepted Update Removed Private Label card indicator
    Given User execute testcases Id "<TC_Mul_EditVerify>" for testcasename 'CMF_Merchant_Merchant cards Accepted_Update_Removed_Private Label card indicator' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152257-Folder - Merchant Private Label Card Indicator BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    Then User verify Cards Disable or enable after Edit
    And User click Back to Merchant link
    Then User verify Privatelabels not present in UI

    Examples: 
      | TC_Mul_EditVerify | ExecuteScenario | UserName | Region |
      | TC_28998828       | Yes             | qatest10 | AP     |
      | TC_28998726       | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Merchant cards Accepted BPI private label card Update Removed Private Label card indicator
    Given User execute testcases Id "<TC_Mul_EditBPIVerify>" for testcasename 'CMF_Merchant_Merchant cards Accepted_BPI private label card_Update_Removed_Private Label card indicator' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152257-Folder - Merchant Private Label Card Indicator BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    Then User verify Cards Disable or enable after Edit
    And User click Back to Merchant link
    Then User verify Privatelabels not present in UI

    Examples: 
      | TC_Mul_EditBPIVerify | ExecuteScenario | UserName | Region |
      | TC_28998774          | Yes             | qatest10 | US     |
      | TC_28998829          | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant_Merchant cards Accepted HSBC private label card Update Removed Private Label card indicator
    Given User execute testcases Id "<TC_Mul_EditHSBCVerify>" for testcasename 'CMF_Merchant_Merchant cards Accepted_HSBC private label card_Update_Removed_Private Label card indicator' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152257-Folder - Merchant Private Label Card Indicator BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    Then User verify Cards Disable or enable after Edit
    And User click Back to Merchant link
    Then User verify Privatelabels not present in UI

    Examples: 
      | TC_Mul_EditHSBCVerify | ExecuteScenario | UserName | Region |
      | TC_28998794           | Yes             | qatest10 | US     |
      | TC_28998830           | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant_Private label card type HSBC assign Multiple without Private label Indicators
    Given User execute testcases Id "<TC_Mul_HSBCVerify>" for testcasename 'CMF_Merchant_Private label card type_HSBC_assign_Multiple_without Private label Indicators' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152268-Multiple Assignments per Card Type - Merchant Private Label Card Indicator BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status

    Examples: 
      | TC_Mul_HSBCVerify | ExecuteScenario | UserName | Region |
      | TC_28999783       | Yes             | qatest10 | US     |
      | TC_28974938       | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant_Private label card type BPI_assign_Multiple_without Private label Indicators
    Given User execute testcases Id "<TC_Mul_BPIVerify>" for testcasename 'CMF_Merchant_Private label card type_BPI_assign_Multiple_without Private label Indicators' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152268-Multiple Assignments per Card Type - Merchant Private Label Card Indicator BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status

    Examples: 
      | TC_Mul_BPIVerify | ExecuteScenario | UserName | Region |
      | TC_28999786      | Yes             | qatest10 | US     |
      | TC_28975648      | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Validate that Private Label Indicator are not displayed on Merchant Cards Accepted screen
    Given User execute testcases Id "<TC_Mul_PrivateLabelsVerify>" for testcasename 'CMF_Validate that Private Label Indicator are not displayed on Merchant Cards Accepted screen.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->Merchant Private Indicator -US152260, US152262, US152267, US152269' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    Then User verify Privatelabels not present in UI

    Examples: 
      | TC_Mul_PrivateLabelsVerify | ExecuteScenario | UserName | Region |
      | TC_29017987                | Yes             | qatest10 | AP     |
      | TC_29018001                | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF BPI private label card Message spec Indiactor Central No Restriction at terminal
    Given User execute testcases Id "<TC_Mul_TerminalBPIcentralVerify>" for testcasename 'CMF_BPI private label card_Message spec Indiactor_Central_No Restriction_at terminal' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152056-Private Label Card Type Restrictions BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    Then User Validating Terminal CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"

    Examples: 
      | TC_Mul_TerminalBPIcentralVerify | ExecuteScenario | UserName | Region |
      | TC_28997750                     | Yes             | qatest10 | AP     |
      | TC_28998487                     | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF BPI private label card Message spec Indiactor West No Restriction at terminal
    Given User execute testcases Id "<TC_Mul_TerminalBPIWestVerify>" for testcasename 'CMF_BPI private label card_Message spec Indiactor_West_No Restriction_at terminal' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152056-Private Label Card Type Restrictions BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    Then User Validating Terminal CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"

    Examples: 
      | TC_Mul_TerminalBPIWestVerify | ExecuteScenario | UserName | Region |
      | TC_28998282                  | Yes             | qatest10 | AP     |
      | TC_28998488                  | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF BPI private label card Message spec Indiactor East No Restriction at terminal
    Given User execute testcases Id "<TC_Mul_TerminalBPIEastVerify>" for testcasename 'CMF_BPI private label card_Message spec Indiactor_East_No Restriction_at terminal' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152056-Private Label Card Type Restrictions BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    Then User Validating Terminal CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"

    Examples: 
      | TC_Mul_TerminalBPIEastVerify | ExecuteScenario | UserName | Region |
      | TC_28998320                  | Yes             | qatest10 | AP     |
      | TC_28998489                  | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF BPI private label card Message spec Indiactor Global XML auth & EDCNo Restriction at terminal
    Given User execute testcases Id "<TC_Mul_TerminalXMLLaunchVerify>" for testcasename 'CMF_BPI private label card_Message spec Indiactor_Global XML auth & EDC_No Restriction_at terminal' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152056-Private Label Card Type Restrictions BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    Then User Validating Terminal CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"

    Examples: 
      | TC_Mul_TerminalXMLLaunchVerify | ExecuteScenario | UserName | Region |
      | TC_28998328                    | Yes             | qatest10 | AP     |
      | TC_28998490                    | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF BPI private label card_Message spec Indiactor Asia Pacific No Restriction at terminal
    Given User execute testcases Id "<TC_Mul_TerminalBPIAsiaVerify>" for testcasename 'CMF_BPI private label card_Message spec Indiactor_Asia Pacific_No Restriction_at terminal' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152056-Private Label Card Type Restrictions BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    Then User Validating Terminal CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"

    Examples: 
      | TC_Mul_TerminalBPIAsiaVerify | ExecuteScenario | UserName | Region |
      | TC_28998382                  | Yes             | qatest10 | AP     |
      | TC_28998491                  | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF HSBC private label card_Message spec Indiactor Global XML auth & EDCNo Restriction at terminal
    Given User execute testcases Id "<TC_Mul_TerminalHSBCXMLVerify>" for testcasename 'CMF_HSBC private label card_Message spec Indiactor_Global XML auth & EDC_No Restriction_at terminal' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152056-Private Label Card Type Restrictions BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    Then User Validating Terminal CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"

    Examples: 
      | TC_Mul_TerminalHSBCXMLVerify | ExecuteScenario | UserName | Region |
      | TC_28998397                  | Yes             | qatest10 | AP     |
      | TC_28998492                  | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF HSBC private label card Message spec Indiactor EastNo Restriction_at terminal
    Given User execute testcases Id "<TC_Mul_TerminalHSBCEastVerify>" for testcasename 'CMF_HSBC private label card_Message spec Indiactor_East_No Restriction_at terminal' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152056-Private Label Card Type Restrictions BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    Then User Validating Terminal CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"

    Examples: 
      | TC_Mul_TerminalHSBCEastVerify | ExecuteScenario | UserName | Region |
      | TC_28998407                   | Yes             | qatest10 | AP     |
      | TC_28998493                   | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF HSBC private label card Message spec Indiactor_Asia Pacific_No Restriction_at terminal
    Given User execute testcases Id "<TC_Mul_TerminalHSBCAsiaVerify>" for testcasename 'CMF_HSBC private label card_Message spec Indiactor_Asia Pacific_No Restriction_at terminal' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152056-Private Label Card Type Restrictions BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    Then User Validating Terminal CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"

    Examples: 
      | TC_Mul_TerminalHSBCAsiaVerify | ExecuteScenario | UserName | Region |
      | TC_28998415                   | Yes             | qatest10 | AP     |
      | TC_28998494                   | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF HSBC private label card_Message spec Indiactor West No Restriction at terminal
    Given User execute testcases Id "<TC_Mul_TerminalHSBCWestVerify>" for testcasename 'CMF_HSBC private label card_Message spec Indiactor_West_No Restriction_at terminal' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152056-Private Label Card Type Restrictions BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    Then User Validating Terminal CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"

    Examples: 
      | TC_Mul_TerminalHSBCWestVerify | ExecuteScenario | UserName | Region |
      | TC_28998436                   | Yes             | qatest10 | AP     |
      | TC_28998495                   | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF HSBC private label card_Message spec Indiactor_Central No Restriction_at terminal
    Given User execute testcases Id "<TC_Mul_TerminalHSBCCentralVerify>" for testcasename 'CMF_HSBC_ private label card_Message spec Indiactor_Central_No Restriction_at terminal' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Functional Testing->US152056-Private Label Card Type Restrictions BCR251' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    And User Change Merchant Status
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    Then User Validating Terminal CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"

    Examples: 
      | TC_Mul_TerminalHSBCCentralVerify | ExecuteScenario | UserName | Region |
      | TC_28998459                      | Yes             | qatest10 | AP     |
      | TC_28998496                      | Yes             | qatest10 | US     |
      
      
      
      
