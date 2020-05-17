package com.hdfc.loans.personalloans;

public  final class VariableNADemo 
{
	public final int x=10;
	
	 public final static int y=20;

	public static void main(String[] args) 
	{
		final int z= 30;
		
		VariableNADemo v = new VariableNADemo();
		System.out.println(v.x);
		//v.x=100;
		System.out.println(v.x);
		
		System.out.println(y);
		//y=200;
		System.out.println(y);
		
		System.out.println(z);
		//z=300;
		System.out.println(z);
		

	}

}
