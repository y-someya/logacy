package jp.co.logacy.validator.search;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class ArtistNameValidator {
	
	public Map<String, String> validator(final String artistName, Map<String, String> errorMap) {
		
		if (StringUtils.isEmpty(artistName)) {
			errorMap.put("empty", "search.msg.empty");
			return errorMap;
		}
		return errorMap;
	}
}
