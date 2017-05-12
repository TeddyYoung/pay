package com.aotu.entity.token;

public class MobileToken extends BaseToken{

	private String tokenStr;

	
	public MobileToken(){
		
	}
	
	
	public MobileToken(String mobile ,String tokenStr){
		this.setTokenKey(mobile);
		this.setTokenStr(tokenStr);
		this.setExpire(String.valueOf(System.currentTimeMillis()+this.expireSeconds));
	}
	
	

	public String getTokenStr() {
		return tokenStr;
	}

	public void setTokenStr(String tokenStr) {
		this.tokenStr = tokenStr;
	}
	
}
