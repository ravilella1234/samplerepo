package com.hdfc.loans.personalloans;

public class StringDemo 
{

	public static void main(String[] args)
	{
		String s1 = " Ravikanth";
		System.out.println(s1);
		System.out.println(s1.indexOf('a'));
		
		System.out.println();
		
		
		System.out.println(s1.length());
		System.out.println(s1.hashCode());
		System.out.println(s1.charAt(2));
		
		System.out.println(s1.isEmpty());
		System.out.println(s1.substring(2, 7));
		System.out.println(s1.replace('R', 'k'));
		
		
		String s2 = new String("ravikanth");
		System.out.println(s2);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.contentEquals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
		System.out.println(s2.contains(s1));
		
		System.out.println(s1+s2);
		System.out.println(s1.concat(s2));
		
		System.out.println(s2.toUpperCase());
		System.out.println(s1.toLowerCase());
		
		System.out.println(s1.equalsIgnoreCase(s2));
     	System.out.println(s1.toLowerCase().equals(s2));
     	
     	
     	System.out.println(s1.toLowerCase().startsWith("ravi"));
     	
     	System.out.println(s1);
     	System.out.println(s1.trim());
     	
     	System.out.println(s1.equals(s2));
     	System.out.println(s1.trim().equals(s2));
     	System.out.println(s1.trim().toLowerCase().equals(s2));
     	System.out.println(s1.trim().equalsIgnoreCase(s2));
     	
     	
     	String s3 = "ravi kanth";
     	System.out.println(s3);
     	
     	String[] s = s3.split(" ");
     	
     	System.out.println(s[0]);
     	System.out.println(s[1]);
     	
     	
	}

}
