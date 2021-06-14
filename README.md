# Testing Amazon Website using Cucumber-Java and Selenium
---

## Requirement
* Java Development Kit
* Maven
* Chromedriver

## Running tests
* Open the project using any IDE (preferably Intellij IDEA) or move to project directory
* Use this command for running the test
    ```
    $ mvn clean install
    ```

## Test Report
* Test report automatically generated on `target` folder after finished the test execution
* Open `overview-features.html` file on your browser from `target/cucumber-reports/advanced-reports/cucumber-html-reports` folder
* If `cucumber.publish.enabled=true` in `cucumber.properties` file, you also can view the test report on the [cucumber report website](https://reports.cucumber.io) or see console message for the specific link
