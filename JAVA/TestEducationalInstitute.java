import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestEducationalInstitute {
    public static void main(String[] args) {
        List<EducationalInstitute> institutes = new ArrayList<>();
        String csvFile = "data/finalData.csv"; // Ensure this path is correct for your environment
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                if (data.length >= 6) {
                    int srNo = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String city = data[2].trim();
                    String state = data[3].trim();
                    String act = data[4].trim();
                    String ministry = data[5].trim();

                    EducationalInstitute institute = new EducationalInstitute(srNo, name, city, state, act, ministry);
                    institutes.add(institute);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        showMenu(institutes);
    }

    private static void showMenu(List<EducationalInstitute> institutes) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Display all Educational Institutes");
            System.out.println("2. Display Institutes by Name");
            System.out.println("3. Display Institutes by State");
            System.out.println("4. Display Institutes by Act");
            System.out.println("5. Display Institutes by Ministry");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    displayAllInstitutes(institutes);
                    break;
                case 2:
                    displayInstitutesByName(institutes, scanner);
                    break;
                case 3:
                    displayInstitutesByState(institutes, scanner);
                    break;
                case 4:
                    displayInstitutesByAct(institutes, scanner);
                    break;
                case 5:
                    displayInstitutesByMinistry(institutes, scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
        
        scanner.close();
    }

    private static void displayAllInstitutes(List<EducationalInstitute> institutes) {
        for (EducationalInstitute institute : institutes) {
            System.out.println(institute);
        }
    }

    private static void displayInstitutesByName(List<EducationalInstitute> institutes, Scanner scanner) {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (EducationalInstitute institute : institutes) {
            if (institute.getInstituteName().toLowerCase().contains(name)) {
                System.out.println(institute);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No institutes found with the name: " + name);
        }
    }

    private static void displayInstitutesByState(List<EducationalInstitute> institutes, Scanner scanner) {
        System.out.print("Enter state to search: ");
        String state = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (EducationalInstitute institute : institutes) {
            if (institute.getState().toLowerCase().contains(state)) {
                System.out.println(institute);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No institutes found in the state: " + state);
        }
    }

    private static void displayInstitutesByAct(List<EducationalInstitute> institutes, Scanner scanner) {
        System.out.print("Enter act to search: ");
        String act = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (EducationalInstitute institute : institutes) {
            if (institute.getAct().toLowerCase().contains(act)) {
                System.out.println(institute);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No institutes found with the act: " + act);
        }
    }

    private static void displayInstitutesByMinistry(List<EducationalInstitute> institutes, Scanner scanner) {
        System.out.print("Enter ministry to search: ");
        String ministry = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (EducationalInstitute institute : institutes) {
            if (institute.getMinistry().toLowerCase().contains(ministry)) {
                System.out.println(institute);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No institutes found with the ministry: " + ministry);
        }
    }
}
