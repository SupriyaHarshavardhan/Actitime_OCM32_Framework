package com.crm.vtiger.GenericUtils;

import java.util.Random;
import java.util.Date;

//import sun.util.calendar.BaseCalendar.Date;

/**
 * this class contains java specific generic libraries
 * @supriya
 */


public class JavaUtility {
	/**
	 * generate random number
	 * @supriya
	 */
	public String getRandomData()
	{
	Random random=new Random();
	int ran=random.nextInt(1000);
	return ""+ran;
	}
	
	/**
	 * Generate current system date
	 * @supriya
	 
	 */
	public String getCurrentSystemDate()
	{
		Date date=new Date();
		String currentDate=date.toString();
		return currentDate;
	}
	
}
