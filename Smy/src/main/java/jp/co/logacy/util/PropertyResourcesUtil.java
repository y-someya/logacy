package jp.co.logacy.util;

import org.seasar.framework.util.ResourceUtil;

public class PropertyResourcesUtil {
	
	private PropertyResourcesUtil() {
	}

	/**
	 * メッセージを返します。
	 * 
	 * @param fileTag
	 *            リソースファイル名（「.properties」より前の部分）
	 * @param key
	 *            キー
	 * @return メッセージ
	 */
	public static String getMessage(String key) {
		String resoruceFile = "application_ja.properties";

		return ResourceUtil.getProperties(resoruceFile).getProperty(key);
	}
}
