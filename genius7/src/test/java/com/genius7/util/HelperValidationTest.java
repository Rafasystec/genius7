package com.genius7.util;

import static com.genius7.util.HelperValidation.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class HelperValidationTest {
	@Test
	public void deveVericarSeOEmialEValido() {
		
		if(HelperValidation.isEmailValid("rafasystec@yahoo.com.br")){
			System.out.println("Email valido");
		}else{
			System.out.println("Email invalido");
		}
		if(HelperValidation.isEmailValid("rafasystecyahoo.com")){
			System.out.println("Email valido");
		}else{
			System.out.println("Email invalido");
		}
		
	}
	
	@Test
	public void shouldAvoidNull() {
		String notNull = HelperValidation.notNull(null);
		assertNotNull(notNull);
		String sameString = HelperValidation.notNull("Same String");
		assertEquals("Same String", sameString);
	}
	@Test
	public void shoulValidateCPF() {
		boolean isValidate = HelperValidation.isCPFValide("15486737149");
		assertTrue(isValidate);
		boolean isInvalideCPF = HelperValidation.isCPFValide("00086737149");
		assertFalse(isInvalideCPF);
		isValidate = HelperValidation.isCPFValide("154.867.371-49");
		assertTrue(isValidate);
		isValidate = HelperValidation.isCPFValide("034.039.033-62");
		assertTrue(isValidate);
		isValidate = HelperValidation.isCPFValide("251544454");
		assertFalse(isValidate);
	}
	
	
	@Test
	public void Should_Validate_Empty_String() {
		boolean isEmpty = HelperValidation.isEmpty("");
		assertTrue(isEmpty);
		boolean isNull = HelperValidation.isEmpty(null);
		assertTrue(isNull);
		boolean isNotEmpty = HelperValidation.isEmpty("Valid String");
		assertFalse(isNotEmpty);
	}
	
	@Test
	public void Should_Validate_Decimal() {
		BigDecimal value = null;
		boolean isNull = HelperValidation.hasValue(value);
		assertFalse(isNull);
		value = new BigDecimal(0);
		boolean isZero = HelperValidation.hasValue(value);
		assertFalse(isZero);
		value = new BigDecimal(-0.05);
		boolean isNegative = HelperValidation.hasValue(value);
		assertTrue(isNegative);
	}
	
	@Test
	public void Should_Validate_Long() {
		Long value = null;
		boolean isNull = HelperValidation.hasValue(value);
		assertFalse(isNull);
		value = 0L;
		boolean isZero = HelperValidation.hasValue(value);
		assertFalse(isZero);
		value = -5L;
		boolean isNegative = HelperValidation.hasValue(value);
		assertTrue(isNegative);
	}
	
	@Test
	public void Should_Validate_Long_AS_ID() {
		Long value = null;
		boolean isNull = HelperValidation.isAValidID(value);
		assertFalse(isNull);
		value = 0L;
		boolean isZero = HelperValidation.isAValidID(value);
		assertFalse(isZero);
		value = -5L;
		boolean isNegative = HelperValidation.isAValidID(value);
		assertFalse(isNegative);
	}
	
	@Test
	public void should_verify_if_a_list_is_empty_or_not(){
		boolean hasItem = hasItem(null);
		assertFalse(hasItem);
		List<String> list = new ArrayList<String>();
		hasItem = hasItem(list);
		assertFalse(hasItem);
		List<String> notEmptyList = Arrays.asList("A","B","C");
		boolean shoulBeTrue = hasItem(notEmptyList);
		assertTrue(shoulBeTrue);
	}

}
