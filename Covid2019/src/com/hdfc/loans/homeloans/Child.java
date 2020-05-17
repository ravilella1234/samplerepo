package com.hdfc.loans.homeloans;

class Parent
{
	public  Number workhard()
	{
		System.out.println("wakeup early, goto college...");
		return 0;
	}
	
	public void care()
	{
		System.out.println("Atmost care...");
	}
	
}


public class Child extends Parent
{
	public  Number workhard()
	{
		System.out.println("wakeup anytime, goto bars/beauty");
		return 0;
	}
	
	public void love()
	{
		System.out.println("iam in love....");
	}

	public static void main(String[] args) 
	{
		Child c = new Child();
		c.workhard();
		c.care();
		c.love();

	}

}
