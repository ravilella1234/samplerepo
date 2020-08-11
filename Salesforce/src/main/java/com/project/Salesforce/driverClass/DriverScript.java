package com.project.Salesforce.driverClass;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;

import com.project.Salesforce.keywordClasses.Applicationkeywords;
import com.project.Salesforce.utilities.ExcelAPI;

public class DriverScript 
{
	public Properties orProp;
	Applicationkeywords app;
		
	
	public Properties getOrProp() {
		return orProp;
	}

	public void setOrProp(Properties orProp) {
		this.orProp = orProp;
	}

	public void executeKeywords(ExcelAPI xls,String testName, Hashtable<String, String> testdata) throws Exception, Exception
	{
		System.out.println("iam driverscript class....");
		int rows = xls.getRowCount("Keyword");
		System.out.println(rows);
		app = new Applicationkeywords();
		app.setOrProp(orProp);
		app.setData(testdata);
		
		
		
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcid = xls.getCellData("Keyword", "TCID", rNum);
			if(tcid.equals(testName))
			{
				String kWord = xls.getCellData("Keyword", "Keywords", rNum);
				String objectKey = xls.getCellData("Keyword", "Object", rNum);
				String dataKey = xls.getCellData("Keyword", "Data", rNum);
				String data = testdata.get(dataKey);
				
				//System.out.println(tcid + "====" + kWord + "====" + orProp.getProperty(objectKey) + "====" + data);
				app.setObjectKey(objectKey);
				app.setDataKey(dataKey);
				
				/*
				 * if(kWord.equals("openBrowser")) app.openBrowser(); else
				 * if(kWord.equals("navigateUrl")) app.navigateUrl(); else
				 * if(kWord.equals("click")) app.click(); else if(kWord.equals("type"))
				 * app.type(); else if(kWord.equals("validatLogin")) app.validatLogin(); else
				 * if(kWord.equals("verifyTitle")) app.verifyTitle();
				 */
				
				//Reflection API
				Method method = app.getClass().getMethod(kWord);
				method.invoke(app);
			}
			
			
		}
	}

}
