package com.example.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {

	public static void main(String[] args) {
        String dateStr = "2010-1-4 1:21:28";
        String dateStr2 = "2010-1-2 1:21:28";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try 
        {
            Date date2 = format.parse(dateStr2);
            Date date = format.parse(dateStr);
            
            System.out.println("两个日期的差距：" + differentDaysByMillisecond(date,date2));
        } catch (Exception e) {
			// TODO: handle exception
		}
        new Date().before(new Date());
        System.err.println(format.format(getPreviousMonth(new Date(),15)));
	}
	
	  public static int differentDaysByMillisecond(Date date1,Date date2)
	    {
	        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
	        return days;
	    }
	  
	  public static Date getPreviousMonth(Date date, int month) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int inputMonthOfYear = cal.get(Calendar.MONTH);
			System.out.println(inputMonthOfYear);
			cal.set(Calendar.MONTH, inputMonthOfYear - month);
			return cal.getTime();
		}
}
