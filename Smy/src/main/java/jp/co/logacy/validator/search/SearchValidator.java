package jp.co.logacy.validator.search;

import java.util.HashMap;
import java.util.Map;

import jp.co.logacy.dto.search.KensakuJokenDto;

public class SearchValidator {
	
	public Map<String, String> validator(final KensakuJokenDto kensakuJokenDto) {
		
		Map<String, String> errorMap = new HashMap<String, String>();
		
		new TitleValidator().validator(kensakuJokenDto.title, errorMap);
		new ArtistNameValidator().validator(kensakuJokenDto.artistName, errorMap);
		
		
		return errorMap;
	}
}
