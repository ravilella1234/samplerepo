package com.project.Salesforce.utilities;

import java.util.Hashtable;

public class DataUtils 
{
	
	public static Object[][] getTestData(ExcelAPI e, String sheetName, String testCaseName) throws Exception
	{
		
		
		int testStartRowNum=0;
		while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName))
		{
			testStartRowNum++;
		}
		System.out.println("Test Start from row :- " + testStartRowNum);
		
		int colStartRowNum = testStartRowNum + 1;
		int dataStartRowNum = testStartRowNum + 2;
		
		
		//calculate row of Data
		int rows = 0;
		while(!e.getCellData(sheetName, 0, dataStartRowNum+rows).equals(""))
		{
			rows++;
		}
		System.out.println("Total rows are :- " + rows);
		
		
		//calculate columns count
		int cols = 0;
		while(!e.getCellData(sheetName, cols, colStartRowNum).equals(""))
		{
			cols++;
		}
		System.out.println("Total columns Count is : "+ cols);

		
		//Read the data
		int dataRow=0;
		Object[][] data= new Object[rows][1];
		Hashtable<String, String> table =null;
		
		for(int rNum= dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			table = new Hashtable<String, String>();
			for(int cNum=0;cNum<cols;cNum++)
			{
				//System.out.println(e.getCellData(sheetName, cNum, rNum));
				//data[dataRow][cNum]=e.getCellData(sheetName, cNum, rNum);
				String key = e.getCellData(sheetName, cNum, colStartRowNum);
				String value = e.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}
			data[dataRow][0]=table;
			dataRow++;
		}
	  
	return data;
	}
	
	//Function to check the runmode of test
	public static boolean isSkip(String testName,ExcelAPI xls)
	{
		int rows = xls.getRowCount(Constants.TESTCASES_SHEET);
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcid = xls.getCellData(Constants.TESTCASES_SHEET, Constants.TCID_COL, rNum);
			if(tcid.equals(testName)) 
			{
				String runmode = xls.getCellData(Constants.TESTCASES_SHEET, Constants.RUNMODE_COL, rNum);
				if(runmode.equals(Constants.RUNMODE_NO))
					return true;
				else
					return false;
			}
		}
		return true;
	}

}
