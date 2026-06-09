# Java Course Group 1

GUI built in Swing, polished with FlatLaf for a modern look.

## Purpose
Collect information from students who studied abroad for one or multiple semesters.

## Project Structure

```
src/com/studyabroad/
├── Main.java              ← entry point, launches the GUI
├── gui/
│   └── StudentForm.java   ← collects input, builds the student object, triggers output
├── model/
│   └── AbroadStudent.java ← plain Java object holding one student's data
└── business/
    └── ExcelWriter.java   ← receives the student object and writes it to Excel (V2)
```

## Application Flow

### V1
1. `Main.java` starts the app and opens `StudentForm`
2. The student fills in the form fields and clicks Submit
3. `StudentForm` reads the field values and constructs a new `AbroadStudent` object
4. The student data is printed to the console for verification

### V2
Steps 1–3 stay identical. Step 4 changes:

4. `StudentForm` passes the `AbroadStudent` object to `ExcelWriter`
5. `ExcelWriter` reads the object's fields and inserts them into an Excel file

The form never writes to Excel directly — it only hands off the finished object.