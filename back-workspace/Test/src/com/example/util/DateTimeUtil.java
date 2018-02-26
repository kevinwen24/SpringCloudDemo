package com.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class DateTimeUtil {
	public static int STAR_YEAR = 1900;
	public static int MONTH_LAG = 1;

	public static Date convertToTimeZoneDate(Date date) {
		Date tempDate = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			format.setTimeZone(TimeZone.getDefault());
			String dateStr = format.format(date);
			tempDate = format.parse(dateStr);
		} catch (ParseException e) {
			System.out.println("incorrect date format:" + date);
		}
		return tempDate;
	}

	public static Date convertToServerDate(double timeLag, String date) {
		Calendar newCal = Calendar.getInstance();
		Date tempDate = convertStringToDateTime(date);
		newCal.setTime(tempDate);
		int hour = (int) Math.floor(timeLag);
		int min = (int) ((timeLag - hour) * 60);

		int transHour = newCal.get(Calendar.HOUR_OF_DAY) + hour;
		int transMin = newCal.get(Calendar.MINUTE) + min;
		newCal.set(Calendar.HOUR_OF_DAY, transHour);
		newCal.set(Calendar.MINUTE, transMin);

		return newCal.getTime();
	}

	public static Date getPreviousDate(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int inputDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		cal.set(Calendar.DAY_OF_YEAR, inputDayOfYear - day);
		return cal.getTime();
	}
	
	public static Date getPreviousMonth(Date date, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int inputMonthOfYear = cal.get(Calendar.MONTH);
		cal.set(Calendar.MONTH, inputMonthOfYear - month);
		return cal.getTime();
	}
	
	public static Date getWeekDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        cal.set(Calendar.HOUR, 12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
	public static Date getDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
	public static int monthDiff(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			return 0;
		}
		Calendar newCal = Calendar.getInstance();
		newCal.setTime(startDate);
		int startYear = newCal.get(Calendar.YEAR);
		int startMonth = newCal.get(Calendar.MONTH);

		newCal.setTime(endDate);
		int endYear = newCal.get(Calendar.YEAR);
		int endMonth = newCal.get(Calendar.MONTH);
		return Math.abs(endMonth + Math.abs(endYear - startYear) * 12 - startMonth);
	}
	
	public static int dayDiff(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			return 0;
		}
		Long diffDay = (endDate.getTime() - startDate.getTime())/(1000*60*60*24);
		return diffDay.intValue();
	}

	public static Date makeMonthStartDate(Calendar calendar) {
		int startDate = 0;
		// startDate =
		// Integer.parseInt(ConfigProps.getInstance().getMonthEndDate());

		Calendar newCal = Calendar.getInstance();
		newCal.setTime(calendar.getTime());
		newCal.set(Calendar.DAY_OF_MONTH, startDate);
		newCal.set(Calendar.HOUR_OF_DAY, 0);
		newCal.set(Calendar.MINUTE, 0);
		newCal.set(Calendar.SECOND, 0);
		Date monthStartDate = newCal.getTime();
		return monthStartDate;
	}

	public static Date makeMonthEndDate(Calendar calendar) {
		int endDate = 0;
		// endDate =
		// Integer.parseInt(ConfigProps.getInstance().getMonthEndDate());
		Calendar newCal = Calendar.getInstance();
		newCal.setTime(calendar.getTime());
		newCal.set(Calendar.DAY_OF_MONTH, endDate);
		newCal.set(Calendar.HOUR_OF_DAY, 23);
		newCal.set(Calendar.MINUTE, 59);
		newCal.set(Calendar.SECOND, 59);
		Date monthEndDate = newCal.getTime();

		return monthEndDate;
	}
	
	public static Date makeMonthStartDate(Date date) {
		int startDate = 1;
		Calendar newCal = Calendar.getInstance();
		newCal.setTime(date);
		newCal.set(Calendar.DAY_OF_MONTH, startDate);
		newCal.set(Calendar.HOUR_OF_DAY, 0);
		newCal.set(Calendar.MINUTE, 0);
		newCal.set(Calendar.SECOND, 0);
		Date monthStartDate = newCal.getTime();
		return monthStartDate;
	}
	
	public static Date makeMonthEndDate(Date date) {
		int endDate = 0;
		Calendar newCal = Calendar.getInstance();
		Date end = getPreviousMonth(date, -1);
		newCal.setTime(end);
		newCal.set(Calendar.DAY_OF_MONTH, endDate);
		newCal.set(Calendar.HOUR_OF_DAY, 0);
		newCal.set(Calendar.MINUTE, 0);
		newCal.set(Calendar.SECOND, 0);
		Date monthEndDate = newCal.getTime();

		return monthEndDate;
	}
	public static String getDataByNow(int beforeDay){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();		
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, day - beforeDay);
        date = cal.getTime();
		String resultDay = simpleDateFormat.format(date);
		return resultDay;
	}

	public static Date convertStringToDateTime(String date) {
		Date tempDate = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			tempDate = simpleDateFormat.parse(date);
		} catch (Exception ex) {
			System.out.println("Incorrect date format:" + date);
		}
		return tempDate;
	}

	public static String convertDateToString(Date date) {
		String tempDate = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tempDate = simpleDateFormat.format(date);
		return tempDate;
	}
	
	public static List<Date> getReportDates(int[] days){
		Date date = getDate(new Date());
		List<Date> dates = new ArrayList<Date>();
		for(int a:days){
			Date d = getPreviousDate(date, a);
			dates.add(d);
		}
		return dates;
	}
	public static List<Date> getReportDates(int day, Date endDate){
		Date date = getDate(endDate);
		List<Date> dates = new ArrayList<Date>();
		for(int a = day;a >= 0;a--){
			Date d = getPreviousDate(date, a);
			dates.add(d);
		}
		return dates;
	}
	
	public static boolean judgeDate(Date a, Date b){
		Calendar aCal = Calendar.getInstance();
		aCal.setTime(a);
		Calendar bCal = Calendar.getInstance();
		bCal.setTime(b);
		int daya = aCal.get(Calendar.DAY_OF_YEAR);
		int dayb = bCal.get(Calendar.DAY_OF_YEAR);
		if(daya == dayb){
			return true;
		}
		return false;
	}
	
	public static String getDateString(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String ds = sdf.format(dt);
		return ds;
	}
	
	public static String getDateStringForList(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		String ds = sdf.format(dt);
		return ds;
	}
	
	public static Date getDateFromString(String date) {
		Date tempDate = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			tempDate = simpleDateFormat.parse(date);
		} catch (Exception ex) {
			System.out.println("Incorrect date format:" + date);
		}
		return tempDate;
	}
}
