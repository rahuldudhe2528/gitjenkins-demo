package com.hyr.dataprovider;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class NInjaExcelDataProvider {
	@DataProvider
	public Object[][] GetData() throws Exception {
		FileInputStream fis=new FileInputStream(".//TestData/NinjaCred.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Ninja");
		int rows=sheet.getPhysicalNumberOfRows();
		int cols=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rows][cols];
		for(int i=0;i<rows-1;i++) {
			for(int j=0;j<cols;j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				
			}
		}
		workbook.close();
		fis.close();
		return data;
		
	}

}
