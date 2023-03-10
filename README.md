# Automated API tests for [Restful-booker](https://restful-booker.herokuapp.com/)
Restful-booker is a resource for testing API with [detailed API documentation.](https://restful-booker.herokuapp.com/apidoc/index.html)
Automated tests were developed as part of a training project using [Rest-Assured](https://rest-assured.io/).

## Tools and technologies
![This is an image](/media/Java.png)
![This is an image](/media/Gradle.png)
![This is an image](/media/Rest-Assured.png)
![This is an image](/media/Intelij_IDEA.png)
![This is an image](/media/Github.png)
![This is an image](/media/JUnit5.png)
![This is an image](/media/Jenkins.png)
![This is an image](/media/Allure_Report.png)
![This is an image](/media/AllureTestOps.png)
![This is an image](/media/Telegram.png)

## What's interesting?
* Models with [Lombok](https://projectlombok.org/)
* Request/response specifications
* Parametrized build
* Custom Allure listener for beautiful API requests/responses logging
* Allure TestOps integration
* Telegram notifications

## Test-cases
- [x] Successful/unsuccessful login
- [x] Create booking
- [x] Update booking
- [x] Delete booking

## How to run :running_woman:

Gradle command:
```gradle clean test```

[Ready build (Jenkins)](https://jenkins.autotests.cloud/job/C16-sw_tata-restful-booker/)

## Test results :bookmark_tabs:
[**Allure report:**](https://jenkins.autotests.cloud/job/C16-sw_tata-restful-booker/4/allure/)

![This is an image](/media/allurereport.png)

[**Allure TestOps**](https://allure.autotests.cloud/launch/20388/tree/286893?treeId=0) provides more oppotunities and information:

![This is an image](/media/testops.png)

Custom Allure listener does the formatting better. Opening request/response details:

![This is an image](/media/listener.png)

Getting telegram notifications after each build:

![This is an image](/media/telegrambot.png)
