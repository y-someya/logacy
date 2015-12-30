package jp.co.logacy.validator.search;

import java.util.Map;

import org.seasar.struts.util.MessageResourcesUtil;

import jp.co.logacy.dto.search.KensakuJokenDto;
import jp.co.logacy.validator.Validator;

public class SearchValidator extends Validator {

	/**
	 * Bluray,DVD検索の条件バリデータ
	 * @param {@link kensakuJokenDto}
	 * @param errorMap
	 * @return errorMap
	 */
	public Map<String, String> validator(final KensakuJokenDto kensakuJokenDto, Map<String, String> errorMap) {

		final CheckSearchParameter checkSearchParameter = new CheckSearchParameter();
		if (checkSearchParameter.isEmptyRequiredParameter(kensakuJokenDto)) {
			final String errorMessage = MessageResourcesUtil.getMessage("search.msg.empty");
			errorMap.put("empty", errorMessage);
			return errorMap;
		}

		if (checkSearchParameter.isNotOver1Character(kensakuJokenDto)) {
			final String errorMessage = MessageResourcesUtil.getMessage("search.msg.parameter.error");
			errorMap.put("parameter.error", errorMessage);
			return errorMap;
		}
		return errorMap;
	}
	
}
