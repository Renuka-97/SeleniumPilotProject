package test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewDemoRead {

	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public NewDemoRead(String excelPath)
	{
		try {
			File sc = new File(excelPath);
			FileInputStream fis = new FileInputStream(sc);
			workbook = new XSSFWorkbook(fis);
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}

	public String getData(int sheetNumber, int row, int column) {

		sheet = workbook.getSheetAt(sheetNumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public int getRowCount(int sheetIndex) {

		int row = workbook.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;

	}

}
