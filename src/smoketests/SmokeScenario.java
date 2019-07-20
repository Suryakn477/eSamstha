/*******************************************************************************
 * © Copyright (C) 2018 Selenium Project @Harish.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package smoketests;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Properties;

import org.testng.annotations.Test;

import objectRepository.AlertsPage;
import objectRepository.BroadbandPayPage;
import objectRepository.BusBookPage;
import objectRepository.DTHRechargePage;
import objectRepository.DashboardPage;
import objectRepository.ElectricityPayPage;
import objectRepository.GasPayPage;
import objectRepository.HelpPage;
import objectRepository.HomePage;
import objectRepository.InsurancePayPage;
import objectRepository.LandlinePayPage;
import objectRepository.LoanPayPage;
import objectRepository.LoginPage;
import objectRepository.PayeesPage;
import objectRepository.PrepaidRechargePage;
import objectRepository.RentalPayPage;
import objectRepository.SendMoneyPage;
import objectRepository.TaxPayPage;
import objectRepository.TopupPage;
import objectRepository.TripleClikPage;
import objectRepository.WalletPage;
import objectRepository.WaterPayPage;
import utilities.PropertiesFileReader;
import utilities.BaseTest;

public class SmokeScenario extends BaseTest{	
	public static Properties commonproperties =null;
	
	static{
		commonproperties =PropertiesFileReader.getInstance().readProperties("common.properties");
	}
	//---------------------------Login-------------------------------------------------------------
	@Test
	public void TC_05_Login_Valid_Testcase() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Login with valid credentials Test Cases------------");
		
		HomePage hp=new HomePage(driver);
		hp.Verify_Home_Page();
		//hp.Select_Environment(commonproperties.getProperty("Environment_name"));
		hp.navigate_LoginPage();
		
		LoginPage lp=new LoginPage(driver);
		lp.Verify_Login_Screen();
		lp.Entering_Details(commonproperties.getProperty("test.mobilenumber"), commonproperties.getProperty("test.settings.vpin"));
//		lp.Verify_Login_OTP_Screen();
		lp.Verify_Dashboard_Screen();
		
		System.out.println("------------Finished Login with valid credentials Test Cases------------");
}
	//-----------------------------TopUp---------------------------------------------------------------------
	
	@Test
	public void TC_05_TopUp_Success_Testcase() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started TopUp with success transaction Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_TopUp_Screen();
		
		TopupPage tp=new TopupPage(driver);
		tp.Entering_Amount(commonproperties.getProperty("test.topup.amount"));
		tp.Verify_TopUp_AddMoney_Screen();
		tp.Add_Money_Netbaking("Y");
		tp.Verify_Success_Message();
		
		dp.Check_All_Alerts();
		
		System.out.println("------------Finished TopUp with success transaction Test Case------------");
	}
	
	//---------------------Offers----------------------------------------------------------------------------
	@Test
	public void TC_01_Verify_Offers_Screen() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Offers Screen is displayed Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Offers_Screen();
				
		System.out.println("------------Finished Offers Screen is displayed Test Case------------");
	}
	
	//---------------------payee-------------------------------------------------------------------------------
	//--------------------Add_Payee----------------------------------------------------------------------------
	@Test
	public void TC_06_Payees_Add_Payee_Valid_MobileNumber() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Added Payee with valid mobile number Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Payees_Screen();
		
		PayeesPage pp=new PayeesPage(driver);
		pp.Payees_Add_Payee_W2W(commonproperties.getProperty("test.payee.mobilenumber"), commonproperties.getProperty("test.payee.name"),"No", commonproperties.getProperty("test.settings.vpin"));
		//pp.Verify_Add_Payee_Success();
		
		System.out.println("------------Finished Added Payee with valid mobile number Test Case------------");
	}
	//--------------------send money---------------------------------------------------------------------------
	
	@Test
	public void TC_09_Payees_Send_Money_Amount_Success() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Send Amount to Payee with valid amount Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Payees_Screen();
		
		PayeesPage pp=new PayeesPage(driver);
		pp.navigate_send_money(commonproperties.getProperty("test.payee.name"));
		pp.Send_Money_to_Payees("1");
		pp.Verify_Send_Money_Success();
		
		dp.Check_All_Alerts();
		
		System.out.println("------------Finished Send Amount to Payee with valid amount Test Case------------");
	}
	
	//-----------------------Receive Money-----------------------------------------------------------------------
	@Test
	public void TC_12_Payees_Request_Money_Amount_Success() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Request Amount to Payee with valid amount Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Payees_Screen();
		
		PayeesPage pp=new PayeesPage(driver);
		pp.navigate_request_money(commonproperties.getProperty("test.payee.name"));
		
		pp.Request_Money_to_Payee("1");
		pp.Verify_Request_Money_Success();
		
		dp.Check_All_Alerts();
	
		System.out.println("------------Finished Request Amount to Payee with valid amount Test Case------------");
	}
	
	//-----------------------Delete Payee -------------------------------------------------------------------------------
	@Test
	public void TC_30_W2B_Payees_Delete_Payee_Valid_MobileNumber() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Deleted W2B Payee with valid mobile number Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Payees_Screen();
		
		PayeesPage pp=new PayeesPage(driver);
		pp.Delete_Payee(commonproperties.getProperty("test.payee.rename"), commonproperties.getProperty("test.pin"));
		//pp.Verify_Delete_Payee_Success_Popup();
		
		System.out.println("------------Finished Deleted W2B Payee with valid mobile number Test Case------------");
	}
	
	//---------------------------------Send Money--------------------------------------------------------------------
	@Test
	public void TC_05_Send_Money_Mobile_Valid_Details_Success() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Send Money with valid details Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_SendMoney_Screen();
		
		SendMoneyPage sp=new SendMoneyPage(driver);
		sp.Send_Money_Details(commonproperties.getProperty("test.payee.mobilenumber"), "1","No");
		sp.Verify_Send_Money_Send_Success();
		
		dp.Check_All_Alerts();

		System.out.println("------------Finished Send Money with valid details Test Case------------");
	}
	
	//----------------------------------Request Money------------------------------------------------------------------
	
	@Test
	public void TC_11_Request_Money_Mobile_Valid_Details_Success() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Request Money with valid details Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_SendMoney_Screen();
		
		SendMoneyPage sp=new SendMoneyPage(driver);
		sp.Request_Money_Details(commonproperties.getProperty("test.payee.mobilenumber"), "1","No");
		sp.Verify_Send_Money_Request_Success();
		
		dp.Check_All_Alerts();

		System.out.println("------------Finished Request Money with valid details Test Case------------");
	}
	
	//--------------------------------Send Money_BAnk---------------------------------------------------------------------
	@Test
	public void TC_20_Verify_Send_Money_Bank_Success() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Verify Send Money Wallet to Bank Success Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_SendMoney_Screen();
		
		SendMoneyPage sp=new SendMoneyPage(driver);
		sp.Send_Money_Bank("Anusha", "123456789", "HDFC0000021", "100");
		sp.Enter_ViolaPIN(commonproperties.getProperty("test.settings.vpin"));
		sp.Verify_Wallet_Bank_Convenience_Fees(commonproperties.getProperty("test.convenience.fee"));
		sp.Payment_Details_Proceed_Button().click();
		//sp.Verify_Wallet_Bank_Success();
		
		dp.Check_All_Alerts();
		
		System.out.println("------------Finished Verify Send Money Wallet to Bank Success Test Case------------");
	}
	//------------------Triple click-------------------------------------------------------------------------------
	@Test
	public void TC_02_TripleClik_Payee_Add_Delete_Save_To_TripleClik() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Payee adding and deleting to TripleClik using Save to TripleClik option Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Payees_Screen();
		
		PayeesPage pp=new PayeesPage(driver);
		pp.Payees_Add_Payee_W2W(commonproperties.getProperty("test.payee.mobilenumber"), commonproperties.getProperty("test.payee.name"),"Yes", commonproperties.getProperty("test.settings.vpin"));
		pp.Entering_ViolaPIN(commonproperties.getProperty("test.settings.vpin"));
		//pp.Verify_Add_Payee_Success();
		
		dp.Navigate_TripleClik_Screen();
		
		TripleClikPage tp=new TripleClikPage(driver);
		tp.Delete_Payee_TripleClik(commonproperties.getProperty("test.payee.name"));
		
		System.out.println("------------Finished Payee adding and deleting to TripleClik using Save to TripleClik option Test Case------------");
	}
	
	//-------------------------Tripleclick Amount Success-----------------------------------------------------------------
	
	@Test
	public void TC_08_TripleClik_Payee_Pay_Amount_Success() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started TripleClik Payee Pay success Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_TripleClik_Screen();
		
		TripleClikPage tp=new TripleClikPage(driver);
		tp.Payee_Pay(commonproperties.getProperty("test.payee.name"), 50);
		tp.TripleClik_Payee_Pay_success();
		
		dp.Check_All_Alerts();
		
		System.out.println("------------Finished TripleClik Payee Pay success Test Case------------");
	}
	//-----------------------Tripleclick Delete-------------------------------------------------------------------------------
	@Test
	public void TC_09_TripleClik_Payee_Delete() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Payee deleting from TripleClik and Payee Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_TripleClik_Screen();
		
		TripleClikPage tp=new TripleClikPage(driver);
		tp.Delete_Payee_TripleClik(commonproperties.getProperty("test.payee.name"));
		
		dp.Navigate_Dashboard_Screen();
		
		dp.Navigate_Payees_Screen();
		
		PayeesPage pp=new PayeesPage(driver);
		pp.Delete_Payee(commonproperties.getProperty("test.payee.name"), commonproperties.getProperty("test.settings.vpin"));
		//pp.Verify_Delete_Payee_Success_Popup();
		
		System.out.println("------------Finished Payee deleting from TripleClik and Payee Test Case------------");
	}
	
	//---------------------Help------------------------------------------------------------------------------------------------
	@Test
	public void TC_01_Help_Options_Screen() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Help Options is displayed Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Help_Screen();
		
		HelpPage hp=new HelpPage(driver);
		hp.Verify_Help_Options();
		
		System.out.println("------------Finished Help Options is displayed Test Case------------");
	}
	
	@Test
	public void TC_02_Help_Chat_Screen() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Chat screen is displayed Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Help_Screen();
		
		HelpPage hp=new HelpPage(driver);
		hp.Verify_Help_Options();
		hp.navigate_chat();		
//		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=' Live Chat']")));

		System.out.println("------------Finished Chat screen is displayed Test Case------------");
	}
	
	@Test
	public void TC_03_Blog_Screen() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Blog screen is displayed Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Help_Screen();
		
		HelpPage hp=new HelpPage(driver);
		hp.Verify_Help_Options();		
		hp.navigate_Blog();
		
		System.out.println("------------Finished Blog screen is displayed Test Case------------");
	}
	
	@Test
	public void TC_04_Demo_Screen() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Demo screen is displayed Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Help_Screen();
		
		HelpPage hp=new HelpPage(driver);
		hp.Verify_Help_Options();		
		hp.navigate_Demo();
		
		System.out.println("------------Finished Demo screen is displayed Test Case------------");
	}
	
	@Test
	public void TC_05_Email_Screen() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Email is navigating Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Help_Screen();
		
		HelpPage hp=new HelpPage(driver);
		hp.Verify_Help_Options();		
		hp.navigate_email();
		
		System.out.println("------------Finished Email is navigating Test Case------------");
	}
	
	@Test
	public void TC_06_Terms_Conditions_Screen() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Terms and Conditions is displayed Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Help_Screen();
		
		HelpPage hp=new HelpPage(driver);
		hp.Verify_Help_Options();		
		hp.navigate_terms_conditions();
		
		System.out.println("------------Finished Terms and Conditions is displayed Test Case------------");
	}
	
	@Test
	public void TC_07_FAQs_Screen() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started FAQ`s is displayed Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Help_Screen();
		
		HelpPage hp=new HelpPage(driver);
		hp.Verify_Help_Options();		
		hp.navigate_FAQ();
		
		System.out.println("------------Finished FAQ`s is displayed Test Case------------");
	}
	
	@Test
	public void TC_12_Assist_Create_Request_Open_Screen() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Create Request with valid details is displayed Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_Help_Screen();
		
		HelpPage hp=new HelpPage(driver);
		hp.Verify_Help_Options();		
		hp.navigate_Assist();
		hp.Assist_Create_Request("KYC", "Profile pic8 not working", "Testing message8");
		hp.Verify_Create_Request_Success();
		hp.Request_Check_Status_Open_Close("Testing message8");
		
		System.out.println("------------Finished Create Request with valid details Test Case------------");
	}
	//----------------------Alerts------------------------------------------------------------------------------------
	@Test
	public void TC_01_Verify_TopUp_AlertMessage() throws MalformedURLException, InterruptedException {
		System.out.println("------------Started Verify Topup message and status in Alerts Test Case------------");
		
		DashboardPage dp=new DashboardPage(driver);
		dp.Verify_Dashboard_Screen();
		dp.Navigate_TopUp_Screen();
		
		TopupPage tp=new TopupPage(driver);
		tp.Entering_Amount("50");
		tp.Verify_TopUp_AddMoney_Screen();
		tp.Add_Money_Netbaking("Y");
		
		dp.Navigate_Alerts_Screen();
		
		AlertsPage ap=new AlertsPage(driver);
		ap.Verify_Alert_Message("Topup of Rs.");
		ap.Verify_Alert_Status("Success");
		
		System.out.println("------------Finished Verify Topup message and status in Alerts Test Case------------");
	}
	//------------------------Wallet---------------------------------------------------------------------------------
		@Test
		public void TC_07_Verify_Wallet_View_All_Transactions() throws MalformedURLException, InterruptedException {
			System.out.println("------------Started Verify all the transactions in the Wallet Test Case------------");
			
			DashboardPage dp=new DashboardPage(driver);
			dp.Verify_Dashboard_Screen();
			dp.Navigate_Wallet_Screen();
			
			WalletPage wp=new WalletPage(driver);
			wp.Navigate_Wallet_Transaction_History();
			
			System.out.println("------------Finished Verify all the transactions in the Wallet Test Case------------");
		}
		
		//-------------------Mobile -----------------------------------------------------------------------------
		//-------------------Prepaid--------------------------------------------------------------------------------
		@Test
		public void TC_05_Verify_Prepaid_Recharge_Success() throws MalformedURLException, InterruptedException {
			System.out.println("------------Started Verify Prepaid Recharge with valid details Test Case------------");
			
			DashboardPage dp=new DashboardPage(driver);
			dp.Verify_Dashboard_Screen();
			dp.Navigate_Recharge_Mobile();
			
			PrepaidRechargePage pr=new PrepaidRechargePage(driver);
			pr.Recharge_Details("Prepaid", "7893343018", "100",commonproperties.getProperty("test.pin"),"Jio Prepaid");
			pr.Verify_Recharge_Payment_Success();
			
			System.out.println("------------Finished Verify Prepaid Recharge with valid details Test Case------------");
		}
		//-------------------Postpaid------------------------------------------------------------------------------------
		@Test
		public void TC_08_Verify_Postpaid_Recharge_Success() throws MalformedURLException, InterruptedException {
			System.out.println("------------Started Verify Postpaid recharge with valid details Test Case------------");
			
			DashboardPage dp=new DashboardPage(driver);
			dp.Verify_Dashboard_Screen();
			dp.Navigate_Recharge_Mobile();
			
			PrepaidRechargePage pr=new PrepaidRechargePage(driver);
			pr.Entering_Recharge_details("Postpaid", "9819653501 ", "","");
			pr.Verify_Mobile_Operators_Screen();
			pr.Entering_Operator_Amount("Vodafone Postpaid");
			
			
			
			System.out.println("------------Finished Verify Verify Postpaid recharge with valid details Test Case------------");
		}
		//-----------------DTH-----------------------------------------------------------------------------------------------
		@Test
		public void TC_07_Verify_DTH_Recharge_Success() throws MalformedURLException, InterruptedException {
			System.out.println("------------Started Verify DTH Recharge with Valid Subscriber ID Test Case------------");
			
			DashboardPage dp=new DashboardPage(driver);
			dp.Verify_Dashboard_Screen();
			dp.Navigate_Recharge_DTH();
			
			DTHRechargePage dr=new DTHRechargePage(driver);
			dr.DTH_Recharge_Details("Tatasky DTH", "1209757481", "100");
			//dr.Entering_Viola_PIN(commonproperties.getProperty("test.pin"));
			//dr.Verify_Payment_Details_Screen();
			//dr.Verify_Recharge_Payment_Success();
			
			System.out.println("------------Finished Verify DTH Recharge with Valid Subscriber ID Test Case------------");
		}
		//---------------Electricity------------------------------------------------------------------------------------------
		@Test
		public void TC_05_Verify_Electricity_Pay_Success() throws MalformedURLException, InterruptedException {
			System.out.println("------------Started Verify payment success Test Case------------");
			
			DashboardPage dp=new DashboardPage(driver);
			dp.Verify_Dashboard_Screen();
			dp.Navigate_Electricity_Pay();
			
			ElectricityPayPage ep=new ElectricityPayPage(driver);
			ep.Electricity_Pay("Assam Power Distribution Company Ltd (APDCL RAPDR)", "11000059552");
			//ep.Verify_Electricity_Bill_Success(commonproperties.getProperty("test.pin"));
			
			System.out.println("------------Finished  Verify payment success Test Case------------");
		}
		//----------------Gas------------------------------------------------------------------------------------------------
		@Test
		public void TC_05_Verify_Gas_Pay_Success() throws MalformedURLException, InterruptedException {
			System.out.println("------------Started Verify Billable Info is fetched Test Case------------");
			
			DashboardPage dp=new DashboardPage(driver);
			dp.Verify_Dashboard_Screen();
			dp.Navigate_Gas_Pay();
			
			GasPayPage gp=new GasPayPage(driver);
			ElectricityPayPage ep=new ElectricityPayPage(driver);
			gp.Gas_Pay("MAHANAGAR GAS LIMITED", "210000344861");
			ep.Pay_Button().click();
			//ep.Verify_Electricity_Bill_Success("9427");
			
			System.out.println("------------Finished Verify Billable Info is fetched Test Case------------");
		}
		//---------------Broadband----------------------------------------------------------------------------------------------
		@Test
		public void TC_05_Verify_Broadband_Pay_Success() throws MalformedURLException, InterruptedException {
			System.out.println("------------Started Verify Billable Info is fetched Test Case------------");
			
			DashboardPage dp=new DashboardPage(driver);
			dp.Verify_Dashboard_Screen();
			dp.Navigate_BroadBand_Pay();
			
			BroadbandPayPage bp=new BroadbandPayPage(driver);
			//ElectricityPayPage ep=new ElectricityPayPage(driver);
			bp.Broadband_Pay("ACT FIBERNET", "sarancruzer@gmail.com");
			//ep.Pay_Button().click();
			//ep.Verify_Electricity_Bill_Success(commonproperties.getProperty("test.pin"));
			
			System.out.println("------------Finished Verify Billable Info is fetched Test Case------------");
		}
		
	//------------------Insurance-------------------------------------------------------------------------------------
		@Test
		public void TC_03_Verify_BroadBand_Pay_Invalid_Error() throws MalformedURLException, InterruptedException, ParseException {
			System.out.println("------------Started Verify invalid error message with invalid details Test Case------------");
			
			DashboardPage dp=new DashboardPage(driver);
			dp.Verify_Dashboard_Screen();
			dp.Navigate_Insurance_Pay();
			
			InsurancePayPage ip=new InsurancePayPage(driver);
			ip.Insurance_Pay("ICICI Prudential Life Insurance Ltd", "21406071","01 December 2013");
					
			System.out.println("------------Finished Verify invalid error message with invalid details Test Case------------");
		}
		//----------LandLine----------------------------------------------------------------------------------------
		@Test
		public void TC_03_Verify_Landline_Pay_Landline_Invalid_Error() throws MalformedURLException, InterruptedException, ParseException {
			System.out.println("------------Started Verify Landline Number error message with invalid value Test Case------------");
			
			DashboardPage dp=new DashboardPage(driver);
			dp.Verify_Dashboard_Screen();
			dp.Navigate_Landline();
			
			LandlinePayPage lp=new LandlinePayPage(driver);
			lp.Landline_Pay("Airtel Landline", "1234567890");
			lp.Verify_Landline_Telephone_Number_Invalid();
			
			System.out.println("------------Finished Verify Landline Number error message with invalid value Test Case------------");
		}
		//--------Water---------------------------------------------------------------------------------------------------
		@Test
		public void TC_04_Verify_Water_Pay_Success() throws MalformedURLException, InterruptedException, ParseException {
			System.out.println("------------Started Verify Water Payment with valid value Test Case------------");
			
			DashboardPage dp=new DashboardPage(driver);
			dp.Verify_Dashboard_Screen();
			dp.Navigate_Water();
			
			WaterPayPage wp=new WaterPayPage(driver);
			wp.Water_Pay("Uttarakhand Jal Sansthan", "MU14MUM01M24N010807761");

			
			System.out.println("------------Finished Verify Water Payment with valid value Test Case------------");
		}
		//---------------Loan------------------------------------------------------------------------------------------------
		@Test
		public void TC_03_Verify_Loan_Pay_Success() throws MalformedURLException, InterruptedException, ParseException {
			System.out.println("------------Started Verify Loan pay with valid value Test Case------------");
			
			DashboardPage dp=new DashboardPage(driver);
			dp.Verify_Dashboard_Screen();
			dp.Navigate_Loan();
			
			LoanPayPage lp=new LoanPayPage(driver);
			lp.Loan_Pay("567000840");
			
			
			System.out.println("------------Finished Verify Loan pay with valid value Test Case------------");
		}
		
		//-----------Tax----------------------------------------------------------------------------------------------------
		@Test
		public void TC_04_Verify_Tax_Pay_Success() throws MalformedURLException, InterruptedException, ParseException {
			System.out.println("------------Started Verify Tax Number with valid value Test Case------------");
			
			DashboardPage dp=new DashboardPage(driver);
			dp.Verify_Dashboard_Screen();
			dp.Navigate_Tax();
			
			TaxPayPage tp=new TaxPayPage(driver);
			tp.Tax_Pay("O/P/22/0000050");
						
			System.out.println("------------Finished Verify Tax Number with valid value Test Case------------");
		}
		//----------Bus---------------------------------------------------------------------------------------------------
		@Test
		public void TC_01_Verify_Bus_Booking_From_To_Same() throws MalformedURLException, InterruptedException {
			System.out.println("------------Started Verify Bus booking cities is same as entered Test Case------------");
			
			DashboardPage dp=new DashboardPage(driver);
			dp.Verify_Dashboard_Screen();
			dp.Navigate_Bus_Book();
			
			BusBookPage bp=new BusBookPage(driver);
			bp.Book_Bus_Ticket("Bangalore", "Hyderabad","11 December 2018");
			bp.Verify_From_To_Cities("Bangalore", "Hyderabad");	
			
			System.out.println("------------Finished Verify Bus booking cities is same as entered Test Case------------");
		}
		//----------Rental-----------------------------------------------------------------------------------------------
		@Test
		public void TC_04_Verify_Rental_Pay_Invalid_Error() throws MalformedURLException, InterruptedException, ParseException {
			System.out.println("------------Started Verify invalid error message with invalid values Test Case------------");
			
			DashboardPage dp=new DashboardPage(driver);
			dp.Verify_Dashboard_Screen();
			dp.Navigate_Rental();
			
			RentalPayPage rp=new RentalPayPage(driver);
			rp.Rental_Pay("ID1234", "abc@gmail.com");
			//rp.Verify_Rental_Pay_Invalid();
									
			System.out.println("------------Finished Verify invalid error message with invalid values Test Case------------");
		}	

}
