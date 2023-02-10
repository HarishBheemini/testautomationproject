package com.auto.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.auto.qa.base.TestBase;
import com.google.common.io.Files;

public class Utilities extends TestBase {
	public static String TestData_Path= "C:\\Users\\pavan\\OneDrive\\Documents\\Harish\\TestAutomation2.xlsx";
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	static FileInputStream fis = null;
	
	// Swtching to frame
	
	// Opening new window
	
	// Switching to newly opened window
	
	// Java Script Executor Methods
	
	// Get current data and time
	
	// Implement custom explicit waits
	
	// Handling interactions with complex elements like calendars, checkboxes, dropdowns
	
	// Screenshot utilities
	
	// ...etc
	
	public Utilities() {
		try {
			fis = new FileInputStream(TestData_Path);
		} catch(FileNotFoundException fo) {
			fo.printStackTrace();
		}
	}
	
	public static Object[][] getTestData() {
		try {
			wb = (XSSFWorkbook) WorkbookFactory.create(fis);
		} catch(IOException e) {
			e.printStackTrace();
		} catch(InvalidFormatException ife)  {
			ife.printStackTrace();
		}
		sheet = wb.getSheet("TestData");
		Object[][] obj = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				obj[i][j] = sheet.getRow(i).getCell(j).toString();
				System.out.println(sheet.getRow(i).getCell(j).toString());
			}
		}
		return obj;
	}
	
	@DataProvider
	public Object[][] getTestDataProvider() {
		return getTestData();
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		Files.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
