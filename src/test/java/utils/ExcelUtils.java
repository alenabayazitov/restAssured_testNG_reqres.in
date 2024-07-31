package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils{
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
			
				}catch(Exception exc) {
					exc.getCause();
					exc.getMessage();
				}
	}

	
	public Object getCellData(int rowNum, int colNum) {
			DataFormatter formatter = new DataFormatter();
			Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			System.out.println(value);
			return value;
	}
	
	public int getRowCount(){
	int rowCount = sheet.getPhysicalNumberOfRows();
	
	System.out.println("No of rows: " + rowCount);
	return rowCount;
	}
}
