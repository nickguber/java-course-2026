# Java Course Group 1

Web app built with Spring Boot and Thymeleaf, styled with Tailwind CSS.

## Purpose
Collect information from students who studied abroad for one or multiple semesters via a web form hosted on the Humboldt University website.

## Tech Stack
- **Backend:** Java 17, Spring Boot 3.3
- **Templates:** Thymeleaf
- **Styling:** Tailwind CSS (CDN)
- **Build:** Maven Wrapper (no Maven installation required)

## Project Structure

```
src/main/
├── java/com/studyabroad/
│   ├── Main.java                          ← entry point (@SpringBootApplication)
│   ├── controller/
│   │   └── StudentFormController.java     ← handles form GET/POST requests
│   ├── model/
│   │   └── AbroadStudent.java             ← Java object holding one student's data
│   └── business/
│       └── ExcelWriter.java               ← receives student object, writes to Excel (V2)
└── resources/
    └── templates/
        └── studentform.html               ← Thymeleaf form template with Tailwind CSS
```

## Run Locally

```bash
./mvnw spring-boot:run
```

Then open [http://localhost:8080](http://localhost:8080) in your browser. No Maven installation needed.

## Application Flow

### V1
1. User opens the form in the browser
2. `StudentFormController` serves `studentform.html`
3. User fills in the fields and clicks Submit
4. Controller maps the form data to a new `AbroadStudent` object
5. Data is printed to the console for verification

### V2
Steps 1–4 stay identical. Step 5 changes:

5. `StudentFormController` passes the `AbroadStudent` object to `ExcelWriter`
6. `ExcelWriter` reads the object's fields and inserts them into an Excel file

The controller never writes to Excel directly — it only hands off the finished object.
