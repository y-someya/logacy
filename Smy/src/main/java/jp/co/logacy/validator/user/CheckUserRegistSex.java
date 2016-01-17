package jp.co.logacy.validator.user;

import java.util.regex.Pattern;

/**
 * ユーザ登録性別チェッククラス
 * @author User
 *
 */
public class CheckUserRegistSex {
	
	/**
	 * 0,1で入力されているかどうか
	 * @param sex
	 * @return true:0,1で入力されている<br>
	 *         false:0,1以外で入力されている
	 */
	public static boolean isInput01(final String sex) {
		
		final String PATTERN_01 = "^[01]{1}$";

		if (Pattern.matches(PATTERN_01, sex)) {
			return true;
		}
		return false;
	}
	
}
