import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class BookLookupSystem {
    public static void main(String[] args) {
        Hashtable<Integer, String> library = new Hashtable<>();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Book Lookup System ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Search a Book");
            System.out.println("3. Remove a Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); 
                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();
                        library.put(id, title);
                        System.out.println("Book added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter Book ID to search: ");
                        int searchId = sc.nextInt();
                        if (library.containsKey(searchId)) {
                            System.out.println("Book ID: " + searchId + " | Book Title: " + library.get(searchId));
                        } else {
                            System.out.println("Book not found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Book ID to remove: ");
                        int removeId = sc.nextInt();
                        if (library.containsKey(removeId)) {
                            library.remove(removeId);
                            System.out.println("Book removed successfully.");
                        } else {
                            System.out.println("Book not found. Unable to remove.");
                        }
                        break;

                    case 4:
                        if (library.isEmpty()) {
                            System.out.println("No books available in the library.");
                        } else {
                            System.out.println("--- All Available Books ---");
                            for (Map.Entry<Integer, String> entry : library.entrySet()) {
                                System.out.println("Book ID: " + entry.getKey() + " | Book Title: " + entry.getValue());
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Exiting Book Lookup System.");
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
