package com.ebus.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;


/**
 * Timestamp utilities
 */
public class Utilities {

	// ISO 8601 standard for handling timestamp (date, time, timezone)
	public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	public static String DEFAULT_TIME_ZONE = "UTC";

	public static String fromISO8601ToDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT,
				Locale.US);
		dateFormat.setTimeZone(TimeZone.getTimeZone(DEFAULT_TIME_ZONE = "UTC"));
		return dateFormat.format(date);
	}

	public static String getISO8601StringForCurrentDate() {
		Date now = new Date();
		return fromISO8601ToDate(now);
	}

	public static Date fromDateToISO8601(String isoString)
			throws ParseException {
		// DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Sample string value "2001-07-04T12:08:56.235-0700";
		return df.parse(isoString);
	}

	/**
	 * Convert String to Timestamp
	 */
	public static Timestamp fromStringToTimeStamp(String timeString){
		Date parsedDate = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try{
			if (timeString != null && !timeString.isEmpty()) {
				if (timeString.matches("\\d{4}-\\d{2}-\\d{2}")) {
					df = new SimpleDateFormat("yyyy-MM-dd");
				} else {
					df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				}
				parsedDate = df.parse(timeString);
			} else {
				parsedDate = df.parse(df.format(parsedDate));
			}
		}
		catch(ParseException pe){
			System.out.println("Error parsing current date: "+pe);
		}
		return new java.sql.Timestamp(parsedDate.getTime());
	}

	/**
	 * Get previous date from (current date - days)
	 */
	public static String getPrevDate(int days) throws ParseException {

		int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		String prevDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY
				* days);
		return prevDate;
	}

	/**
	 * Get previous time from (current time - hours)
	 */
	public static String getPrevTime(int hours) throws ParseException {

		int MILLIS_IN_HOUR = 1000 * 60 * 60;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		String prevTime = dateFormat.format(date.getTime() - MILLIS_IN_HOUR
				* hours);
		return prevTime;
	}

	/**
	 * Get start date from given month
	 */
	public static String getStartDate(String monthYear) throws ParseException {
		String month = monthYear.substring(0, 2);
		String year = monthYear.substring(2);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = dateFormat.parse(year + "/" + month + "/01");
		long time = date.getTime();
		Timestamp t = new Timestamp(time);
		return t.toString();
	}

	/**
	 * Get end date for the given month
	 */
	public static String getEndDate(String monthYear) throws ParseException {
		String month = monthYear.substring(0, 2);
		String year = monthYear.substring(2);
		String days = "0";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		if (month.contains("02")) {
			if (isLeapYear(Integer.parseInt(year))) {
				days = "29";
			} else {
				days = "28";
			}
		}
		if (month.contains("01") || month.contains("03")
				|| month.contains("05") || month.contains("07")
				|| month.contains("08") || month.contains("10")
				|| month.contains("12")) {
			days = "31";
		} else if (month.contains("04") || month.contains("06")
				|| month.contains("09") || month.contains("11")) {
			days = "30";
		}
		Date date = dateFormat.parse(year + "/" + month + "/" + days);
		long time = date.getTime();
		Timestamp t = new Timestamp(time);
		return t.toString();
	}

	/**
	 * To check if the year is leap year
	 */
	public static boolean isLeapYear(int year) {
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Convert Timestamp to String
	 */
	public static String fromTimestampToString(Timestamp timeStamp) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date newDate = new Date();
		if(timeStamp != null) {
		try {
			newDate = format.parse(timeStamp.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		return format.format(newDate);
	}

	/**
	 * Convert String to Timestamp
	 */
	public static Time fromStringToTime(String timeString)
			throws ParseException {
		Date parsedDate = new Date();
		DateFormat df = new SimpleDateFormat("hh:mm:ss");
		if (timeString != null && !timeString.isEmpty()) {
			df = new SimpleDateFormat("hh:mm:ss");
			parsedDate = df.parse(timeString);
		} else {
			parsedDate = df.parse(df.format(parsedDate));
		}
		return new java.sql.Time(parsedDate.getTime());
	}

	/**
	 * Convert String to Timestamp
	 */
	public static Date fromStringToDate(String dateString) {
		if (dateString == null)
			return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(dateFormat.parse(dateString));
		} catch (ParseException e) {
			return null;
		}
		return cal.getTime();
	}

	/**
	 * Convert Time to String
	 */
	public static String fromTimeToString(Time time) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date newDate = new Date();
		try {
			newDate = format.parse(time.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return format.format(newDate);
	}

	/**
	 * date format
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * Convert Date to String
	 */
	public static String fromDateToString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"E MMM dd HH:mm:ss Z yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		String date2 = null;
		try {
			date2 = formatter2.format(formatter.parse(date.toString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date2;
	}
	
	public static Timestamp LocalToUTC(Timestamp timeStamp, String timeZone) {
		if (timeZone != null && !timeZone.isEmpty()) {
			SimpleDateFormat sdfgmt = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			sdfgmt.setTimeZone(TimeZone.getTimeZone(timeZone));

			SimpleDateFormat sdfmad = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			sdfmad.setTimeZone(TimeZone.getTimeZone("UTC"));

			Date inptdate = null;
			try {
				inptdate = sdfgmt.parse(timeStamp.toString());
				inptdate = sdfmad.parse(sdfmad.format(inptdate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new java.sql.Timestamp(inptdate.getTime());
		} else {
			return timeStamp;
		}
	}

	public static Timestamp UTCToLocal(Timestamp timeStamp, String timeZone) {
		if (timeZone != null && !timeZone.isEmpty()) {
			SimpleDateFormat sdfgmt = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			sdfgmt.setTimeZone(TimeZone.getTimeZone("UTC"));

			SimpleDateFormat sdfmad = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			sdfmad.setTimeZone(TimeZone.getTimeZone(timeZone));

			Date inptdate = null;
			try {
				inptdate = sdfgmt.parse(timeStamp.toString());
				String date = sdfmad.format(inptdate);
				return fromStringToTimeStamp(date);

			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			return timeStamp;
		}

		return null;
	}

	public static Properties getProperties(String fileName) throws Exception {

		Properties properties = new Properties();
		InputStream stream = Utilities.class.getResourceAsStream(fileName);
		try {
			properties.load(stream);
		} catch (IOException e) {
			throw new RuntimeException(
					fileName + " must be present in classpath",
					e);
		} finally {
			stream.close();
		}
		return properties;
	}


	// Find A within B (do we really need this?)
	public static boolean contains(String A, String B) {
		A = A == null ? "" : A;
		B = B == null ? "" : B;

		return A.toLowerCase().contains(B.toLowerCase());
	}
	
	/*
	 * Get Basefile name from a URL
	 */
	/*public static String getBaseFileName(String url){
		// String url =
		// "https://s3.amazonaws.com/cloudly-fe/cloudly/5ef85f20-7006-48a0-a92f-1a52306569f3/vgene_1410415967834_schema.sql";

		String[] baseName = FilenameUtils.getBaseName(url).split("_");
		//String extension = FilenameUtils.getExtension(url);
		return baseName[0];
	} */
	
	/*
	 * Get Basefile name from a URL
	 */
	/*public static String getBaseFileNameWithExt(String url){
		// String url =
		// "https://s3.amazonaws.com/cloudly-fe/cloudly/5ef85f20-7006-48a0-a92f-1a52306569f3/vgene_1410415967834_schema.sql";

		String[] baseName = FilenameUtils.getBaseName(url).split("_");
		String extension = FilenameUtils.getExtension(url);
		
		return baseName[0]+extension;
	} */
	
	/*
	 * Get Extension from a URL
	 */
	/*public static String getExtension(String url){
		// String url =
		// "https://s3.amazonaws.com/cloudly-fe/cloudly/5ef85f20-7006-48a0-a92f-1a52306569f3/vgene_1410415967834_schema.sql";

		String extension = FilenameUtils.getExtension(url);
		return extension;
	} */
}