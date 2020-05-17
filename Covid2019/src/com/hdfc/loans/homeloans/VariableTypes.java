package com.hdfc.loans.homeloans;

public class VariableTypes 
{
	// primitive variable
	int x=10;   // instance (or) global (or) non-static variable
	static String cname="vmware";  // static variable
	static VariableTypes obj;
	
	
	public   void m1()
	{
		int x=100; // local variable
		System.out.println(this.x);	
		
		System.out.println(x);
		System.out.println(VariableTypes.cname);
		
	}
	
	public static void m2()
	{
		obj = new VariableTypes();
		System.out.println(obj.x);
		System.out.println(VariableTypes.cname);
	}
	
	public static void main(String[] args) 
	{
		obj = new VariableTypes(); // reference varibale
		System.out.println(obj.x);
		System.out.println(VariableTypes.cname);	
	}

}
