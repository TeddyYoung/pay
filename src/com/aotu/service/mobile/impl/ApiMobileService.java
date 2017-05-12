package com.aotu.service.mobile.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.entity.Customer;
import com.aotu.entity.token.AuthCodeToken;
import com.aotu.service.ICustomerService;
import com.aotu.service.ISmsService;
import com.aotu.service.mobile.IApiMobileService;
import com.aotu.service.token.ITokenService;

@Service("apiMobileService")
public class ApiMobileService implements IApiMobileService{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ITokenService tokenService;
	
	@Autowired
	private ISmsService smsService;
	
	@Autowired
	private ICustomerService customerService;


	@Override
	public void toRegister(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toLogout(String tokenKey) throws Exception {
		try {
			this.tokenService.logout(tokenKey);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("注销失败！");
		}		
	}

	@Override
	public void toForgotPwd(String brandId,String phone, String authCode, String password) throws Exception {
		AuthCodeToken token = null;
		try {
			token = this.tokenService.getAuthCode(phone+authCode);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		if(token==null) {
			throw new Exception("验证码无效！");
		}
		if(this.tokenService.isExpire(token)) {
			throw new Exception("验证码已过期！");
		}
		Customer customer = customerService.getCustomerByBrandAndPhone(brandId, phone);
		if(customer==null)throw new Exception("查无此用户");
		else{
			customer.setLoginPassword(password);
			this.customerService.update(customer);
		}
	}
	
	@Override
	public void toSendAuthCode(String brandId,String phone) throws Exception{
		Customer customer = customerService.getCustomerByBrandAndPhone(brandId, phone);
		if(customer == null) throw new Exception("查无此用户！");
		smsService.sendAuthCodeYP(phone, brandId);
	}

}
