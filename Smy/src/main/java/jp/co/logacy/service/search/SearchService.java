package jp.co.logacy.service.search;

import javax.annotation.Resource;

import jp.co.logacy.dto.search.KensakuJokenDto;
import jp.co.logacy.dto.search.SearchResultDto;
import jp.co.logacy.exception.SmyException;

public class SearchService {

	@Resource
	public SearchResultDto searchResultDto;
	
	@Resource
	public ApiService apiService;
	
	/**
	 * {@link ApiService#getDvdInformationSearchResult(KensakuJokenDto)}のヒューリティクス
	 * @param {@link KensakuJokenDto}
	 * @return {@link SearchResultDto} 
	 */
	public SearchResultDto searchDvdInformation(final KensakuJokenDto kensakuJokenDto) {
		
		if (kensakuJokenDto == null) {
			throw new SmyException();
		}
		
		searchResultDto = apiService.getDvdInformationSearchResult(kensakuJokenDto);
		
		return searchResultDto;
	}
}
