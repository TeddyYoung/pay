package com.aotu.dao.token;

import com.aotu.entity.token.AuthCodeToken;
import com.aotu.entity.token.BaseToken;
import com.aotu.entity.token.MobileToken;
import com.aotu.entity.token.UserToken;



/**
 * token管理 DAO
 * @author Teddy
 */
public interface ITokenDAO {
	
	/**
	 * 获取token
	 * @param tokenKey
	 * @return
	 */
	
	public boolean add(final BaseToken token);
	
	public boolean update(final BaseToken token);
    
	public void remove(String keyId);

	public MobileToken getMobileToken(String tokenKey);
	
	public AuthCodeToken getAuthCode(String tokenKey);
	
	public UserToken getUserToken(String tokenKey);
	
}
