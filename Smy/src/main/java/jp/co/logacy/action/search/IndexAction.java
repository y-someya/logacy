package jp.co.logacy.action.search;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import jp.co.logacy.dto.search.KensakuJokenDto;
import jp.co.logacy.dto.search.SearchResultDto;
import jp.co.logacy.exception.SmyException;
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
	
	final Logger log = Logger.getLogger(IndexAction.class.getName());

	@Execute(validator = false)
	public String index() {
		
		return "index.jsp";
	}

	/**
	 * 検索結果画面を表示する
	 * @return
	 */
	@Execute(validator = false)
	public String result() {
		
		setKensakuJokenToDto(indexForm, kensakuJokenDto);
		
		if (isValidKensakuJoken(kensakuJokenDto)) {
			log.info("検索条件が設定されていません");
			return "index.jsp";
		}
		
		searchResultDto = searchService.searchDvdInformation(kensakuJokenDto);
		
		return "result.jsp";
	}
	
	/**
	 * 検索条件をDTOに詰める
	 * 
	 * @param {@link IndexForm}
	 * @param {@link KensakuJokenDto}
	 */
	private void setKensakuJokenToDto(final IndexForm indexForm, final KensakuJokenDto kensakuJokenDto) {
		
		if (indexForm == null || kensakuJokenDto == null) {
			throw new SmyException();
		}
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
	}
	
	/**
	 * 検索条件パラメータにエラーがあるかどうか
	 * @param {@link KensakuJokenDto}
	 * @return true:パラメータエラーあり<br>
	 *         false:パラメータエラーなし
	 */
	private boolean isValidKensakuJoken(final KensakuJokenDto kensakuJokenDto) {
		
		if(kensakuJokenDto == null) {
			return true;
		}
		
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
}
