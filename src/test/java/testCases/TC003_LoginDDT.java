package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	@Test(dataProvider = "LoginData",dataProviderClass =DataProviders.class,groups = "Datadriven")
	public void verify_loginDDT(String email,String pass,String exp)
	{
		logger.info("****** Starting TC003_loginDDT ******");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin(); 
		
		AccountLoginPage lp=new AccountLoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pass);
		lp.clickLogin();
		
		MyAccountPage maccp=new MyAccountPage(driver);
		boolean targetPage=maccp.isMyAccountPageExists();
		
		 if(exp.equalsIgnoreCase("Valid"))
		 {
			 if(targetPage==true)
			 {
				 maccp.clicklogout();
				 Assert.assertTrue(true);	 
			 }
			 else
			 {
				 Assert.assertTrue(false);
			 }
			 
		 }
		 if(exp.equalsIgnoreCase("Invalid"))
		 {
			 if(targetPage==true)
			 {
				 maccp.clicklogout();
				 Assert.assertTrue(false);	 
			 } 
			 else
			 {
				 Assert.assertTrue(true);
			 }
		 }
		}catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("****** Finished TC003_loginDDT ******");
	}
}
