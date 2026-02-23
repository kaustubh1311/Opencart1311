package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass {
	
	@Test(groups = {"Sanity","Master"})
	public void verify_account_login()
	{
		try {
		logger.info("****** Starting TC002Account_login_test ******");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		AccountLoginPage lp=new AccountLoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage maccp=new MyAccountPage(driver);
		Assert.assertEquals(maccp.isMyAccountPageExists(),true,"Login failed");
		}catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("**** Finished  TC002Account_login_test ****");
	}
}
