<<<<<<< HEAD

# Rest Assured API Test Framework

A Java-based API automation framework using **Rest Assured** and **TestNG** to validate RESTful web services with clean, modular, and maintainable test code.

## 🚀 Features

- 🔹 REST API testing with **Rest Assured**
- 🔹 Test management using **TestNG**
- 🔹 JSON → POJO deserialization with **Jackson/Lombok**
- 🔹 Modular test structure (Base, Utilities, Test classes)
- 🔹 Status code, body, header, and response time validation
- 🔹 Easy-to-maintain test cases for CRUD operations

## 🧰 Tech Stack

| Tool            | Purpose                      |
|-----------------|------------------------------|
| Java            | Programming language         |
| Rest Assured    | API Testing framework        |
| TestNG          | Test execution engine        |
| Maven           | Build and dependency manager |
| Lombok          | Reduces boilerplate code     |
| Jackson         | JSON parsing & mapping       |

## 📁 Project Structure

```
rest-assured-api-test/
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── base/               # Base classes and config
│       │   ├── tests/              # Test classes
│       │   └── utils/              # Helper methods
│
├── testng.xml                      # TestNG test suite config
├── pom.xml                         # Maven dependencies
└── README.md
```

## ✅ Sample Test Case

```java
given()
    .baseUri(BASE_URL)
    .when()
    .get("/users/1")
    .then()
    .statusCode(200)
    .body("id", equalTo(1));
```

## 🛠️ Getting Started

### Prerequisites

- Java 11+
- Maven installed
- IDE (e.g., IntelliJ, Eclipse)

### Run Tests

```bash
mvn clean test
```

## 📌 Future Improvements

- Add data-driven tests using external JSON/CSV
- Integrate with Allure/Extent Reports
- Add CI support (e.g., GitHub Actions, Jenkins)
- OAuth2/Bearer token support for secured APIs

## 🤝 Contributing

Pull requests are welcome! If you'd like to contribute, fork the repo and submit a PR.

---

## 📬 Contact

**Deepak Salla**  
Email: your.email@example.com  
GitHub: [DeepakSalla](https://github.com/DeepakSalla)
=======
markdown
Copy
Edit
# 🧪 REST Assured API Test Framework

This project is a test automation framework built using **REST Assured**, **TestNG**, and **ExtentReports** to validate a sample REST API's functionality. It also includes **GitHub Actions** integration for continuous testing.

---

## 📌 Features

- ✅ REST API test automation using REST Assured
- ✅ Covers GET, POST, PUT, DELETE operations
- ✅ Positive and negative test case coverage
- ✅ Validates response status, body, and headers
- ✅ Integrated ExtentReports for detailed HTML reports
- ✅ Configuration-driven (Base URI, Test Data)
- ✅ CI/CD with GitHub Actions for test automation on every push

---

## 🔧 Tech Stack

| Tool             | Purpose                         |
|------------------|---------------------------------|
| Java             | Programming Language             |
| REST Assured     | API Testing Framework            |
| TestNG           | Testing Framework                |
| Maven            | Build & Dependency Management    |
| ExtentReports    | Test Reporting                   |
| GitHub Actions   | Continuous Integration/Testing   |
>>>>>>> 8823b3e99d2799eae383762bee85ce9ad4fcbe5a

---
