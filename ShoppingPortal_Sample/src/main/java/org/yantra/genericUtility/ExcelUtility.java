package org.yantra.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	private Workbook workbook;
	
	/**
	 * This method is used to Initialize the Excel file
	 * @param excelPath
	 */
public void initializeExcelfile(String excelPath)
{
	FileInputStream fisExcel;
		try {
			fisExcel=new FileInputStream(excelPath);
			workbook=WorkbookFactory.create(fisExcel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		    catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		} 
}
/**
 * This Method is used to write the data to the excel
 * @param sheetname
 * @param rowNumber
 * @param cellNumber
 * @param value
 */

public String setDataIntoExcel(String sheetname,int rowNumber,int cellNumber,String value)
{
	Sheet sheet=workbook.getSheet(sheetname);
	sheet.getRow(rowNumber).createCell(cellNumber).setCellValue(value);
	System.out.println("Data is entered");
	return value; 

}
/**
 * This method is used to provide the data to Excel
 * @param excelPath
 */
public void provideDataIntoExcel(String excelPath)
{
	FileOutputStream fosExcel;
	try {
		fosExcel=new FileOutputStream(excelPath);
		workbook.write(fosExcel);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}
/**
 * This method is used to get the data from Excel
 * @param sheetName
 * @param rowNumber
 * @param cellNumber
 * @return
 */
public String getDataFromExcel(String sheetName,int rowNumber,int cellNumber)
{
	Sheet sheet=workbook.getSheet(sheetName);
	return new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
}
public void workbookClose()
{
	try {
		workbook.close();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}
}


















