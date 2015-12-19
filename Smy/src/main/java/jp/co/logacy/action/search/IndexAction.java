package jp.co.logacy.action.search;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import jp.co.logacy.dto.search.KensakuJokenDto;
import jp.co.logacy.dto.search.SearchResultDto;
import jp.co.logacy.form.search.IndexForm;
import jp.co.logacy.service.search.SearchService;

public class IndexAction {
	
	@Resource
	@ActionForm
	protected IndexForm indexForm;
	
	@Resource
	public KensakuJokenDto kensakuJokenDto;
	
	@Resource
	public SearchResultDto searchResultDto;
	
	@Resource
	public SearchService searchService;

	@Execute(validator = false)
	public String index() {
		
		return "index.jsp";
	}

	@Execute(validator = false)
	public String result() throws Exception {
		
		kensakuJokenDto.title = indexForm.title;
		kensakuJokenDto.artistName = indexForm.artistName;
		kensakuJokenDto.label = indexForm.label;
		kensakuJokenDto.jan = indexForm.jan;
		kensakuJokenDto.booksGenreId = indexForm.booksGenreId;
		kensakuJokenDto.affiliateId = indexForm.affiliateId;
		kensakuJokenDto.elements = indexForm.elements;
		kensakuJokenDto.formatVersion = indexForm.formatVersion;
		kensakuJokenDto.hits = indexForm.hits;
		kensakuJokenDto.page = indexForm.page;
		kensakuJokenDto.availability = indexForm.availability;
		kensakuJokenDto.outOfStockFlag = indexForm.outOfStockFlag;
		kensakuJokenDto.sort = indexForm.sort;
		kensakuJokenDto.limitedFlag = indexForm.limitedFlag;
		kensakuJokenDto.carrier = indexForm.carrier;
		kensakuJokenDto.genreInformationFlag = indexForm.genreInformationFlag;
		
		searchResultDto = searchService.getSearchResult(kensakuJokenDto);
		
		return "result.jsp";
	}
}
