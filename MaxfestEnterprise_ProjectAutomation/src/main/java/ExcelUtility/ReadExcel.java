package ExcelUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static FileInputStream f;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;

	public static String readString(int i, int j) throws IOException {
		f = new FileInputStream("C:\\Deepu\\Selenium_Work\\SeleniumProject\\src\\main\\resources\\ExcelProp\\ProjectDetails.xlsx");
		//C:\\Deepu\\Selenium_Work\\SeleniumProject\\src\\main\\resources\\ExcelProp\\
		wb = new XSSFWorkbook(f); // to get the excel work book
		// sh = wb.getSheet("Sheet1"); // to get the particular sheet in the excel work
		// book.
		sh = wb.getSheetAt(2);
		Row r = sh.getRow(i); // to get the row in the excel sheet
		Cell c = r.getCell(j); // to get the cell in the row.
		return c.getStringCellValue(); // will return the value in the cell
	}

	public static String readNumeric(int i, int j) throws IOException 
	{
		f = new FileInputStream("C:\\\\Deepu\\\\Selenium_Work\\\\SeleniumProject\\\\src\\\\main\\\\resources\\\\ExcelProp\\\\ProjectDetails.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheetAt(2);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		int val = (int) c.getNumericCellValue();
		return String.valueOf(val);
	}	
}
