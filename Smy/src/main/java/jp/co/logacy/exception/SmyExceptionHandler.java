package jp.co.logacy.exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

public class SmyExceptionHandler extends ExceptionHandler {

	final Logger log = Logger.getLogger(SmyExceptionHandler.class.getName());
	
	@Override
	public ActionForward execute(Exception ex, ExceptionConfig ae, ActionMapping mapping, ActionForm formInstance,
			HttpServletRequest request, HttpServletResponse response) throws ServletException {

		log.error(ex.getClass());

		// メッセージ生成
		ActionMessage msg = new ActionMessage("msg.key.handler");

		String property = Globals.ERROR_KEY;
		ActionForward forward = new ActionForward(ae.getPath());
		String scope = "request";

		// リクエストにエラーメッセージを保存
		storeException(request, property, msg, forward, scope);

		if (!response.isCommitted()) {
			return forward;
		}
		return null;
	}

}
