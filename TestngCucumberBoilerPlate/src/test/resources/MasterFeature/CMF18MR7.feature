Feature: Execution of CMF18MR7 scripts

  Background: 
    Given : User loads the "CMF18MR7" json file

  Scenario Outline: GSAP_CMF Discover Acquirer ID
    Given User execute testcaseId 'TC_23912273' for testcasename 'CMF_BCR294_with_DIS_Acq_ID_Mertchant_Add Diners_verify_AP' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->BCR294_Restrictions on deleting values from Acquirer Account->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Customer Page
    And User Creating unique Customer Number
    And User enter Customer Mandatory details
    And User giving Specific Logic to Customer
    And User Adding Customer all cut Times
    And User click on Save button to create Pending Customer
    And User adding Acquirer Account to Customer
    And User adding Encryption to Customer
    Then Adding Card type to Customer and Verifying Error Msg

    Examples: 
      | ExecuteScenario | UserName | Region |
      | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Discover Acquirer ID for Diner Card
    Given User execute testcaseId 'TC_23891248' for testcasename 'CMF_BCR294_with_DIS_Acq_ID_Mertchant_Add Diners_Verify_AP' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->BCR294_Restrictions on deleting values from Acquirer Account->AP' Execute "<ExecuteScenario>"
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
    And User navigates to Acquirer Page
    And User Search for Acquirer Account
    Then Delete Acq Discover ID and Validate error message

    Examples: 
      | ExecuteScenario | UserName | Region |
      | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Discover Acquirer ID for Discover Card
    Given User execute testcaseId 'TC_23891328' for testcasename 'CMF_BCR294_with_DIS_Acq_ID_Mertchant_Add Discover_Verify AP' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->BCR294_Restrictions on deleting values from Acquirer Account->AP' Execute "<ExecuteScenario>"
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
    And User navigates to Acquirer Page
    And User Search for Acquirer Account
    Then Delete Acq Discover ID and Validate error message

    Examples: 
      | ExecuteScenario | UserName | Region |
      | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Discover Acquirer ID for Discover Card
    Given User execute testcaseId 'TC_23891377' for testcasename 'CMF_BCR294_with_DIS_Acq_ID_Mertchant_Add Discover_Diners_Verify_AP' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->BCR294_Restrictions on deleting values from Acquirer Account->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    Then User Validating Customer CMF Database Multiple values "<Region>"
    Then User Validating Customer G2 Database Multiple values "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User navigates to Acquirer Page
    And User Search for Acquirer Account
    Then Delete Acq Discover ID and Validate error message

    Examples: 
      | ExecuteScenario | UserName | Region |
      | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Discover Acquirer ID for Discover Card
    Given User execute testcases Id "<TC_Mul_CustCreate>" for testcasename 'CMF_BCR294_DIS_Acq_ID_Add_Discover_Card_Verify_US' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->BCR294_Restrictions on deleting values from Acquirer Account->US' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    Then User Validating Customer CMF Database Multiple values "<Region>"
    Then User Validating Customer G2 Database Multiple values "<Region>"

    Examples: 
      | TC_Mul_CustCreate | ExecuteScenario | UserName | Region |
      | TC_23891130       | Yes             | qatest10 | US     |
      | TC_23948549       | Yes             | qatest10 | US     |
      | TC_24049843       | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Discover Acquirer ID for Discover Card
    Given User execute testcaseId 'TC_23891131' for testcasename 'CMF_BCR294_Without_DIS_Acq_ID_Add_Discover_Card_Verify_US' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->BCR294_Restrictions on deleting values from Acquirer Account->US' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Customer Page
    And User Creating unique Customer Number
    And User enter Customer Mandatory details
    And User giving Specific Logic to Customer
    And User Adding Customer all cut Times
    And User click on Save button to create Pending Customer
    And User adding Acquirer Account to Customer
    And User adding Encryption to Customer
    And User Adding Card Types to Customer
    And User click on Back to Customer link
    Then User validate and open customer for Merchant

    Examples: 
      | ExecuteScenario | UserName | Region |
      | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Discover Acquirer ID for Discover Card
    Given User execute testcaseId 'TC_23891132' for testcasename 'CMF_BCR294_delete_discover_id_assigned _discover card_verify_US' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->BCR294_Restrictions on deleting values from Acquirer Account->US' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    Then User Validating Customer CMF Database Multiple values "<Region>"
    Then User Validating Customer G2 Database Multiple values "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User navigates to Acquirer Page
    And User Search for Acquirer Account
    Then Delete Acq Discover ID and Validate error message

    Examples: 
      | ExecuteScenario | UserName | Region |
      | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Discover Acquirer ID for Discover Card a
    Given User execute testcases Id "<TC_Mul_DiscoverID>" for testcasename 'CMF_BCR294_Assign_Diners_Two Acquirer account' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->Select Discover Card Type (Customer) BCR294->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Customer Page
    And User Creating unique Customer Number
    And User enter Customer Mandatory details
    And User giving Specific Logic to Customer
    And User Adding Customer all cut Times
    And User click on Save button to create Pending Customer
    And User adding Acquirer Account to Customer
    And User adding second Acquirer Account to Customer
    And User adding Encryption to Customer
    And User Adding Card Types to Customer
    And User click on Back to Customer link
    And User Validate Customer
    Then User changing Customer status to Open
    Then User Validating Customer CMF Database Multiple values "<Region>"
    Then User Validating Customer G2 Database Multiple values "<Region>"

    Examples: 
      | TC_Mul_DiscoverID | ExecuteScenario | UserName | Region |
      | TC_23913634       | Yes             | qatest10 | AP     |
      | TC_23913661       | Yes             | qatest10 | AP     |
      | TC_23913696       | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Discover Acquirer ID for Discover Card
    Given User execute testcases Id "<TC_Mul_DiscoverID1>" for testcasename 'CMF_BCR294_Assign_Diners_Two Acquirer account_Without_Discover ID' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->Select Discover Card Type (Customer) BCR294->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Customer Page
    And User Creating unique Customer Number
    And User enter Customer Mandatory details
    And User giving Specific Logic to Customer
    And User Adding Customer all cut Times
    And User click on Save button to create Pending Customer
    And User adding Acquirer Account to Customer
    And User adding second Acquirer Account to Customer
    And User adding Encryption to Customer
    And User Adding Card Types to Customer
    And User click on Back to Customer link
    Then User validate and open customer for Merchant

    Examples: 
      | TC_Mul_DiscoverID1 | ExecuteScenario | UserName | Region |
      | TC_23913709        | Yes             | qatest10 | AP     |
      | TC_23913882        | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Discover Acquirer ID for Discover Card and Diners Club cards
    Given User execute testcases Id "<TC_Mul_DiscoverID2>" for testcasename 'CMF_BCR294_Delete_second acquirer account_Diners card' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->Select Discover Card Type (Customer) BCR294->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Customer Page
    And User Creating unique Customer Number
    And User enter Customer Mandatory details
    And User giving Specific Logic to Customer
    And User Adding Customer all cut Times
    And User click on Save button to create Pending Customer
    And User adding Acquirer Account to Customer
    And User adding second Acquirer Account to Customer
    And User adding Encryption to Customer
    And User Adding Card Types to Customer
    And User click on Back to Customer link
    Then User validate and open customer for Merchant
    Then User delete Acquirer and validate Error message

    Examples: 
      | TC_Mul_DiscoverID2 | ExecuteScenario | UserName | Region |
      | TC_23913895        | Yes             | qatest10 | AP     |
      | TC_23913952        | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF BCR288 MasMid to Merchant
    Given User execute testcases Id "<TC_Mul_MasMID>" for testcasename 'CMF_BCR288_MAS_MID_New_Merchant_Search' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->Merchant Search Facility - BCR288->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Adding Issuer to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    Then User searching for Existing Merchant Using MASMID

    Examples: 
      | TC_Mul_MasMID | ExecuteScenario | UserName | Region |
      | TC_23878933   | Yes             | qatest10 | AP     |
      | TC_23879242   | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF BCR288 MasMid to Merchant
    Given User execute testcases Id "<TC_Mul_MasMID1>" for testcasename 'CMF_BCR288_MAS_MID_Merchant_Search_Special_Characters' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->Merchant Search Facility - BCR288->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Adding Issuer to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    Then User searching for Existing Merchant Using INVALID MASMID

    Examples: 
      | TC_Mul_MasMID1 | ExecuteScenario | UserName | Region |
      | TC_23879312    | Yes             | qatest10 | AP     |
      | TC_23879602    | Yes             | qatest10 | AP     |
      | TC_23879625    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF BCR288 MasMid to Merchant
    Given User execute testcases Id "<TC_Mul_MasMID3>" for testcasename 'CMF_BCR288_MAS_MID_Merchant_Search_Special_Characters' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->Merchant Search Facility - BCR288->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Adding Multiple Issuer to Merchant
    And User click Back to Merchant link
    And User Validate Merchant
    Then User Change Merchant Status
    Then User searching for Existing Merchant Using MASMID

    Examples: 
      | TC_Mul_MasMID3 | ExecuteScenario | UserName | Region |
      | TC_23881979    | Yes             | qatest10 | AP     |
      | TC_23882154    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Discover Acquirer ID for Diners Card
    Given User execute testcaseId 'TC_23912187' for testcasename 'CMF_BCR294_Update_DIS_Acq_ID_Add_Diners_Card_Verify_AP' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->Dependence on Acquirer ID BCR294->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    Then User Validating Customer CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"
    When User navigates to Acquirer Page
    And User Search for Acquirer Account
    Then Update Acquirer Discover ID
    Then User Validating Customer CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"

    Examples: 
      | ExecuteScenario | UserName | Region |
      | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Discover Acquirer ID for Diners Card
    Given User execute testcaseId 'TC_23891128' for testcasename 'CMF_BCR294_DIS_Acq_ID_Add_Diners_Card_Verify_AP' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->Dependence on Acquirer ID BCR294->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    Then User Validating Customer CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"

    Examples: 
      | ExecuteScenario | UserName | Region |
      | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Discover Acquirer ID for Diners Card
    Given User execute testcaseId 'TC_23891129' for testcasename 'CMF_BCR294_Without_DIS_Acq_ID_Add_Diners_Card_Verify_AP' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->Dependence on Acquirer ID BCR294->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Customer Page
    And User Creating unique Customer Number
    And User enter Customer Mandatory details
    And User giving Specific Logic to Customer
    And User Adding Customer all cut Times
    And User click on Save button to create Pending Customer
    And User adding Acquirer Account to Customer
    And User adding Encryption to Customer
    Then Adding Card type to Customer and Verifying Error Msg

    Examples: 
      | ExecuteScenario | UserName | Region |
      | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Discover and Diners SE Number
    Given User execute testcases Id "<TC_Mul_SENumber>" for testcasename 'SE number_Length validation_card type_AMEX' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->SE Number Value Length Validation BCR294' Execute "<ExecuteScenario>"
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
    Then User Change Merchant Status
    Then User Validating Merchant CMF Database Region "<Region>"
    Then User Validating Merchant G2 Database Region "<Region>"

    Examples: 
      | TC_Mul_SENumber | ExecuteScenario | UserName | Region |
      | TC_23914002     | Yes             | qatest10 | AP     |
      | TC_23916850     | Yes             | qatest10 | AP     |
      | TC_23917005     | Yes             | qatest10 | AP     |
      | TC_23978948     | Yes             | qatest10 | AP     |
      | TC_23979004     | Yes             | qatest10 | AP     |
      | TC_23979015     | Yes             | qatest10 | AP     |
      | TC_24476805     | Yes             | qatest10 | AP     |
      | TC_24476840     | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Discover SE number validation
    Given User execute testcaseId 'TC_24477777' for testcasename 'CMF_Discover_card_INVALID_check digit number_US' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Discover Check Digit Validation BCR294->AP' Execute "<ExecuteScenario>"
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
    Then User Giving Invalid SE number to Merchant Card and Validate Error Msg

    Examples: 
      | ExecuteScenario | UserName | Region |
      | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Non Mon Dest File format validation
    Given User execute testcases Id "<TC_Mul_NonMonDest>" for testcasename 'CMF_Edit_Non_Mon_GCF_2018_To_Verizon_File_Format' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->Modified GCF File - Verizon - CMF- BCR298->US' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Non Monetary Page
    And User Create Unique Non Monetary name
    And User Create Unique Non Monetary DataTransFileName
    And User fillDataFileDetailsRiskNet
    And User fillExceptionDetails
    And User Add Card Types to NonMonDest
    And User Add CutTimes to NonMonDest
    Then User Save NonMonDest
    Then User Edit Non Mon and Update File Format

    Examples: 
      | TC_Mul_NonMonDest | ExecuteScenario | UserName | Region |
      | TC_23947430       | Yes             | qatest10 | US     |
      | TC_24049839       | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Non Mon Dest File format validation
    Given User execute testcases Id "<TC_Mul_NonMonDest1>" for testcasename 'CMF_Edit_Non_Mon_Verizon_File_Format' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->Modified GCF File - Verizon - CMF- BCR298->US' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Non Monetary Page
    And User Create Unique Non Monetary name
    And User Create Unique Non Monetary DataTransFileName
    And User fillDataFileDetailsRiskNet
    And User fillExceptionDetails
    And User Add Card Types to NonMonDest
    And User Add CutTimes to NonMonDest
    Then User Save NonMonDest

    Examples: 
      | TC_Mul_NonMonDest1 | ExecuteScenario | UserName | Region |
      | TC_23947593        | Yes             | qatest10 | US     |
      | TC_24049840        | Yes             | qatest10 | AP     |
      | TC_23947703        | Yes             | qatest10 | US     |
      | TC_24049841        | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Non Mon Dest File format validation
    Given User execute testcases Id "<TC_Mul_NonMonDest2>" for testcasename 'CMF_Edit_Non_Mon_Verizon_File_Format' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Functional->Modified GCF File - Verizon - CMF- BCR298->US' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Non Monetary Page
    And User Create Unique Non Monetary name
    And User Create Unique Non Monetary DataTransFileName
    And User fillDataFileDetailsRiskNet
    And User fillExceptionDetails
    And User Add Card Types to NonMonDest
    And User Add CutTimes to NonMonDest
    Then User Save NonMonDest
    Then User Delete NonMonDest

    Examples: 
      | TC_Mul_NonMonDest2 | ExecuteScenario | UserName | Region |
      | TC_23947957        | Yes             | qatest10 | US     |
      | TC_24049842        | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Non Mon Dest File format validation
    Given User execute testcases Id "<TC_Mul_Defects>" for testcasename 'DE38252_US' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Defects->DE38252_US' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Customer Page
    And User Creating unique Customer Number
    And User enter Customer Mandatory details
    And User giving Specific Logic to Customer
    And User Adding Customer all cut Times
    And User click on Save button to create Pending Customer
    And User adding Acquirer Account to Customer
    And User adding second Acquirer Account to Customer

    Examples: 
      | TC_Mul_Defects | ExecuteScenario | UserName | Region |
      | TC_23949564    | Yes             | qatest10 | US     |
      | TC_23949579    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Non Mon Dest File format validation
    Given User execute testcases Id "<TC_Mul_Defects1>" for testcasename 'DE40486_US' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Defects->DE40486_US' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Non Monetary Page
    And User Search for Non Monetary
    Then User Delete NonMonDest Validate Error

    Examples: 
      | TC_Mul_Defects1 | ExecuteScenario | UserName | Region |
      | TC_23949590     | Yes             | qatest10 | US     |
      | TC_23949595     | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Non Mon Dest File format validation
    Given User execute testcases Id "<TC_Mul_Defects2>" for testcasename 'DE44814_US' and module 'TestCases->Subject->CMF->2018 Test Cases->18.7 Test cases->Defects->DE40486_US' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Non Monetary Page
    And User Search for Non Monetary
    Then User remove Card Types to NonMonDest and validate error

    Examples: 
      | TC_Mul_Defects2 | ExecuteScenario | UserName | Region |
      | TC_23949610     | Yes             | qatest10 | US     |
      | TC_23949614     | Yes             | qatest10 | AP     |
      
      
    
      
      
