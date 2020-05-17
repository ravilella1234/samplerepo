package com.hdfc.loans.homeloans;

public class WrapperDemo 
{

	public static void main(String[] args) 
	{
		int i=10;
		System.out.println(i);
		
		Integer i1= new Integer(100);
		System.out.println(i1);
		
		Integer i2 = new Integer("123");
		System.out.println(i2);
		
		int i3;
		i3=i1+i2;
		System.out.println(i3);
		
		String s1="123";
		String s2="321";
		int s3;
		
		//s3=s1+s2;
		s3=Integer.parseInt(s1) + Integer.parseInt(s2);
		System.out.println(s3);
		
		

	}

}
