package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_Cart {
	
	@DataProvider(name="dp_AddCart")
	public static Iterator<String[]> getAddCartdata() throws IOException
	{
		
		List<String[]> Obj = flagRowCount("AddCart");
		return Obj.iterator();
		
	}
	
	@DataProvider(name="dp_DeleteCart")
	public static Iterator<String[]> getDeleteCartdata() throws IOException
	{
		
		List<String[]> Obj = flagRowCount("DeleteCart");
		return Obj.iterator();
		
	}
	
	
	public static List<String[]> flagRowCount(String Scriptname ) throws IOException
	{
		ExcelReadWrite xl= new ExcelReadWrite("D:\\Aug_BB_Project\\TestData\\TestData.xls");
		HSSFSheet Scenario_Cart = xl.Setsheet("Scenario_Cart");
		
		int Rowcount = xl.getrowcount(Scenario_Cart);
		System.out.println(Rowcount);
		
		List<String[]> List_Cart= new ArrayList<String[]>();
		
		for( int xlrow=1;xlrow<=Rowcount;xlrow++)
		{
			String Execute_Flag = xl.Readvalue(Scenario_Cart, xlrow, "Execute_Flag");
			String Script_name = xl.Readvalue(Scenario_Cart, xlrow, "Script_name");
			
			if((Execute_Flag.equals("Y")) && (Script_name.equals(Scriptname)))
			{
				String [] arr_Cart= new String[5];
				
				arr_Cart[0]=xl.Readvalue(Scenario_Cart, xlrow, "TC_ID");
				arr_Cart[1]=xl.Readvalue(Scenario_Cart, xlrow, "Order");
				arr_Cart[2]=xl.Readvalue(Scenario_Cart, xlrow, "Search_Item");
				arr_Cart[3]=xl.Readvalue(Scenario_Cart, xlrow, "Quantity");
				arr_Cart[4]=xl.Readvalue(Scenario_Cart, xlrow, "Exp_Result");
				
				List_Cart.add(arr_Cart);
				
			}//end of if
			
		}//end of for loop
		
		return List_Cart;	
		
		
	}

}
