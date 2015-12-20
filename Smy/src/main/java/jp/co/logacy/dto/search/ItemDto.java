package jp.co.logacy.dto.search;

public class ItemDto {
	
	/** DVD/Blu-rayタイトル */
	public String title;
	
	/** DVD/Blu-rayタイトルカナ */
	public String titleKana;
	
	/** 出演者名/監督名等 */
	public String artistName;
	
	/** 出演者名/監督名等　カナ */
	public String artistNameKana;
	
	/** 販売元名 */
	public String label;
	
	/** JANコード */
	public String jan;
	
	/** メーカー品番 */
	public String makerCode;
	
	/** 商品説明文 */
	public String itemCaption;
	
	/** 発売日 */
	public String salesDate;
	
	/** 税込販売価格 */
	public int itemPrice;
	
	/** 定価 */
	public int listPrice;
	
	/** 割引率 */
	public int discountRate;
	
	/** 割引額 */
	public int discountPrice;
	
	/** 商品URL */
	public String itemUrl;
	
	/** アフェリエイトURL */
	public String affiliateUrl;
	
	/** 商品画像64×64URL */
	public String smallImageUrl;
	
	/** 商品画像128×128URL */
	public String mediumImageUrl;
	
	/** 商品画像200×200URL */
	public String largeImageUrl;
	
	/** 在庫状況 */
	public String availability;
	
	/** 送料フラグ */
	public int postageFlag;
	
	/** 限定フラグ */
	public int limitedFlag;
	
	/** レビュー件数 */
	public int reviewCount;
	
	/** レビュー平均 */
	public String reviewAverage;
	
	/** 楽天ブックスジャンルID */
	public String booksGenreId;
	
}
