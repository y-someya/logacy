package jp.co.logacy.service.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Resource;

import jp.co.logacy.dto.search.KensakuJokenDto;
import jp.co.logacy.dto.search.SearchResultDto;
import net.arnx.jsonic.JSON;

public class ApiService {

	@Resource
	public SearchResultDto searchResultDto;

	public SearchResultDto getApiResult(final KensakuJokenDto kensakuJokenDto) throws IOException {

		String apiUrl = "https://app.rakuten.co.jp/services/api/BooksDVD/Search/20130522?applicationId=1029138026252166276&title=%E3%83%9D%E3%83%83%E3%82%BF%E3%83%BC";
		URL connectUrl = new URL(apiUrl);
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
//		aaasearchResultDto = JSON.decode("{\"carrier\": 0,\"count\": 30, \"first\": 1,\"hits\": 30, \"last\": 30, \"page\": 1, \"pageCount\": 1}" , SearchResultDto.class);

		return searchResultDto;
	}

}
