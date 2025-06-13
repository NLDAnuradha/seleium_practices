# My First Selenium WebDriver Project 🔧

Welcome to my first Selenium automation testing project! This project represents my initial journey into web automation testing using Selenium WebDriver as a complete beginner.

> **Note**: This project was migrated to this new GitHub account due to losing access to my previous account credentials. The original development work was completed as part of my learning journey with Selenium.

## 📚 About This Project

This project was created while learning Selenium WebDriver through a comprehensive YouTube tutorial series. It demonstrates fundamental Selenium concepts and web automation techniques that I've mastered during my learning journey from scratch.

## 🎯 Learning Objectives Achieved

Through this project, I've learned and implemented:

- ✅ Setting up Selenium WebDriver environment
- ✅ Configuring browser drivers (ChromeDriver)
- ✅ Writing basic automation scripts
- ✅ Understanding WebDriver API and methods
- ✅ Locating web elements using various strategies
- ✅ Performing user interactions (clicks, typing, scrolling)
- ✅ Handling different types of web elements
- ✅ Working with forms, dropdowns, and checkboxes
- ✅ Managing browser windows and tabs
- ✅ Implementing waits (implicit and explicit)
- ✅ Taking screenshots and handling alerts
- ✅ Understanding Selenium best practices

## 🛠️ Technologies Used

- **Selenium WebDriver** - Web Automation Framework
- **Java** - Programming Language
- **Maven** - Build Tool & Dependency Management
- **TestNG/JUnit** - Testing Framework
- **ChromeDriver** - Browser Drivers


## 🧪 Test Cases Covered

### Basic WebDriver Operations
- Browser launch and navigation
- Page title and URL verification
- Browser window management
- Taking screenshots

### Element Interaction Tests
- Finding elements by different locators
- Clicking buttons and links
- Text input and clearing fields
- Handling checkboxes and radio buttons

### Form Handling
- Filling out web forms
- Dropdown selection (Select class)
- File upload functionality
- Form submission validation

### Advanced Scenarios
- Handling JavaScript alerts
- Working with multiple windows/tabs
- Mouse hover actions
- Keyboard actions and shortcuts
- Scrolling and page navigation

### Wait Strategies
- Implicit waits implementation
- Explicit waits with WebDriverWait
- Fluent wait examples
- Custom wait conditions

## 📝 Key Selenium Concepts Learned

### WebDriver Initialization
```java
WebDriver driver = new ChromeDriver();
WebDriver driver = new FirefoxDriver();
```

### Element Locators
```java
// By ID
driver.findElement(By.id("element-id"));

// By Name
driver.findElement(By.name("element-name"));

// By Class Name
driver.findElement(By.className("class-name"));

// By XPath
driver.findElement(By.xpath("//div[@class='example']"));

// By CSS Selector
driver.findElement(By.cssSelector(".class-name"));
```

### Common WebDriver Methods
```java
// Navigation
driver.get("https://example.com");
driver.navigate().back();
driver.navigate().forward();
driver.navigate().refresh();

// Element Interactions
element.click();
element.sendKeys("text");
element.clear();
element.getText();
element.getAttribute("attribute");

// Waits
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.elementToBeClickable(By.id("element")));
```

## 🎓 What I Learned

As a beginner, this project taught me:

1. **WebDriver Architecture**: Understanding how Selenium communicates with browsers
2. **Element Location**: Mastering different locator strategies and their use cases
3. **Synchronization**: Implementing proper wait strategies for stable tests
4. **Browser Management**: Handling multiple browsers and browser configurations
5. **Test Organization**: Structuring automation projects for maintainability
6. **Debugging**: Troubleshooting common Selenium issues and errors
7. **Best Practices**: Writing reliable and maintainable automation code

## 🔧 Configuration Management

### Browser Configuration
```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--headless");
options.addArguments("--no-sandbox");
WebDriver driver = new ChromeDriver(options);
```

### TestNG Configuration (testng.xml)
```java
xml<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="SeleniumTestSuite">
    <test name="BasicTests">
        <classes>
            <class name="BasicWebDriverTests"/>
        </classes>
    </test>
</suite>
```

📊 Test Reporting

TestNG HTML reports
Screenshots on test failures
Detailed logs for debugging
Cross-browser test results

🚀 Future Improvements
Plans for enhancing this project:

 Implement Page Object Model (POM) pattern
 Add data-driven testing with Excel/CSV
 Integrate with TestNG for better reporting
 Add parallel test execution
 Implement custom utility methods
 Add API testing integration
 Set up CI/CD pipeline integration
 Add cross-browser testing grid setup


🌐 Cross-Browser Testing
This project supports testing across multiple browsers:

Google Chrome
Mozilla Firefox
Microsoft Edge (with EdgeDriver)

📚 Resources Used

YouTube Tutorial Series: [Link to the tutorial series I followed](https://www.youtube.com/watch?v=xhVs-h1ik00&list=PLgbf4L0WvebciyGW9bKfMLr-TGUp_u6K5)

[Selenium Official Documentation](https://www.selenium.dev/documentation/webdriver/getting_started/)

[TestNG Documentation](https://testng.org/)

[Maven Repository](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)

🎉 Achievements

✅ Completed first Selenium WebDriver project as a beginner
✅ Successfully implemented basic to intermediate automation scenarios
✅ Gained hands-on experience with web automation testing
✅ Learned industry-standard automation practices
✅ Built foundation for advanced Selenium concepts

📈 Learning Path
This project served as my foundation before moving on to:

Advanced Selenium concepts
Framework development (like moving to Cypress)
API testing
Performance testing

👨‍💻 About Me
This represents my first major milestone in test automation. Starting with Selenium gave me a solid foundation in web automation principles, which I later built upon with other tools like Cypress.

📞 Contact - [Linkedin](https://www.linkedin.com/in/anuradha-liyanage-8b2578231/)

Feel free to reach out if you have any questions about this project or want to discuss Selenium automation testing!


This project was created as part of my journey to learn Selenium WebDriver automation testing. Each test case represents a new concept I mastered along the way, forming the foundation of my automation testing skills!
Migration Note: Originally developed on a different Local account, this project has been migrated here due to credential access issues with the previous account.
