# Java Grading System

This is a simple Grading System implemented in Java that accepts multiple subjects and calculates grades for internal, theory, and practical exams based on inputted marks. It also provides the overall grade and CGPA for the student.

## Features

- Input the number of subjects.
- Enter marks for internal, theory, and practical exams.
- Calculates grades for each subject based on the marks entered.
- Provides individual grades for internal, theory, and practical exams.
- Outputs the overall grade and CGPA.

## How It Works

1. The user enters the number of subjects.
2. The user is prompted to input subject names.
3. The user enters the maximum marks for internal, theory, and practical exams.
4. For each subject, the user inputs the marks obtained in internal, theory, and practical exams.
5. The system calculates grades for each subject:
    - **F** grade if the student fails any part.
    - Total grades and CGPA are computed only if the student passes.
6. The final overall grade and CGPA are displayed based on the grades in each subject.

## How To Run

1. **Compile the program:**

    Make sure you have Java installed. Compile the program using:

    ```bash
    javac Main.java
    ```

2. **Run the program:**

    After compiling, you can run the program with:

    ```bash
    java Main
    ```

3. **Follow the prompts:**

    Enter the details as prompted, including subject names, maximum marks, and the marks for each subject.

## Code Overview

The program uses a `Main` class that handles all user inputs and processing of grades. A separate `grade` class is used to handle the calculation of grades and grade points based on the input marks. 

### Main Class Structure

- `noofsubject`: Stores the number of subjects.
- `internalMax`, `practicalMax`, `TheoryMax`: Stores maximum marks for each type of exam.
- `overallgrade`, `overallpoint`, `sumpoint`: Used to calculate and store the overall grade and CGPA.
  
### Grade Class Methods

- `calculateGrade(int marks, int maxMarks)`: Calculates the grade based on the marks.
- `calculateGradePoint(int marks, int maxMarks)`: Calculates grade points for CGPA calculation.

### Example
![Grade OP](https://github.com/user-attachments/assets/500e3245-a70e-42d9-837c-cf5176519171)
