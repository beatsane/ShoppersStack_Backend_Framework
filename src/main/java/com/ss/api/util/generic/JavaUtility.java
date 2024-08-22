package com.ss.api.util.generic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author CHIDUSD
 */
public class JavaUtility {

	/**
	 * Generates a random number in the range of 0-5000
	 * 
	 * @return
	 */
	public int generateRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}

	/**
	 * Returns the system date in YYYY-MM-DD format
	 * 
	 * @return
	 */
	public String getSystemDateYYYY_MM_DD() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		String systemDate = simpleDateFormat.format(date);
		return systemDate;
	}
}
