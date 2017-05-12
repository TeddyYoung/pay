package com.aotu.entity.token;

import com.aotu.util.Logger;
import com.aotu.util.ShortUUID;

public class BaseToken {

	public static final int expireSeconds = 1296000000;  //15天的秒數
	
	private String tokenKey;
	private String expire;
	private String secretKey;
	
	
	public BaseToken(){
		this.tokenKey = ShortUUID.genId();
		this.secretKey = ShortUUID.secretKey();
		this.expire = String.valueOf(System.currentTimeMillis()+expireSeconds);
	
	}
	


	public String getTokenKey() {
		return tokenKey;
	}



	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}



	public String getExpire() {
		return expire;
	}


	public void setExpire(String expire) {
		this.expire = expire;
	}



	public String getSecretKey() {
		return secretKey;
	}



	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	

}
