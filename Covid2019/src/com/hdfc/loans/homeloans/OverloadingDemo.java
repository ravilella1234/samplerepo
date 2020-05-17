package com.hdfc.loans.homeloans;

public class OverloadingDemo 
{
	
	
	/*
	 * public void add(float b) { System.out.println(b); }
	 */
	 
	
	/*
	 * public void add(int a) { System.out.println(a); }
	 */
	
	/*
	 * public void add(String a) { System.out.println(a); }
	 */
	
	
	/*
	 * public void add(Integer a) { System.out.println(a); }
	 */
	
	/*
	 * public void add(Number a) { System.out.println(a); }
	 */
	
	public void add(Object a)
	{
		System.out.println(a);
	}
	
	public static void main(String[] args) 
	{
		OverloadingDemo obj = new OverloadingDemo();
		obj.add(1744);
		obj.add(12.34f);
		obj.add("ravilella");
		obj.add(1000);
		obj.add(33.34f);
		obj.add("ravikanth");
	}

}
