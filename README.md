Testing Demo Web Site UI/API

This project performs automated front-end and API testing on the demo website https://auto.pragmatic.bg/index.php?route=common/home&language=en-gb, focusing on common functionalities such as login, product search, error message validation, and other typical user interface interactions.

Technologies Used

- Java as the programming language
- TestNG and JUnit 5 as testing frameworks
- Selenium WebDriver for browser automation
- Rest-Assured for API testing
- Maven for dependency management and test execution
- Developed using IntelliJ IDEA Community Edition

Project Structure

The project follows the Page Object Model (POM) design pattern, which separates the page interaction logic from the test logic. This improves code maintainability and readability by organizing classes to represent web pages and encapsulate actions and verifications on those pages.

Packages

- Pages → page classes with locators and methods for UI interaction
- TestPositive → positive UI tests (e.g., successful login)
- TestApi → API tests (e.g., POST requests to create a user)

Note on API Tests: The API tests simulate user creation via POST requests. The demo website does not actually create users, but these tests are designed to verify the API communication. To test this functionality, you may need to modify the data in the request body.

How to Set Up and Run

Prerequisites

- Installed JDK (version 8 or higher recommended)
- Maven installed and configured in your system PATH (optional if using IntelliJ)
- IntelliJ IDEA Community Edition (recommended for ease of use)
- Compatible browser driver (e.g., chromedriver) matching your browser version

Running Tests

Using IntelliJ IDEA:
Import the project as a Maven project and run tests directly from the TestNG or JUnit panel.

Using Terminal in IntelliJ IDEA:
Navigate to the project root folder and run:

mvn clean test

or

mvn test

These commands will execute the automated test suite (both UI and API tests).

Author

Project developed by Eduard Vasilev.
