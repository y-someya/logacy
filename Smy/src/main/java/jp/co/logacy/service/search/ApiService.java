package jp.co.logacy.service.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.annotation.Resource;

import jp.co.logacy.constant.ApiConst;
import jp.co.logacy.dto.search.KensakuJokenDto;
import jp.co.logacy.dto.search.SearchResultDto;
import net.arnx.jsonic.JSON;

public class ApiService {

	@Resource
	public SearchResultDto searchResultDto;

	/**
	 * 
	 * @param {@link KensakuJokenDto}
	 * @return {@link SearchResultDto}
	 * @throws IOException
	 */
	public SearchResultDto getDvdInformationSearchResult(final KensakuJokenDto kensakuJokenDto) throws IOException {
		
		URL connectUrl = new URL(createApiUrl(kensakuJokenDto));
		HttpURLConnection con = (HttpURLConnection) connectUrl.openConnection();

		con.setRequestMethod("GET");
		con.setDoOutput(true);
		con.setInstanceFollowRedirects(true);

		System.out.println("レスポンスヘッダ:");
		System.out.println("レスポンスコード[" + con.getResponseCode() + "] " + "レスポンスメッセージ[" + con.getResponseMessage() + "]");

		InputStreamReader isr = new InputStreamReader(con.getInputStream(), "UTF-8");
		BufferedReader reader = new BufferedReader(isr);
		System.out.println("code : " + con.getResponseCode());

		StringBuffer buffer = new StringBuffer();
		String str;
		while ((str = reader.readLine()) != null) {
			buffer.append(str + "\n");
		}

		String json = new String(buffer);
		System.out.println(json);

		searchResultDto = JSON.decode(json, SearchResultDto.class);

		return searchResultDto;
	}
	
	/**
	 * DVD,Bluray情報検索API接続用のURLを作成する
	 * 
	 * @param {@link KensakuJokenDto}
	 * @return ApiUrl
	 * @throws UnsupportedEncodingException 
	 */
	public String createApiUrl(final KensakuJokenDto kensakuJokenDto) throws UnsupportedEncodingException {
		StringBuilder apiUrl = new StringBuilder();
		apiUrl.append(ApiConst.DVD_INFORMATION_ACQUISITION_API_URL);
	
		return createApiUrlParameter(kensakuJokenDto, apiUrl).toString();
	}
	
	/**
	 * DVD,Bluray情報検索API接続用のURLパラメータを作成する
	 * @param {@link KensakuJokenDto}
	 * @param apiUrl
	 * @return パラメータ作成後のAPIURL
	 * @throws UnsupportedEncodingException 
	 */
	public StringBuilder createApiUrlParameter(final KensakuJokenDto kensakuJokenDto, StringBuilder apiUrl) throws UnsupportedEncodingException {
		
		apiUrl.append("?applicationId=");
		apiUrl.append(ApiConst.APPLICATION_ID);			
		
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
	}

}
