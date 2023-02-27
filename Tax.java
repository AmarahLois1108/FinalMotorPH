package motorPH2;

public class Tax {
	public static double calculateWithholdingTax(double weeklyGrossSalary) {
	    double annualGrossSalary = weeklyGrossSalary * 52;
	    double taxableIncome = annualGrossSalary - 250000;
	    double taxAmount = 0.0;
	    if (taxableIncome <= 0) {
	        taxAmount = 0.0;
	    } else if (taxableIncome <= 400000) {
	        taxAmount = taxableIncome * 0.20;
	    } else if (taxableIncome <= 800000) {
	        taxAmount = 40000 + (taxableIncome - 400000) * 0.25;
	    } else if (taxableIncome <= 2000000) {
	        taxAmount = 140000 + (taxableIncome - 800000) * 0.30;
	    } else if (taxableIncome <= 8000000) {
	        taxAmount = 540000 + (taxableIncome - 2000000) * 0.32;
	    } else {
	        taxAmount = 2320000 + (taxableIncome - 8000000) * 0.35;
	    }
	    double withholdingTax = taxAmount / 52;
	    return withholdingTax;
	}
	

}
