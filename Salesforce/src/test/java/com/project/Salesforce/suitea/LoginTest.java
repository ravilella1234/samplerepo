package com.project.Salesforce.suitea;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.project.Salesforce.Base.BaseTest;
import com.project.Salesforce.utilities.Constants;
import com.project.Salesforce.utilities.DataUtils;

public class LoginTest extends BaseTest
{
	
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> data) throws Exception 
  {
	  System.out.println("iam f test");
	  test.log(Status.INFO, "Starting the LogiTest");
	  test.log(Status.INFO, data.toString());
	 // test.log(Status.PASS, "Test is Passed....");
	  
	  if(DataUtils.isSkip(testName, xls) || data.get(Constants.RUNMODE_COL).equals(Constants.RUNMODE_NO))
	  {
		  test.log(Status.SKIP, "Runmode is set to no");
		  throw new SkipException("Runmode is set to no");
	  }
		  
	  
	  ds.executeKeywords(xls, testName, data);
  }
  
  @DataProvider
  public Object[][] getData() throws Exception
  {
	  System.out.println("iam the dataprovider....");
	  
	  //String testName = "LoginTest";
	  String sheetName="Data";
	  
	return DataUtils.getTestData(xls, sheetName, testName);
  }
}
