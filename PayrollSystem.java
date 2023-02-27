package motorPH2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PayrollSystem {
    private boolean loggedIn = false;
    private String userType = "unknown";
    private String employeeId = null;

    public void run() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                if (!loggedIn) {
                	System.out.println("Welcome to MotorPH Payroll System");
                	System.out.println("=================================");
                	System.out.println();
                    System.out.print("Please enter your Employee ID:");
                    if (!scanner.hasNextLine()) {
                        break;
                    }
                    employeeId = scanner.nextLine();
                    System.out.print("Please enter your Password:");
                    if (!scanner.hasNextLine()) {
                        break;
                    }
                    String password = scanner.nextLine();

                    try (BufferedReader reader = new BufferedReader(new FileReader("login.txt"))) {
                        String line;
                        boolean foundUser = false;

                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts[0].equals(employeeId) && parts[1].equals(password)) {
                                loggedIn = true;
                                userType = parts[2];
                                foundUser = true;
                                break;
                            }
                        }

                        if (!foundUser) {
                            System.out.println("Invalid employee ID or password. Please try again.");
                            continue; // Prompt the user to log in again
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("=================================");
                    System.out.println("Login successful.");
                }

                if (userType.equals("admin")) {
                    System.out.println("Welcome, Admin" + " "+ GetData.getFirstName(employeeId) +" "+ GetData.getLastName(employeeId));
                    System.out.println();
                    System.out.println("Please select an option:");
                    System.out.println("1. Employee Menu");
                    System.out.println("2. Admin Menu");
                    System.out.println("3. Exit"); 

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                        	EmployeeMenu.showEmployeeMenu(employeeId);
                            break;
                        case 2:
                            // TODO: Implement payroll management menu
                            System.out.println("Admin Menu not implemented yet");
                            break;
                        case 3:
                            System.out.println("Goodbye!");
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                } else if (userType.equals("employee")) {
                    // Display the employee menu
                    EmployeeMenu.showEmployeeMenu(employeeId);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PayrollSystem payrollSystem = new PayrollSystem();
        payrollSystem.run();
    
}
}
