import java.util.Scanner;

class Student {
    String studentId, studentName, department;
    Student(String id, String name, String dept) {
        studentId = id; studentName = name; department = dept;
    }
    void displayStudentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Department: " + department);
    }
}

class UndergraduateStudent extends Student {
    int semester; double cgpa;
    UndergraduateStudent(String id, String name, String dept, int sem, double cgpa) {
        super(id, name, dept); this.semester = sem; this.cgpa = cgpa;
    }
    void displayUGDetails() {
        System.out.println("Semester: " + semester);
        System.out.println("CGPA: " + cgpa);
    }
}

class PostgraduateStudent extends Student {
    String specialization, researchTopic;
    PostgraduateStudent(String id, String name, String dept, String spec, String topic) {
        super(id, name, dept); this.specialization = spec; this.researchTopic = topic;
    }
    void displayPGDetails() {
        System.out.println("Specialization: " + specialization);
        System.out.println("Research Topic: " + researchTopic);
    }
}

public class StudentManagementDemo {
    static Scanner sc = new Scanner(System.in);

    // Common to both subclasses; returns null (after printing the error) on bad input.
    static Student readCommonDetails() {
        System.out.println("Enter Student ID: ");
        String id = sc.nextLine().trim();
        if (id.startsWith("-")) { System.out.println("Error: Invalid Student ID. Returning to menu."); return null; }

        System.out.println("Enter Student Name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) { System.out.println("Error: Student Name cannot be empty. Returning to menu."); return null; }

        System.out.println("Enter Department: ");
        String dept = sc.nextLine().trim();
        return new Student(id, name, dept);
    }

    static Integer readIntInRange(String prompt, int min, int max, String field) {
        System.out.println(prompt);
        int val;
        try { val = Integer.parseInt(sc.nextLine().trim()); }
        catch (Exception e) { System.out.println("Error: " + field + " must be a number. Returning to menu."); return null; }
        if (val < min || val > max) { System.out.println("Error: Invalid " + field + " (Valid range: " + min + "-" + max + "). Returning to menu."); return null; }
        return val;
    }

    static Double readDoubleInRange(String prompt, double min, double max, String field) {
        System.out.println(prompt);
        double val;
        try { val = Double.parseDouble(sc.nextLine().trim()); }
        catch (Exception e) { System.out.println("Error: " + field + " must be a decimal number. Returning to menu."); return null; }
        if (val < min || val > max) { System.out.println("Error: Invalid " + field + " (Valid range: " + min + "-" + max + "). Returning to menu."); return null; }
        return val;
    }

    static void handleUndergraduate() {
        Student base = readCommonDetails();
        if (base == null) return;
        Integer sem = readIntInRange("Enter Semester (1-8): ", 1, 8, "Semester");
        if (sem == null) return;
        Double cgpa = readDoubleInRange("Enter CGPA (0.0-10.0): ", 0.0, 10.0, "CGPA");
        if (cgpa == null) return;

        UndergraduateStudent ug = new UndergraduateStudent(base.studentId, base.studentName, base.department, sem, cgpa);
        System.out.println("\n--- Undergraduate Student Details ---");
        ug.displayStudentDetails();
        ug.displayUGDetails();
    }

    static void handlePostgraduate() {
        Student base = readCommonDetails();
        if (base == null) return;
        System.out.println("Enter Specialization: ");
        String spec = sc.nextLine().trim();
        System.out.println("Enter Research Topic: ");
        String topic = sc.nextLine().trim();
        if (topic.isEmpty()) { System.out.println("Error: Research Topic cannot be empty. Returning to menu."); return; }

        PostgraduateStudent pg = new PostgraduateStudent(base.studentId, base.studentName, base.department, spec, topic);
        System.out.println("\n--- Postgraduate Student Details ---");
        pg.displayStudentDetails();
        pg.displayPGDetails();
    }

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 3) {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Manage Undergraduate Student");
            System.out.println("2. Manage Postgraduate Student");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            try { choice = Integer.parseInt(sc.nextLine().trim()); }
            catch (Exception e) { System.out.println("Invalid input. Please enter a valid number."); continue; }

            switch (choice) {
                case 1 -> handleUndergraduate();
                case 2 -> handlePostgraduate();
                case 3 -> System.out.println("Exiting Student Management Application.");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}
