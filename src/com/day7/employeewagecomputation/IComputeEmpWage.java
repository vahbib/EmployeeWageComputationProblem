package com.day7.employeewagecomputation;

//USERCASE11-14
public interface IComputeEmpWage {
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);

	public void computeEmpWage();

	public int getTotalWage(String company);
}
