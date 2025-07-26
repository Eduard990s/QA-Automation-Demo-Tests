Testing Demo Web Site UI

This project performs automated front-end testing on the demo website [Pragmatic Auto](https://auto.pragmatic.bg/index.php?route=common/home&language=en-gb), focusing on common functionalities such as login, product search, error message validation, and other typical user interface interactions.
Technologies Used

    Java as the programming language

    TestNG as the testing framework

    Selenium WebDriver for browser automation

    Maven for dependency management and test execution

    Developed using IntelliJ IDEA Community Edition

Project Structure

The project follows the Page Object Model (POM) design pattern, which separates the page interaction logic from the test logic. This improves code maintainability and readability by organizing classes to represent web pages and encapsulate actions and verifications on those pages.
How to Set Up and Run
Prerequisites

    Installed JDK (version 8 or higher recommended)

    Maven installed and configured in your system PATH (optional if using IntelliJ)

    IntelliJ IDEA Community Edition (recommended for ease of use)

    Compatible browser driver (e.g., chromedriver) matching your browser version

Running Tests

    Using IntelliJ IDEA: Import the project as a Maven project and run tests directly from the TestNG panel.

    Using Terminal in Intellij IDEA: Navigate to the project root folder and run:

mvn clean test

or

mvn test

These commands will execute the automated test suite.
Author

Project developed by Eduard Vasilev.
