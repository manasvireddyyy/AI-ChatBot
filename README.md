# 🤖 Gold Fish AI ChatBot

A console-based AI chatbot built in Java that communicates with Google's Gemini API. The chatbot accepts user input, sends it to the Gemini AI model, receives a response in JSON format, parses it using Jackson, and displays the AI-generated reply in the console.

---

## 📌 Features

- 💬 Interactive console chatbot
- 🤖 AI-powered responses using Google Gemini API
- 🌐 HTTP communication using Java HttpClient
- 📦 JSON parsing using Jackson
- 🔐 Secure API key management using environment variables
- 🛠 Maven-based project structure

---

## 🛠 Tech Stack

- Java 21
- Maven
- Java HttpClient
- Jackson Databind
- Google Gemini API
- Git & GitHub

---

## 📚 Concepts Learned

### Java
- Scanner
- Strings
- Text Blocks (`"""`)
- Exception Handling
- Loops & Conditional Statements

### Networking
- URI
- HttpClient
- HttpRequest
- HttpResponse
- HTTP POST Requests

### REST APIs
- API Keys
- Request & Response
- Headers
- JSON Communication

### JSON Parsing
- ObjectMapper
- JsonNode
- Extracting nested JSON values

### Maven
- Dependency Management
- pom.xml
- Build Automation

### Git
- Git
- GitHub
- .gitignore
- Version Control

---

## 🚀 Development Phases

### Phase 1 – Console Chatbot
- Created a console-based chatbot
- Took user input using Scanner
- Used loops to keep the chatbot running
- Added exit condition using "bye"

---

### Phase 2 – API Integration
- Learned about REST APIs
- Connected Java application to Gemini API
- Created HttpClient
- Understood request-response communication

---

### Phase 3 – JSON Request Body
- Created JSON request body using Java Text Blocks
- Inserted user prompt dynamically using `formatted()`

---

### Phase 4 – HTTP Request
- Built HTTP POST request
- Added API endpoint
- Added request headers
- Attached JSON body

---

### Phase 5 – Sending Request
- Sent request using HttpClient
- Received JSON response
- Understood HTTP communication flow

---

### Phase 6 – JSON Parsing
- Added Jackson using Maven
- Parsed JSON using ObjectMapper
- Extracted AI response from nested JSON

---

## 🔄 Application Flow

```text
Start
   │
   ▼
Read User Input
   │
   ▼
Is input "bye"?
   │
 ┌─┴──────────────┐
 │                │
Yes              No
 │                │
 ▼                ▼
Exit        Create JSON Request
                  │
                  ▼
         Build HTTP Request
                  │
                  ▼
       Send Request to Gemini
                  │
                  ▼
        Receive JSON Response
                  │
                  ▼
     Parse Response using Jackson
                  │
                  ▼
         Display AI Response
                  │
                  ▼
              Repeat
```

---

## 📂 Project Structure

```
AI-ChatBot
│
├── pom.xml
├── README.md
├── .gitignore
└── src
    └── main
        └── java
            └── AIChatBot.java
```

---

## ⚠ Challenges Faced

### VS Code Java Language Server Issues
**Problem**
- Imports disappeared while typing.
- Java packages were not recognized.

**Solution**
- Reloaded VS Code window.
- Cleaned Java Language Server Workspace.
- Imported Maven project correctly.

---

### Jackson Imports Not Working

**Problem**
- `ObjectMapper` and `JsonNode` showed red errors.

**Cause**
- Maven dependencies were not loaded.

**Solution**
- Installed Maven.
- Added Jackson dependency to `pom.xml`.
- Imported Java project into VS Code.

---

### Maven Migration

**Problem**
- `java AIChatBot` stopped working.

**Reason**
- Maven uses the standard project structure.

**Solution**
- Moved source code to:

```
src/main/java/
```

- Compiled using:

```bash
mvn compile
```

- Ran using:

```bash
mvn exec:java
```

---

### GitHub Push Issues

**Problem**
- Push rejected because remote repository contained commits.

**Solution**
- Pulled remote changes and merged before pushing.

---

## 🔐 API Key Security

Initially, the API key was hardcoded inside the source code.

```java
private static final String API_KEY = "...";
```

This is insecure because anyone with access to the repository can use the key.

The project was updated to use an environment variable instead:

```java
private static final String API_KEY =
        System.getenv("GEMINI_API_KEY");
```

### Benefits

- API key is never uploaded to GitHub.
- Prevents unauthorized usage.
- Follows industry best practices.

---

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/manasvireddyyy/AI-ChatBot.git
```

### 2. Navigate into the project

```bash
cd AI-ChatBot
```

### 3. Set your Gemini API key

macOS/Linux

```bash
export GEMINI_API_KEY=YOUR_API_KEY
```

Windows

```cmd
set GEMINI_API_KEY=YOUR_API_KEY
```

### 4. Compile

```bash
mvn compile
```

### 5. Run

```bash
mvn exec:java
```

---

## 📸 Sample Output

<img width="786" height="294" alt="Screenshot 2026-06-30 at 7 44 37 PM" src="https://github.com/user-attachments/assets/60df03a5-cfb2-44dd-8080-a6fd297e4db6" />


---

## 🎯 Learning Outcome

This project helped me understand:

- Building AI-powered applications in Java
- REST API communication
- HTTP request/response lifecycle
- JSON parsing using Jackson
- Maven dependency management
- Secure handling of API keys
- Git and GitHub workflow
- Debugging Java and VS Code issues

---

## 👨‍💻 Author

**Manasvi Reddy**

Built as part of my Java learning journey, progressing from simple rule-based chatbots to AI-powered applications using the Google Gemini API.
