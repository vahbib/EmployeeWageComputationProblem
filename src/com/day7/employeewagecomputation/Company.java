package com.day7.employeewagecomputation;

//USERCASE 10
public class Company {

	public final String company;
	public final int empRate;
	public final int maxHrsPerMonth;
	public final int numOfWorkingDays;
	public int totalWage;

	public Company(String company, int empRate, int numOfWorkingDays, int maxHrsPerMonth) {
		super();
		this.company = company;
		this.empRate = empRate;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrsPerMonth = maxHrsPerMonth;
	}

	public void setTotalWage(int totalWage) {
		this.totalWage = totalWage;
	}

	@Override
	public String toString() {
		return "Total Employee Wage for Company " + company + " is " + totalWage + ".";
	}

}
