package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups = {"Regression","Master"})
	public  void verify_account_registration() throws Exception
	{
		
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("clicked on Register Link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("providing customer details...");
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com"); //generating random mail id
		regpage.setTelephone(randomNumber());
		
		String pwd=randomAlphaNumeric();
		regpage.setPassword(pwd);
		regpage.setPasswordConfirm(pwd);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message..");
		String confmsg=regpage.getConfirmationmsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed..");
			logger.debug("debug logs..");
			Assert.assertTrue(false);
		}
		}
		catch (Exception e)
		{
			logger.error("Test failed..");
			logger.debug("debug logs..");
			Assert.fail();
		}
		
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
	
	
}
