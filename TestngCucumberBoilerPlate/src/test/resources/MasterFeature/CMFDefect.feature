Feature: Execution of CMFDefect scripts

  Background: 
    Given : User loads the "CMFDefect" json file

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53843>" for testcasename 'DE53843' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    Then User verify Invalid SENumber

    Examples: 
      | TC_Mul_DE53843 | ExecuteScenario | UserName | Region |
      | TC_29834916    | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Terminal Debit card Verify
    Given User execute testcases Id "<TC_Mul_DE53941>" for testcasename 'DE53941' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding EBT card to Terminal and Verify Error

    Examples: 
      | TC_Mul_DE53941 | ExecuteScenario | UserName | Region |
      | TC_29836744    | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53110>" for testcasename 'DE53110' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant

    Examples: 
      | TC_Mul_DE53110 | ExecuteScenario | UserName | Region |
      | TC_29835027    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53659>" for testcasename 'DE53659' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant

    Examples: 
      | TC_Mul_DE53659 | ExecuteScenario | UserName | Region |
      | TC_29835029    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53042>" for testcasename 'DE53042' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant

    Examples: 
      | TC_Mul_DE53042 | ExecuteScenario | UserName | Region |
      | TC_29835957    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53089>" for testcasename 'DE53089' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal

    Examples: 
      | TC_Mul_DE53089 | ExecuteScenario | UserName | Region |
      | TC_29835991    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53851>" for testcasename 'DE53851' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    And User searching for Existing Merchant
    And User Deleting  Card types to Open  Merchant

    Examples: 
      | TC_Mul_DE53851 | ExecuteScenario | UserName | Region |
      | TC_29835055    | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53938>" for testcasename 'DE53938' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    And User searching for Existing Merchant
    And User clicking update terminal  to Merchantcards
    When User navigates to Add Terminal Page
    And User Search By TerminalID
    When User verify EBT card in terminal page
    And User searching for Existing Merchant
    And User Deleting  Card types to Open  Merchant

    Examples: 
      | TC_Mul_DE53938 | ExecuteScenario | UserName | Region |
      | TC_29836714    | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53929>" for testcasename 'DE53929' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    And User Clicking Back To Terminal
    And User move terminal to deactivate state
    And User searching for the  Merchant by gettext
    And User move Merchant to deactivate state and open
    And User Deleting  Card types to Open  Merchant

    Examples: 
      | TC_Mul_DE53929 | ExecuteScenario | UserName | Region |
      | TC_29836699    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53801>" for testcasename 'DE53801' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant

    Examples: 
      | TC_Mul_DE53801 | ExecuteScenario | UserName | Region |
      | TC_29836255    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53044>" for testcasename 'DE53044' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User Deleting Card type to Open  Merchant without error

    Examples: 
      | TC_Mul_DE53044 | ExecuteScenario | UserName | Region |
      | TC_29835966    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53840>" for testcasename 'DE53840' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant for Canada

    Examples: 
      | TC_Mul_DE53840 | ExecuteScenario | UserName | Region |
      | TC_29836516    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53091>" for testcasename 'DE53091' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Merchant Page
    And User Enters parent customer
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User verify alert message for merchant SE number

    Examples: 
      | TC_Mul_DE53091 | ExecuteScenario | UserName | Region |
      | TC_29836029    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53766>" for testcasename 'DE53766' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant for Canada
    And User click Back to Merchant link
    And User Deleting Card type to Open  Merchant without error

    Examples: 
      | TC_Mul_DE53766 | ExecuteScenario | UserName | Region |
      | TC_29836355    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53248>" for testcasename 'DE53248' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
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
    And User Deleting Card type to Open  Merchant without error

    Examples: 
      | TC_Mul_DE53248 | ExecuteScenario | UserName | Region |
      | TC_29836216    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53232>" for testcasename 'DE53232' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    And User verify Transaction Switch listvalue

    Examples: 
      | TC_Mul_DE53232 | ExecuteScenario | UserName | Region |
      | TC_29836188    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53223>" for testcasename 'DE53223' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant

    Examples: 
      | TC_Mul_DE53223 | ExecuteScenario | UserName | Region |
      | TC_29836142    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53222>" for testcasename 'DE53222' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal with errror

    Examples: 
      | TC_Mul_DE53222 | ExecuteScenario | UserName | Region |
      | TC_29836125    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53182>" for testcasename 'DE53182' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    And User searching for Existing Merchant
    And User Deleting Card type to Open  Merchant without error
    And User click Back to Merchant link
    And User Adding Card types to Merchant

    Examples: 
      | TC_Mul_DE53182 | ExecuteScenario | UserName | Region |
      | TC_29836105    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53138>" for testcasename 'DE53138' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User verify SE number for Visa and Mastercard

    Examples: 
      | TC_Mul_DE53138 | ExecuteScenario | UserName | Region |
      | TC_29836092    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53873>" for testcasename 'DE53873' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    And User Clicking Back To Terminal
    Then User Change the terminal Status
    Then User verify Disabled EDCIndicator for AuthOnly

    Examples: 
      | TC_Mul_DE53873 | ExecuteScenario | UserName | Region |
      | TC_29835041    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53038>" for testcasename 'DE53038' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    And User searching for Existing Merchant
    And User navigates to Adding Card types to Merchant
    And User validates Merchant cards page

    Examples: 
      | TC_Mul_DE53038 | ExecuteScenario | UserName | Region |
      | TC_29835940    | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53094>" for testcasename 'DE53094' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    Then User validates Merchant cards for canada

    Examples: 
      | TC_Mul_DE53094 | ExecuteScenario | UserName | Region |
      | TC_29836056    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53448>" for testcasename 'DE53448' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    And User Clicking Back To Terminal
    Then User Change the terminal Status
    Then User verify deleting two cards for terminalpage
    Then User verify deleting full cards for terminalpage

    Examples: 
      | TC_Mul_DE53448 | ExecuteScenario | UserName | Region |
      | TC_29836245    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53764>" for testcasename 'DE53764' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    Then User clicks checkall and uncheck cardtypes in merchantpage

    Examples: 
      | TC_Mul_DE53764 | ExecuteScenario | UserName | Region |
      | TC_29836343    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53781>" for testcasename 'DE53781' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    Then User verify jcb added to terminal page

    Examples: 
      | TC_Mul_DE53781 | ExecuteScenario | UserName | Region |
      | TC_29836359    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53940>" for testcasename 'DE53940' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    And User searching for Existing Merchant
    And User clicking update terminal  to Merchantcards without error
    And User click Back to Merchant link
    Then User verify AuditDetails in Merchantpage
    And User clicking uncheckbox  to Merchantcards without error

    Examples: 
      | TC_Mul_DE53940 | ExecuteScenario | UserName | Region |
      | TC_29836721    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53930>" for testcasename 'DE53930' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Terminal Page
    And User Enter Merchant Id
    Then User verify Undefined MCC in terminalPage

    Examples: 
      | TC_Mul_DE53930 | ExecuteScenario | UserName | Region |
      | TC_29836703    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53885>" for testcasename 'DE53885' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    Then User verify SE numbers for merchant page

    Examples: 
      | TC_Mul_DE53885 | ExecuteScenario | UserName | Region |
      | TC_29836688    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53539>" for testcasename 'DE53539' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    Then User verify SE numbers for merchant page
    And User searching for Existing Merchant
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    And User clicking uncheckbox  to Merchantcards without error

    Examples: 
      | TC_Mul_DE53539 | ExecuteScenario | UserName | Region |
      | TC_29836298    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53833>" for testcasename 'DE53833' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    Then User Edit Country Code in MerchantPage
    And User navigates to Adding Card types to Merchant
    Then User verify SE numbers for merchant page

    Examples: 
      | TC_Mul_DE53833 | ExecuteScenario | UserName | Region |
      | TC_29835050    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53113>" for testcasename 'DE53113' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal
    And User Clicking Back To Terminal
    Then User Change the terminal Status
    And User Verify EDC indicator to Terminal
    And User Change EDC Indicator to Terminal

    Examples: 
      | TC_Mul_DE53113 | ExecuteScenario | UserName | Region |
      | TC_29836078    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53464>" for testcasename 'DE53464' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    And User Navigates to child customernumber
    And User Creating Child Customer and verify LOB

    Examples: 
      | TC_Mul_DE53464 | ExecuteScenario | UserName | Region |
      | TC_29836292    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53878>" for testcasename 'DE53878' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    And User click Back to Merchant link

    Examples: 
      | TC_Mul_DE53878 | ExecuteScenario | UserName | Region |
      | TC_29836527    | Yes             | qatest10 | AP     |


  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53932>" for testcasename 'DE53932' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    When User navigates to Add Merchant Page
    And User Enters parent customer Dynamically
    And User Creates unique Merchant ID
    And User fill overview details of Merchant
    And User fill Address details of Merchant
    And User filling Manditory Business Details to Merchant
    And User click Save to create Pending Merchant
    And User Change Merchant Status
    And User Adding Card types to Merchant
    And User click Back to Merchant link
    When User navigates to Add Terminal Page
    And User Enters  Merchant number Dynamically
    When User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Save the Terminal
    And User Adding Card types to Terminal with errror

    Examples: 
      | TC_Mul_DE53932 | ExecuteScenario | UserName | Region |
      | TC_29836707    | Yes             | qatest10 | AP     |

  Scenario Outline: GSAP_CMF Merchant cards SE Number Verify
    Given User execute testcases Id "<TC_Mul_DE53736>" for testcasename 'DE53736' and module 'TestCases->Subject->CMF->2019 Test Cases->19.2 Test Cases->Defects_BCR251>' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    And User searching for Existing Merchant
    And User clicking update terminal  to Merchant already existing cards without error
    And User Verifying cardtypes for different Terminal
    Examples: 
      | TC_Mul_DE53736 | ExecuteScenario | UserName | Region |
      | TC_29836300    | Yes             | qatest10 | US     |
      
      
      
   
      
      
      
