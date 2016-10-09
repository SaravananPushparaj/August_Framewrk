package Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Cart;

public class Scenario_Cart extends Base_Class {
	
	static Logger log=Logger.getLogger(Scenario_Cart.class);
	SoftAssert SAssert= new SoftAssert();
	
	@Test(dataProvider="dp_AddCart", dataProviderClass=DataProvider_Component.DataProvider_Cart.class)
	public void TestAddCart(String TC_ID, String Order, String Search_Item, String Quantity, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Testcase " +TC_ID +" Order is  "+Order);
		Start_Server();
		Init_app();
		
		PageObject_Cart BC_Pob= new PageObject_Cart(driver);
		
		Explicit_wait(BC_Pob.Search_btn, 25);
		BC_Pob.Click_Searchbtn();
		
		Explicit_wait(BC_Pob.Search_txtbox, 25);
		BC_Pob.Enter_Searchtxt(Search_Item);
		
		Explicit_wait(BC_Pob.Add_btn, 25);
		BC_Pob.Click_Addbtn();
		
		Explicit_wait(BC_Pob.Cart_img, 25);
		BC_Pob.Click_ImgCart();
		
		Explicit_wait(BC_Pob.AddCart_msg, 25);
		String Actual_Result = BC_Pob.getAddCartmsg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Expected Result is " +Exp_Result + " Actual Result is "+Actual_Result);
		}
		else
		{
			log.info("Failed as Expected Result is " +Exp_Result + " Actual Result is "+Actual_Result);
			SAssert.fail();
		}
		
		
		Stop_Server();
		SAssert.assertAll();
		
	}
	
	@Test(dataProvider="dp_DeleteCart", dataProviderClass=DataProvider_Component.DataProvider_Cart.class)
	public void TestDeleteCart(String TC_ID, String Order, String Search_Item, String Quantity, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Testcase " +TC_ID +" Order is  "+Order);
		Start_Server();
		Init_app();
		
		PageObject_Cart BC_Pob= new PageObject_Cart(driver);
		
		Explicit_wait(BC_Pob.Search_btn, 25);
		BC_Pob.Click_Searchbtn();
		
		Explicit_wait(BC_Pob.Search_txtbox, 25);
		BC_Pob.Enter_Searchtxt(Search_Item);
		
		Explicit_wait(BC_Pob.Add_btn, 25);
		BC_Pob.Click_Addbtn();
		
		Explicit_wait(BC_Pob.Cart_img, 25);
		BC_Pob.Click_ImgCart();
		
		Explicit_wait(BC_Pob.DeleteCart_btn, 25);
		BC_Pob.Click_Removebtn();
		
		Explicit_wait(BC_Pob.DeleteCart_msg, 25);
		String Actual_Result = BC_Pob.getDeleteCartmsg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Expected Result is " +Exp_Result + " Actual Result is "+Actual_Result);
		}
		else
		{
			log.info("Failed as Expected Result is " +Exp_Result + " Actual Result is "+Actual_Result);
			SAssert.fail();
		}
		
		
		Stop_Server();
		SAssert.assertAll();
		
	}

	
	
	
	
	

}
