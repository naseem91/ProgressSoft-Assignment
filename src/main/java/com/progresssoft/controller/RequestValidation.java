package com.progresssoft.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;

/**
 * 
 * @author Naseem Adel
 *
 */
public class RequestValidation {
	
	final static String DATE_FORMAT = "dd/MM/yyyy";
	
	/**
	 * 
	 * @param curr
	 * @return true if the currency valid and false if it doesn't
	 */
	public static boolean checkCurrency(String curr) {
		for(Currency currency : Currency.getAvailableCurrencies()) {
			if(currency.getCurrencyCode().equals(curr))
				return true;
		}
	return false;
	}
	/**
	 * 
	 * @param date
	 * @return true if the data is vaild and false if it doesn't
	 */
	public static boolean isDateValid(String date) 
	{
	        try {
	            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	            df.setLenient(false);
	            df.parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	}

}
