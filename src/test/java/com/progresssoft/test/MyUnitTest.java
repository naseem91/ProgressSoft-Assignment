package com.progresssoft.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.progresssoft.controller.RequestValidation;

class MyUnitTest {


	/**
	 * Create two test sceanario to check Currency
	 */
	@Test
	public void TestCurrency() {
		String myCurrency="USD";
		boolean result= RequestValidation.checkCurrency(myCurrency);
		assertEquals(true, result);
	}
	
	@Test
	public void TestCurrency2() {
		String myCurrency="SA2";
		boolean result= RequestValidation.checkCurrency(myCurrency);
		assertEquals(false, result);
	}
	/**
	 * Create two test sceanario to check Date 
	 */
	@Test
	public void checkDate() {
		String myDate="8/90/2020";
		boolean result = RequestValidation.isDateValid(myDate);
		assertEquals(false, result);		
	}
	
	@Test
	public void checkDate2() {
		String myDate="8/9/2020";
		boolean result = RequestValidation.isDateValid(myDate);
		assertEquals(false, result);		
	}
}
