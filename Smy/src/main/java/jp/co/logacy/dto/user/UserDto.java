package jp.co.logacy.dto.user;

import java.io.Serializable;

/**
 * ユーザ情報を保持するDTO
 * @author User
 *
 */
public class UserDto implements Serializable {

	public static final long serialVersionUID = 1L;
	
	/** ユーザID */
	public String id;
	
	/** ユーザ名 */
	public String name;
	
	/** パスワード */
	public String password;
	
	/** 年齢 */
	public String age;
	
	/** 性別 */
	public String sex;
	
	/** 誕生日 */
	public String birthDay;
	
	/** 自己紹介 */
	public String introduction;
}
