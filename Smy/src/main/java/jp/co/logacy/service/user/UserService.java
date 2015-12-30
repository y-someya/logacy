package jp.co.logacy.service.user;

import javax.annotation.Resource;

import jp.co.logacy.dto.user.UserDto;

/**
 * ユーザ情報を扱うサービスクラス
 * @author User
 *
 */
public class UserService {
	
	@Resource
	public UserDto userDto;

	/**
	 * ユーザ情報を登録する
	 * @param userDto
	 */
	public void registUserInformation(final UserDto userDto) {
		
	}
}