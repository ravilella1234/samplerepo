package com.hdfc.loans.homeloans;

public class EmployeeChild extends Employee
{
	String address;
	
	public EmployeeChild(String address) 
	{
		super(1746,"kiran",12.45f);
		this.address=address;
		
		System.out.println(this.address);
	}
		
	
	public static void main(String[] args) 
	{
		EmployeeChild ec = new EmployeeChild("hyderabad");
	}

}
