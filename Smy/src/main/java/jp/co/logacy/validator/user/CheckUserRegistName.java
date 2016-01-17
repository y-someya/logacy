package jp.co.logacy.validator.user;

import jp.co.logacy.dto.user.UserDto;

/**
 * ユーザ登録名前チェッククラス
 * @author User
 *
 */
public class CheckUserRegistName {

	/**
	 * 名前が入力サイズを超えているかどうか
	 * @param {@link UserDto}
	 * @return true：超えている<br>
	 *         false:超えていない
	 */
	public static boolean isOverNameSize(final String name) {
		
		final int MAX_NAME_SIZE = 30;

		if (name == null || name.length() > MAX_NAME_SIZE) {
			return true;
		}
		return false;
	}
}
