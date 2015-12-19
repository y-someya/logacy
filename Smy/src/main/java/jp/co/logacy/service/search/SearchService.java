package jp.co.logacy.service.search;

import javax.annotation.Resource;

import jp.co.logacy.dto.search.KensakuJokenDto;
import jp.co.logacy.dto.search.SearchResultDto;

public class SearchService {

	@Resource
	public SearchResultDto searchResultDto;
	
	@Resource
	public ApiService apiService;
	
	/**
	 * 検索条件から検索結果を返す
	 * @param kensakuJokenDto {@link KensakuJokenDto}
	 * @return searchResultDto
	 * @throws Exception 
	 */
	public SearchResultDto getSearchResult(final KensakuJokenDto kensakuJokenDto) throws Exception {
		
		searchResultDto = apiService.getApiResult(kensakuJokenDto);
		
		return searchResultDto;
	}
}
