package jp.co.logacy.validator.user;

import java.util.regex.Pattern;

/**
 * ユーザ登録年齢チェッククラス
 * @author User
 *
 */
public class CheckUserRegistAge {
	
	/**
	 * 半角数字以外で入力されているかどうか
	 * @param age
	 * @return true:半角数字以外<br>
	 *         false:半角数字
	 */
	public static boolean isNotAgeHalfNumber(final String age) {
		
		final String HALF_NUMBER_PATTERN = "^[0-9]+$";

		if ("".equals(age) || Pattern.matches(HALF_NUMBER_PATTERN, age)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 3桁以内で入力されているかどうか
	 * @param age
	 * @return true:3桁以内<br>
	 *         false:4桁以上
	 */
	public static boolean isNotOverAgeSize(final String age) {
		
		final int MAX_AGE_SIZE = 3;

		if (age.length() > MAX_AGE_SIZE) {
			return false;
		}
		return true;
	}
}
