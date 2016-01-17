package jp.co.logacy.action.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import jp.co.logacy.dto.user.UserDto;
import jp.co.logacy.exception.SmyException;
import jp.co.logacy.form.user.IndexForm;
import jp.co.logacy.service.user.UserService;
import jp.co.logacy.validator.user.UserRegistValidator;

public class IndexAction {

	@ActionForm
	@Resource
	protected IndexForm indexForm;
	
	@Resource
	protected UserDto userDto;
	
	@Resource
	protected UserService userService;
	
	@Resource
	protected Map<String, String> errorMap = new HashMap<>();
	
	final Logger log = Logger.getLogger(IndexAction.class.getName());
	
	/**
	 * ユーザ登録
	 * @return
	 */
	@Execute(validator=false)
	public String index() {
		return "index.jsp";
	}

	/**
	 * 
	 * ユーザ編集
	 * @return
	 */
	@Execute(validator=false)
	public String regist() {
		return "regist.jsp";
	}

	/**
	 * ユーザ登録完了
	 * @return
	 */
	@Execute(validator=false, urlPattern="/complete")
	public String complete() {
		
		setUserInformationToDto(userDto, indexForm);
		errorMap = validRegistUserInformation(userDto);
		if (errorMap != null) {
			return "regist.jsp";
		}
		userService.registUserInformation(userDto);

		return "complete.jsp";
	}
	
	/**
	 * ユーザ情報をDTOに詰め替える
	 * @param {@link UserDto}
	 * @param {@link CompleteForm}
	 */
	private void setUserInformationToDto(final UserDto userDto, final IndexForm indexForm) {
		if (indexForm == null) {
			throw new SmyException("completeFormがnullです");
		}
		if (userDto == null) {
			return;
		}
		userDto.id = indexForm.id;
		userDto.name = indexForm.name;
		userDto.password = indexForm.password;
		userDto.age = indexForm.age;
		userDto.sex = indexForm.sex;
		userDto.birthDay = indexForm.birthDay;
		userDto.introduction = indexForm.introduction;
	}
	
	/**
	 * {@link UserRegistValidator#validator(UserDto, Map)}のヒューリティクス
	 * @param {@link UserDto}
	 * @return errorMap
	 */
	private Map<String, String> validRegistUserInformation(final UserDto userDto) {
		
		try {
			log.info("ユーザ登録バリデータ処理開始");
			errorMap = new UserRegistValidator().validator(userDto, errorMap);
			log.info("ユーザ登録バリデータ処理終了");
			return errorMap;
		} catch (SmyException e) {
			throw new SmyException("ユーザ登録バリデータ処理中にエラーが発生しました" + e.getMessage());
		}
	}
}
