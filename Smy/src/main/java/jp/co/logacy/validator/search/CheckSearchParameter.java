package jp.co.logacy.validator.search;

import jp.co.logacy.dto.search.KensakuJokenDto;

/**
 * 検索パラメータチェッククラス
 * @author User
 *
 */
public class CheckSearchParameter {

	/**
	 * 必須パラメータが全て未入力かどうか
	 * @param {@link KensakuJokenDto}
	 * @return true:すべて未入力<br>
	 *         false:いずれかが入力されている
	 */
	public boolean isEmptyRequiredParameter(final KensakuJokenDto kensakuJokenDto) {
		
		if (kensakuJokenDto.title != null && !kensakuJokenDto.title.equals("")) {
			return false;
		}
		if (kensakuJokenDto.artistName != null && !kensakuJokenDto.artistName.equals("")) {
			return false;
		}
		if (kensakuJokenDto.label != null && !kensakuJokenDto.label.equals("")) {
			return false;
		}
		if (kensakuJokenDto.jan != null && !kensakuJokenDto.jan.equals("")) {
			return false;
		}
		if (kensakuJokenDto.booksGenreId != null && !kensakuJokenDto.booksGenreId.equals("")) {
			return false;
		}
		return true;
	}
	
	/**
	 * すべての必須パラメータが1文字未満か
	 * @param {@link KensakuJokenDto}
	 * @return true:すべての必須パラメータが1文字未満<br>
	 *         false:いずれかの必須パラメータが1文字以上
	 */
	public boolean isNotOver1Character(final KensakuJokenDto kensakuJokenDto) {
		final int MIN_LIMIT_REQUIRED_PARAMETER = 1;
		
		if (kensakuJokenDto.title.length() > MIN_LIMIT_REQUIRED_PARAMETER) {
			return false;
		}
		if (kensakuJokenDto.artistName.length() > MIN_LIMIT_REQUIRED_PARAMETER) {
			return false;
		}
		if (kensakuJokenDto.label.length() > MIN_LIMIT_REQUIRED_PARAMETER) {
			return false;
		}
		if (kensakuJokenDto.jan.length() > MIN_LIMIT_REQUIRED_PARAMETER) {
			return false;
		}
		if (kensakuJokenDto.booksGenreId.length() > MIN_LIMIT_REQUIRED_PARAMETER) {
			return false;
		}
		return true;
	}
}
