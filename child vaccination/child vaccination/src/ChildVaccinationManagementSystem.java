import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChildVaccinationManagementSystem {

    static class VaccinationRecord {
        private String vaccineName;
        private String dateAdministered;

        public VaccinationRecord(String vaccineName, String dateAdministered) {
            this.vaccineName = vaccineName;
            this.dateAdministered = dateAdministered;
        }

        public String getVaccineName() {
            return vaccineName;
        }

        public String getDateAdministered() {
            return dateAdministered;
        }

        @Override
        public String toString() {
            return "Vaccine: " + vaccineName + ", Date: " + dateAdministered;
        }
    }

    static class Child {
        private String name;
        private int age;
        private List<VaccinationRecord> vaccinationRecords;

        public Child(String name, int age) {
            this.name = name;
            this.age = age;
            this.vaccinationRecords = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public List<VaccinationRecord> getVaccinationRecords() {
            return vaccinationRecords;
        }

        public void addVaccinationRecord(VaccinationRecord record) {
            vaccinationRecords.add(record);
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Age: " + age;
        }
    }

    static class VaccinationManager {
        private List<Child> children;

        public VaccinationManager() {
            this.children = new ArrayList<>();
        }

        public void addChild(Child child) {
            children.add(child);
        }

        public Child findChild(String name) {
            for (Child child : children) {
                if (child.getName().equalsIgnoreCase(name)) {
                    return child;
                }
            }
            return null;
        }

        public void addVaccinationRecord(String childName, VaccinationRecord record) {
            Child child = findChild(childName);
            if (child != null) {
                child.addVaccinationRecord(record);
                System.out.println("Vaccination record added.");
            } else {
                System.out.println("Child not found.");
            }
        }

        public void displayChildRecords(String childName) {
            Child child = findChild(childName);
            if (child != null) {
                System.out.println(child);
                for (VaccinationRecord record : child.getVaccinationRecords()) {
                    System.out.println(record);
                }
            } else {
                System.out.println("Child not found.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VaccinationManager manager = new VaccinationManager();

        while (true) {
            System.out.println("\nChild Vaccination Management System");
            System.out.println("1. Add Child");
            System.out.println("2. Add Vaccination Record");
            System.out.println("3. Display Child Records");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter child's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter child's age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    manager.addChild(new Child(name, age));
                    System.out.println("Child added.");
                    break;

                case 2:
                    System.out.print("Enter child's name: ");
                    String childName = scanner.nextLine();
                    System.out.print("Enter vaccine name: ");
                    String vaccineName = scanner.nextLine();
                    System.out.print("Enter date administered: ");
                    String date = scanner.nextLine();
                    manager.addVaccinationRecord(childName, new VaccinationRecord(vaccineName, date));
                    break;

                case 3:
                    System.out.print("Enter child's name: ");
                    String displayName = scanner.nextLine();
                    manager.displayChildRecords(displayName);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
