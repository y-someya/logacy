package jp.co.logacy.validator.user;

import java.util.Map;

import javax.annotation.Resource;

import org.seasar.struts.util.MessageResourcesUtil;

import jp.co.logacy.dto.user.UserDto;
import jp.co.logacy.service.user.UserService;
import jp.co.logacy.util.StringUtils;
import jp.co.logacy.validator.Validator;
/**
 * ユーザ登録バリデータクラス
 * @author User
 *
 */
public class UserRegistValidator extends Validator {
	
	final static String USER_NAME = "名前";
	final static String USER_PASSWORD = "パスワード";
	final static String USER_AGE = "年齢";
	final static String USER_SEX = "性別";
	final static String MAX_USER_NAME_SIZE = "30";
	final static String MAX_USER_PASSWORD_SIZE = "30";
	final static String MAX_USER_AGE_SIZE = "3";
	
	@Resource
	protected UserService userService;
	
	/**
	 * ユーザ登録バリデータ
	 * @param {@link UserDto}
	 * @param errorMap
	 * @return errorMap
	 */
	public Map<String, String> validator(final UserDto userDto, final Map<String, String> errorMap) {

		if (CheckUserRegistParameter.isEmptyRequiredParameter(userDto)) {
			final String errorMessage = MessageResourcesUtil.getMessage("user.regist.msg.empty");
			errorMap.put("empty", errorMessage);
		}

		if (CheckUserRegistName.isOverNameSize(userDto.name)) {
			final String errorMessage = MessageResourcesUtil.getMessage("user.regist.msg.over");
			errorMap.put("over", StringUtils.createMessage(errorMessage, USER_NAME, MAX_USER_NAME_SIZE));
		}
		
		if (userService.isSelectSameUserNameToTblUser(userDto.name)) {
			final String errorMessage = MessageResourcesUtil.getMessage("user.regist.msg.same.name");
			errorMap.put("same.name", errorMessage);
		}
		
		if (CheckUserRegistPassword.isOverPasswordSize(userDto.password)) {
			final String errorMessage = MessageResourcesUtil.getMessage("user.regist.msg.over");
			errorMap.put("over", StringUtils.createMessage(errorMessage, USER_PASSWORD, MAX_USER_PASSWORD_SIZE));
		}
		
		if (CheckUserRegistAge.isNotAgeHalfNumber(userDto.age) || !CheckUserRegistAge.isNotAgeHalfNumber(userDto.age)) {
			final String errorMessage = MessageResourcesUtil.getMessage("user.regist.msg.not.half.number");
			errorMap.put("not.half.number", StringUtils.createMessage(errorMessage, USER_AGE, MAX_USER_AGE_SIZE));
		}
		
		if (CheckUserRegistSex.isInput01(userDto.sex)) {
			final String errorMessage = MessageResourcesUtil.getMessage("user.regist.msg.fraud");
			errorMap.put("fraud", StringUtils.createMessage(errorMessage, USER_SEX));
		}
		return errorMap;
	}
	
}
