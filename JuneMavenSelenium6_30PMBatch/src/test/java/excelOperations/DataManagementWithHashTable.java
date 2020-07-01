package excelOperations;

import org.testng.annotations.Test;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataManagementWithHashTable 
{
	
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> data) 
  {
	  if(data.get("Runmode").equals("Y"))
		  System.out.println(data.get("Runmode") + " -----" + data.get("Browser") + " ---- " + data.get("UserName") + "----" + data.get("UserPassword"));
  }

  @DataProvider
  public Object[][] getData() throws Exception 
  {
	ExcelAPI e = new ExcelAPI("C:\\Users\\DELL\\Desktop\\SuiteA.xlsx");
	String sheetName = "Data";
	String testCaseName = "LoginTest";
	  
	return DataUtils.getTestData(e,sheetName, testCaseName);   
  }
  
  
}
