package com.project.Salesforce.driverClass;

import java.util.Hashtable;

import com.project.Salesforce.utilities.ExcelAPI;

public class DriverScript 
{
	public void executeKeywords(ExcelAPI xls,String testName, Hashtable<String, String> data)
	{
		System.out.println("iam driverscript class....");
		int rows = xls.getRowCount("Keyword");
		System.out.println(rows);
		
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcid = xls.getCellData("Keyword", "TCID", rNum);
			if(tcid.equals(testName))
			{
				String kWord = xls.getCellData("Keyword", "Keywords", rNum);
				String objectKey = xls.getCellData("Keyword", "Object", rNum);
				String dataKey = xls.getCellData("Keyword", "Data", rNum);
				
				System.out.println(tcid + "====" + kWord + "====" + objectKey + "====" + dataKey);
			}
			
			
		}
	}

}
