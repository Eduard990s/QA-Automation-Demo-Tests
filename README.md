Testing Demo Web Site UI/API

This project performs automated front-end (UI) and API testing on the demo Pragmatic website, available at https://auto.pragmatic.bg/index.php?route=common/home&language=en-gb
. The tests focus on common functionalities such as login, product search, error message validation, and other typical user interactions.

Technologies Used

Java as the programming language

JUnit 5 as the testing framework

Selenium WebDriver for browser automation

Rest-Assured for API testing

Maven for dependency management and test execution

Allure for generating and visualizing interactive test reports

IntelliJ IDEA Community Edition for development

Project Structure

The project uses the Page Object Model (POM) design pattern, which separates the page interaction logic from the test logic. This improves code maintainability and readability by organizing classes to represent web pages and encapsulate actions and verifications on those pages.

Main Packages

Pages → page classes containing locators and methods for UI interaction

TestPositive → positive UI tests, e.g., successful login

TestNegative → negative UI tests, e.g., login with invalid credentials

TestApi → API tests, e.g., POST requests to create a user

Note on API Tests: The API tests simulate user creation via POST requests. The demo website does not actually create users, but these tests are designed to verify API communication. To test this functionality, you may need to modify the data in the request body.

Allure Reporting

Allure is used to generate detailed test reports. Screenshots are captured at key points during UI tests, especially for failed or critical steps, and attached to the report. Each test step, severity, story, and description is documented via Allure annotations.

Currently, not all test classes are fully integrated with Allure. At the moment, Allure reporting is applied for:

Negative login test in TestNegative

All API tests in TestApi

In the future, more tests will be integrated with Allure, including screenshots where necessary for better traceability.

Future Development: This project will soon also be implemented in TypeScript using Playwright, taking advantage of TypeScript’s type safety and Playwright’s modern end-to-end testing features.

Running Tests
Prerequisites

Installed JDK (version 8 or higher recommended)

Maven installed and configured in your system PATH

IntelliJ IDEA Community Edition

Compatible browser driver (e.g., Chromedriver)

Executing Tests

Run the test suite using Maven:

mvn test


This command executes all automated tests (UI and API).

Generate and view Allure report in HTML:

mvn allure:serve


This will create a fully interactive HTML report in your browser, showing:

Test suites and individual tests

Test status: passed, failed, broken

Step-by-step execution annotated with Allure (@Story, @Description, @Severity)

Attached screenshots (for tests that have them)

The HTML report makes it easier to review test results in a single page, with detailed context for each test and step.

Author

Project developed by Eduard Vasilev.
