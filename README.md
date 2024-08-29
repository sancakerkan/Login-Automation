# Login-Test
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-25A162?style=for-the-badge&logo=testng&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This repository contains automated tests for a simple login interface using Selenium WebDriver and TestNG. The tests include verification of correct and incorrect login attempts across different browsers.

## Features

- **Cross-Browser Testing:** Tests run on both Chrome and Firefox.
- **Login Verification:** Ensures correct redirection on successful login and appropriate error handling on failure.
- **TestNG Factory:** Demonstrates the use of the @Factory annotation in TestNG to create test instances.

## Installation

### Prerequisites

- Java Development Kit (JDK) 8 or later
- Maven
- An IDE with Maven support (IntelliJ IDEA, Eclipse, etc.)

### Cloning the Repository

1. **Using IntelliJ IDEA:** 
    - Go to `File` > `New` > `Project from Version Control`.
    - Enter the repository URL: `https://github.com/yourusername/Login-Test.git`.
    - Click `Clone`.

2. **Using Eclipse:**
    - Go to `File` > `Import...`.
    - Select `Git` > `Projects from Git` > `Clone URI`.
    - Enter the repository URL: `https://github.com/yourusername/Login-Test.git`.
    - Follow the prompts to complete the cloning process.

3. **OR Simply Download the ZIP file**
    - [ZIP File](https://github.com/yourusername/Login-Test/archive/refs/heads/main.zip)

## Usage

### Running the Tests

1. **Using IntelliJ IDEA:**
    - Open the project.
    - Navigate to the `src/test/java/` directory.
    - Right-click the `LoginTestFactory` class.
    - Select `Run 'LoginTestFactory'`.

2. **Using Eclipse:**
    - Open the project.
    - Navigate to the `src/test/java/` directory.
    - Right-click the `LoginTestFactory` class.
    - Select `Run As` > `TestNG Test`.

### Test Structure

- `ChromeLoginTest`: Tests login functionality on Chrome.
- `FirefoxLoginTest`: Tests login functionality on Firefox.
- `LoginTestFactory`: Generates test instances for both Chrome and Firefox.

## Contributing

Contributions are welcome! If you have any suggestions or improvements, feel free to open an issue or submit a pull request.

1. Fork the repository
2. Create your feature branch 
3. Commit your changes 
4. Push to the branch 
5. Open a pull request

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
