package jp.co.logacy.validator.user;

import jp.co.logacy.dto.user.UserDto;

/**
 * ユーザ登録パスワードチェッククラス
 * @author User
 *
 */
public class CheckUserRegistPassword {

	/**
	 * パスワードが入力サイズを超えているかどうか
	 * @param {@link UserDto}
	 * @return true：超えている<br>
	 *         false:超えていない
	 */
	public static boolean isOverPasswordSize(final String password) {
		
		final int MAX_PASSWORD_SIZE = 30;
		
		if (password == null || password.length() > MAX_PASSWORD_SIZE) {
			return true;
		}
		return false;
	}
}
