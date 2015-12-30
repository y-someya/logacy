package jp.co.logacy.validator;

import java.util.Map;

public abstract class Validator {

	public Map<String, String> validator(final Object object, Map<String, String> errorMap) {
		return errorMap;
	};
}
