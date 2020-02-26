package com.surya.cards.validation;

public class CreditCardUtilValidator {
	
	public static boolean isvalidCreditCardNumber(String creditCardNumber)
	{
		if(null!=creditCardNumber 
				&& !creditCardNumber.trim().isEmpty() 
				&& !(creditCardNumber.trim().length()>19)
				&& !(creditCardNumber.trim().length()<10)
				&& creditCardNumber.trim().matches("^[0-9]*$")
				&& luhnCheck(creditCardNumber.trim()))
		{
			return true;
		}
		return false;
	}
	

	private static boolean luhnCheck(String card) {
		if (card == null)
			return false;
		char checkDigit = card.charAt(card.length() - 1);
		String digit = calculateCheckDigit(card.substring(0, card.length() - 1));
		return checkDigit == digit.charAt(0);
	}
	private static String calculateCheckDigit(String card) {
		if (card == null)
			return null;
		String digit;
		/* convert to array of int for simplicity */
		int[] digits = new int[card.length()];
		for (int i = 0; i < card.length(); i++) {
			digits[i] = Character.getNumericValue(card.charAt(i));
		}
		
		/* double every other starting from right - jumping from 2 in 2 */
		for (int i = digits.length - 1; i >= 0; i -= 2)	{
			digits[i] += digits[i];
			
			/* taking the sum of digits grater than 10 - simple trick by substracting 9 */
			if (digits[i] >= 10) {
				digits[i] = digits[i] - 9;
			}
		}
		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			sum += digits[i];
		}
		/* multiply by 9 step */
		sum = sum * 9;
		
		/* convert to string to be easier to take the last digit */
		digit = sum + "";
		return digit.substring(digit.length() - 1);
	}
	


}
