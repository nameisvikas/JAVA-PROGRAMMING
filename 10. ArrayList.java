import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int studentId;
    private String studentName;
    private String department;
    private int semester;

    public Student(int studentId, String studentName, String department, int semester) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.semester = semester;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + studentName
                + ", Course/Department: " + department + ", Semester: " + semester;
    }
}

public class StudentRecordManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    boolean duplicate = false;
                    for (Student s : students) {
                        if (s.getStudentId() == id) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        System.out.println("Error: Student ID " + id + " already exists.");
                        break;
                    }

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Course/Department: ");
                    String dept = scanner.nextLine();

                    System.out.print("Enter Semester: ");
                    int sem = scanner.nextInt();
                    scanner.nextLine();

                    Student newStudent = new Student(id, name, dept, sem);
                    students.add(newStudent);
                    System.out.println("Student record added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Student ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();

                    boolean removed = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getStudentId() == removeId) {
                            students.remove(i);
                            System.out.println("Student record removed successfully.");
                            removed = true;
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Student record not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter 1 to search by ID or 2 to search by Name: ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    boolean found = false;

                    if (searchChoice == 1) {
                        System.out.print("Enter Student ID to search: ");
                        int searchId = scanner.nextInt();
                        scanner.nextLine();

                        for (Student s : students) {
                            if (s.getStudentId() == searchId) {
                                System.out.println("Record found: " + s.toString());
                                found = true;
                                break;
                            }
                        }
                    } else if (searchChoice == 2) {
                        System.out.print("Enter Student Name to search: ");
                        String searchName = scanner.nextLine();

                        for (Student s : students) {
                            if (s.getStudentName().equalsIgnoreCase(searchName)) {
                                System.out.println("Record found: " + s.toString());
                                found = true;
                            }
                        }
                    } else {
                        System.out.println("Invalid search choice.");
                        break;
                    }

                    if (!found) {
                        System.out.println("Student record not found.");
                    }
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        System.out.println("\n--- All Student Records ---");
                        for (Student s : students) {
                            System.out.println(s.toString());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting Student Record Management System.");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
