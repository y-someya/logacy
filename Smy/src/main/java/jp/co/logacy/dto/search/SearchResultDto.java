package jp.co.logacy.dto.search;

import java.util.List;

/**
 * 楽天ブックスDVD/Blu-ray検索APIの結果保持DTO
 * 
 * @author y_someya
 *
 */
public class SearchResultDto {
	
	/** 検索数 */
	public int count;
	
	/** ページ番号 */
	public int page;
	
	/** ページ内商品始追番 */
	public int first;
	
	/** ページ内商品終追番 */
	public int last;
	
	/** ヒット件数 */
	public int hits;
	
	/** キャリア情報 */
	public int carrier;
	
	/** 総ページ数 */
	public int pageCount;

	public List<ItemsDto> Items;
	
	public List<String> GenreInformation;
	
}
