package jp.co.logacy.action.user;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import jp.co.logacy.dto.user.UserDto;
import jp.co.logacy.exception.SmyException;
import jp.co.logacy.form.user.CompleteForm;
import jp.co.logacy.form.user.RegistForm;
import jp.co.logacy.service.user.UserService;

public class IndexAction {

	@ActionForm
	@Resource
	protected RegistForm registForm;
	
	@ActionForm
	@Resource
	protected CompleteForm completeForm;
	
	@Resource
	public UserDto userDto;
	
	@Resource
	public UserService userService;
	
	final Logger log = Logger.getLogger(IndexAction.class.getName());
	
	public String regist() {
		return "regist.jsp";
	}

	/**
	 * ユーザ登録完了
	 * @return
	 */
	@Execute
	public String complete() {
		
		setUserInformationToDto(userDto, completeForm);
		userService.registUserInformation(userDto);
		
		return "complete.jsp";
	}
	
	/**
	 * ユーザ情報をDTOに詰め替える
	 * @param {@link UserDto}
	 * @param {@link CompleteForm}
	 */
	private void setUserInformationToDto(final UserDto userDto, final CompleteForm completeForm) {
		if (userDto == null || completeForm == null) {
			throw new SmyException();
		}
		userDto.id = completeForm.id;
		userDto.name = completeForm.name;
		userDto.password = completeForm.password;
		userDto.age = completeForm.age;
		userDto.sex = completeForm.sex;
		userDto.birthDay = completeForm.birthDay;
		userDto.introduction = completeForm.introduction;
	}
}
