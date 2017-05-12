package com.aotu.service;

import com.aotu.entity.token.AuthCodeToken;



public interface ISmsService{
	
	
	/**
	 * 发送注册验证码
	 * @param tel
	 * @return
	 */
	 public boolean sendAuthCodeYP(String tel,  String brandId);
	 
	 /**
	  * 判断验证码是否有效
	  * @param authCode
	  * @param authcode.tel 必填
	  * @param authcode.code 必填
	  * @return
	  */
	 public boolean isValidCode(AuthCodeToken authCode);


}
