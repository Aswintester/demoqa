package com.demoqa.dataUtile;

import org.testng.annotations.DataProvider;

public class DataUtile {
	@DataProvider
	public String[][] getData() {
		String[][] excelData = ReadExcel.getExcelData();

    return excelData;
}
}