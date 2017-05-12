package com.aotu.service.token.impl;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.token.ITokenDAO;
import com.aotu.entity.Customer;
import com.aotu.entity.system.User;
import com.aotu.entity.token.AuthCodeToken;
import com.aotu.entity.token.BaseToken;
import com.aotu.entity.token.MobileToken;
import com.aotu.entity.token.UserToken;
import com.aotu.service.IUserService;
import com.aotu.service.token.ITokenService;


/**
 * Token管理 Service
 * 
 * @author Teddy
 */
@Service("tokenService")
public class TokenServiceImpl implements ITokenService {

	
	private Logger log = LoggerFactory.getLogger(TokenServiceImpl.class);

	@Autowired
	private ITokenDAO tokenDAO;
	
	@Autowired
	private IUserService userService;


	public void save(BaseToken token){
		this.tokenDAO.add(token);
	}
	
	public UserToken login(Customer customer) throws Exception {
		try {
			String mobile = customer.getPhone();
			MobileToken mobileToken = this.getMobileToken(mobile);
			UserToken userToken;
		    
			if(mobileToken==null){
				userToken = this.createToken(customer);
				mobileToken = new MobileToken(mobile,userToken.getTokenKey());
				this.tokenDAO.add(mobileToken);
			}else{
//				String tokenKey = mobileToken.getTokenStr();
//				this.tokenDAO.remove(tokenKey);
				this.tokenDAO.remove(mobileToken.getTokenKey());
				userToken = this.createToken(customer);
				this.tokenDAO.remove(mobileToken.getTokenKey());
				mobileToken = new MobileToken(mobile,userToken.getTokenKey());
				this.tokenDAO.add(mobileToken);
			}
			return userToken;
		} catch (Exception e){
			throw new Exception("用户名或者密码出错");
		}

	}

	public UserToken getUserToken(String tokenKey) throws Exception {
		try {
			return tokenDAO.getUserToken(tokenKey);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public MobileToken getMobileToken(String mobile) throws Exception{
		try {
			return tokenDAO.getMobileToken(mobile);
		} catch (Exception e) {
			throw e;
		}
	}
	
	


	/*
	 * 创建token
	 * 根据用户的类型来判断从Teacher还是staff获取信息
	 */
	private UserToken createToken(Customer customer) throws Exception {
		UserToken userToken = new UserToken();
		userToken.setUserId(customer.getId()==null? "":customer.getId());
		this.tokenDAO.add(userToken);	
		return userToken;
	}

	public boolean logout(String token){
		boolean flag = true;
		try {
			UserToken usertoken = this.getUserToken(token);
			String mobile = usertoken.getMobile();
			tokenDAO.remove(token);
			tokenDAO.remove(mobile);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	public boolean isVaild(String tokenKey) {
		if (tokenKey == null || "".equals(tokenKey)) {
			return false;
		}
		UserToken token = (UserToken) this.tokenDAO.getUserToken(tokenKey);
		if (token == null) {
			return false;
		}
		if(!this.isExpire(token)){//是否过期
			token.setExpire(String.valueOf(System.currentTimeMillis()+BaseToken.expireSeconds)); //未过期
			return this.tokenDAO.update(token); // 未过期就更新过期时间;
		}else{
			this.tokenDAO.remove(tokenKey); // 过期删除掉该token信息在 redis 中
			return false;
		}
	}

	public void updateToken(UserToken token){
		UserToken tokenTemp = (UserToken) this.tokenDAO.getUserToken(token.getTokenKey());
		if (tokenTemp == null) {
			this.tokenDAO.add(tokenTemp);
		} else {
			tokenDAO.update(tokenTemp);
		}
	}

	public boolean isExpire(BaseToken token){
		if(Long.valueOf(token.getExpire()).compareTo(System.currentTimeMillis())>=0)return false;
		return true;
	}

	@Override
	public AuthCodeToken getAuthCode(String tokenKey) throws Exception {
		try {
			return tokenDAO.getAuthCode(tokenKey);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void remove(String tokenKey) {
		tokenDAO.remove(tokenKey);
	}

}
