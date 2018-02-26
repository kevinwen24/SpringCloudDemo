package com.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class DateUtil {

	private static Map<Integer, String> monthMap = new HashMap<Integer, String>();

	static {
		monthMap.put(1, "January");
		monthMap.put(2, "February");
		monthMap.put(3, "March");
		monthMap.put(4, "April");
		monthMap.put(5, "May");
		monthMap.put(6, "June");
		monthMap.put(7, "July");
		monthMap.put(8, "August");
		monthMap.put(9, "September");
		monthMap.put(10, "October");
		monthMap.put(11, "November");
		monthMap.put(12, "December");
	}

	public static List<String> getRecentMonth(int count) {
		List<String> recentMonth = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		for (int i = count; i >= 1; i--) {
			if ((currentMonth - i) < 0) {
				recentMonth.add(monthMap.get(13 + currentMonth - i));
			} else {
				recentMonth.add(monthMap.get(currentMonth - i + 1));
			}
		}
		return recentMonth;
	}

	public static int getMonthNumber(Date startDate, Date endDate) {
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);
		int startYear = startCalendar.get(Calendar.YEAR);
		int starMonth = startCalendar.get(Calendar.MONTH);
		int endYear = endCalendar.get(Calendar.YEAR);
		int endMonth = endCalendar.get(Calendar.MONTH);

		int monthNumber = (endYear - startYear) * 12 + endMonth - starMonth;
		return monthNumber;
	}

	/**
	 * Get 00:00:00 and 23:59:59 yesterday.
	 * 
	 * @return
	 */
	public static Date[] getYesterdayBeginAndEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.MILLISECOND, 0);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date start = calendar.getTime();

		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date end = calendar.getTime();

		return new Date[] { start, end };
	}

	/**
	 * Get 00:00:00 and 23:59:59 today.
	 * 
	 * @return
	 */
	public static Date[] getTodayBeginAndEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MILLISECOND, 0);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date start = calendar.getTime();

		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date end = calendar.getTime();

		return new Date[] { start, end };
	}

	public static Date[] getSpecialTimeZoneUTCBeginAndEnd(Integer offset) {
		if (null == offset) {
			offset = 0;
		}
		Date timeZone = getSpecialTimeZoneDate(offset);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(timeZone);
		calendar.set(Calendar.MILLISECOND, 0);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.HOUR_OF_DAY, -offset);
		Date start = calendar.getTime();

		calendar = Calendar.getInstance();
		calendar.setTime(timeZone);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.add(Calendar.HOUR_OF_DAY, -offset);
		Date end = calendar.getTime();

		return new Date[] { start, end };
	}

	public static Date getSpecialTimeZoneDate(Integer offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, offset == null ? 0 : offset.intValue());
		return calendar.getTime();
	}

	public static int getDateNumber(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.US);
		String ds = sdf.format(dt);
		return Integer.parseInt(ds);
	}

	public static String getDateString(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ds = sdf.format(dt);
		return ds;
	}

	public static String getDateString(Date dt, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String ds = sdf.format(dt);
		return ds;
	}

	public static String getYesterDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		Date dt = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ds = sdf.format(dt);
		return ds;
	}

	public static Date getMin(Date d1, Date d2) {
		return d1.before(d2) ? d1 : d2;
	}

	public static Date getMax(Date d1, Date d2) {
		return d1.after(d2) ? d1 : d2;
	}

	public static Date getLastSunday() {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		calendar.add(Calendar.DATE, 1 - dayOfWeek);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date getLastMonday() {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		calendar.add(Calendar.DATE, -5 - dayOfWeek);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date getMonthBeforeCurrentDay(int n) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -n);
		return c.getTime();
	}

	public static Date getLastYearDay(int n) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -n);
		return c.getTime();
	}

	public static Date getDeadline(int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1 - day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static int getDayNumber(Date startDate, Date endDate) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(startDate);
		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
		aCalendar.setTime(endDate);
		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
		return day2 - day1;
	}

	public static String[] getStringDateArrays(Date startDate, Date endDate) {
		Date[] dates = getDateArrays(startDate, endDate);
		String[] strDate = new String[dates.length];
		for (int i = 0; i < dates.length; i++) {
			strDate[i] = getDateString(dates[i]);
		}
		return strDate;
	}

	public static Date[] getDateArrays(Date startDate, Date endDate) {
		ArrayList<Date> ret = new ArrayList<Date>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(endDate);

		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDate = calendar.getTime();
		calendar.setTime(startDate);

		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		startDate = calendar.getTime();
		Date tmpDate = calendar.getTime();
		long endTime = endDate.getTime();
		while (tmpDate.before(endDate) || tmpDate.getTime() == endTime) {
			ret.add(calendar.getTime());
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			tmpDate = calendar.getTime();
		}
		Date[] dates = new Date[ret.size()];
		ret.toArray(dates);
		return dates;
	}

	/**
	 * Parse filterDate in the pages.
	 * 
	 * @param filterDate
	 * @return Date[] contains startDate,endDate
	 */
	public static Date[] parseFilterDate(String filterDate) {
		Date startDate = null;
		Date endDate = null;
		Date[] dates = null;
		if (null == filterDate || "".equals(filterDate)) {

		} else {
			dates = new Date[2];
			try {
				String[] filterDates = filterDate.split("-");
				String d1 = filterDates[0].trim();
				String d2 = filterDates[1].trim();
				SimpleDateFormat in = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
				startDate = in.parse(d1);
				endDate = in.parse(d2);
				dates[0] = startDate;
				dates[1] = endDate;

			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}

		}
		return dates;
	}

	public static Date parseDate(String Date) {
		Date startDate = null;
		if (null != Date) {
			try {
				SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
				startDate = in.parse(Date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return startDate;
	}
	
	public static Date parseStringToDate(String Date) {
		Date startDate = null;
		if (null != Date) {
			try {
				SimpleDateFormat in = new SimpleDateFormat("yyyy/MM/dd");
				startDate = in.parse(Date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return startDate;
	}

	public static Date parseDay(String Date) {
		Date startDate = null;
		try {
			SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			startDate = in.parse(Date + " 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return startDate;
	}

	public static Date parseEndDay(String Date) {
		Date endDate = null;
		try {
			SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			endDate = in.parse(Date + " 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return endDate;
	}

	public static String getStringTime() {
		SimpleDateFormat in = new SimpleDateFormat("yyyyMMddHHmmss");
		return in.format(new Date());
	}

	public static Date parseStartDay(String Date) {
		Date startDate = null;
		try {
			SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			startDate = in.parse(Date + " 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return startDate;
	}

	public static String[] getStringDateArrays(String startDate, String endDate) {
		Date startTime = parseDate(startDate);
		Date endTime = parseDate(endDate);
		Date[] dates = getDateArrays(startTime, endTime);
		String[] strDate = new String[dates.length];
		for (int i = 0; i < dates.length; i++) {
			strDate[i] = getDateString(dates[i]);
		}
		return strDate;
	}

	/*public static Date getPreviousMonthStartDate() {
		int startDate = 1;
		startDate = Integer.parseInt(Props.getInstance().getString("monthStartDate", null));
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, startDate);
		lastDate.add(Calendar.MONTH, -1);
		lastDate.set(Calendar.HOUR_OF_DAY, 0);
		lastDate.set(Calendar.MINUTE, 0);
		lastDate.set(Calendar.SECOND, 0);
		Date startTime = lastDate.getTime();
		return startTime;
	}

	public static Date getPreviousMonthEndDate() {
		int startDate = 1;
		startDate = Integer.parseInt(Props.getInstance().getString("monthStartDate", null));
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, startDate);
		lastDate.add(Calendar.MONTH, -1);
		lastDate.set(Calendar.HOUR_OF_DAY, 0);
		lastDate.set(Calendar.MINUTE, 0);
		lastDate.set(Calendar.SECOND, 0);
		Date startTime = lastDate.getTime();
		return startTime;
	}
*/
	public static Date getStartDate() {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 1900);
		date.set(Calendar.DATE, 1);
		date.set(Calendar.MONTH, 0);
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		Date startTime = date.getTime();
		return startTime;

	}

	public static Date getEndDate() {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 3000);
		date.set(Calendar.DATE, 1);
		date.set(Calendar.MONTH, 0);
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		Date endTime = date.getTime();
		return endTime;

	}

	public static Boolean isResetEnergyPoints(Date lastDate,Date nowDate) {
		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		String formatDate = in.format(lastDate);
		SimpleDateFormat in2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date startDate = null;
		try {
			startDate = in2.parse(formatDate + " 06:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date endDate = DateUtil.addOneDay(startDate);				
		return nowDate.after(endDate);
	}

	public static Date addOneDay(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		date = calendar.getTime();
		return date;
	}
	
	public static Date getPastServerDays(Integer days, Integer offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 0 - days);
		calendar.add(Calendar.HOUR_OF_DAY, offset == null ? 0 : offset.intValue());
		return calendar.getTime();
	}
}
