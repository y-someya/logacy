package jp.co.logacy.validator.user;

import jp.co.logacy.dto.user.UserDto;
import jp.co.logacy.exception.SmyException;

/**
 * ユーザ登録バリデータチェッククラス
 * @author User
 *
 */
public class CheckUserRegistParameter {

	/**
	 * 必須パラメータが未入力かどうか
	 * @param {@link UserDto}
	 * @return true:未入力<br>
	 *         false:入力されている
	 */
	public static boolean isEmptyRequiredParameter(final UserDto userDto) {
		
		if (userDto == null) {
			throw new SmyException("userDtoがnullです");
		}
		if (userDto.name == null || userDto.name.equals("")) {
			return true;
		}
		if (userDto.password == null || userDto.password.equals("")) {
			return true;
		}
		if (userDto.sex == null || userDto.sex.equals("")) {
			return true;
		}
		return false;
	}
}
