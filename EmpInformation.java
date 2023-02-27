package motorPH2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EmpInformation {
	 static void viewPersonalDetails(String employeeId) throws IOException {
		 String tab = ("\t:" + "\t");
	        
	        System.out.println("                      Personal Information");
	        System.out.println("=====================================================================");
	        System.out.println("Employee ID" + tab + GetData.getEmployeeId(employeeId));
	        System.out.println("---------------------------------------------------------------------");
	        System.out.println("Last Name" + tab + GetData.getLastName(employeeId));
	        System.out.println("---------------------------------------------------------------------");
	        System.out.println("First Name" + tab + GetData.getFirstName(employeeId));
	        System.out.println("---------------------------------------------------------------------");
	        System.out.println("Birthday"+ tab + GetData.getBirthday(employeeId));
	        System.out.println("---------------------------------------------------------------------");
	        System.out.println("Address\t" + tab + GetData.getAddress(employeeId));
	        System.out.println("---------------------------------------------------------------------");
	        System.out.println("Phone Number"+ tab + GetData.getPhoneNumber(employeeId));
	        System.out.println("---------------------------------------------------------------------");
	        System.out.println("SSS #\t" + tab + GetData.getSssNo(employeeId));
	        System.out.println("---------------------------------------------------------------------");
	        System.out.println("Philhealth"  + tab + GetData.getPhilhealthNo(employeeId));
	        System.out.println("---------------------------------------------------------------------");
	        System.out.println("TIN #\t" + tab + GetData.getTinNo(employeeId));
	        System.out.println("---------------------------------------------------------------------");;
	        System.out.println("Pag-ibig #" + tab + GetData.getPagibigNo(employeeId));
	        System.out.println("---------------------------------------------------------------------");
	        System.out.println("Status\t"  + tab + GetData.getStatus(employeeId));
	        System.out.println("---------------------------------------------------------------------");
	        System.out.println("Position" + tab +GetData.getPosition(employeeId));
	        System.out.println("---------------------------------------------------------------------");
	        System.out.println("Supervisor" + tab + GetData.getSupervisor(employeeId));
	        System.out.println("=====================================================================");

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
	        	
	        	
	                        try (PrintWriter writer = new PrintWriter(new FileWriter("personal_information.txt"))) {
	                        	writer.println("                        Personal Details");
	                        	writer.println("=====================================================================");
	                	        writer.println("Employee ID" + tab + GetData.getEmployeeId(employeeId));
	                	        writer.println("---------------------------------------------------------------------");
	                	        writer.println("Last Name" + tab + GetData.getLastName(employeeId));
	                	        writer.println("---------------------------------------------------------------------");
	                	        writer.println("First Name" + tab + GetData.getFirstName(employeeId));
	                	        writer.println("---------------------------------------------------------------------");
	                	        writer.println("Birthday" + tab + GetData.getBirthday(employeeId));
	                	        writer.println("---------------------------------------------------------------------");
	                	        writer.println("Address\t" + tab + GetData.getAddress(employeeId));
	                	        writer.println("---------------------------------------------------------------------");
	                	        writer.println("Phone Number" + tab + GetData.getPhoneNumber(employeeId));
	                	        writer.println("---------------------------------------------------------------------");
	                	        writer.println("SSS #\t" + tab + GetData.getSssNo(employeeId));
	                	        writer.println("---------------------------------------------------------------------");
	                	        writer.println("Philhealth" + tab + GetData.getPhilhealthNo(employeeId));
	                	        writer.println("---------------------------------------------------------------------");
	                	        writer.println("TIN #\t" + tab + GetData.getTinNo(employeeId));
	                	        writer.println("---------------------------------------------------------------------");
	                	        writer.println("Pag-ibig" + tab + GetData.getPagibigNo(employeeId));
	                	        writer.println("---------------------------------------------------------------------");
	                	        writer.println("Status\t" + tab +  GetData.getStatus(employeeId));
	                	        writer.println("---------------------------------------------------------------------");
	                	        writer.println("Position" + tab + GetData.getPosition(employeeId));
	                	        writer.println("---------------------------------------------------------------------");
	                	        writer.println("Supervisor" + tab + GetData.getSupervisor(employeeId));
	                	        writer.println("=====================================================================");
	                	        
	                	        System.out.println("Personal details printed to personal_information.txt");
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
						
                       scanner.close();
	                }
	 }
}
