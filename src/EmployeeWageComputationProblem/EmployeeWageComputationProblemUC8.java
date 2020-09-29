package EmployeeWageComputationProblem;

public class EmployeeWageComputationProblemUC8 {
	
	public static final int full_time = 1;
	public static final int part_time = 2;
	
	private String company;
	private int empRate;
	private int maxHrsPerMonth;
	private int numOfWorkingDays;
	private static int totalWage;
	
	public EmployeeWageComputationProblemUC8(String company, int empRate, int numOfWorkingDays, int maxHrsPerMonth) {
		super();
		this.company = company;
		this.empRate = empRate;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrsPerMonth = maxHrsPerMonth;
	}
	public void calculation() {
		int totalEmpHrs = 0;
		int totalworkingdays = 0;
		int empHours;
		
		while (totalEmpHrs <= maxHrsPerMonth && totalworkingdays < numOfWorkingDays) {
			
			totalworkingdays ++;
		
			int empcheck = (int) Math.floor(Math.random()*10)%3;
		
			if (empcheck == full_time)
				empHours = 8;
			else if (empcheck == part_time)
				empHours = 4;
			else
				empHours = 0;
			
			totalEmpHrs += empHours;
			System.out.println("Days: "+totalworkingdays +" Employee Hours: "+totalEmpHrs);
		}
		totalWage = totalEmpHrs*empRate;
		System.out.println("Total Employee Wage for Company "+company+" is "+totalWage+".");
		
	}
	public static void main(String[] args) {
		
		EmployeeWageComputationProblemUC8 Store1 = new EmployeeWageComputationProblemUC8("Big Bazar", 10, 30, 150);
		EmployeeWageComputationProblemUC8 Store2 = new EmployeeWageComputationProblemUC8("Sahara Ganj", 20, 28, 160);
		
		Store1.calculation();
		Store2.calculation();
	}
}
