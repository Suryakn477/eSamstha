/*******************************************************************************
 * © Copyright (C) 2018 Selenium Project @Surya.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.DashboardPage;
import utilities.BaseTest;


public class OrgConfigScenario extends BaseTest{
	
	public static HSSFWorkbook workbook;
    public static HSSFSheet worksheet;
    public static DataFormatter formatter= new DataFormatter();
    public static String file_location = System.getProperty("user.dir")+"\\Excel\\Error_Validation_TestData.xls";
    static String SheetName= "DTH";
	
	@DataProvider(name="DTH")
	public static Object[][] ReadDataFromExcel() throws IOException
    {
    FileInputStream fileInputStream= new FileInputStream(file_location); //Excel sheet file location get mentioned here
        workbook = new HSSFWorkbook (fileInputStream); //get my workbook 
        worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
        HSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
     
        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum 
         
        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
        
            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
            {  
                HSSFRow row= worksheet.getRow(i+1);
               
                for (int j=0; j<ColNum; j++) //Loop work for colNum
                {
                    if(row==null)
                        Data[i][j]= "";
                    else
                    {
                        HSSFCell cell= row.getCell(j);
                        
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data 
                        else
                        {
                            String value=formatter.formatCellValue(cell);
                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                        }
                    }
                }
                
            }
 
        return Data;
    }
	
	//@Test
	
	
}
