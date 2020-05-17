package com.hdfc.loans.homeloans;

public class B extends A  // ISA RelationShip
{
	public void m1()
	{
		System.out.println("iam overriden m1 from ClassB");
	}
	
	public void m2()
	{
		System.out.println("iam m2 from ClassB");
	}
	
	public static void main(String[] args) 
	{
		A a = new A(); // HasA Relationship
		a.m1();
		System.out.println(a.x);
		
		B b = new B();
		b.m2();
		b.m1();
		System.out.println(b.x);
	}

}
