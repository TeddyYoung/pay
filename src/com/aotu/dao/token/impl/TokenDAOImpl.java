package com.aotu.dao.token.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import com.aotu.dao.token.ITokenDAO;
import com.aotu.entity.token.AuthCodeToken;
import com.aotu.entity.token.BaseToken;
import com.aotu.entity.token.MobileToken;
import com.aotu.entity.token.UserToken;
import com.aotu.mobile.vo.UserVo;
import com.aotu.util.JsonUtil;
import com.aotu.util.Logger;

import net.sf.json.JSONObject;

/**
 * token管理 DAO
 * @author Teddy
 */
@Repository("tokenDAO")
public class TokenDAOImpl extends AbstractBaseRedisDao implements ITokenDAO {
	
	protected Logger logger = Logger.getLogger(this.getClass());

	public void remove(String token) {
		delete(token);
	}

	public boolean add(final BaseToken token) {
		boolean result = (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(token.getTokenKey());
				byte[] value = serializer.serialize(tokenToString(token));
				return connection.setNX(key, value);
			}
		});
		return result;
	}

	/**
	 * 删除 <br>
	 * ------------------------------<br>
	 * 
	 * @param key
	 */
	public void delete(String key) {
		List<String> list = new ArrayList<String>();
		list.add(key);
		delete(list);
	}

	/**
	 * 删除多个 <br>
	 * ------------------------------<br>
	 * 
	 * @param keys
	 */
	public void delete(List<String> keys){
		redisTemplate.delete(keys);
	}

	/**
	 * 修改 <br>
	 * ------------------------------<br>
	 * 
	 * @param token
	 * @return
	 */
	public boolean update(final BaseToken token){
		String key = token.getTokenKey();
		boolean result = (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(token.getTokenKey());
				byte[] value = serializer.serialize(tokenToString(token));
				connection.set(key, value);
				return true;
			}
		});
		return result;
	}

	
	
	/**
	 * 通过key获取 <br>
	 * ------------------------------<br>
	 * 
	 * @param keyId
	 * @return
	 */
	@Override
	public MobileToken getMobileToken(final String tokenKey){
		MobileToken result = (MobileToken) redisTemplate.execute(new RedisCallback<MobileToken>() {
			public MobileToken doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				
				byte[] key = serializer.serialize(tokenKey);
				byte[] value = connection.get(key);
				if (value == null) {             
					return null;
				}
				String js = serializer.deserialize(value);
				MobileToken token = new MobileToken();
				try {
					token = (MobileToken) JsonUtil.JsonStr2Entity(js, MobileToken.class);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return token;
			}
		});
		return result; 
	}
	/*
	 * token转换成字符串
	 */
	private String tokenToString(BaseToken token) {
		JSONObject json = new JSONObject();
		try {
			json = JsonUtil.entity2Json(token);
		} catch (ServletException e) {
			this.logger.error(e.getMessage());
		} catch (IOException e) {
			this.logger.error(e.getMessage());
		}
		return json.toString();
	}

	@Override
	public UserToken getUserToken(final String tokenKey) {
		UserToken result = (UserToken) redisTemplate.execute(new RedisCallback<UserToken>() {
			public UserToken doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(tokenKey);
				byte[] value = connection.get(key);
				if (value == null) {
					return null;
				}
				String js = serializer.deserialize(value);
				UserToken token = new UserToken();
				try {
					token = (UserToken) JsonUtil.JsonStr2Entity(js, UserToken.class);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return token;
			}
		});
		return result;
	}
	
	/**
	 * 通过key获取 <br>
	 * ------------------------------<br>
	 * 
	 * @param keyId
	 * @return
	 */
	@Override
	public AuthCodeToken getAuthCode(final String tokenKey) {
		AuthCodeToken result = (AuthCodeToken) redisTemplate.execute(new RedisCallback<AuthCodeToken>() {
			public AuthCodeToken doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(tokenKey);
				byte[] value = connection.get(key);
				if (value == null) {
					return null;
				}
				String js = serializer.deserialize(value);
				AuthCodeToken token = new AuthCodeToken();
				try {
					token = (AuthCodeToken) JsonUtil.JsonStr2Entity(js, AuthCodeToken.class);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return token;
			}
		});
		return result;
	}
	
}
