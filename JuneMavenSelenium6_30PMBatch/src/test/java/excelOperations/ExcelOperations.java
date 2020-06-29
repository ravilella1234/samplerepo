package excelOperations;

public class ExcelOperations 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e1 = new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		
		System.out.println(e1.getRowCount("login"));
		
		System.out.println(e1.columnCount("login"));
		
		System.out.println(e1.getCellData("login", 1, 2));
		
		System.out.println(e1.getCellData("login", "UserName", 2));
		
		e1.setCellData("login", 4, 2, "failed");

	}

}
