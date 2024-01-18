**ORANGE HRM_UI_AUTOMATION_FRAMEWORK**

Writing and automating test cases for open source OrangeHRM HR Software.
UI Automation Framework is based on Page Object Model design pattern following Data-Driven Framework with Cucumber, using Java, Selenium, JUnit, Maven, Git, Extent Reports, Lo4j.

This is Maven project that implements a Page Object Model design pattern using Selenium WebDriver with JUnit testing tool, using Java programming language with JUnit assertions.

**FUNCTIONALITY**

The following flows were automated:
1. Test cases for Login Page
2. Test cases for Recruitment Page
3. Test cases for Time Reports Page

**TECHNOLOGIES USED**
- Selenium WebDriver
- JDK (Java Development Kit)
- JUnit (Test Unit Framework)
- Maven (Build tool)
- Apache POI (Read utilities for Excel)
- Lo4j (logging)
- Reports

**PAGE OBJECT MODEL**

Page Object Model, also known as POM, is a design pattern in Selenium that creates an object repository for storing all web elements. It is useful in reducing code duplication and improves test case maintenance.
In Page Object Model, consider each web page of an application as a class file. Each class file will contain only corresponding web page elements. Using these elements, user can perform operations on the website under test.

- Why I have chosen Page Object Model?
  - Code Maintainability: Helps in organizing the code in a way that makes it more readable and maintainable. Each page in your application has a corresponding page class in your test, which holds the page's functionalities and elements.
  - Code reusability: Elements and methods of page classes are reusable across different tests. Once you define a page object, you can use it in multiple test scripts, reducing code duplication.
  - 
