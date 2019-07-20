/*******************************************************************************
 * © Copyright (C) 2018 Selenium Project @Harish.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.DTHRechargePage;
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
	
	@Test
	public void TC_01_Verify_DTH_Recharge_Empty_Errors() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Verify Enter valid subscriber number and valid Amount error message is displayed Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Recharge_DTH();
		
		DTHRechargePage dr=new DTHRechargePage(driver);
		dr.DTH_Recharge_Details("Dish TV DTH", "", "");
		dr.Verify_DTH_Recharge_Empty_Errors();
		
		System.out.println("------------Finished Verify Enter valid subscriber number and valid Amount error message is displayed Test Case------------");
	}
	
	@Test(dataProvider="DTH")
	public void TC_02_Verify_DTH_Recharge_Subscriber_Empty_Error(String sno,String operator,String errormsg) throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Verify Enter valid subscriber number error message is displayed Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Recharge_DTH();
		
		DTHRechargePage dr=new DTHRechargePage(driver);
		dr.DTH_Recharge_Details(operator, "", "100");
		dr.Verify_DTH_Recharge_Subscriber_Empty_Error(errormsg);
		
		System.out.println("------------Finished Verify Enter valid subscriber number error message is displayed Test Case------------");
	}
	
	@Test
	public void TC_03_Verify_DTH_Recharge_Amount_Empty_Error() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Verify Enter valid Amount error message is displayed Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Recharge_DTH();
		
		DTHRechargePage dr=new DTHRechargePage(driver);
		dr.DTH_Recharge_Details("Dish TV DTH", "123456", "");
		dr.Verify_DTH_Recharge_Amount_Empty_Error();
		
		System.out.println("------------Finished Verify Enter valid Amount error message is displayed Test Case------------");
	}
	
	@Test
	public void TC_04_Verify_DTH_Recharge_Invalid_Amount_Error() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Verify Enter valid Amount error message is displayed for invalid amount Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Recharge_DTH();
		
		DTHRechargePage dr=new DTHRechargePage(driver);
		dr.DTH_Recharge_Details("Dish TV DTH", "123456", "0");
		dr.Verify_DTH_Recharge_Amount_Empty_Error();
		
		System.out.println("------------Finished Verify Enter valid Amount error message is displayed for invalid amount Test Case------------");
	}
	
	@Test
	public void TC_05_Verify_DTH_Recharge_Empty_Errors() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Verify DTH Recharge Viola PIN invalid Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Recharge_DTH();
		
		DTHRechargePage dr=new DTHRechargePage(driver);
		dr.DTH_Recharge_Details("Dish TV DTH", "123456", "100");
		dr.Entering_Viola_PIN("9999");
		dr.Verify_ViolaPIN_Invalid();
		
		System.out.println("------------Finished Verify DTH Recharge Viola PIN invalid Test Case------------");
	}
	
	@Test
	public void TC_06_Verify_DTH_Recharge_Invalid_SubscriberID() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Verify DTH Recharge with Invalid Subscriber ID Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Recharge_DTH();
		
		DTHRechargePage dr=new DTHRechargePage(driver);
		dr.DTH_Recharge_Details("Dish TV DTH", "123456", "100");
		dr.Entering_Viola_PIN("6666");
		dr.Verify_DTH_Recharge_Subscriber_Invalid();
		
		System.out.println("------------Finished Verify DTH Recharge with Invalid Subscriber ID Test Case------------");
	}
	
	@Test
	public void TC_07_Verify_DTH_Recharge_Success() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Verify DTH Recharge with Valid Subscriber ID Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Recharge_DTH();
		
		DTHRechargePage dr=new DTHRechargePage(driver);
		dr.DTH_Recharge_Details("Tatasky DTH", "1209757481", "100");
		dr.Entering_Viola_PIN(commonProperties.getProperty("test.pin"));
		dr.Verify_Payment_Details_Screen();
		dr.Verify_Recharge_Payment_Success();
		
		System.out.println("------------Finished Verify DTH Recharge with Valid Subscriber ID Test Case------------");
	}
	
}
