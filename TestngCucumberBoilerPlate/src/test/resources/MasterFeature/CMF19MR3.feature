Feature: Execution of CMF19MR3 scripts

  Background: 
    Given : User loads the "CMF19MR3" json file

  Scenario Outline: GSAP_CMF US159260_Terminal UI Time Zone BCR302
    Given User execute testcases Id "<TC_Mul_TermTimeZone>" for testcasename 'CMF_Terminal Timezone_Select_Australian Western (GMT +08 00, No DST)' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US159260_Terminal UI Time Zone BCR302' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    When User create Open Merchant with Parent Cust1
    When User Create Open Terminal
    Then User Validating Terminal CMF Database Region "<Region>"
    Then User Validating Terminal G2 Database Region "<Region>"

    Examples: 
      | TC_Mul_TermTimeZone | ExecuteScenario | UserName | Region |
      | TC_29378647         | Yes             | qatest10 | AP     |
      | TC_29418958         | Yes             | qatest10 | US     |
      | TC_29378654         | Yes             | qatest10 | AP     |
      | TC_29418959         | Yes             | qatest10 | US     |
      | TC_29378657         | Yes             | qatest10 | AP     |
      | TC_29418960         | Yes             | qatest10 | US     |
      | TC_29378663         | Yes             | qatest10 | AP     |
      | TC_29418961         | Yes             | qatest10 | US     |
      | TC_29378702         | Yes             | qatest10 | AP     |
      | TC_29418962         | Yes             | qatest10 | US     |
      | TC_29378704         | Yes             | qatest10 | AP     |
      | TC_29418963         | Yes             | qatest10 | US     |
      | TC_29378705         | Yes             | qatest10 | AP     |
      | TC_29418964         | Yes             | qatest10 | US     |
      | TC_29393061         | Yes             | qatest10 | AP     |
      | TC_29418965         | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US159260_Terminal UI Time Zone BCR302
    Given User execute testcases Id "<TC_Mul_TermTimeZoneValidations>" for testcasename 'CMF_Validate if Terminal time zone is required' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US159260_Terminal UI Time Zone BCR302' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    When User create Open Merchant with Parent Cust1
    When User navigates to Add Terminal Page
    And User Enter Merchant Id Dynamically
    And User Creating unique TerminalID
    And User Enters All Details
    And User Enters Terminal Details for MerchantInitiated
    And User Check merchant Adress for Terminal
    And User Enters Refund and Purchase Details
    And User Save the Terminal
    And User Adding Card types to Terminal
    And User Clicking Back To Terminal
    And User validate the terminal to Validate TimeZone Req Error

    Examples: 
      | TC_Mul_TermTimeZoneValidations | ExecuteScenario | UserName | Region |
      | TC_29393138                    | Yes             | qatest10 | AP     |
      | TC_29418967                    | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US159260_Terminal UI Time Zone BCR302
    Given User execute testcases Id "<TC_Mul_TermTimeZoneDefault>" for testcasename 'CMF_Validate default value for Terminal time zone field' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US159260_Terminal UI Time Zone BCR302' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer1
    When User create Open Merchant with Parent Cust1
    When User navigates to Add Terminal Page
    Then User validate Terminal TimeZone Default Value

    Examples: 
      | TC_Mul_TermTimeZoneDefault | ExecuteScenario | UserName | Region |
      | TC_29393130                | Yes             | qatest10 | AP     |
      | TC_29418966                | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US159260_Terminal UI Time Zone BCR302
    Given User execute testcases Id "<TC_Mul_TermTimeZoneNewValues>" for testcasename 'CMF_Validate default value for Terminal time zone field' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US159260_Terminal UI Time Zone BCR302' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User navigates to Add Terminal Page
    Then User validate Terminal TimeZone All New Values

    Examples: 
      | TC_Mul_TermTimeZoneNewValues | ExecuteScenario | UserName | Region |
      | TC_29378360                  | Yes             | qatest10 | AP     |
      | TC_29418957                  | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US149660_Group - Risk Management BCR280
    Given User execute testcases Id "<TC_Mul_MerchRiskManagement>" for testcasename 'CMF_Risk Management field should not be present on Merchant management screen' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US149660_Group - Risk Management BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Merchant to Validate Risk Management Not present

    Examples: 
      | TC_Mul_MerchRiskManagement | ExecuteScenario | UserName | Region |
      | TC_29377693                | Yes             | qatest10 | AP     |
      | TC_29378267                | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US149660_Group - Risk Management BCR280
    Given User execute testcases Id "<TC_Mul_TermRiskManagement>" for testcasename 'CMF_Risk Management field should not be present on Terminal management screen' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US149660_Group - Risk Management BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Terminal to Validate Risk Management Not present

    Examples: 
      | TC_Mul_TermRiskManagement | ExecuteScenario | UserName | Region |
      | TC_29377992               | Yes             | qatest10 | AP     |
      | TC_29378266               | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US158348-Customer - Line of Business - Canadian Child Customers - CR357
    Given User execute testcases Id "<TC_Mul_CanadianCustLob>" for testcasename 'CMF_Canada_LOB_Child customer_parent customer_by default' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US158348-Customer - Line of Business - Canadian Child Customers - CR357->CMF_Canada_Child customer_parent customer(Non canada)_LOB_from Immediate parent customer' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    Then User Validating Customer CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"
    Then User Click on Add Child Customer link and Verify LOB

    Examples: 
      | TC_Mul_CanadianCustLob | ExecuteScenario | UserName | Region |
      | TC_29376801            | Yes             | qatest10 | US     |
      | TC_29620433            | Yes             | qatest10 | US     |
      | TC_29620456            | Yes             | qatest10 | US     |
      | TC_29620627            | Yes             | qatest10 | US     |
      | TC_29620891            | Yes             | qatest10 | US     |
      | TC_29620896            | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US158348-Customer - Line of Business - Canadian Child Customers - CR357
    Given User execute testcases Id "<TC_Mul_MulChildCust>" for testcasename 'CMF_Canada_LOB_Child customer_parent customer_by default' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US158348-Customer - Line of Business - Canadian Child Customers - CR357->CMF_Canada_Child customer_parent customer(Non canada)_LOB_from Immediate parent customer' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    Then User Validating Customer CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"
    Then User Click on Add Child Customer link and Verify LOB
    And User Creating unique Customer Number
    And User click on Save button to create Pending Customer
    And User Searching Customer Dynamically
    Then User Click on Add Child Customer link and Verify LOB

    Examples: 
      | TC_Mul_CanadianCustLob | ExecuteScenario | UserName | Region |
      | TC_29620444            | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US158348-Customer - Line of Business - Canadian Child Customers - CR357
    Given User execute testcases Id "<TC_Mul_CanadianProcessor>" for testcasename 'CMF_Canada_LOB_Child customer_parent customer_by default' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US158348-Customer - Line of Business - Canadian Child Customers - CR357->CMF_Canada_Child customer_parent customer(Non canada)_LOB_from Immediate parent customer' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    When User create Open Customer
    Then User Validating Customer CMF Database Region "<Region>"
    Then User Validating Customer G2 Database Region "<Region>"
    Then User Click on Add Child Customer link and Verify Processor

    Examples: 
      | TC_Mul_CanadianProcessor | ExecuteScenario | UserName | Region |
      | TC_29378292              | Yes             | qatest10 | US     |
      | TC_29621008              | Yes             | qatest10 | US     |
      | TC_29621245              | Yes             | qatest10 | US     |
      | TC_29622222              | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Merchant - Visa Merchant Type - BCR280
    Given User execute testcases Id "<TC_Mul_VisaMerchant>" for testcasename 'CMF_Merchant_support profile_Visa merchant type_sunset' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->Merchant - Visa Merchant Type - BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Merchant to Validate VISA MERCHANT Not present

    Examples: 
      | TC_Mul_VisaMerchant | ExecuteScenario | UserName | Region |
      | TC_29395747         | Yes             | qatest10 | AP     |
      | TC_29750834         | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US149743-Group - Welcome Kits BCR280
    Given User execute testcases Id "<TC_Mul_WelcomeKits>" for testcasename 'CMF_Merchant_support profile_welcome kits_sunset' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US149743-Group - Welcome Kits BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Merchant to Validate WELCOME KITS Not present

    Examples: 
      | TC_Mul_WelcomeKits | ExecuteScenario | UserName | Region |
      | TC_29394850        | Yes             | qatest10 | AP     |
      | TC_29751138        | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Group - Voice Center Number BCR280
    Given User execute testcases Id "<TC_Mul_VoiceCenter>" for testcasename 'CMF_Merchant_support profile_Voice center number_sunset' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->Group - Voice Center Number BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Merchant to Validate VOICE CENTER Not present

    Examples: 
      | TC_Mul_VoiceCenter | ExecuteScenario | UserName | Region |
      | TC_29395687        | Yes             | qatest10 | AP     |
      | TC_29751433        | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Group - Training BCR280
    Given User execute testcases Id "<TC_Mul_MerchTraining>" for testcasename 'CMF_Merchant_support profile_Voice center number_sunset' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->Group - Training BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Merchant to Validate TRAINING Not present

    Examples: 
      | TC_Mul_MerchTraining | ExecuteScenario | UserName | Region |
      | TC_29751472          | Yes             | qatest10 | AP     |
      | TC_29751626          | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF Group - Supplies BCR280
    Given User execute testcases Id "<TC_Mul_MerchSupplies>" for testcasename 'CMF_Merchant_support profile_Supplies_sunset' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->Group - Supplies BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Merchant to Validate SUPPLIES Not present

    Examples: 
      | TC_Mul_MerchSupplies | ExecuteScenario | UserName | Region |
      | TC_29751680          | Yes             | qatest10 | AP     |
      | TC_29751792          | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US149836_Group - Replacements BCR280
    Given User execute testcases Id "<TC_Mul_MerchReplacements>" for testcasename 'CMF_Replacements field should not be displayed on Merchant management screen.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US149836_Group - Replacements BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Merchant to Validate REPLACEMENTS Not present

    Examples: 
      | TC_Mul_MerchReplacements | ExecuteScenario | UserName | Region |
      | TC_29378294              | Yes             | qatest10 | AP     |
      | TC_29378340              | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US149836_Group - Replacements BCR280
    Given User execute testcases Id "<TC_Mul_TermReplacement>" for testcasename 'CMF_Replacements field should not be displayed on Terminal management screen.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US149836_Group - Replacements BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Terminal to Validate REPLACEMENTS Not present

    Examples: 
      | TC_Mul_TermReplacement | ExecuteScenario | UserName | Region |
      | TC_29378322            | Yes             | qatest10 | AP     |
      | TC_29378339            | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US149618_Terminal Display Only Fields from Customer BCR280
    Given User execute testcases Id "<TC_Mul_TermDebitReversal>" for testcasename 'CMF_Debit System Reversal Handling field should not be displayed under debit section on the Terminal UI.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US149618_Terminal Display Only Fields from Customer BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Terminal to Validate DEBIT REVERSAL Not present

    Examples: 
      | TC_Mul_TermDebitReversal | ExecuteScenario | UserName | Region |
      | TC_29423056              | Yes             | qatest10 | AP     |
      | TC_29620974              | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US149618_Terminal Display Only Fields from Customer BCR280
    Given User execute testcases Id "<TC_Mul_TermAllRemove>" for testcasename 'CMF_Fields should not be displayed on terminal UI under support profile section.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US149618_Terminal Display Only Fields from Customer BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Terminal to Validate ALL REMOVED fields Not present

    Examples: 
      | TC_Mul_TermAllRemove | ExecuteScenario | UserName | Region |
      | TC_29423065          | Yes             | qatest10 | AP     |
      | TC_29620976          | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US149774_Group - Plate Orders BCR280
    Given User execute testcases Id "<TC_Mul_MerchPlateOrder>" for testcasename 'CMF_'Plate orders' field should not be displayed under support profile section on Merchant UI.' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US149774_Group - Plate Orders BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Merchant to Validate PLATE ORDER Not present

    Examples: 
      | TC_Mul_MerchPlateOrder | ExecuteScenario | UserName | Region |
      | TC_29423143            | Yes             | qatest10 | AP     |
      | TC_29621024            | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US149617_Merchant Display Only Fields from Customer BCR280
    Given User execute testcases Id "<TC_Mul_MerchAllRemove>" for testcasename 'CMF_Following fields should not be displayed on Merchant UI' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US149617_Merchant Display Only Fields from Customer BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Merchant to Validate ALL REMOVED fields Not present

    Examples: 
      | TC_Mul_MerchAllRemove | ExecuteScenario | UserName | Region |
      | TC_29423355           | Yes             | qatest10 | AP     |
      | TC_29621446           | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US149858_Group - Hardware Deployment BCR280
    Given User execute testcases Id "<TC_Mul_MerchHardWare>" for testcasename 'CMF_Following fields should not be displayed on Merchant UI' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US149858_Group - Hardware Deployment BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Merchant to Validate HARDWARE DEPLOYMENT Not present

    Examples: 
      | TC_Mul_MerchHardWare | ExecuteScenario | UserName | Region |
      | TC_29547969          | Yes             | qatest10 | AP     |
      | TC_29622680          | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US149826_Group - Full Help Desk Support BCR280
    Given User execute testcases Id "<TC_Mul_MerchHelpDesk>" for testcasename 'CMF_Following fields should not be displayed on Merchant UI' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US149826_Group - Full Help Desk Support BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Merchant to Validate HELPDESK SUPPOURT Not present

    Examples: 
      | TC_Mul_MerchHelpDesk | ExecuteScenario | UserName | Region |
      | TC_29547970          | Yes             | qatest10 | AP     |
      | TC_29623676          | Yes             | qatest10 | US     |

  Scenario Outline: GSAP_CMF US159173_Merchant - MasterCard Merchant Type - Business Racial or Ethnic Type - BCR280
    Given User execute testcases Id "<TC_Mul_MerchRacial>" for testcasename 'CMF_Racial or Ethnic Type field should not be displayed on Merchant UI' and module 'TestCases->Subject->CMF->2019 Test Cases->19.3 Test Cases->Functional Testing->US159173_Merchant - MasterCard Merchant Type - Business Racial or Ethnic Type - BCR280' Execute "<ExecuteScenario>"
    When Launch the Application and Login with the User "<UserName>" Region "<Region>"
    Then User search Open Merchant to Validate RACIAL/ETHENIC Not present

    Examples: 
      | TC_Mul_MerchRacial | ExecuteScenario | UserName | Region |
      | TC_29548001        | Yes             | qatest10 | AP     |
      | TC_29623934        | Yes             | qatest10 | US     |
