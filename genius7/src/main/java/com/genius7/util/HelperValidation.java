package com.genius7.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;


public class HelperValidation {
	
	public static boolean isEmailValid(String email)
    {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
	
	public static String notNull(String value) {
		if(value == null) {
			return "";
		}
		return value;
	}
	
	public static boolean isEmpty(String value) {
		if(value == null || value.trim().isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static boolean hasValue(BigDecimal value) {
		if(value == null ) {
			return false;
		}else{
			if(value.doubleValue() == 0){
				return false;
			}
		}
		return true;
	}
	
	public static boolean hasValue(Long value) {
		if(value == null ) {
			return false;
		}else{
			if(value == 0){
				return false;
			}
		}
		return true;
	}
	
	public static boolean hasValue(Integer value) {
		if(value == null ) {
			return false;
		}else{
			if(value == 0){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isAValidID(Long id) {
		if(id == null ) {
			return false;
		}else{
			if(id <= 0){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if a CPF is valid.
	 * @param cpf
	 * @return
	 */
	public static boolean isCPFValide(String cpf) {
		try{
			cpf = new CPFFormatter().unformat(cpf);
			CPFValidator validator = new CPFValidator(false);
			validator.assertValid(cpf);
			return true;
		} catch (InvalidStateException e) { // exception lançada quando o documento é inválido
			System.out.println(e.getInvalidMessages());
			return false;
		}catch (IllegalArgumentException e) {
			System.err.println("is Valid CPF: "+e.getMessage());
			return false;
		}
	}
	
	
	
	/**
	 * Check if a list is empty or not.
	 * @param list
	 * @return
	 */
	public static boolean hasItem(@SuppressWarnings("rawtypes") List list) {
		if(list == null)return false;
		if(list.size() > 0){
			return true;
		}else{
			return false;
		}
	}

}
