package Utilities;

import java.util.HashMap;

public class Hashmapexp {
	
	public static HashMap logincredentials()
	{
		HashMap<String,String> usercredentials=new HashMap<String,String> ();
		usercredentials.put("Employee","Priyanshua-Chetu@123");
		usercredentials.put("Admin","naveenautomation-test@123");
		return usercredentials;
		
	}
	
	public static HashMap Calender()
	{
		HashMap<Integer,String> months=new HashMap<Integer,String> ();
        months.put(1,"January");
        months.put(2,"February");
        months.put(3,"March");
        months.put(4,"April");
        months.put(5,"May");
        months.put(6,"June");
        months.put(7,"July");
        months.put(8,"August");
        months.put(9,"September");
        months.put(10,"October");
        months.put(11,"November");
        months.put(12,"December");
        return months;
	}
	
	

}
