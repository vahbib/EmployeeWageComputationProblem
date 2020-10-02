package com.day7.employeewagecomputation;

import java.util.*;

//USERCASE11-14
public class EmpWageBuilder implements IComputeEmpWage {
	public static final int full_time = 1;
	public static final int part_time = 2;

	private int numOfCompany = 0;
	private LinkedList<CompanyEmpWage> companyEmpWageList;
	private Map<String, CompanyEmpWage> companyToEmpwageMap;

	public EmpWageBuilder() {
		companyEmpWageList = new LinkedList<>();
		companyToEmpwageMap = new HashMap<>();
	}

	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
		companyToEmpwageMap.put(company, companyEmpWage);
		companyEmpWageList.add(companyEmpWage);
	}

	public void computeEmpWage() {
		for (int i = 0; i < companyEmpWageList.size(); i++) {
			CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}

	@Override
	public int getTotalWage(String company) {
		return companyToEmpwageMap.get(company).totalEmpWage;
	}

	public int computeEmpWage(CompanyEmpWage companyEmpWage) {
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
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
		return totalEmpHrs * companyEmpWage.empRatePerHour;
	}

	public static void main(String[] args) {
		IComputeEmpWage empWageBuilder = new EmpWageBuilder();
		empWageBuilder.addCompanyEmpWage("Central Mall", 20, 20, 100);
		empWageBuilder.addCompanyEmpWage("Pothys", 25, 18, 120);
		empWageBuilder.computeEmpWage();
		System.out.println("Total Wage for Central Mall is " + empWageBuilder.getTotalWage("Central Mall"));
		System.out.println("Total Wage for Pothys is " + empWageBuilder.getTotalWage("Pothys"));
	}

}
