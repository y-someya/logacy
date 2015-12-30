package jp.co.logacy.service.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import jp.co.logacy.constant.ApiConst;
import jp.co.logacy.dto.search.KensakuJokenDto;
import jp.co.logacy.dto.search.SearchResultDto;
import jp.co.logacy.exception.SmyException;
import net.arnx.jsonic.JSON;

/**
 * API管理サービスクラス
 * @author User
 *
 */
public class ApiService {

	@Resource
	public SearchResultDto searchResultDto;
	
	final Logger log = Logger.getLogger(ApiService.class.getName());
	
	/**
	 * APIレスポンスコード管理enum
	 * @author User
	 *
	 */
	public enum ApiResponseCode {
		SUCESS(200, "正常に値が返されました"),
		PARAMETER_ERROR(400, "必須パラメータが不足しています"),
		NOT_FOUND_DATA(404, "検索対象のデータが存在しません"),
		MOST_REQUEST(429, "リクエスト過多"),
		RAKUTEN_ERROR(500, "楽天エラー"),
		MENTENANCE(503, "メンテナンス中");
		
		ApiResponseCode(final int responseCode, final String message) {
			this.responseCode = responseCode;
			this.message = message;
		}
		
		private int responseCode;
		
		private String message;
		
		public int getResponseCode() {
			return responseCode;
		}
		
		public String getMessage() {
			return message;
		}
	}

	/**
	 * Bluray,DVD情報を検索し、結果を返す
	 * @param {@link KensakuJokenDto}
	 * @return {@link SearchResultDto}
	 * @throws IOException
	 */
	public SearchResultDto getDvdInformationSearchResult(final KensakuJokenDto kensakuJokenDto) {

		log.info("getDvdInformationSearchResult開始：");
		try {
			URL connectUrl = new URL(createApiUrl(kensakuJokenDto));
			HttpURLConnection con = (HttpURLConnection) connectUrl.openConnection();

			con.setRequestMethod("GET");
			con.setDoOutput(true);
			con.setInstanceFollowRedirects(true);

			log.info("レスポンスコード[" + con.getResponseCode() + "] " + "レスポンスメッセージ[" + con.getResponseMessage() + "]");
			log.info("code : " + con.getResponseCode());

			if (con.getResponseCode() == ApiResponseCode.SUCESS.getResponseCode()) {
				InputStreamReader isr = new InputStreamReader(con.getInputStream(), "UTF-8");
				BufferedReader reader = new BufferedReader(isr);
	
				StringBuffer buffer = new StringBuffer();
				String str;
				while ((str = reader.readLine()) != null) {
					buffer.append(str + "\n");
				}
	
				String json = new String(buffer);
				log.info(json);
	
				searchResultDto = JSON.decode(json, SearchResultDto.class);
			} else {
				printErrorLog(con.getResponseCode());
				throw new IOException();
			}
			
			return searchResultDto;
		} catch (IOException e) {
			throw new SmyException("Bluray,DVD情報の検索に失敗しました");
		} finally {
			log.info("getDvdInformationSearchResult終了");
		}
	}
	
	/**
	 * DVD,Bluray情報検索API接続用のURLを作成する
	 * 
	 * @param {@link KensakuJokenDto}
	 * @return ApiUrl
	 * @throws IOException 
	 */
	public String createApiUrl(final KensakuJokenDto kensakuJokenDto) throws IOException {
		try {
			StringBuilder apiUrl = new StringBuilder();
			apiUrl.append(ApiConst.DVD_INFORMATION_ACQUISITION_API_URL);

			return createApiUrlParameter(kensakuJokenDto, apiUrl).toString();
		} catch (IOException e) {
			log.error("DVD,Bluray情報検索API接続用のURL作成に失敗しました");
			throw e;
		}
	}
	
	/**
	 * DVD,Bluray情報検索API接続用のURLパラメータを作成する
	 * @param {@link KensakuJokenDto}
	 * @param apiUrl
	 * @return パラメータ作成後のAPIURL
	 * @throws IOException  
	 */
	public StringBuilder createApiUrlParameter(final KensakuJokenDto kensakuJokenDto, StringBuilder apiUrl)
			throws IOException {

		apiUrl.append("?applicationId=");
		apiUrl.append(ApiConst.APPLICATION_ID);

		try {
			if (kensakuJokenDto.title != null && !kensakuJokenDto.title.equals("")) {
				apiUrl.append("&title=");
				apiUrl.append(URLEncoder.encode(kensakuJokenDto.title, "UTF-8"));
			}

			if (kensakuJokenDto.artistName != null && !kensakuJokenDto.artistName.equals("")) {
				apiUrl.append("&artistName=");
				apiUrl.append(URLEncoder.encode(kensakuJokenDto.artistName, "UTF-8"));
			}

			if (kensakuJokenDto.label != null && !kensakuJokenDto.label.equals("")) {
				apiUrl.append("&label=");
				apiUrl.append(URLEncoder.encode(kensakuJokenDto.label, "UTF-8"));
			}

			if (kensakuJokenDto.jan != null && !kensakuJokenDto.jan.equals("")) {
				apiUrl.append("&jan=");
				apiUrl.append(kensakuJokenDto.label);
			}

			if (kensakuJokenDto.booksGenreId != null && !kensakuJokenDto.booksGenreId.equals("")) {
				apiUrl.append("&booksGenreId=");
				apiUrl.append(kensakuJokenDto.booksGenreId);
			}

			if (kensakuJokenDto.affiliateId != null && !kensakuJokenDto.affiliateId.equals("")) {
				apiUrl.append("&affiliateId=");
				apiUrl.append(kensakuJokenDto.affiliateId);
			}

			if (kensakuJokenDto.elements != null && !kensakuJokenDto.elements.equals("")) {
				apiUrl.append("&elements=");
				apiUrl.append(kensakuJokenDto.elements);
			}

			if (kensakuJokenDto.formatVersion != null && !kensakuJokenDto.formatVersion.equals("")) {
				apiUrl.append("&formatVersion=");
				apiUrl.append(kensakuJokenDto.formatVersion);
			}

			if (kensakuJokenDto.hits != null && !kensakuJokenDto.hits.equals("")) {
				apiUrl.append("&hits=");
				apiUrl.append(kensakuJokenDto.hits);
			}

			if (kensakuJokenDto.page != null && !kensakuJokenDto.page.equals("")) {
				apiUrl.append("&page=");
				apiUrl.append(kensakuJokenDto.page);
			}

			if (kensakuJokenDto.availability != null && !kensakuJokenDto.availability.equals("")) {
				apiUrl.append("&availability=");
				apiUrl.append(kensakuJokenDto.availability);
			}

			if (kensakuJokenDto.outOfStockFlag != null && !kensakuJokenDto.outOfStockFlag.equals("")) {
				apiUrl.append("&outOfStockFlag=");
				apiUrl.append(kensakuJokenDto.outOfStockFlag);
			}

			if (kensakuJokenDto.sort != null && !kensakuJokenDto.sort.equals("")) {
				apiUrl.append("&sort=");
				apiUrl.append(kensakuJokenDto.sort);
			}

			if (kensakuJokenDto.limitedFlag != null && !kensakuJokenDto.limitedFlag.equals("")) {
				apiUrl.append("&limitedFlag=");
				apiUrl.append(kensakuJokenDto.limitedFlag);
			}

			if (kensakuJokenDto.carrier != null && !kensakuJokenDto.carrier.equals("")) {
				apiUrl.append("&carrier=");
				apiUrl.append(kensakuJokenDto.carrier);
			}

			if (kensakuJokenDto.genreInformationFlag != null && !kensakuJokenDto.genreInformationFlag.equals("")) {
				apiUrl.append("&genreInformationFlag=");
				apiUrl.append(kensakuJokenDto.genreInformationFlag);
			}

			return apiUrl;
		} catch (IOException e) {
			log.error("URLEncodeに失敗しました");
			throw e;
		}
	}
	
	/**
	 * APIレスポンスエラーログを出力する
	 * @param errorCode
	 */
	public void printErrorLog(final int errorCode) {
		
		if (errorCode == ApiResponseCode.PARAMETER_ERROR.getResponseCode()) {
			log.error(ApiResponseCode.PARAMETER_ERROR.getMessage());
		} else if (errorCode == ApiResponseCode.NOT_FOUND_DATA.getResponseCode()) {
			log.error(ApiResponseCode.NOT_FOUND_DATA.getMessage());
		} else if (errorCode == ApiResponseCode.MOST_REQUEST.getResponseCode()) {
			log.error(ApiResponseCode.MENTENANCE.getMessage());
		} else if (errorCode == ApiResponseCode.RAKUTEN_ERROR.getResponseCode()) {
			log.error(ApiResponseCode.RAKUTEN_ERROR.getMessage());
		} else if (errorCode == ApiResponseCode.MENTENANCE.getResponseCode()) {
			log.error(ApiResponseCode.MENTENANCE.getMessage());
		}	
	}

}
