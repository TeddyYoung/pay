package com.aotu.util;

import java.util.HashMap;
import java.util.Map;
import com.aotu.entity.token.BaseToken;
import com.aotu.exception.ParameterErrorException;

public class SecretArgs extends HashMap implements Map{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Map map = null;
	BaseToken token;
	
	private static final String ARGS_SPLITER = "&";
	
	private static final String ARG_SPLITER = "=";
	
	protected Logger logger = Logger.getLogger(this.getClass());

	
	public SecretArgs(String args,BaseToken token){
		try {
			Map returnMap = new HashMap();
			String decodeArgs = Des3.decode(args, token.getSecretKey());
			String[] params  = decodeArgs.split(ARGS_SPLITER);
			for (String string : params) {
				String[] param = string.split(ARG_SPLITER);
				if(param.length>1){
					returnMap.put(param[0], param[1]);
				}else{
					returnMap.put(param[0], "");
				}
			}
			map = returnMap;
		} catch (Exception e) {
			logger.error("参数解析出错", e);
			throw new ParameterErrorException("参数解析出错，请重新登录");
		}
	}
	
	
	public String getString(Object key) {
		return (String)get(key);
	}
	
//	public static void main(String[] args) {
//		String a = "a=&b=123456&c=123467";
//		for (String string : a.split("=")) {
//			System.out.println(">>>>"+string);
//		}
//	}
}
