package com.prameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelFileReading1 {
	public static Object[][] excelReading(String sheetName) {
	    
		FileInputStream fis = null;
		try {
	//	fis = new FileInputStream(filePath);
		fis = new FileInputStream("C:\\Users\\shiva\\Desktop\\Data.xlsx");
		} catch (FileNotFoundException e) {
		
		e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		
		try {
		workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		       
		int row = sheet.getLastRowNum();
		int cell = sheet.getRow(0).getLastCellNum();
		
		
		Object [][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
		for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
		data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		
		System.out.println(data[i][j]); 
		
		
		
		}
		}
		return   data;       
		} 
	
	
	/*public static void main(String[]args) {
		excelReading("Sheet1");
	}
	
		
		public static Object[][] excelReading(String sheetname) {
	                        //I have placed an excel file 'Test.xlsx' in my D Driver 
	 FileInputStream fis = null;
	try {
		fis = new FileInputStream("C:\\Users\\shiva\\Desktop\\Data.xlsx");
		}catch (IOException e) {
		e.printStackTrace();
	}
	
	 XSSFWorkbook workbook = null;
	try {
		workbook = new XSSFWorkbook(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 XSSFSheet sheet = workbook.getSheet(sheetname);
	                        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
	                        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
	 int row = sheet.getLastRowNum();
	 int cell = sheet.getRow(0).getLastCellNum();
	 
	 Object [][] data= new Object[row][cell];
	 for(int i=0;i<row;i++) {
		 
		 for(int j=0;j<cell;j++) {
			 
		 data[i][j]=sheet.getRow(i).getCell(j);
		
			System.out.println(data[i][j]); 
			
		 }
	 }
	    return   data;       
	
	 
	 } */
		}




