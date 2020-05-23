package com.collections;

public class DemoClass 
{

	public static void main(String[] args) 
	{
		Student s= new Student();
		//System.out.println(s.sno);
		//System.out.println(s.sname);
		
		s.setSno(100);
		System.out.println(s.getSno());
		
		s.setSname("keerthan");
		System.out.println(s.getSname());
	}

}
