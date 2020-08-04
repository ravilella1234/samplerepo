package com.project.Salesforce.suiteb;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.Salesforce.Base.BaseTest;
import com.project.Salesforce.driverClass.DriverScript;
import com.project.Salesforce.utilities.DataUtils;

public class TestA extends BaseTest
{
	@Test(dataProvider = "getData")
	  public void f(Hashtable<String, String> data) 
	  {
		  System.out.println("iam f test");
		  ds = new DriverScript();
		  ds.executeKeywords(xls, testName, data);
	  }
	  
	  @DataProvider
	  public Object[][] getData() throws Exception
	  {
		  System.out.println("iam the dataprovider....");
		  
		  //String testName = "TestA";
		  String sheetName="Data";
		  
		return DataUtils.getTestData(xls, sheetName, testName);
	  }
}
