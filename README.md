# SwivelTestAutomationAssignment

## Technologies Used
This project was created using Maven, Java 8 (or above) and Selenium 4.8.0<br />
Chrome version - 110.0 (Latest version)<br />
IDE - Eclipse(2022-03)

## **Special Instructions**
1) Build the project using maven `clean install` command before running the test.
2) Please note that the chrome drivers to be used with Windows and macOS for the given Chrome version is included in the /SwivelTestAutomationAssignment/drivers folders. Use chromedriver for macOS and chromedriver.exe for Windows. Update the needed value accordingly in /SwivelTestAutomationAssignment/src/test/resources/config.properties before executing the test.
3) Run Test.java class as a java application to run the automation.

## **Issues faced and workourounds applied**
1) Unit price element on the product view had different css ids based on the product selected. In this test only two types of ids used for the element is covered. Additional items can be added as needed in the future.


