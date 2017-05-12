package com.aotu.service.token;

import com.aotu.entity.Customer;
import com.aotu.entity.system.User;
import com.aotu.entity.token.AuthCodeToken;
import com.aotu.entity.token.BaseToken;
import com.aotu.entity.token.MobileToken;
import com.aotu.entity.token.UserToken;


/**
 * token管理 Service
 * @author Teddy
 */
public interface ITokenService {
	
	/**
	 * 移动端 - 登陆
	 * @param user
	 * @return
	 */
	public UserToken login(Customer user) throws Exception;
	
	/**
	 * 通过tokenKey过去token信息
	 * @param tokenKey
	 * @return
	 */
	public UserToken getUserToken(String tokenKey) throws Exception;
	
	
	/**
	 * 
	 * @param tokenKey
	 * @return
	 * @throws Exception
	 */
	public AuthCodeToken getAuthCode(String tokenKey) throws Exception;
	
	
	/**
	 * 通過手機號找到TokenKey;
	 * @param mobileKey
	 * @return
	 */
	public MobileToken getMobileToken(String mobileKey) throws Exception;
	
	/**
	 * 判断token是否有效
	 * @param token
	 * @return
	 */
	public boolean isVaild(String token);
    
	/**
	 * 注销token
	 * @param token
	 * @return
	 */
	public boolean logout(String token);

    /**
     * 更新token
     * @param token
     */
    public void updateToken(UserToken token);
    
    public boolean isExpire(BaseToken tokens);

	public void remove(String tokenKey);

	public void save(BaseToken token);

}
