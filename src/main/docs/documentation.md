# Study Abroad Course Collector — Documentation

## Purpose

Web form hosted at Humboldt University that collects study abroad course data from students. Submitted entries are appended to an Excel file used by the immigration office.

## Tech Stack

- **Java 17**, **Spring Boot 3.3**, **Thymeleaf**, **Tailwind CSS (CDN)**, **Apache POI**, **Maven**

## Application Flow

1. Student opens the form at `GET /courses`
2. Student fills in course details and submits
3. `StudentFormController` maps the form data to an `AbroadCourse` object
4. `ExcelWriter.writeAbroadCourse()` appends the entry as a new row to the Excel file

## Key Classes

### `AbroadCourse` (`model/AbroadCourse.java`)
Holds one course submission. Fields: `university`, `city`, `country`, `courseId`, `courseName`, `erasmusID`, `ects`, `courseURL`, `diplom`.

### `StudentFormController` (`controller/StudentFormController.java`)
Handles `GET /courses` (serves the form) and `POST /courses` (passes the submitted object to `ExcelWriter`).

### `ExcelWriter` (`business/ExcelWriter.java`)
Opens the existing workbook, finds the last row, appends a new row with the course fields in column order (0–8), then writes back to the same file. `writeAbroadCourse` is `synchronized` to handle concurrent submissions safely.

## Excel File

Located at `src/main/java/com/studyabroad/db/abroad_course_accounting_applications.xlsx`.

The file is opened and appended to on every submission — it is never recreated. This allows the immigration office to edit the file manually without losing their changes.

> **TODO:** Move the file path to `application.properties` before deployment so it can be configured per environment without touching the source code.

## Decisions made
- Use springboot and thymleaf set up as simplest frontend 
- Use Apache POI to give further contributors a broader range of customisable possibiliities

## Running Locally

```bash
./mvnw spring-boot:run
```

Open `http://localhost:8080/courses` in your browser.
