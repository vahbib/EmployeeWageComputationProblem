package com.day7.employeewagecomputation;

// USERCASE 10
public class EmployeeWageBuilderArray {
	public static final int full_time = 1;
	public static final int part_time = 2;

	private int numOfCompany = 0;
	private Company[] companyEmpWageArray;

	public EmployeeWageBuilderArray() {
		companyEmpWageArray = new Company[5];
	}

	private void addCompany(String company, int empRate, int numOfWorkingDays, int maxHrsPerMonth) {
		companyEmpWageArray[numOfCompany] = new Company(company, empRate, numOfWorkingDays, maxHrsPerMonth);
		numOfCompany++;
	}

	private void computeEmpWage() {
		for (int i = 0; i < numOfCompany; i++) {
			companyEmpWageArray[i].setTotalWage(this.computeEmpWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);

		}
	}

	private int computeEmpWage(Company companyEmpWage) {
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		while (totalEmpHrs <= companyEmpWage.maxHrsPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
			totalWorkingDays++;
			int empcheck = (int) Math.floor(Math.random() * 10) % 3;
			switch (empcheck) {
			case part_time:
				empHrs = 4;
				break;
			case full_time:
				empHrs = 8;
				break;
			default:
				empHrs = 0;
				break;
			}
			totalEmpHrs += empHrs;
			System.out.println("Days: " + totalWorkingDays + " | Employee Hours: " + totalEmpHrs);
		}
		return totalEmpHrs * companyEmpWage.empRate;
	}

	public static void main(String[] args) {
		EmployeeWageBuilderArray eWB = new EmployeeWageBuilderArray();
		eWB.addCompany("Singapore Mall", 20, 200, 100);
		eWB.addCompany("Spencers", 10, 150, 60);
		eWB.computeEmpWage();
	}
}
