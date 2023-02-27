package motorPH2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class GrossSalary {
	public static double calculateWeeklyGrossSalary(String employeeId, int weekNumber) {
		 
	    double riceSubsidy = GetData.getRiceSubsidy(employeeId);
	    double phoneAllowance =  GetData.getPhoneAllowance(employeeId);
	    double clothingAllowance =  GetData.getClothingAllowance(employeeId);
	    double hourlyRate =  GetData.getHourlyRate(employeeId);

	    try (BufferedReader reader = new BufferedReader(new FileReader("Employee_salary.txt"))) {
	        String line;

	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(",");
	            if (parts.length < 7) {
	                // handle the error here, such as by skipping the line or logging a message
	                continue;
	            }
	            if (parts[0].equals(employeeId)) {
	                hourlyRate = Double.parseDouble(parts[6]);
	                break;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    double hoursWorkedInWeek = CalculateHours.calculateHoursWorkedInWeek(employeeId, weekNumber);
	    double weeklyGrossSalary = (hourlyRate * hoursWorkedInWeek) + ((riceSubsidy + phoneAllowance + clothingAllowance)/4);
	    DecimalFormat df = new DecimalFormat("#.##");
	    String formattedGrossSalary = df.format(weeklyGrossSalary);

	    return Double.parseDouble(formattedGrossSalary);
	}


	
}
