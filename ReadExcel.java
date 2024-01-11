package com.demoqa.dataUtile;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static String[][] getExcelData() {
		// String fileLocation = "./test-data/Login-data.xlsx"; //file location, (./
		// default project folder)
		String fileLocation = new File("./test-data/Login-data.xlsx").getAbsolutePath();
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook(fileLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // workbook access or loading the file
		XSSFSheet sheet = wbook.getSheetAt(0); // access sheet
		int lastRowNum = sheet.getLastRowNum();
		int numberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println("No.of Rows with header: " + numberOfRows);
		System.out.println("No.of Rows: " + lastRowNum);
		short lastCellNum = sheet.getRow(0).getLastCellNum(); // to get column number
		System.out.println("No.of cells: " + lastCellNum);
		String[][] data = new String[lastRowNum][lastCellNum];
		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i); // row
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j); // column
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell); // class to read numeric and string
				// System.out.println(value);
				data[i - 1][j] = value;

				/*
				 * String value = cell.getStringCellValue(); // value System.out.println(value);
				 * // printing the value
				 */
			}
		}
		try {
			wbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}
}
