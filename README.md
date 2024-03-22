## Shopping UI Automation Project | Aditi Narlawar

This project is designed for automating tests for the Shopping website's user interface (UI). It utilizes Selenium
WebDriver and TestNG for test automation.

## What does this repository contain?

This project contains configurations and dependencies for automating tests for a shopping website's user interface. It includes the following features and components:

- **`Java`:** Java programming language is used for writing test code.
- `Selenium WebDriver`: Selenium WebDriver is used for automating interactions with the UI elements.
- `TestNG`: TestNG is used for organizing and executing test cases using the TestNG testing framework.
- `TestNG Listeners`: Events in the test execution are captured using TestNG Listeners.
- `Maven`: Maven is used as a build management tool.
- `Extent Report`: Extent Report is used for comprehensive test reporting.

### Run Test

- Using command: `mvn clean test`

## Test Cases

### SubmitOrderTest

- `submitOrder`: This test case logs in to the application, adds a product to the cart, checks out the product, and
  verifies the confirmation message.
- `orderHistoryPage`: This test case verifies the display of the order history page.

### ErrorValidation

- `loginPageErrorValidation`: This test case validates error handling on the login page.
- `productErrorValidation`: This test case validates error handling on the product page.

## Prerequisites

- Java Development Kit (JDK)
- Selenium
- TestNG
- Maven
- WebDriver executable (e.g., chromedriver.exe)
- IDE (e.g., IntelliJ IDEA)

## Setup Instructions

1. Clone the project repository.
2. Open the project in your preferred IDE.
3. Configure the project dependencies and WebDriver executable.
4. Locate the any of the `.xml file` in the project structure.
   Right-click on the `.xml file`.
   Select run option to run the TestNG suite.

## Author

[Aditi Narlawar]