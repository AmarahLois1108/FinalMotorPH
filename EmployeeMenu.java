package motorPH2;


import java.io.IOException;
import java.util.Scanner;


public class EmployeeMenu {
    private static final int MIN_OPTION = 1;
    private static final int MAX_OPTION = 4;

    public static void showEmployeeMenu(String employeeId) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the employee menu.");
        System.out.println("=================================");

        int choice;
        do {
            System.out.println("\nPlease select an option:");
            System.out.println("1. View Personal Details");
            System.out.println("2. View Salary Details");
            System.out.println("3. View Payslip");
            System.out.println("4. Log out");

            // Check if there is input available
            while (!scanner.hasNextLine()) {
                // Wait for input
            }

            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);

                if (choice < MIN_OPTION || choice > MAX_OPTION) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                } else {
                    switch (choice) {
                        case 1:
                            EmpInformation.viewPersonalDetails(employeeId);
                            break;
                        case 2:
                            EmpSalary.viewSalaryDetails(employeeId);
                            break;
                        case 3:
                            EmpPayslip.viewPayslipDetails(employeeId);
                            break;
                        case 4:
                        	System.out.println("You have been logged out. Press enter to go back to the login screen.");
	                        scanner.nextLine(); // Wait for enter key to be pressed
	                        PayrollSystem payrollSystem = new PayrollSystem();
	                        payrollSystem.run();
                            return;
                            // Return to caller to redirect to login prompt
                        default:
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                choice = 0;
            }
        } while (choice != MAX_OPTION);

        scanner.close();
    }
}

	

    