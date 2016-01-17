package jp.co.logacy.util;

/**
 * 文字列関連のUtilクラス
 * @author User
 *
 */
public class StringUtils {
	
	/**
	 * メッセージを作成する<br>
	 * messageの{0}などに、引数argsの文言を埋め込む
	 * @param message
	 * @param args
	 * @return message
	 */
	public static String createMessage(String message, final String ... args) {
		
		for(int i = 0; i < args.length; i++) {
			message = message.replace("{" + i + "}", args[i]);
		}
		return message;
	}
}
