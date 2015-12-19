package jp.co.logacy.validator.search;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class TitleValidator {
	
	public Map<String, String> validator(final String title, Map<String, String> errorMap) {
		
		if (StringUtils.isEmpty(title)) {
			errorMap.put("empty", "search.msg.empty");
			return errorMap;
		}
		return errorMap;
	}
}
