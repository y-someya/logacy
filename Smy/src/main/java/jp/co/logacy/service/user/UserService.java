package jp.co.logacy.service.user;

import java.sql.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.seasar.extension.jdbc.JdbcManager;

import jp.co.logacy.dto.user.UserDto;
import jp.co.logacy.entity.user.TblUser;
import jp.co.logacy.exception.SmyException;

/**
 * ユーザ情報を扱うサービスクラス
 * @author User
 *
 */
public class UserService {
	
	@Resource
	protected UserDto userDto;
	
	@Resource
	protected JdbcManager jdbcManager;

	@Resource
	protected TblUser tblUser;
	
	private Logger log = Logger.getLogger(UserService.class);
	
	/**
	 * ユーザ情報を登録する
	 * @param {@link UserDto}
	 */
	public void registUserInformation(final UserDto userDto) {
		try {
			log.info("ユーザ情報登録処理開始");
			tblUser = convUserDtoToTblUser(userDto);
			final int resultUser = registUserInformationToTblUser(tblUser);
			if (resultUser == 0) {
				throw new SmyException("TBL_USERへのユーザ登録が失敗しました");
			}
			
			final int resultUserKanri = registUserInformationToTblUserKanri();
			if (resultUserKanri == 0) {
				throw new SmyException("TBL_USER_KANRIへのユーザ登録が失敗しました");
			}
			log.info("ユーザ情報登録処理完了");
		} catch (SmyException e) {
			throw new SmyException("ユーザ情報登録中にエラーが発生しました" + e.getMessage());
		}
	}
	
	/**
	 * ユーザ管理テーブルにユーザ情報を登録する
	 * @param {@link UserDto}
	 * @return
	 */
	public int registUserInformationToTblUserKanri() {
		return jdbcManager.updateBySqlFile("sql.jp.co.logacy.user.insertUserInformationToTblUserKanri.sql").execute();
	}
	
	/**
	 * ユーザテーブルにユーザ情報を登録する
	 * @param {@link UserDto}
	 * @return
	 */
	public int registUserInformationToTblUser(final TblUser tblUser) {
		
		if (tblUser == null) {
			log.error("tblUserがnullです");
			return 0;
		}
		return jdbcManager.updateBySqlFile("sql.jp.co.logacy.user.insertUserInformationToTblUser.sql", tblUser).execute();
	}
	
	/**
	 * 登録されているユーザに同名のユーザが存在するかどうか
	 * @param name ユーザ名
	 * @return true:存在する
	 *         false:存在しない
	 */
	public boolean isSelectSameUserNameToTblUser(final String name) {
		
		if (name == null) {
			throw new SmyException("userNameがnullです");
		}
		final String result = jdbcManager.selectBySqlFile(String.class, "sql.jp.co.logacy.user.selectCountUserNameToTblUser.sql", name).getSingleResult();
		if (result == null) {
			return false;
		}
		return true;
	}

	/**
	 * ユーザ情報をDtoからユーザ情報Entityに詰め替える<br>
	 * passwordは暗号化を掛ける
	 * 
	 * @param {@link UserDto}
	 * @return {@link TblUser}
	 */
	private TblUser convUserDtoToTblUser(final UserDto userDto) {
		
		if (userDto == null) {
			return null;
		}
		try {
			TblUser tblUser = new TblUser();
			tblUser.setId(Integer.parseInt(userDto.id));
			tblUser.setName(userDto.name);
			tblUser.setPassword(encPassword(userDto.password));
			tblUser.setAge(Integer.parseInt(userDto.age));
			tblUser.setSex(convSex(userDto.sex));
			tblUser.setBirthday(convBirthDay(userDto.birthDay));
			tblUser.setIntroduction(userDto.introduction);
			return tblUser;
		} catch (Exception e) {
			log.error("tblUser変換詰め替え中にエラーが発生しました" + e.getMessage());
			throw e;
		}
	}
	
	/**
	 * パスワードを暗号化する
	 * @param {@link UserDto#password}
	 * @return 暗号化されたパスワード
	 */
	public String encPassword(final String password) {
		
		final String encPassword = "null";
		return encPassword;
	}
	
	/**
	 * 性別を真偽値に変換する
	 * @param {@link UserDto#sex}
	 * @return true:1男性<br>
	 *         false:0女性
	 */
	public Boolean convSex(final String sex) {
		
		if ("1".equals(sex)) {
			return true;
		} else if ("0".equals(sex)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 誕生日(yyyy/mm/dd)をDate型に変換する
	 * @param {@link UserDto#birthDay}
	 * @return Date型に変換された誕生日
	 */
	public Date convBirthDay(final String birthDay) {

		final String[] splitBirthDay = splitBirthDay(birthDay);
		if (splitBirthDay == null) {
			return null;
		}
		@SuppressWarnings("deprecation")
		Date convBirthDay = new Date(Integer.parseInt(splitBirthDay[0]), Integer.parseInt(splitBirthDay[1]),
				Integer.parseInt(splitBirthDay[2]));
		return convBirthDay;
	}
	
	/**
	 * 
	 * @param birthDay
	 * @return
	 */
	public String[] splitBirthDay(final String birthDay) {
		
		if (birthDay == null || "".equals(birthDay)) {
			return null;
		}
		return birthDay.split("/");
	}
}