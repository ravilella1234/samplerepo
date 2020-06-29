package excelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDataByColoumnNumber 
{

	public static void main(String[] args) throws Exception 
	{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		FileOutputStream fos = null;
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		XSSFRow row = sheet.getRow(4);
		XSSFCell cell = row.getCell(4);
		
		XSSFFont font = wb.createFont();
		XSSFCellStyle style = wb.createCellStyle();
		
		font.setFontName("Calibri");
		font.setFontHeight(12.0);
		font.setBold(true);
		
		style.setFont(font);
		cell.setCellStyle(style);
		
		cell.setCellValue("Aborted");
		
		fos = new FileOutputStream("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
		
	}

}
