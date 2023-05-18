package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadriven1 {

	public String[][] getdata(String Firstname,String lastname,String Phone,String Email,
			String Address,String City,String State,String Postalcode,String Country ,
			String Username,String Password,String Confirm) throws IOException {
				
		File file = new File("/Users/TA20463982/Tamilworkspace/restproject/src/main/java/utilities/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet 1");
		
		int row =sheet.getLastRowNum()+1;
		int col= sheet.getRow(0).getLastCellNum();
		
		String [][]data = new String[row][col];
		String value="";
		for(int i=0;i<row;i++) {
			Row row1=sheet.getRow(i);
			for(int j=0;j<col;j++) {
				value=row1.getCell(j).getStringCellValue();
				data[i][j]=value;
			}
		}
		return data;
		
	}
}
