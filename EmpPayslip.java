package motorPH2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EmpPayslip {

    public static void viewPayslipDetails(String employeeId) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
			int weekNumber = -1;

			while (weekNumber < 1 || weekNumber > 52) {
			    System.out.print("Please enter the week number (1-52) for the payslip: ");

			    if (!scanner.hasNextLine()) {
			        System.out.println("No input found. Please try again.");
			        continue;
			    }

			    try {
			        weekNumber = Integer.parseInt(scanner.nextLine());
			    } catch (NumberFormatException e) {
			        System.out.println("Invalid input. Please enter a valid number.");
			    }
			}

			double hoursWorkedInWeek = CalculateHours.calculateHoursWorkedInWeek(employeeId, weekNumber);
			double weeklyGrossSalary = GrossSalary.calculateWeeklyGrossSalary(employeeId, weekNumber);
			double hourlyRate = GetData.getHourlyRate(employeeId);
			double riceSubsidy = GetData.getRiceSubsidy(employeeId);
			double phoneAllowance =  GetData.getPhoneAllowance(employeeId);
			double clothingAllowance =  GetData.getClothingAllowance(employeeId);
			double philhealth = GetData.getPhilhealthDeduction(employeeId);
			double sss = GetData.getSssDeduction(employeeId);
			double pagibig = GetData.getPagibigDeduction(employeeId);
			double tax = Tax.calculateWithholdingTax(weeklyGrossSalary);
			double weeklyDeduction = Deductions.calculateWeeklyDeduction(employeeId, weekNumber, weeklyGrossSalary);
			double weeklyNetSalary = weeklyGrossSalary - weeklyDeduction;

			DecimalFormat df = new DecimalFormat("#.##");
			String formattedWeeklyNetSalary = df.format(weeklyNetSalary);
			String formattedWeeklyDeductions = df.format(weeklyDeduction);
			String formattedPhilhealth = df.format(philhealth / 4);
			String formattedTax = df.format(tax);
			String formattedSss = df.format(sss / 4);
			String formattedPagibig = df.format(pagibig / 4);

			LocalDate startDate = LocalDate.now().with(WeekFields.ISO.weekOfYear(), weekNumber).with(WeekFields.ISO.dayOfWeek(), 1);
			LocalDate endDate = startDate.plusDays(6);
			System.out.println();
			System.out.println("===========================================");
			System.out.println("         Payslip for "  + startDate.format(DateTimeFormatter.ofPattern("MMM d")) + " - " + endDate.format(DateTimeFormatter.ofPattern("MMM d")));
			System.out.println("===========================================");
			System.out.println("Employee Name		:"+ " " + GetData.getFirstName(employeeId) + " " + GetData.getLastName(employeeId));
			System.out.println("-------------------------------------------");
			System.out.println("Employee ID		: " + GetData.getEmployeeId(employeeId));
			System.out.println("-------------------------------------------");
			System.out.println("Date range		: " + startDate.format(DateTimeFormatter.ofPattern("MMM d")) + " - " + endDate.format(DateTimeFormatter.ofPattern("MMM d")));
			System.out.println("-------------------------------------------");
			System.out.println("Hours worked		: " + hoursWorkedInWeek);
			System.out.println("-------------------------------------------");
			System.out.println("Hourly rate		: " + hourlyRate);
			System.out.println("-------------------------------------------");
			System.out.println("Rice Subsidy		: " + riceSubsidy / 4);
			System.out.println("-------------------------------------------");
			System.out.println("Phone Allowance		: " + phoneAllowance / 4);
			System.out.println("-------------------------------------------");
			System.out.println("Clothing Allowance	: " + clothingAllowance / 4);
			System.out.println("-------------------------------------------");
			System.out.println("Gross salary		: " + weeklyGrossSalary);
			System.out.println("-------------------------------------------");
			System.out.println("Philheath		: " + formattedPhilhealth);
			System.out.println("-------------------------------------------");
			System.out.println("Pag-ibig		: " + formattedPagibig);
			System.out.println("-------------------------------------------");
			System.out.println("Sss			: " + formattedSss);
			System.out.println("-------------------------------------------");
			System.out.println("Tax			: " + formattedTax);
			System.out.println("-------------------------------------------");
			System.out.println("Total Deductions	: " + formattedWeeklyDeductions);
			System.out.println("-------------------------------------------");
			System.out.println("Weekly Net Salary	: " + formattedWeeklyNetSalary);
			System.out.println("===========================================");

	        Scanner scanner1 = new Scanner(System.in);

		    String choice;
	        do {
	            System.out.println("Do you want to print these details to a file? (y/n)");
	            try {
	                choice = scanner1.nextLine();
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
	                    choice = scanner1.nextLine();
	                } catch (NoSuchElementException e) {
	                    choice = "";
	                }
	            } while (choice.equals(""));
	            
	            if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
	                System.out.println("Invalid choice, please try again.");
	            }
	        }

	        if (choice.equalsIgnoreCase("y")) {
	        	
				
			    						try  (PrintWriter writer = new PrintWriter(new FileWriter("payslip.txt"))) {
			    							writer.println();
			    							writer.println("===========================================");
			    							writer.println("         Payslip for "  + startDate.format(DateTimeFormatter.ofPattern("MMM d")) + " - " + endDate.format(DateTimeFormatter.ofPattern("MMM d")));
			    							writer.println("===========================================");
			    							writer.println("Employee Name		:"+ " " + GetData.getFirstName(employeeId) + " " + GetData.getLastName(employeeId));
			    							writer.println("-------------------------------------------");
			    							writer.println("Employee ID		: " + GetData.getEmployeeId(employeeId));
			    							writer.println("-------------------------------------------");
			    							writer.println("Date range		: " + startDate.format(DateTimeFormatter.ofPattern("MMM d")) + " - " + endDate.format(DateTimeFormatter.ofPattern("MMM d")));
			    							writer.println("-------------------------------------------");
			    							writer.println("Hours worked		: " + hoursWorkedInWeek);
			    							writer.println("-------------------------------------------");
			    							writer.println("Hourly rate		: " + hourlyRate);
			    							writer.println("-------------------------------------------");
			    							writer.println("Rice Subsidy		: " + riceSubsidy / 4);
			    							writer.println("-------------------------------------------");
			    							writer.println("Phone Allowance		: " + phoneAllowance / 4);
			    							writer.println("-------------------------------------------");
			    							writer.println("Clothing Allowance	: " + clothingAllowance / 4);
			    							writer.println("-------------------------------------------");
			    							writer.println("Gross salary		: " + weeklyGrossSalary);
			    							writer.println("-------------------------------------------");
			    							writer.println("Philheath		: " + formattedPhilhealth);
			    							writer.println("-------------------------------------------");
			    							writer.println("Pag-ibig		: " + formattedPagibig);
			    							writer.println("-------------------------------------------");
			    							writer.println("Sss			: " + formattedSss);
			    							writer.println("-------------------------------------------");
			    							writer.println("Tax			: " + formattedTax);
			    							writer.println("-------------------------------------------");
			    							writer.println("Total Deductions	: " + formattedWeeklyDeductions);
			    							writer.println("-------------------------------------------");
			    							writer.println("Weekly Net Salary	: " + formattedWeeklyNetSalary);
			    							writer.println("===========================================");

							    		System.out.println("Payslip printed to payslip.txt");
							    		
			    						} catch (IOException e) {
				                            e.printStackTrace();
				                        }

			    						 System.out.println("Press 1 to go back to the main menu or 2 to log out.");
			    		                    
			    		                    String menuChoice = scanner1.nextLine();
			    		                    
			    		                    if (menuChoice.equals("1")) {
			    		                        EmployeeMenu.showEmployeeMenu(employeeId);
			    		                    }else if (menuChoice.equals("2")) {
			    		                        System.out.println("You have been logged out. Press enter to go back to the login screen.");
			    		                        scanner1.nextLine(); // Wait for enter key to be pressed
			    		                        PayrollSystem payrollSystem = new PayrollSystem();
			    		                        payrollSystem.run();
			    					  
			    		                    } else {
			    		                        System.out.println("Invalid choice, returning to main menu.");
			    		                        EmployeeMenu.showEmployeeMenu(employeeId);
			    		                    }
			    }

			    		                    scanner1.close();
		}
            }
        }
        
    
        
    

    
