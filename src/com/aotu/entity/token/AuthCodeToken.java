package com.aotu.entity.token;

public class AuthCodeToken extends BaseToken{

	private static final int expireSeconds = 300000;
	
	public AuthCodeToken(String mobile,String authCode){
		this.setExpire(String.valueOf(System.currentTimeMillis()+this.expireSeconds));
		this.setTokenKey(mobile+authCode);
	}
	
	public AuthCodeToken(){
		
	}
}
