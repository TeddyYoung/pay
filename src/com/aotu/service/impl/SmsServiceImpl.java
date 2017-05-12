/**
 * Copyright 2015 Software innovation and R & D center. All rights reserved.
 * File Name: SmsService.java
 * Encoding UTF-8
 * Version: 0.0.1
 * History:	2015年9月12日
 */
package com.aotu.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.annotation.Resource;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;







import com.aotu.entity.token.AuthCodeToken;
import com.aotu.service.ISmsService;
import com.aotu.service.token.ITokenService;
import com.aotu.util.CacheUtil;

import jodd.http.HttpBrowser;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

/**
 * 
 * @author: huiyang.yu
 * @version Revision: 0.0.1
 * @Date: 2015年9月12日
 */
@SuppressWarnings("all")
@Service("smsService")
public class SmsServiceImpl implements ISmsService{
	
	private static final String TEST_CODE_PARAM = "TEST_CODE";
	//短信服务商的 APIKEY;
	private static final String SM_API_KEY = "_SM_API_KEY";
	//短信服务商的短信内容服务
	private static final String SM_CONTENT = "_SM_CONTENT";
	
	private Logger log = LoggerFactory.getLogger(SmsServiceImpl.class);
	
	@Autowired
	private ITokenService tokenService;

	private String getRandomCode(){
        char[] codeSeq = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            String randomCode = String.valueOf(codeSeq[random.nextInt(codeSeq.length)]);// random.nextInt(10));
            code.append(randomCode);
        }
        return code.toString();
	}
	

	
	/**
	 * 获取验证码
	 * @author: huiyang.yu
	 * @param obj
	 */
	public boolean isValidCode(AuthCodeToken token){
		Boolean bool = false;
		AuthCodeToken code = null;
		try {
			code = tokenService.getAuthCode(token.getTokenKey());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		//用户攻击
		if (code == null) {
			return bool;
		}
		if(tokenService.isExpire(token)){
			bool = false;
		}else{
			bool= true;
		}
		tokenService.remove(token.getTokenKey());
		return bool;
	}
	
	

	


    public boolean sendAuthCodeYP(String tel, String brandId){
        //生成6位随机数
    	String code = this.getRandomCode();
    	log.info("code======"+code);
    	String apikey = CacheUtil.getParamValueByName(brandId+SM_API_KEY);
    	String smContent = CacheUtil.getParamValueByName(brandId+SM_CONTENT);
    	String text = String.format(smContent, code);
        
        HttpBrowser browser = new HttpBrowser();
        HttpRequest request = HttpRequest.post("http://yunpian.com/v1/sms/send.json");
        request.form("apikey", apikey);
        request.form("text", text);
        request.form("mobile", tel);
        HttpResponse resp = browser.sendRequest(request);
        //处理返回结果
        String msg ="";
        try {
            msg = new String(resp.body().getBytes("iso-8859-1"),"Utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
        }
        log.debug(msg);

        //保存验证码到缓存数据库中
        AuthCodeToken obj = new AuthCodeToken(tel,code);
        log.info(tel+code);
        this.tokenService.save(obj);
        return true;
    }
    



}
