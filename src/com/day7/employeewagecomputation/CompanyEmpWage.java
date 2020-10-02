package com.day7.employeewagecomputation;

//USERCASE11-14
public class CompanyEmpWage {

	public final String company;
	public final int numOfWorkingDays;
	public final int empRatePerHour;
	public final int maxHoursPerMonth;
	public int totalEmpWage;

	public CompanyEmpWage(String company, int numOfWorkingDays, int empRatePerHour, int maxHoursPerMonth) {
		super();
		this.company = company;
		this.numOfWorkingDays = numOfWorkingDays;
		this.empRatePerHour = empRatePerHour;
		this.maxHoursPerMonth = maxHoursPerMonth;
		totalEmpWage = 0;
	}

	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}

	@Override
	public String toString() {
		return "Total Employee Wage for Company " + company + " is " + totalEmpWage + ".";
	}
}
