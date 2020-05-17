package com.hdfc.loans.carloans;

public class Hdfc implements Rbi
{

	public static void main(String[] args) 
	{
		Hdfc h = new Hdfc();
		h.withdrawl();
		h.deposit();

	}

	@Override
	public void withdrawl() {
		System.out.println("iam overriden withdrawl in HDFC");
	}

	@Override
	public void deposit() {
		System.out.println("iam overriden deposit in HDFC");
	}

}
