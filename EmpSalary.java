package motorPH2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EmpSalary {
    static void viewSalaryDetails(String employeeId) throws IOException {
    	String tab = ("\t:" + "\t");
    	System.out.println("========================================");
        System.out.println("          Salary Information");
        System.out.println("========================================");
        System.out.println("Employee Name:"+ " " + GetData.getFirstName(employeeId) + " " + GetData.getLastName(employeeId));
        System.out.println("----------------------------------------");
        System.out.println("Basic Salary"+"\t" + tab + GetData.getBasicSalary(employeeId));
        System.out.println("----------------------------------------");
        System.out.println("Gross Semi Monthly rate"+ tab + GetData.getGrossSemiMonthlyRate(employeeId));
        System.out.println("----------------------------------------");
        System.out.println("Hourly Rate"+"\t"+ tab + GetData.getHourlyRate(employeeId));
        System.out.println("----------------------------------------");
        System.out.println("Rice Subsidy"+"\t"+ tab + GetData.getRiceSubsidy(employeeId));
        System.out.println("----------------------------------------");
        System.out.println("Phone Allowance"+"\t"+ tab + GetData.getPhoneAllowance(employeeId));
        System.out.println("----------------------------------------");
        System.out.println("Clothing Allowance"+ tab + GetData.getClothingAllowance(employeeId));
        System.out.println("========================================");


        Scanner scanner = new Scanner(System.in);

	    String choice;
        do {
            System.out.println("Do you want to print these details to a file? (y/n)");
            try {
                choice = scanner.nextLine();
            } catch (NoSuchElementException e) {
                choice = "";
            }
        } while (choice.equals(""));

        if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
            System.out.println("Invalid choice, please try again.");
        }

        while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
            do {
                System.out.println("Do you want to print these details to a file? (y/n)");
                try {
                    choice = scanner.nextLine();
                } catch (NoSuchElementException e) {
                    choice = "";
                }
            } while (choice.equals(""));
            
            if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
                System.out.println("Invalid choice, please try again.");
            }
        }

        if (choice.equalsIgnoreCase("y")) {
        	
            try (PrintWriter writer = new PrintWriter(new FileWriter("salary_information.txt"))) {
            	writer.println("========================================");
                writer.println("              Salary Information");
                writer.println("========================================");
                writer.println("Employee Name:"+ " " + GetData.getFirstName(employeeId) + " " + GetData.getLastName(employeeId));
                writer.println("----------------------------------------");
                writer.println("Basic Salary"+"\t"+"\t" + tab + GetData.getBasicSalary(employeeId));
                writer.println("----------------------------------------");
                writer.println("Gross Semi Monthly rate"+ tab + GetData.getGrossSemiMonthlyRate(employeeId));
                writer.println("----------------------------------------");
                writer.println("Hourly Rate\t" + "\t" + "\t" + tab + GetData.getHourlyRate(employeeId));
                writer.println("----------------------------------------");
                writer.println("Rice Subsidy\t"+ "\t" + tab + GetData.getRiceSubsidy(employeeId));
                writer.println("----------------------------------------");
                writer.println("Phone Allowance\t"+ "\t" + tab + GetData.getPhoneAllowance(employeeId));
                writer.println("----------------------------------------");
                writer.println("Clothing Allowance"+ "\t" + tab  + GetData.getClothingAllowance(employeeId));
                writer.println("========================================");
                System.out.println("Salary Information printed to salary_information.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Press 1 to go back to the main menu or 2 to log out.");
        
        String menuChoice = scanner.nextLine();
        
        if (menuChoice.equals("1")) {
            EmployeeMenu.showEmployeeMenu(employeeId);
        }else if (menuChoice.equals("2")) {
            System.out.println("You have been logged out. Press enter to go back to the login screen.");
            scanner.nextLine(); // Wait for enter key to be pressed
            PayrollSystem payrollSystem = new PayrollSystem();
            payrollSystem.run();
  
        } else {
            System.out.println("Invalid choice, returning to main menu.");
            EmployeeMenu.showEmployeeMenu(employeeId);
        }

        scanner.close();
    }
}
