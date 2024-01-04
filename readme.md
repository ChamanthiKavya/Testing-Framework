# Amazon Test Suite

This repository contains an automated test suite for testing key functionalities of the Amazon web application using Selenium WebDriver and TestNG.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Test Descriptions](#test-descriptions)
- [Usage](#usage)
- [Improvements and Future Work](#improvements-and-future-work)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before running the tests, ensure you have the following installed:

- Java
- Selenium WebDriver
- TestNG
- ChromeDriver (or other WebDriver based on your browser)

## Getting Started

1. Clone this repository:

    ```bash
    git clone https://github.com/ChamanthiKavya/Testing-Framework.git
   
    ```

2. Download ChromeDriver (or WebDriver for your preferred browser) and update the path in the `setUp` method of the `AmazonTestSuite` class.

3. Open the project in your preferred IDE.

4. Install dependencies using a build tool like Maven or Gradle.

## Test Descriptions

### 1. User Registration (`testUserRegistration`)

- Positive Scenario: Registers a new user and verifies the successful registration message.
- Negative Scenario: Attempts to register with an existing email and verifies the error message.

### 2. User Login (`testUserLogin`)

- Positive Scenario: Logs in with valid credentials and verifies the user greeting.
- Negative Scenario: Attempts to login with invalid credentials and verifies the error message.

### 3. Product Search and Filter (`testProductSearchAndFilter`)

- Positive Scenario: Searches for a product, applies price range filters, and verifies the displayed products.
- Negative Scenario: Searches for a non-existing product and verifies the absence of search results.

### 4. Add to Shopping Cart (`testAddToShoppingCart`)

- Positive Scenario: Searches for a product, adds it to the shopping cart, and verifies the cart count.
- Negative Scenario: Attempts to add a non-existing product to the cart and verifies the absence of the "Add to Cart" button.

### 5. Checkout Process (`testCheckoutProcess`)

- Positive Scenario: Adds a product to the cart and proceeds through the checkout steps, verifying successful navigation.
- Negative Scenario: Attempts to go to the checkout page without adding any product to the cart and verifies the empty cart message.

## Usage

Run the test suite by executing the `AmazonTestSuite` class.

## Improvements and Future Work

- Consider adding explicit waits for improved synchronization.
- Create reusable methods for common actions to reduce code duplication.
- Parameterize test data for increased flexibility.
- Implement a logging mechanism to capture information and potential issues during test execution.

## Contributing

Feel free to contribute by opening issues or submitting pull requests.


