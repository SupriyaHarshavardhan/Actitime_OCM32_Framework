package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contains method for reading the data in excel
 * 
 * @author supriya
 *
 */

public class ExcelUtility {
	/**
	 * this method used to read data from excel by specifying sheet
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return cellString value
	 * @throws Throwable
	 */

	public String getExcelData(String sheetName, int rownum, int cellnum) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(file);
		String value = workbook.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;

	}

	/**
	 * this method retuen all the data in the sheet
	 * 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] getExcelData(String sheetName) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRow][lastCell];
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

	/**
	 * this method is uesd to read data
	 * 
	 * @param sheetName
	 * @param tcID
	 * @param headerValue
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName, String tcID, String headerValue) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int expectedRow = 0;
		for (int i = 0; i <= lastRow; i++) {
			String testCaseID = sheet.getRow(i).getCell(0).getStringCellValue();
			if (testCaseID.equalsIgnoreCase(tcID)) {
				expectedRow = i;
				break;
			}
		}
		expectedRow--;
		int expectedColumn = 0;
		int lastCell = sheet.getRow(expectedRow).getLastCellNum();
		for (int j = 0; j < lastCell; j++) {
			String value = sheet.getRow(expectedRow).getCell(j).getStringCellValue();
			if (value.equalsIgnoreCase(headerValue)) {
				expectedColumn = j;
				break;
			}
		}
		return sheet.getRow(expectedRow + 1).getCell(expectedColumn).getStringCellValue();
	}

	/**
	 * this method is used to write data into excelsheet
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param column
	 * @param value
	 * @throws Throwable
	 */

	public void writeExcelData(String sheetname, int rownum, int column, String value) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(file);
		workbook.createSheet(sheetname).createRow(rownum).createCell(column).setCellValue(value);
		FileOutputStream writeFile = new FileOutputStream(IPathConstant.EXCELPATH);
		workbook.write(writeFile);
	}

}
