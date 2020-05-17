package com.hdfc.loans.personalloans;

public class Array2DD 
{

	public static void main(String[] args) 
	{
		int a[][]= {
				      {10,20,30,100},
				      {40,50,60},
				      {70,80,90,1,2},
				   };
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0; j<a[i].length;j++)
			{
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		for(int k[] : a)
		{
			for(int l : k)
			{
				System.out.print(l + "\t");
			}
			System.out.println();
		}
		

	}

}
