package com.demoqa.dataUtile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public void writeData(String sheetName, String cellValue, int row, int col) throws IOException {

		String excelPath = "./test-data/Login-data.xlsx";

		File file = new File(excelPath);

		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet(sheetName);

		sheet.getRow(row).createCell(col).setCellValue(cellValue);

		FileOutputStream fos = new FileOutputStream(file);

		wb.write(fos);

		wb.close();

		fos.close();
	}

}
