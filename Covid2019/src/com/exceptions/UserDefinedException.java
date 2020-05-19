package com.exceptions;

import java.util.Scanner;

public class UserDefinedException extends Exception
{

	public UserDefinedException(String msg) 
	{
		super(msg);
	}

	public static void main(String[] args) 
	{
		String str;
		Scanner sc = new Scanner(System.in);
		
		
		while (true) 
		{
			System.out.println("Enter the String : ");
			str=sc.nextLine();
			try 
			{
				if (str.length() != 10) 
				{
					throw new UserDefinedException("String should be 10 characters");
				} 
				else 
				{
					System.out.println(str);
					break;
				}
			} 
			catch (UserDefinedException e) 
			{
				e.printStackTrace();
			} 
		}

	}

}
