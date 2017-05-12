package com.aotu.service.mobile;

import com.aotu.entity.Customer;

public interface IApiMobileService{

	public void toRegister(Customer customer);
	
	public void toLogout(String tokenKey) throws Exception;
	
	public void toForgotPwd(String brandId,String phone,String authCode,String password) throws Exception;

	public void toSendAuthCode(String brandId,String phone) throws Exception;
	
}
