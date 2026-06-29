# Study Abroad Course Collector

Web app hosted at Humboldt University that collects study abroad course data from students via a web form. Submitted entries are appended to an Excel file used by the immigration office.

## Tech Stack

- **Java 17**, **Spring Boot 3.3**
- **Thymeleaf** (server-side templates)
- **Tailwind CSS** (CDN)
- **Apache POI** (Excel read/write)
- **Maven Wrapper** (no Maven installation required)

## Project Structure

```
src/main/
├── java/com/studyabroad/
│   ├── Main.java                          <- entry point (@SpringBootApplication)
│   ├── controller/
│   │   └── StudentFormController.java     <- handles form GET/POST requests
│   ├── model/
│   │   ├── Course.java                    <- parent class with shared course fields
│   │   └── AbroadCourse.java              <- extends Course, adds study abroad-specific fields
│   ├── business/
│   │   └── ExcelWriter.java               <- appends course data to the Excel workbook
│   └── db/
│       └── abroad_course_accounting_applications.xlsx
├── resources/
│   ├── static/
│   │   └── Huberlin-logo.svg
│   └── templates/
│       └── studentform.html               <- Thymeleaf form template with Tailwind CSS
└── docs/
    └── documentation.md
```

## Running Locally

```bash
./mvnw spring-boot:run
```

Open [http://localhost:8080/courses](http://localhost:8080/courses) in your browser. No Maven installation needed.

## How to Use

1. Navigate to `http://localhost:8080/courses` in your browser.
2. Fill in the course form fields:
   - **Universitat** -- name of the university abroad
   - **Stadt** -- city of the university
   - **Land** -- country
   - **Kurs-ID** -- numeric course identifier
   - **Kursname** -- full name of the course
   - **Erasmus-ID** -- optional Erasmus program ID
   - **ECTS** -- number of ECTS credits
   - **Kurs-URL** -- link to the course page
   - **Abschluss** -- degree program (e.g. Bachelor of Science)
3. Click **Kurs einreichen** to submit.
4. A green success banner confirms the entry was saved. If something goes wrong, a red error banner appears.

Each submission appends a new row to the Excel file at `src/main/java/com/studyabroad/db/abroad_course_accounting_applications.xlsx`.

## Application Flow

1. Student opens the form at `GET /courses`.
2. `StudentFormController` serves `studentform.html` with an empty `AbroadCourse` model attribute.
3. Student fills in course details and submits the form (`POST /courses`).
4. `StudentFormController` maps the form data to an `AbroadCourse` object and passes it to `ExcelWriter`.
5. `ExcelWriter.writeAbroadCourse()` opens the existing workbook, finds the last row, appends a new row with the course fields in column order (0-8), and writes back to the same file.
6. The student is redirected back to `/courses` with a success or error query parameter.

## Key Classes

### `Course` (`model/Course.java`)
Parent class holding the standard course fields shared by any course type: `courseName`, `ects`, `courseId`, `courseURL`, `diplom`.

### `AbroadCourse` (`model/AbroadCourse.java`)
Extends `Course`. Adds the study abroad-specific fields: `university`, `city`, `country`, `erasmusID`, `hasErasmusId`.

### `StudentFormController` (`controller/StudentFormController.java`)
Handles `GET /courses` (serves the form) and `POST /courses` (passes the submitted object to `ExcelWriter`). Redirects with `?success=true` or `?error=true` query parameters.

### `ExcelWriter` (`business/ExcelWriter.java`)
Opens the existing workbook, finds the last row, appends a new row with the course fields in column order (0-8), then writes back to the same file. `writeAbroadCourse` is `synchronized` to handle concurrent submissions safely.

## Excel File

Located at `src/main/java/com/studyabroad/db/abroad_course_accounting_applications.xlsx`.

The file is opened and appended to on every submission -- it is never recreated. This allows the immigration office to edit the file manually without losing their changes.

> **TODO:** Move the file path to `application.properties` before deployment so it can be configured per environment without touching the source code.

## Design Decisions

- **Spring Boot + Thymeleaf** chosen as the simplest full-stack setup for a form-based web app.
- **Apache POI** used for Excel I/O to give contributors a broad range of customizable possibilities (cell styles, formulas, etc.).
- The controller never writes to Excel directly -- it only hands off the finished `AbroadCourse` object to `ExcelWriter`, keeping concerns separated.
