package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	
	public void readexcelfile(String filepath) throws IOException {
		FileInputStream fs = new FileInputStream(new File(filepath));
		workbook = new XSSFWorkbook(fs);	
	}
	
	public String getData(int sheetNumber, int row, int cell) {
		sheet = workbook.getSheetAt(sheetNumber);
		String data = "";
		try {
			data = sheet.getRow(row).getCell(cell).getStringCellValue();
		}
		catch(Exception e){
			Long value = (long) sheet.getRow(row).getCell(cell).getNumericCellValue();
			data = value.toString();
		}
		return data;
	}
	
	public int getRowCount(int sheetNumber) {
		sheet = workbook.getSheetAt(sheetNumber);
		return sheet.getLastRowNum()-sheet.getFirstRowNum()+1;
	}
	
	public int getCellCount(int sheetNumber, int row) {
		sheet = workbook.getSheetAt(sheetNumber);
		return sheet.getRow(row).getLastCellNum();
	}


}
