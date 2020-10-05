Feature: Execution of CMF19MR1 scripts

  Background: 
    Given : User loads the "CMF19MR1" json file

  Scenario Outline: GSAP_CMF Verify Bigbatch Log Submission field
    Given User execute testcases Id "<TC_Mul_NewLog>" for testcasename 'CMF_Log Submission Record field must be displayed while adding Big Batch' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->Big Batch Management UI - Log Submission Records - BCR333' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Bigbatch Page
    Then User verify Log submission field

    Examples: 
      | TC_Mul_NewLog | ExecuteScenario | UserName | Region |
      | TC_28016504   | Yes             | qatest10 | AP     |
      | TC_28016513   | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Verify Bigbatch Log Submission field
    Given User execute testcases Id "<TC_Mul_OldLog>" for testcasename 'CMF_Log Submission Record field must be displayed while updating Big Batch' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->Big Batch Management UI - Log Submission Records - BCR333' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Bigbatch Page
    And User search for existing Bigbatch
    Then User verify Log submission field

    Examples: 
      | TC_Mul_OldLog | ExecuteScenario | UserName | Region |
      | TC_28016505   | Yes             | qatest10 | AP     |
      | TC_28016509   | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Verify Bigbatch Log Submission field
    Given User execute testcases Id "<TC_Mul_NewBigBatch>" for testcasename 'CMF - Create Big Batch - Default value for Log Submission Record field' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->Big Batch Management UI - Log Submission Records - BCR333' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Bigbatch Page
    And User Create Unique Bigbatch name
    And User Create Unique BigBatchID
    And User Enter BigBatch Common Details
    And User verify Log submission field Default Value
    Then User Click on Save Button

    Examples: 
      | TC_Mul_NewBigBatch | ExecuteScenario | UserName | Region |
      | TC_28016506        | Yes             | qatest10 | AP     |
      | TC_28016510        | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Verify Bigbatch Log Submission field
    Given User execute testcases Id "<TC_Mul_LogSubNo>" for testcasename 'CMF-Create Big Batch with Log Submission record value as No' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->Big Batch Management UI - Log Submission Records - BCR333' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Bigbatch Page
    And User Create Unique Bigbatch name
    And User Create Unique BigBatchID
    And User Enter BigBatch Common Details
    And Select Log Submission Record
    Then User Click on Save Button

    Examples: 
      | TC_Mul_LogSubNo | ExecuteScenario | UserName | Region |
      | TC_28016507     | Yes             | qatest10 | AP     |
      | TC_28016511     | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Verify Bigbatch Log Submission field
    Given User execute testcases Id "<TC_Mul_BigbUpdate>" for testcasename 'CMF- Update Big Batch' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->Big Batch Management UI - Log Submission Records - BCR333' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Bigbatch Page
    And User search for existing Bigbatch
    And User Edit Big Batch
    And User change Log submission to No
    Then User Click on Save Button to Update
    And User Edit Big Batch
    And User change Log submission to Yes
    Then User Click on Save Button to Update

    Examples: 
      | TC_Mul_BigbUpdate | ExecuteScenario | UserName | Region |
      | TC_28016508       | Yes             | qatest10 | AP     |
      | TC_28016512       | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Verify Bigbatch Log Submission field
    Given User execute testcases Id "<TC_Mul_BibLogDB>" for testcasename 'CMF_Log Submission Records value "Yes" sent to G2 while adding new Big batch' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->Send Log Submission Records Option - BCR333' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Bigbatch Page
    And User Create Unique Bigbatch name
    And User Create Unique BigBatchID
    And User Enter BigBatch Common Details
    And User change Log submission
    Then User Click on Save Button
    Then User Validating Bigbatch CMF Database Region "<Region>"
    Then User Validating Bigbatch G2 Database Region "<Region>"

    Examples: 
      | TC_Mul_BibLogDB | ExecuteScenario | UserName | Region |
      | TC_28016516     | Yes             | qatest10 | AP     |
      | TC_28016521     | Yes             | qatest10 | US     |
      | TC_28016517     | Yes             | qatest10 | AP     |
      | TC_28016522     | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Verify Bigbatch Log Submission field
    Given User execute testcases Id "<TC_Mul_BigbatchUpdate>" for testcasename 'CMF_Log Submission Records value "Yes" sent to G2 while Updating Big batch' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->Big Batch Management UI - Log Submission Records - BCR333' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Bigbatch Page
    And User search for existing Bigbatch
    And User Edit Big Batch
    And User change Log submission
    Then User Click on Save Button to Update
    Then User Validating Bigbatch CMF Database Region "<Region>"
    Then User Validating Bigbatch G2 Database Region "<Region>"

    Examples: 
      | TC_Mul_BigbatchUpdate | ExecuteScenario | UserName | Region |
      | TC_28016518           | Yes             | qatest10 | AP     |
      | TC_28016523           | Yes             | qatest10 | US     |
      | TC_28016520           | Yes             | qatest10 | AP     |
      | TC_28016524           | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF BCR316 MasMid to Merchant
    Given User execute testcases Id "<TC_Mul_MerChain>" for testcasename 'CMF_Merchant Chain Effective date field disabled while adding a new merchant' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US153247_UI Notes (Merchant Chain Effective Date) BCR316->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Business Details to Merchant
    And User click Save to create Pending Merchant
    Then User Verify effective date in Merchant Chain

    Examples: 
      | TC_Mul_MerChain | ExecuteScenario | UserName | Region |
      | TC_28012953     | Yes             | qatest10 | AP     |
      | TC_28016171     | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US153247_UI Notes Merchant Chain Effective Date
    Given User execute testcases Id "<TC_Mul_ExistMerChain>" for testcasename 'CMF_Merchant Chain Effective Date field should be removed while updating any merchant' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US153247_UI Notes (Merchant Chain Effective Date) BCR316->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User searching for Existing Merchant
    Then User Verify effective date in Merchant Chain

    Examples: 
      | TC_Mul_ExistMerChain | ExecuteScenario | UserName | Region |
      | TC_28012955          | Yes             | qatest10 | AP     |
      | TC_28016172          | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Check the Effective Date and Time for Merchant
    Given User execute testcases Id "<TC_Mul_Merchant_DateTime>" for testcasename 'CMF_Effective DateTime on Merchant cards accepted UI should be disabled while adding new Merchant.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->SE Merchant ID Effective Date/Time UI Notes BCR316' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    Then User Click on Card type on Merchant page

    Examples: 
      | TC_Mul_Merchant_DateTime | ExecuteScenario | UserName | Region |
      | TC_28012961              | Yes             | qatest10 | AP     |
      | TC_28012965              | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Check the Effective Date and Time for Merchant and Edit
    Given User execute testcases Id "<TC_Mul_Merchant_DateTimeEdit>" for testcasename 'CMF_Effective DateTime on Merchant cards accepted UI should not be editable while adding new Merchant.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->SE Merchant ID Effective Date/Time UI Notes BCR316' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    Then User Click on Card type on Merchant page
    And User click disable Element
    And User click disable CalenderElement
    And User click disable dropdown for Effectivetime

    Examples: 
      | TC_Mul_Merchant_DateTimeEdit | ExecuteScenario | UserName | Region |
      | TC_28012962                  | Yes             | qatest10 | AP     |
      | TC_28012966                  | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Search for Existing Merchant and Edit Effective Date or time.
    Given User execute testcases Id "<TC_Mul_SearchMerchant_DateTimeEdit>" for testcasename 'CMF_Effective DateTime on Merchant cards accepted UI should be disabled while updating any merchant.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->SE Merchant ID Effective Date/Time UI Notes BCR316' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Merchant Page
    And User searching for Existing Merchant
    Then User Click on Card type on Merchant page

    Examples: 
      | TC_Mul_SearchMerchant_DateTimeEdit | ExecuteScenario | UserName | Region |
      | TC_28012963                        | Yes             | qatest10 | AP     |
      | TC_28012968                        | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Search for Existing Merchant and Edit Date and time.
    Given User execute testcases Id "<TC_Mul_SearchMerchant_EditTime>" for testcasename 'CMF_Effective DateTime on Merchant cards accepted UI should not be editable while updating any merchant.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->SE Merchant ID Effective Date/Time UI Notes BCR316' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Merchant Page
    And User searching for Existing Merchant
    Then User Click on Card type on Merchant page
    And User click disable Element
    And User click disable CalenderElement
    And User click disable dropdown for Effectivetime

    Examples: 
      | TC_Mul_SearchMerchant_EditTime | ExecuteScenario | UserName | Region |
      | TC_28012964                    | Yes             | qatest10 | AP     |
      | TC_28012969                    | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US147143_UI Notes Merchant Chain Effective Date
    Given User execute testcases Id "<TC_Mul_ExistMerChain>" for testcasename 'CMF_User with CPR_Maintain permission should be able to edit the Customer number on Customer managemnet screen' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US153247_UI Notes (Merchant Chain Effective Date) BCR316->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    And User Searching Customer By number
    And User Click on Edit Button
    And User Creating unique Customer Number
    And User Click on customer Save changes Successfully

    Examples: 
      | TC_Mul_ExistMerChain | ExecuteScenario | UserName | Region |
      | TC_28013002          | Yes             | qatest10 | AP     |
      | TC_28013011          | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US147143_CPR - Customer Portfolio Reassignment
    Given User execute testcases Id "<TC_Mul_withoutCPRCust>" for testcasename 'CMF_User without CPR_Maintain permission should NOT be able to edit the Customer number on Customer managemnet screen' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147143_CPR - Customer Portfolio Reassignment - Restrict Customer Number Updates - BCR316' Execute "<ExecuteScenario>"
    When Launch the USAT Application and Login with the User "<USATLoginuser>" Region "<Region>"
    And Search for user "<SearchUser>" to Delete existing CPR roles
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    And User Searching Customer By number
    And User Click on Edit Button
    Then User Verify Cust Number and Name disabled

    Examples: 
      | TC_Mul_withoutCPRCust | ExecuteScenario | UserName | Region | USATLoginuser | SearchUser |
      | TC_28013003           | Yes             | qatest20 | AP     | qatest10      | qatest20   |
      | TC_28013012           | Yes             | qatest20 | US     | qatest10      | qatest20   |

  Scenario Outline: GSAP_CMF US147143_CPR - Customer Portfolio Reassignment
    Given User execute testcases Id "<TC_Mul_withoutCPRMerch>" for testcasename 'CMF_User without CPR_Maintain permission should NOT be able to edit the Customer number on Merchant management screen' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147143_CPR - Customer Portfolio Reassignment - Restrict Customer Number Updates - BCR316' Execute "<ExecuteScenario>"
    When Launch the USAT Application and Login with the User "<USATLoginuser>" Region "<Region>"
    And Search for user "<SearchUser>" to Delete existing CPR roles
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    And User searching for Existing Merchant
    And User Click on Edit Button
    Then User Verify Cust Number and Name disabled

    Examples: 
      | TC_Mul_withoutCPRMerch | ExecuteScenario | UserName | Region | USATLoginuser | SearchUser |
      | TC_28013004            | Yes             | qatest20 | AP     | qatest10      | qatest20   |
      | TC_28013007            | Yes             | qatest20 | US     | qatest10      | qatest20   |

  Scenario Outline: GSAP_CMF US147143_CPR - Customer Portfolio Reassignment
    Given User execute testcases Id "<TC_Mul_withoutCPRTerm>" for testcasename 'CMF_User without CPR_Maintain permission should NOT be able to edit the Customer number on Terminal management screen' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147143_CPR - Customer Portfolio Reassignment - Restrict Customer Number Updates - BCR316' Execute "<ExecuteScenario>"
    When Launch the USAT Application and Login with the User "<USATLoginuser>" Region "<Region>"
    And Search for user "<SearchUser>" to Delete existing CPR roles
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    And User Search By TerminalID
    And User Click on Edit Button
    Then User Verify Cust Number and Name disabled

    Examples: 
      | TC_Mul_withoutCPRTerm | ExecuteScenario | UserName | Region | USATLoginuser | SearchUser |
      | TC_28013005           | Yes             | qatest20 | AP     | qatest10      | qatest20   |
      | TC_28013008           | Yes             | qatest20 | US     | qatest10      | qatest20   |

  Scenario Outline: GSAP_CMF US147143_CPR - Customer Portfolio Reassignment
    Given User execute testcases Id "<TC_Mul_withoutCPRChain>" for testcasename 'CMF_User without CPR_Maintain permission should NOT be able to edit the Customer number on Chain management screen.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147143_CPR - Customer Portfolio Reassignment - Restrict Customer Number Updates - BCR316' Execute "<ExecuteScenario>"
    When Launch the USAT Application and Login with the User "<USATLoginuser>" Region "<Region>"
    And Search for user "<SearchUser>" to Delete existing CPR roles
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    And User navigates to Chain Page
    And User Search Chain ID
    And User Click on Edit Button
    Then User Verify Cust Number and Name disabled

    Examples: 
      | TC_Mul_withoutCPRChain | ExecuteScenario | UserName | Region | USATLoginuser | SearchUser |
      | TC_28013006            | Yes             | qatest20 | AP     | qatest10      | qatest20   |
      | TC_28013010            | Yes             | qatest20 | US     | qatest10      | qatest20   |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment
    Given User execute testcases Id "<TC_Mul_CPRcustMerch>" for testcasename 'CMF_User with both permissions Should be able to change the Parent customer for the Merchant_No chains assigned to merchant.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User With Both Permissions' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    And User create Open Merchant with Parent Cust1
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change parent customer for CPR Validation

    Examples: 
      | TC_Mul_CPRcustMerch | ExecuteScenario | UserName | Region |
      | TC_28096492         | Yes             | qatest10 | AP     |
      | TC_28159314         | Yes             | qatest10 | US     |
      | TC_28120242         | Yes             | qatest10 | AP     |
      | TC_28159317         | Yes             | qatest10 | US     |
      | TC_28124722         | Yes             | qatest10 | AP     |
      | TC_28159328         | Yes             | qatest10 | US     |
      | TC_28120248         | Yes             | qatest10 | AP     |
      | TC_28159318         | Yes             | qatest10 | US     |
      | TC_28120354         | Yes             | qatest10 | AP     |
      | TC_28159323         | Yes             | qatest10 | US     |
      | TC_28174647         | Yes             | qatest10 | AP     |
      | TC_28174657         | Yes             | qatest10 | US     |
      | TC_28181193         | Yes             | qatest10 | AP     |
      | TC_28181358         | Yes             | qatest10 | US     |
      | TC_28181241         | Yes             | qatest10 | AP     |
      | TC_28181359         | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment
    Given User execute testcases Id "<TC_Mul_CPRMerchChain>" for testcasename 'CMF_User with both permissions Should be able to change the Parent customer for the Merchant No chains assigned to merchant' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User With Both Permissions' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    And User Create Chain1 CPR Validations
    When User navigates to Add Merchant Page
    And User Enters parent customer1 Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User filling Business Details to Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Adding Chain1 to Merchant Dynamically
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change parent customer for CPR Validation

    Examples: 
      | TC_Mul_CPRMerchChain | ExecuteScenario | UserName | Region |
      | TC_28097169          | Yes             | qatest10 | AP     |
      | TC_28159315          | Yes             | qatest10 | US     |
      | TC_28291812          | Yes             | qatest10 | US     |
      | TC_28124757          | Yes             | qatest10 | AP     |
      | TC_28159329          | Yes             | qatest10 | US     |
      | TC_28159553          | Yes             | qatest10 | AP     |
      | TC_28159843          | Yes             | qatest10 | US     |
      | TC_28178179          | Yes             | qatest10 | AP     |
      | TC_28181354          | Yes             | qatest10 | US     |
      | TC_28180189          | Yes             | qatest10 | AP     |
      | TC_28181356          | Yes             | qatest10 | US     |
      | TC_28180806          | Yes             | qatest10 | AP     |
      | TC_28181357          | Yes             | qatest10 | US     |
      | TC_28181270          | Yes             | qatest10 | AP     |
      | TC_28181360          | Yes             | qatest10 | US     |
      | TC_28180045          | Yes             | qatest10 | AP     |
      | TC_28181355          | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment Not able
    Given User execute testcases Id "<TC_Mul_CPRNotAble>" for testcasename 'CMF_User with both permissions Should NOT be able to change the Parent customer for the Merchant as data at customer level is different but Chain is assigned to merchant.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User With Both Permissions' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    And User Create Chain1 CPR Validations
    When User navigates to Add Merchant Page
    And User Enters parent customer1 Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User filling Business Details to Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Adding Chain1 to Merchant Dynamically
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_CPRNotAble | ExecuteScenario | UserName | Region |
      | TC_28159316       | Yes             | qatest10 | US     |
      | TC_28120256       | Yes             | qatest10 | AP     |
      | TC_28159319       | Yes             | qatest10 | US     |
      | TC_28120299       | Yes             | qatest10 | AP     |
      | TC_28159320       | Yes             | qatest10 | US     |
      | TC_28124834       | Yes             | qatest10 | AP     |
      | TC_28159330       | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment Not able
    Given User execute testcases Id "<TC_Mul_CPRNotAbleScenarios>" for testcasename 'CMF_User with both permissions Should NOT be able to change the Parent customer for the Merchant as data at customer level is same & cut times assigned are different' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User With Both Permissions' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    And User create Open Merchant with Parent Cust1
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_CPRNotAbleScenarios | ExecuteScenario | UserName | Region |
      | TC_28120312                | Yes             | qatest10 | AP     |
      | TC_28159321                | Yes             | qatest10 | US     |
      | TC_28120321                | Yes             | qatest10 | AP     |
      | TC_28159322                | Yes             | qatest10 | US     |
      | TC_28120794                | Yes             | qatest10 | AP     |
      | TC_28159325                | Yes             | qatest10 | US     |
      | TC_28121032                | Yes             | qatest10 | AP     |
      | TC_28159327                | Yes             | qatest10 | US     |
      | TC_28124878                | Yes             | qatest10 | AP     |
      | TC_28159331                | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment Not able
    Given User execute testcases Id "<TC_Mul_CPRPendingCust>" for testcasename 'CMF_User having CPR_Maintain,CPR_View permissions should not be able to change the parent customer for the Merchant when all data is same at customer level. But parent customer1 is in pending status' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User With Both Permissions' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Customer Page
    And User Creating unique Customer Number For Cust1
    And User enter Customer Mandatory details
    And User giving Specific Logic to Customer
    And User Adding Customer all cut Times
    And User click on Save button to create Pending Customer
    And User adding Acquirer Account to Customer
    And User adding Encryption to Customer
    And User Adding Card Types to Customer
    And User click on Back to Customer link
    And User create Open Merchant with Parent Cust1
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_CPRPendingCust | ExecuteScenario | UserName | Region |
      | TC_28159683           | Yes             | qatest10 | AP     |
      | TC_28159844           | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment Not able
    Given User execute testcases Id "<TC_Mul_CPRMerchPending>" for testcasename 'CMF_User having CPR_Maintain,CPR_View permissions should not be able to change the parent customer for the Merchant when all data is same at customer level. But Merchant is in pending status' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User With Both Permissions' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    When User navigates to Add Merchant Page
    And User Enters parent customer1 Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User filling Business Details to Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change parent customer for CPR Validation

    Examples: 
      | TC_Mul_CPRMerchPending | ExecuteScenario | UserName | Region |
      | TC_28177932            | Yes             | qatest10 | AP     |
      | TC_28181353            | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment
    Given User execute testcases Id "<TC_Mul_CPRMaintain>" for testcasename 'CMF_User with only CPR_Maintain Permission Should NOT be able to change the Parent customer for the Merchant when data at customer level is same & no chain assigned.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User with Only CPR_Maintain Permission' Execute "<ExecuteScenario>"
    When Launch the USAT Application and Login with the User "<USATLoginuser>" Region "<Region>"
    And Search for user "<SearchUser>" to Delete existing CPR roles and Add new CPR roles
    When Launch the Application and Login with the User "<SearchUser>" Region "<Region>"
    When User create Open Customer1
    And User create Open Merchant with Parent Cust1
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_CPRMaintain | ExecuteScenario | Region | USATLoginuser | SearchUser |
      | TC_28216578        | Yes             | AP     | qatest10      | qatest20   |
      | TC_28219058        | Yes             | US     | qatest10      | qatest20   |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment Not able
    Given User execute testcases Id "<TC_Mul_CPRMaintainChain>" for testcasename 'CMF_User with only CPR_Maintain Permission Should NOT be able to change the Parent customer for the Merchant when data at customer level is same & chain assigned.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User with Only CPR_Maintain Permission' Execute "<ExecuteScenario>"
    When Launch the USAT Application and Login with the User "<USATLoginuser>" Region "<Region>"
    And Search for user "<SearchUser>" to Delete existing CPR roles and Add new CPR roles
    When Launch the Application and Login with the User "<SearchUser>" Region "<Region>"
    When User create Open Customer1
    And User Create Chain1 CPR Validations
    When User navigates to Add Merchant Page
    And User Enters parent customer1 Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User filling Business Details to Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Adding Chain1 to Merchant Dynamically
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_CPRMaintainChain | ExecuteScenario | Region | USATLoginuser | SearchUser |
      | TC_28216596             | Yes             | AP     | qatest10      | qatest20   |
      | TC_28219059             | Yes             | US     | qatest10      | qatest20   |
      | TC_28216761             | Yes             | AP     | qatest10      | qatest20   |
      | TC_28219060             | Yes             | US     | qatest10      | qatest20   |
      | TC_28217205             | Yes             | AP     | qatest10      | qatest20   |
      | TC_28219061             | Yes             | US     | qatest10      | qatest20   |
      | TC_28217231             | Yes             | AP     | qatest10      | qatest20   |
      | TC_28219062             | Yes             | US     | qatest10      | qatest20   |
      | TC_28217512             | Yes             | AP     | qatest10      | qatest20   |
      | TC_28219063             | Yes             | US     | qatest10      | qatest20   |
      | TC_28217658             | Yes             | AP     | qatest10      | qatest20   |
      | TC_28219064             | Yes             | US     | qatest10      | qatest20   |
      | TC_28218865             | Yes             | AP     | qatest10      | qatest20   |
      | TC_28219068             | Yes             | US     | qatest10      | qatest20   |
      | TC_28218879             | Yes             | AP     | qatest10      | qatest20   |
      | TC_28219069             | Yes             | US     | qatest10      | qatest20   |
      | TC_28218943             | Yes             | AP     | qatest10      | qatest20   |
      | TC_28219070             | Yes             | US     | qatest10      | qatest20   |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment Not able
    Given User execute testcases Id "<TC_Mul_CPRMaintainPending>" for testcasename 'CMF_User with only CPR_Maintain Permission Should NOT be able to change the Parent customer for the Merchant when data at customer level is same & chain assigned.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User with Only CPR_Maintain Permission' Execute "<ExecuteScenario>"
    When Launch the USAT Application and Login with the User "<USATLoginuser>" Region "<Region>"
    And Search for user "<SearchUser>" to Delete existing CPR roles and Add new CPR roles
    When Launch the Application and Login with the User "<SearchUser>" Region "<Region>"
    And User create Pending Customer1
    And User Create Chain1 CPR Validations
    When User navigates to Add Merchant Page
    And User Enters parent customer1 Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User filling Business Details to Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Adding Chain1 to Merchant Dynamically
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_CPRMaintainPending | ExecuteScenario | Region | USATLoginuser | SearchUser |
      | TC_28217949               | Yes             | AP     | qatest10      | qatest20   |
      | TC_28219065               | Yes             | US     | qatest10      | qatest20   |
      | TC_28222621               | Yes             | AP     | qatest10      | qatest20   |
      | TC_28223059               | Yes             | US     | qatest10      | qatest20   |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment Not able
    Given User execute testcases Id "<TC_Mul_CPRMaintainPendCust2>" for testcasename 'CMF_User with only CPR_Maintain Permission Should NOT be able to change the Parent customer for the Merchant when data at customer level is same & chain assigned.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User with Only CPR_Maintain Permission' Execute "<ExecuteScenario>"
    When Launch the USAT Application and Login with the User "<USATLoginuser>" Region "<Region>"
    And Search for user "<SearchUser>" to Delete existing CPR roles and Add new CPR roles
    When Launch the Application and Login with the User "<SearchUser>" Region "<Region>"
    When User create Open Customer1
    And User Create Chain1 CPR Validations
    When User navigates to Add Merchant Page
    And User Enters parent customer1 Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User filling Business Details to Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Adding Chain1 to Merchant Dynamically
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    And User create Pending Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_CPRMaintainPendCust2 | ExecuteScenario | Region | USATLoginuser | SearchUser |
      | TC_28218270                 | Yes             | AP     | qatest10      | qatest20   |
      | TC_28219066                 | Yes             | US     | qatest10      | qatest20   |
      | TC_28222629                 | Yes             | AP     | qatest10      | qatest20   |
      | TC_28223060                 | Yes             | US     | qatest10      | qatest20   |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment Not able
    Given User execute testcases Id "<TC_Mul_CPRMaintainPendMerch>" for testcasename 'CMF_User with only CPR_Maintain Permission Should NOT be able to change the Parent customer for the Merchant when data at customer level is same & chain assigned.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User with Only CPR_Maintain Permission' Execute "<ExecuteScenario>"
    When Launch the USAT Application and Login with the User "<USATLoginuser>" Region "<Region>"
    And Search for user "<SearchUser>" to Delete existing CPR roles and Add new CPR roles
    When Launch the Application and Login with the User "<SearchUser>" Region "<Region>"
    When User create Open Customer1
    And User Create Chain1 CPR Validations
    When User navigates to Add Merchant Page
    And User Enters parent customer1 Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User filling Business Details to Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Adding Chain1 to Merchant Dynamically
    And User click Back to Merchant link
    And User Validate Merchant
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_CPRMaintainPendMerch | ExecuteScenario | Region | USATLoginuser | SearchUser |
      | TC_28218277                 | Yes             | AP     | qatest10      | qatest20   |
      | TC_28219067                 | Yes             | US     | qatest10      | qatest20   |
      | TC_28222964                 | Yes             | AP     | qatest10      | qatest20   |
      | TC_28223061                 | Yes             | US     | qatest10      | qatest20   |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment
    Given User execute testcases Id "<TC_Mul_CPRView>" for testcasename 'CMF_User with only CPR_View Permission Should NOT be able to change the Parent customer for the Merchant when data at customer level is same & no chain assigned.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User with only CPR_View Permission' Execute "<ExecuteScenario>"
    When Launch the USAT Application and Login with the User "<USATLoginuser>" Region "<Region>"
    And Search for user "<SearchUser>" to Delete existing CPR roles and Add new CPR roles
    When Launch the Application and Login with the User "<SearchUser>" Region "<Region>"
    When User create Open Customer1
    And User create Open Merchant with Parent Cust1
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_CPRView | ExecuteScenario | Region | USATLoginuser | SearchUser |
      | TC_28221130    | Yes             | AP     | qatest10      | qatest20   |
      | TC_28223052    | Yes             | US     | qatest10      | qatest20   |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment Not able
    Given User execute testcases Id "<TC_Mul_CPRViewChain>" for testcasename 'CMF_User with only CPR_View Permission Should NOT be able to change the Parent customer for the Merchant when data at customer level is same & chain assigned.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User with only CPR_View Permission' Execute "<ExecuteScenario>"
    When Launch the USAT Application and Login with the User "<USATLoginuser>" Region "<Region>"
    And Search for user "<SearchUser>" to Delete existing CPR roles and Add new CPR roles
    When Launch the Application and Login with the User "<SearchUser>" Region "<Region>"
    When User create Open Customer1
    And User Create Chain1 CPR Validations
    When User navigates to Add Merchant Page
    And User Enters parent customer1 Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User filling Business Details to Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Adding Chain1 to Merchant Dynamically
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_CPRViewChain | ExecuteScenario | Region | USATLoginuser | SearchUser |
      | TC_28221525         | Yes             | AP     | qatest10      | qatest20   |
      | TC_28223053         | Yes             | US     | qatest10      | qatest20   |
      | TC_28222391         | Yes             | AP     | qatest10      | qatest20   |
      | TC_28223054         | Yes             | US     | qatest10      | qatest20   |
      | TC_28222424         | Yes             | AP     | qatest10      | qatest20   |
      | TC_28223055         | Yes             | US     | qatest10      | qatest20   |
      | TC_28222447         | Yes             | AP     | qatest10      | qatest20   |
      | TC_28223056         | Yes             | US     | qatest10      | qatest20   |
      | TC_28222473         | Yes             | AP     | qatest10      | qatest20   |
      | TC_28223057         | Yes             | US     | qatest10      | qatest20   |
      | TC_28222542         | Yes             | AP     | qatest10      | qatest20   |
      | TC_28223058         | Yes             | US     | qatest10      | qatest20   |
      | TC_28222989         | Yes             | AP     | qatest10      | qatest20   |
      | TC_28223062         | Yes             | US     | qatest10      | qatest20   |
      | TC_28223027         | Yes             | AP     | qatest10      | qatest20   |
      | TC_28223063         | Yes             | US     | qatest10      | qatest20   |
      | TC_28223031         | Yes             | AP     | qatest10      | qatest20   |
      | TC_28223064         | Yes             | US     | qatest10      | qatest20   |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment Not able
    Given User execute testcases Id "<TC_Mul_NotHaveBothCPR>" for testcasename 'CMF_User not having CPR_Maintain,CPR_View permissions Should NOT be able to change the Parent customer for the Merchant when data at customer level same, cut times are same,cards assigned are same, No chain assigned to merchant.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User Not having CPR_View, CPR_Maintain permissions' Execute "<ExecuteScenario>"
    When Launch the USAT Application and Login with the User "<USATLoginuser>" Region "<Region>"
    And Search for user "<SearchUser>" to Delete existing CPR roles
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    And User Create Chain1 CPR Validations
    When User navigates to Add Merchant Page
    And User Enters parent customer1 Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User filling Business Details to Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Adding Chain1 to Merchant Dynamically
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_NotHaveBothCPR | ExecuteScenario | UserName | Region | USATLoginuser | SearchUser |
      | TC_28257815           | Yes             | qatest20 | AP     | qatest10      | qatest20   |
      | TC_28260089           | Yes             | qatest20 | US     | qatest10      | qatest20   |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment Not able
    Given User execute testcases Id "<TC_Mul_NotHaveBothCPRChain>" for testcasename 'CMF_User not having CPR_Maintain,CPR_View permissions Should NOT be able to change the Parent customer for the Merchant when data at customer level same, cut times are same,cards assigned are same, No chain assigned to merchant.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User Not having CPR_View, CPR_Maintain permissions' Execute "<ExecuteScenario>"
    When Launch the USAT Application and Login with the User "<USATLoginuser>" Region "<Region>"
    And Search for user "<SearchUser>" to Delete existing CPR roles
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    When User navigates to Add Merchant Page
    And User Enters parent customer1 Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User filling Business Details to Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_NotHaveBothCPRChain | ExecuteScenario | UserName | Region | USATLoginuser | SearchUser |
      | TC_28258063                | Yes             | qatest20 | AP     | qatest10      | qatest20   |
      | TC_28260091                | Yes             | qatest20 | US     | qatest10      | qatest20   |

  Scenario Outline: GSAP_CMF US147148_CPR - Customer Portfolio Reassignment - Merchant Card Types - BCR316
    Given User execute testcases Id "<TC_Mul_CPRBCR148>" for testcasename 'CMF_User with both permissions Should be able to change the Parent customer for the Merchant_No chains assigned to merchant.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147148_CPR - Customer Portfolio Reassignment - Merchant Card Types - BCR316->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    And User create Open Merchant with Parent Cust1
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change parent customer for CPR Validation

    Examples: 
      | TC_Mul_CPRBCR148 | ExecuteScenario | UserName | Region |
      | TC_28013013      | Yes             | qatest10 | AP     |
      | TC_28013018      | Yes             | qatest10 | US     |
      | TC_28013017      | Yes             | qatest10 | AP     |
      | TC_28013023      | Yes             | qatest10 | US     |
      | TC_28081650      | Yes             | qatest10 | US     |
      | TC_28013023      | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US147148_CPR - Customer Portfolio Reassignment - Merchant Card Types - BCR316
    Given User execute testcases Id "<TC_Mul_CPRNotAbleCards>" for testcasename 'CMF_User with permissions should NOT be able to change the Parent customer if the Customers have different card types assigned.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147148_CPR - Customer Portfolio Reassignment - Merchant Card Types - BCR316->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    And User create Open Merchant with Parent Cust1
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_CPRNotAbleCards | ExecuteScenario | UserName | Region |
      | TC_28013014            | Yes             | qatest10 | AP     |
      | TC_28013020            | Yes             | qatest10 | US     |
      | TC_28016939            | Yes             | qatest10 | US     |
      | TC_28282418            | Yes             | qatest10 | AP     |
      | TC_28286457            | Yes             | qatest10 | US     |
      | TC_28286306            | Yes             | qatest10 | AP     |
      | TC_28286458            | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US147148_CPR - Customer Portfolio Reassignment - Merchant Card Types - BCR316
    Given User execute testcases Id "<TC_Mul_NotHaveBothCPRCards>" for testcasename 'CMF_User without permissions should NOT be able to change the Parent customer if the Customers have same card types assigned.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User Not having CPR_View, CPR_Maintain permissions' Execute "<ExecuteScenario>"
    When Launch the USAT Application and Login with the User "<USATLoginuser>" Region "<Region>"
    And Search for user "<SearchUser>" to Delete existing CPR roles
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    When User navigates to Add Merchant Page
    And User Enters parent customer1 Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User filling Business Details to Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_NotHaveBothCPRCards | ExecuteScenario | UserName | Region | USATLoginuser | SearchUser |
      | TC_28013015                | Yes             | qatest20 | AP     | qatest10      | qatest20   |
      | TC_28013021                | Yes             | qatest20 | US     | qatest10      | qatest20   |
      | TC_28013016                | Yes             | qatest20 | AP     | qatest10      | qatest20   |
      | TC_28013022                | Yes             | qatest20 | US     | qatest10      | qatest20   |

  Scenario Outline: GSAP_CMF US154123_CPR - Customer Portfolio Rassignment - Discover Retained Flag - BCR316
    Given User execute testcases Id "<TC_Mul_CPRDiscover>" for testcasename 'CMF_Discover Retained flag as No & Acquirer with Discover Acquirer ID' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US154123_CPR - Customer Portfolio Rassignment - Discover Retained Flag - BCR316->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    When User navigates to Add Merchant Page
    And User Enters parent customer1 Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User Change Discover Retained value
    And User filling Business Details to Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change parent customer for CPR Validation

    Examples: 
      | TC_Mul_CPRDiscover | ExecuteScenario | UserName | Region |
      | TC_28016543        | Yes             | qatest10 | AP     |
      | TC_28016691        | Yes             | qatest10 | US     |
      | TC_28016594        | Yes             | qatest10 | AP     |
      | TC_28016693        | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US154123_CPR - Customer Portfolio Rassignment - Discover Retained Flag - BCR316
    Given User execute testcases Id "<TC_Mul_CPRDiscoverRetained>" for testcasename 'CMF_Discover Retained flag as No & Acquirer with Discover Acquirer ID' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US154123_CPR - Customer Portfolio Rassignment - Discover Retained Flag - BCR316->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    When User navigates to Add Merchant Page
    And User Enters parent customer1 Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User Change Discover Retained value
    And User filling Business Details to Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    When User navigates to Add Acquirer Page
    And User Create Unique Acquirer name
    And User fill Acquirer Details Region "<Region>"
    And User Save Acquirer Account
    When User navigates to Add Customer Page
    And User Creating unique Customer Number For Cust2
    And User enter Customer2 Mandatory details
    And User giving Specific Logic to Customer2
    And User Adding Customer2 all cut Times
    And User click on Save button to create Pending Customer
    And User adding Acquirer Account to Customer Dynamically
    And User Adding Card Types to Customer2
    And User click on Back to Customer link
    And User Validate Customer
    And User changing Customer status to Open
    And User searching for Existing Merchant Dynamically
    Then User Change Parent Cust and getting Error CPR validations

    Examples: 
      | TC_Mul_CPRDiscoverRetained | ExecuteScenario | UserName | Region |
      | TC_28016573                | Yes             | qatest10 | AP     |
      | TC_28016692                | Yes             | qatest10 | US     |
      | TC_28016612                | Yes             | qatest10 | AP     |
      | TC_28016694                | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US147149_CPR - Customer Portfolio Reassignment - Inherited/Stored Fields - BCR316
    Given User execute testcases Id "<TC_Mul_CPRDBValidations>" for testcasename 'CPR_User should not be able to process CPR if values of inherited fields are different_LOB' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->CMF US147149_CPR - Customer Portfolio Reassignment - Inherited/Stored Fields - BCR316->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    Then User Validating Customer CMF Database CPR Cust1 Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer1 Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User Change Discover Retained value
    And User filling Business Details to Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    And User create Open Customer2
    Then User Validating Customer CMF Database CPR cust2 Region "<Region>"
    And User Searching Customer2 for CPR and Change LOB
    And User searching for Existing Merchant Dynamically
    Then User Change parent customer for CPR Validation
    Then User Validating Merchant CMF CPR Database Region "<Region>"

    Examples: 
      | TC_Mul_CPRDBValidations | ExecuteScenario | UserName | Region |
      | TC_28364042             | Yes             | qatest10 | AP     |
      | TC_28364177             | Yes             | qatest10 | US     |
      | TC_28364053             | Yes             | qatest10 | AP     |
      | TC_28364178             | Yes             | qatest10 | US     |
      | TC_28364066             | Yes             | qatest10 | AP     |
      | TC_28364179             | Yes             | qatest10 | US     |
      | TC_28281437             | Yes             | qatest10 | AP     |
      | TC_28286459             | Yes             | qatest10 | US     |
      | TC_28281503             | Yes             | qatest10 | AP     |
      | TC_28286456             | Yes             | qatest10 | US     |
      | TC_28282418             | Yes             | qatest10 | AP     |
      | TC_28286457             | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US147142_CPR - Customer Portfolio Reassignment Not able
    Given User execute testcases Id "<TC_Mul_CPRNotAbleTerm>" for testcasename 'CMF_User with both permissions Should be able to change the Parent customer for the Merchant as Reference no settings data at terminal level is same.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.1 Test Cases->Functional Testing->US147142_CPR - Customer Portfolio Reassignment - Access - BCR316->User With Both Permissions' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    And User create Open Merchant with Parent Cust1
    When User navigates to Add Terminal Page
    And User Enter Merchant Id Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    And User Clicking Back To Terminal
    And User validate the terminal
    Then User Change the terminal Status
    And User create Open Customer2
    And User searching for Existing Merchant Dynamically
    Then User Change parent customer for CPR Validation

    Examples: 
      | TC_Mul_CPRNotAbleTerm | ExecuteScenario | UserName | Region |
      | TC_28097188           | Yes             | qatest10 | AP     |
      | TC_28291813           | Yes             | qatest10 | US     |
