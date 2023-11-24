# Pathology Lab Management Test

This project contains automated tests for a Pathology Lab Management system using Selenium WebDriver and TestNG, developed in IntelliJ IDEA.

# Prerequisites

- Clone the repository:
  git clone https://github.com/pathaksakshi/kennect.git
  cd kennect
  
- Java installed on your machine
- Maven installed on your machine
- IntelliJ IDEA installed

# Dependencies

This project uses the following dependencies:

- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) for managing WebDriver binaries.
- [TestNG](https://testng.org/) for test execution and reporting.

To install the dependencies, you can use IntelliJ IDEA's built-in Maven support:

1. Open the project in IntelliJ IDEA.
2. Right-click on the `pom.xml` file.
3. Select "Add as Maven Project" to import the dependencies.

# Running the Tests in IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Navigate to the `PathologyLabManagementTest` class.
3. Right-click on the class name.
4. Select "Run 'PathologyLabManagementTest'" to execute the tests.

## Test Description

The main test (`PathologyLabManagementTest`) performs the following actions:

1. Navigates to the login page.
2. Logs in with valid credentials.
3. Navigates to the "Patients" section and adds a new patient with general details.
4. Enters additional health-related details for the patient.
5. Adds tests for the patient, selects recommended labs, and provides additional information.
6. Scrolls to the end of the page.
7. Clicks on the "Add" button to save the information.


# Additional Notes

- The `loadingWait` method is used for waiting until the loading spinner disappears.
- The `scrolls` method is used to scroll to the end of the page.

**Note:** Ensure that you have the appropriate WebDriver executable for your browser (in this case, ChromeDriver) compatible with your browser version.

