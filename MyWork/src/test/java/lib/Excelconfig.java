package lib;

import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelconfig {

	XSSFWorkbook wb;
	XSSFSheet sheet1;
	public Excelconfig(String Filepath) 
	{
		try {
			wb=new	XSSFWorkbook(Filepath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		} 
		  
	}
	
	public String getData(int sheetnumber,int row,int column)
	{
		sheet1=wb.getSheetAt(sheetnumber);
		String data=sheet1.getRow(row).getCell(column).getStringCellValue();		
		
		return data;
		
	}
}
