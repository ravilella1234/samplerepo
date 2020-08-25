package com.project.Salesforce.driverClass;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.project.Salesforce.keywordClasses.Applicationkeywords;
import com.project.Salesforce.utilities.Constants;
import com.project.Salesforce.utilities.ExcelAPI;

public class DriverScript 
{
	public Properties orProp;
	Applicationkeywords app;
	public ExtentTest test;
		

	

	public void setTest(ExtentTest test) {
		this.test = test;
	}

	public Properties getOrProp() {
		return orProp;
	}

	public void setOrProp(Properties orProp) {
		this.orProp = orProp;
	}
	
	public void quit()
	{
		if(app!=null)
			app.quit();
	}

	public void executeKeywords(ExcelAPI xls,String testName, Hashtable<String, String> testdata) throws Exception, Exception
	{
		System.out.println("iam driverscript class....");
		int rows = xls.getRowCount(Constants.KEYWORD_SHEET);
		System.out.println(rows);
		app = new Applicationkeywords();
		app.setOrProp(orProp);
		app.setData(testdata);	
		
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcid = xls.getCellData(Constants.KEYWORD_SHEET, Constants.TCID_COL, rNum);
			if(tcid.equals(testName))
			{
				String kWord = xls.getCellData(Constants.KEYWORD_SHEET, Constants.KEYWORD_COL, rNum);
				String objectKey = xls.getCellData(Constants.KEYWORD_SHEET, Constants.OBJECT_COL, rNum);
				String dataKey = xls.getCellData(Constants.KEYWORD_SHEET, Constants.DATA_COL, rNum);
				String data = testdata.get(dataKey);
				
				//test.log(Status.INFO, "iam in driverscript");
				//test.log(Status.INFO, tcid + "====" + kWord + "====" + orProp.getProperty(objectKey) + "====" + data);
				//System.out.println(tcid + "====" + kWord + "====" + orProp.getProperty(objectKey) + "====" + data);
				app.setObjectKey(objectKey);
				app.setDataKey(dataKey);
				app.setTest(test);
				
				
				//Reflection API
				Method method = app.getClass().getMethod(kWord);
				method.invoke(app);
			}
			
			
		}
	}

}
