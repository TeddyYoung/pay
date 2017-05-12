package com.aotu.mobile.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.allinpay.ets.client.StringUtil;
import com.aotu.entity.Customer;
import com.aotu.entity.system.User;
import com.aotu.entity.token.AuthCodeToken;
import com.aotu.entity.token.UserToken;
import com.aotu.mobile.controller.base.HandlerResponse;
import com.aotu.mobile.controller.base.MobileBaseController;
import com.aotu.service.ICustomerService;
import com.aotu.service.ISmsService;
import com.aotu.service.IUserService;
import com.aotu.service.impl.SmsServiceImpl;
import com.aotu.service.mobile.IApiMobileService;
import com.aotu.service.token.ITokenService;
import com.aotu.util.PageData;

@Controller
@RequestMapping(value = "/api/login")
public class ApiLogin extends MobileBaseController{

	
	@Resource(name = "tokenService")
	private ITokenService tokenService;
	
	@Resource(name = "smsService")
	private ISmsService smsService;
	
	
	@Resource(name = "apiMobileService")
	private IApiMobileService apiMobileService;
	
	@Resource(name = "customerService")
	private ICustomerService customerService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/login")
	public void login(HttpServletResponse response) throws Exception {
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			// 接收并打印请求参数
			PageData pageData = this.getPageData();
			logger.info("请求参数 >>>>> " + pageData);
			String phone = pageData.getString("phone");
			String brandId = pageData.getString("brandId");
//			String brandNo = pageData.getString("brandNo");
			String password = pageData.getString("password");
			
			if (StringUtil.isEmpty(phone)||StringUtil.isEmpty(password)||StringUtil.isEmpty(brandId)) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			// 调用userService的登陆方法
			Customer cs = new Customer();
			cs.setPhone(phone);
			cs.setLoginPassword(password);
			cs.setBrandId(brandId);
		    
//			cs.setBrandNo(brandNo);
			List<Customer> customers = customerService.queryList(cs);
			if(customers.size()==0)throw new Exception("该用户未注册！");
			UserToken token = this.tokenService.login(customers.get(0));
			if(token!=null){
				handlerResponse.setResponseCode(RESPONSE_CODE_SUCCESS);
				handlerResponse.setResponseObj(token);
				handlerResponse.setResponseMessage("登录成功");
			}else{
				handlerResponse.setResponseCode(RESPONSE_CODE_FAIL);
				handlerResponse.setResponseMessage("登录未成功，请联系客服人员");
			}
		} catch (Exception e) {
			logger.error(e.toString(), e);
			handlerResponse.setResponseCode(RESPONSE_CODE_FAIL);
			handlerResponse.setResponseMessage(e.getMessage());
		} finally {
			this.writeJson(response, handlerResponse);
		}
	}
	
	
	@RequestMapping(value = "/isTokenVaild")
	public void isTokenVaild(HttpServletResponse response) throws Exception {
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			// 接收并打印请求参数
			PageData pageData = this.getPageData();
			logger.info("请求参数 >>>>> " + pageData);
			String token = pageData.getString("token");
			if (StringUtil.isEmpty(token)) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			Boolean bool = this.tokenService.isVaild(token);
			if(token!=null){
				handlerResponse.setResponseCode(RESPONSE_CODE_SUCCESS);
				handlerResponse.setResponseObj(bool);
			}else{
				handlerResponse.setResponseCode(RESPONSE_CODE_FAIL);
				handlerResponse.setResponseMessage("令牌已经失效请重新登录！");
			}
		} catch (Exception e) {
			logger.error(e.toString(), e);
			handlerResponse.setResponseCode(RESPONSE_CODE_FAIL);
			handlerResponse.setResponseMessage(e.getMessage());
		} finally {
			this.writeJson(response, handlerResponse);
		}
	}
	
	
	@RequestMapping(value = "/getAuthCode")
	public void getAuthCode(HttpServletResponse response) throws Exception {
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			// 接收并打印请求参数
			PageData pageData = this.getPageData();
			logger.info("请求参数 >>>>> " + pageData);
			String phone = pageData.getString("phone");
			String brandId = pageData.getString("brandId");
			if (StringUtil.isEmpty(phone)||StringUtil.isEmpty(brandId)) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			apiMobileService.toSendAuthCode(brandId, phone);
			handlerResponse.setResponseCode(RESPONSE_CODE_SUCCESS);
			handlerResponse.setResponseMessage("短信发送成功！");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			handlerResponse.setResponseCode(RESPONSE_CODE_FAIL);
			handlerResponse.setResponseMessage(e.getMessage());
		} finally {
			this.writeJson(response, handlerResponse);
		}
	}
	
	
	@RequestMapping(value = "/toForgotPwd")
	public void toForgotPwd(HttpServletResponse response) throws Exception {
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			// 接收并打印请求参数
			PageData pageData = this.getPageData();
			logger.info("请求参数 >>>>> " + pageData);
			String phone = pageData.getString("phone");
			String brandId = pageData.getString("brandId");
			String authCode = pageData.getString("authCode");
			String loginPassword = pageData.getString("loginPassword");
			if (StringUtil.isEmpty(brandId)||StringUtil.isEmpty(phone)||StringUtil.isEmpty(authCode)||StringUtil.isEmpty(loginPassword)) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			AuthCodeToken token = new AuthCodeToken(phone,authCode);
			if(this.smsService.isValidCode(token)){
				try {
					Customer customer = customerService.getCustomerByBrandAndPhone(brandId, phone);
					if(customer==null) throw new Exception("查无此用户");
					customer.setLoginPassword(loginPassword);
					this.customerService.update(customer);
				} catch (Exception e) {
					throw new Exception("登录密码修改失败，请联系客服人员！");
				}
			}else{
				throw new Exception("无效验证码！");
			}
			handlerResponse.setResponseCode(RESPONSE_CODE_SUCCESS);
			handlerResponse.setResponseMessage("登录密码修改成功！");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			handlerResponse.setResponseCode(RESPONSE_CODE_FAIL);
			handlerResponse.setResponseMessage(e.getMessage());
		} finally {
			this.writeJson(response, handlerResponse);
		}
	}
	
	@RequestMapping(value = "/toLogout")
	public void toLogout(HttpServletResponse response) throws Exception {
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			// 接收并打印请求参数
			PageData pageData = this.getPageData();
			logger.info("请求参数 >>>>> " + pageData);
			String token = pageData.getString("token");

			if (StringUtil.isEmpty(token)) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			boolean bool = this.tokenService.logout(token);
			if(bool){
				handlerResponse.setResponseCode(RESPONSE_CODE_SUCCESS);
				handlerResponse.setResponseMessage("退出成功！");
			}else{
				throw new Exception("退出失败！");
			}

		} catch (Exception e) {
			logger.error(e.toString(), e);
			handlerResponse.setResponseCode(RESPONSE_CODE_FAIL);
			handlerResponse.setResponseMessage(e.getMessage());
		} finally {
			this.writeJson(response, handlerResponse);
		}
	}
}
