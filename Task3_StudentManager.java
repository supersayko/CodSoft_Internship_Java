import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class newStudent {
    private final String name;
    private final int rollNumber;
    private final String grade;

    public newStudent(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nRoll Number: " + rollNumber + "\nGrade: " + grade + "\n";
    }
}
class StudentManagementSystem {
    private final List<newStudent> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(newStudent student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public newStudent searchStudent(int rollNumber) {
        for (newStudent student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (newStudent student : students) {
            System.out.println(student);
        }
    }

    public void saveStudentDataToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (newStudent student : students) {
                writer.println(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
            }
            System.out.println("Student data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving student data to file: " + e.getMessage());
        }
    }

    public void loadStudentDataFromFile(String filename) {
        students.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int rollNumber = Integer.parseInt(parts[1]);
                    String grade = parts[2];
                    students.add(new newStudent(name, rollNumber, grade));
                }
            }
            System.out.println("Student data loaded from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading student data from file: " + e.getMessage());
        }
    }
}
public class Task3_StudentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save Student Data");
            System.out.println("6. Load Student Data");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();
                    system.addStudent(new newStudent(name, rollNumber, grade));
                }
                case 2 -> {
                    System.out.print("Enter roll number of student to remove: ");
                    int rollNumberToRemove = sc.nextInt();
                    system.removeStudent(rollNumberToRemove);
                }
                case 3 -> {
                    System.out.print("Enter roll number of student to search: ");
                    int rollNumberToSearch = sc.nextInt();
                    newStudent searchedStudent = system.searchStudent(rollNumberToSearch);
                    if (searchedStudent != null) {
                        System.out.println("Student found:\n" + searchedStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 4 -> {
                    System.out.println("All Students:");
                    system.displayAllStudents();
                }
                case 5 -> {
                    System.out.print("Enter filename to save student data: ");
                    String saveFilename = sc.nextLine();
                    system.saveStudentDataToFile(saveFilename);
                }
                case 6 -> {
                    System.out.print("Enter filename to load student data: ");
                    String loadFilename = sc.nextLine();
                    system.loadStudentDataFromFile(loadFilename);
                }
                case 7 -> {
                    System.out.println("Exiting Student Management System. Goodbye!");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
