# 🧪 WordPress Plugin Automation Testing (Flextable)

A robust automated testing framework designed for the **Flextable WordPress Plugin**. This project uses **Selenium WebDriver** and **TestNG** to validate table creation, data integrity, and UI responsiveness on a local WordPress environment.

## 📋 Prerequisites

Before running the project, ensure your environment is set up:

*   **OS:** Windows / Mac / Linux
*   **WordPress:** Latest version (Running via Local WP)
*   **Java:** JDK 17
*   **IDE:** IntelliJ IDEA
*   **Build Tool:** Gradle
*   **Browsers:** Chrome, Firefox

## ⚙️ Installation

**1. Clone the repository**

```
git clone https://github.com/mr-tanzim-ahmed/wordpress-plugin-automation-testing.git
```
2. Add Dependencies
   Ensure your build.gradle file includes the following:
```
   dependencies {
   implementation 'org.seleniumhq.selenium:selenium-java:4.25.0'
   testImplementation 'org.testng:testng:7.10.2'
   testImplementation 'com.aventstack:extentreports:5.1.2'
   testImplementation 'io.github.cdimascio:java-dotenv:5.2.2'
   }
```
## 2. Open the Project

1. Open **IntelliJ IDEA**.
2. Select **Open** and choose the cloned project folder.
3. Allow Gradle to sync and download dependencies.

---

## 🔑 Configuration

> Note: You can run tests using your own WordPress environment credentials.

**Option A (Properties):**  
Update the `src/test/resources/config.properties` file with your URL, username, and password.

**Option B (.env):**  
Create a `.env` file in the root directory to store sensitive credentials safely.

---

## 🚀 How to Run Tests

1. Navigate to the resources folder in the project view:  
   `src/test/resources/`
2. Locate the test suite file:  
   `regressionSuiteForFlexTablePluginWithReport.xml`
3. Right-click on the file and select **Run '...xml'**.

---

## 🔄 CI/CD

The automation suite is integrated with **GitHub Actions**. Here’s the workflow process:

1. **Trigger:** Runs automatically on push or pull requests to the `main` branch.
2. **Checkout Code:** Retrieves the latest code from the repository.
3. **Setup Environment:**
    - Installs **JDK 17**
    - Installs **Google Chrome** and **ChromeDriver**
    - Sets up **Gradle**
4. **Build Project:** Compiles the project using Gradle.
5. **Run Tests:** Executes the TestNG suite and generates **Extent Reports**.
6. **Serve Report (Optional):** Extent Reports can be served locally via a simple HTTP server for review.  
