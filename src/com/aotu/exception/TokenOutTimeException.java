package com.aotu.exception;

import com.aotu.mobile.controller.base.HandlerResponse;

public class TokenOutTimeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3484647446336167659L;

	public static final String RESPONSE_CODE_OUTTIME="407";
	
	public static final String RESPONSE_ERROR_MESSAGE= "令牌已失效，请重新登录！";
	
	public TokenOutTimeException(HandlerResponse handlerResponse) {
		handlerResponse.setResponseCode(RESPONSE_CODE_OUTTIME);
		handlerResponse.setResponseMessage(RESPONSE_ERROR_MESSAGE);
	}

}
