package com.example.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DataTimeZoneTest {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:mmm");
		TimeZone timeZone = TimeZone.getTimeZone("UTC+1");
		simpleDateFormat.setTimeZone(timeZone);
		System.out.println(simpleDateFormat.format(date));
	}
}
