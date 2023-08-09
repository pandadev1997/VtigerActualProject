package com.crm.vtger.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	/**
	 * This method will help us to update the into excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	public void updateExcelData(String sheet,int row,int cell,String data) throws Throwable {
		FileInputStream fis=new FileInputStream(Ipathconstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(Ipathconstant.excelfilepath);
		wb.write(fos);
		wb.close();
	
	}
	/**
	 * This method will help us to fetch the data from excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public String getTheDataIntoExcel(String sheet,int row,int cell) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream(Ipathconstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cel = wb.getSheet(sheet).getRow(row).getCell(cell);
		DataFormatter df=new  DataFormatter();
		String value = df.formatCellValue(cel);
		return value;
	}
	@DataProvider
	public Object[][] getmultiple() throws Throwable{
		FileInputStream fs=new FileInputStream(Ipathconstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fs);
	    Sheet sh = wb.getSheet("multiple");
	    int lastrow = sh.getLastRowNum()+1;
	    int lastcell = sh.getRow(0).getLastCellNum();
	    Object[][] data=new Object[lastrow][lastcell];
	    for(int i=0;i<lastrow;i++) {
	    	for(int j=0;j<lastcell;j++) {
	    		data[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
	    	}
	    }
	    return data;
	}
	

}
