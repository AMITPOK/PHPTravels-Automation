package com.qa.PHPTravels.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static Workbook book;
	public static Sheet sheet;

	public static Object[][] getdata(String sheetName) {
		Object[][] data = null;
		try {
			FileInputStream ip = new FileInputStream(AppConstants.TEST_DATA_LOCATION);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int row = 0; row < sheet.getLastRowNum(); row++) {
				for (int column = 0; column < sheet.getRow(0).getLastCellNum(); column++) {
					data[row][column] = sheet.getRow(row + 1).getCell(column).toString();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
