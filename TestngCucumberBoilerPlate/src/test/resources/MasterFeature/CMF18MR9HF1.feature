Feature: Execution of CMF18MR9HF1 scripts

  Background:
    Given : User loads the "CMF18MR9HF1" json file

  Scenario Outline: GSAP_CMF Encryption Validations
    Given User execute testcases Id "<TC_Mul_Encryption1>" for testcasename 'Group Encryption key-150 Alphanumeric characters_Length Validation' and module 'TestCases->Subject->CMF->2018 Test Cases->18.9.1 Test cases->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Encryption Page
    And User Create Unique Encryption name
    And User Create Unique Serial Index File
    And User Enter Encryption common details
    Then User Click on Save
    Then User Validating Encryption CMF Database Multiple values "<Region>"
    Then User Validating Encryption G2 Database Multiple values "<Region>"

    Examples:
      | TC_Mul_Encryption1 | ExecuteScenario | UserName | Region |
      | TC_25867465       | Yes             | qatest10 | AP     |
      | TC_25867622       | Yes             | qatest10 | AP     |
      | TC_25867714       | Yes             | qatest10 | AP     |
      | TC_25871147       | Yes             | qatest10 | AP     |
      | TC_25871155       | Yes             | qatest10 | AP     |
      | TC_25871131       | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Encryption Validations
    Given User execute testcaseId 'TC_25867681' for testcasename 'Group Encryption key_Valid characters and special characters' and module 'TestCases->Subject->CMF->2018 Test Cases->18.9.1 Test cases->AP' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Encryption Page
    And User Create Unique Encryption name
    And User Create Unique Serial Index File
    Then Encryption blocked key Special characters alert validation
    Then User Validating Encryption CMF Database Multiple values "<Region>"
    Then User Validating Encryption G2 Database Multiple values "<Region>"

    Examples:
      | ExecuteScenario | UserName | Region |
      | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Encryption Validations
    Given User execute testcases Id "<TC_Mul_Encryption2>" for testcasename 'Group Encryption key-150 Alphanumeric characters_Length Validation' and module 'TestCases->Subject->CMF->2018 Test Cases->18.9.1 Test cases->US' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Encryption Page
    And User Create Unique Encryption name
    And User Create Unique Serial Index File
    And User Enter Encryption common details
    Then User Click on Save
    Then User Validating Encryption CMF Database Multiple values "<Region>"
    Then User Validating Encryption G2 Database Multiple values "<Region>"

    Examples:
      | TC_Mul_Encryption2 | ExecuteScenario | UserName | Region |
      | TC_25891662       | Yes             | qatest10 | US     |
      | TC_25891663       | Yes             | qatest10 | US     |
      | TC_25891665       | Yes             | qatest10 | US     |
      | TC_25891667       | Yes             | qatest10 | US     |
      | TC_25891668       | Yes             | qatest10 | US     |
      | TC_25891666       | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Encryption Validations
    Given User execute testcaseId 'TC_25891664' for testcasename 'Group Encryption key_Valid characters and special characters' and module 'TestCases->Subject->CMF->2018 Test Cases->18.9.1 Test cases->US' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Encryption Page
    And User Create Unique Encryption name
    And User Create Unique Serial Index File
    Then Encryption blocked key Special characters alert validation
    Then User Validating Encryption CMF Database Multiple values "<Region>"
    Then User Validating Encryption G2 Database Multiple values "<Region>"

    Examples:
      | ExecuteScenario | UserName | Region |
      | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Encryption Validations
    Given User execute testcases Id "<TC_Mul_EncryptEBT3>" for testcasename 'DE50367_AP' and module 'TestCases->Subject->CMF->2018 Test Cases->18.9.1 Test cases->Defects' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Encryption Page
    And User Create Unique Encryption name
    And User Create Unique Serial Index File
    And User Enter Encryption common details
    And User Click on Save
    And User navigates to Add Customer Page
    And User Creating unique Customer Number
    And User enter Customer Mandatory details
    And User giving Specific Logic to Customer
    And User Adding Customer all cut Times
    And User click on Save button to create Pending Customer
    And User adding Acquirer Account to Customer
    And User adding Encryption to Customer Dynamically
    And User Adding Card Types to Customer
    And User click on Back to Customer link
    And User Validate Customer
    Then User changing Customer status to Open
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    Then User Change Merchant Status
    When User navigates to Add Terminal Page
    And User Enter Merchant Id Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal

    Examples:
      | TC_Mul_EncryptEBT3 | ExecuteScenario | UserName | Region |
      | TC_25931503       | Yes             | qatest10 | AP     |
      | TC_25931513       | Yes             | qatest10 | US     |
