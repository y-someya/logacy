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
	 * DVD,Bluray情報を検索する
	 * @param kensakuJokenDto {@link KensakuJokenDto}
	 * @return searchResultDto
	 * @throws Exception 
	 */
	public SearchResultDto searchDvdInformation(final KensakuJokenDto kensakuJokenDto) throws Exception {
		
		searchResultDto = apiService.getDvdInformationSearchResult(kensakuJokenDto);
		
		return searchResultDto;
	}
}
