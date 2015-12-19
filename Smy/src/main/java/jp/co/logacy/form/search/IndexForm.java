package jp.co.logacy.form.search;

/**
 * BD検索用の検索条件フォーム
 * 
 * @author y_someya
 *
 */
public class IndexForm {
	
	/** タイトル */
	public String title;
	
	/** 出演者名 */
	public String artistName;
	
	/** 販売元名 */
	public String label;
	
	/** JANコード */
	public String jan;
	
	/** 楽天ブックジャンルID */
	public String booksGenreId;
	
	/** アフェリエイトID */
	public String affiliateId;
	
	/** 出力パラメータ指定 */
	public String elements;
	
	/** 出力フォーマットバージョン */
	public String formatVersion;
	
	/** 1ページあたりの取得件数 */
	public String hits;
	
	/** 取得ページ */
	public String page;
	
	/** 在庫状況 */
	public String availability;
	
	/** 品切れ等、購入不可商品表示フラグ */
	public String outOfStockFlag;
	
	/** ソート */
	public String sort;
	
	/** 限定フラグ */
	public String limitedFlag;
	
	/** キャリア */
	public String carrier;
	
	/** ジャンルごとの商品数取得フラグ */
	public String genreInformationFlag;
}
