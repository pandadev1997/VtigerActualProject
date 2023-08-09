package com.crm.vtger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.crm.vtger.genericUtility.Ipathconstant;

public class Excel_practice {
	@Test
	public void get() throws Throwable {
		FileInputStream fs=new FileInputStream(Ipathconstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sh = wb.getSheet("multiple");
		int lastrow = sh.getLastRowNum()+1;
		System.out.println(lastrow);
		int lastcell=0;
		for(int i=0;i<lastrow;i++) {
			 lastcell=sh.getRow(i).getLastCellNum();
		}
		 System.out.println(lastcell);


	}

}
