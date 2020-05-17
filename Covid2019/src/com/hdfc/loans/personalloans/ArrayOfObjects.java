package com.hdfc.loans.personalloans;

public class ArrayOfObjects 
{

	public static void main(String[] args) 
	{
		Student s1= new Student(1744,"ravilella");
		Student s2= new Student(1745,"keerthan");
		Student s3= new Student(1746,"sai");
		Student s4= new Student(1747,"kiran");
	
		Student[]  s = new Student[4];
		s[0]=s1;
		s[1]=s2;
		s[2]=s3;
		s[3]=s4;
		
		for(Student i:s)
		{
			System.out.println(i);
		}
	}
}

class Student
{
	int sNo;
	String sName;
	
	public Student(int sNo, String sName) 
	{
		super();
		this.sNo = sNo;
		this.sName = sName;
	}

	@Override
	public String toString() 
	{
		return "Student [sNo=" + sNo + ", sName=" + sName + "]";
	}

		
}
