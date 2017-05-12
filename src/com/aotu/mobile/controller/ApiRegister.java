package com.aotu.mobile.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import com.allinpay.ets.client.StringUtil;
import com.aotu.entity.Customer;
import com.aotu.entity.CustomerDefaultRate;
import com.aotu.mobile.controller.base.HandlerResponse;
import com.aotu.mobile.controller.base.MobileBaseController;
import com.aotu.service.ICustomerDefaultRateService;
import com.aotu.service.ICustomerRateService;
import com.aotu.service.ICustomerService;
import com.aotu.util.PageData;

public class ApiRegister extends MobileBaseController{
	
	@Resource(name = "customerService")
	private ICustomerService customerService;
	
	@Resource(name = "customerRateService")
	private ICustomerRateService customerRateService;
	
	@Resource(name = "customerDefaultRateService")
	private ICustomerDefaultRateService customerDefaultRateService;
	

	public void isRegisted(HttpServletResponse response)throws Exception{
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
			// 调用userService的登陆方法
			Customer cs = new Customer();
			cs.setPhone(phone);
			cs.setBrandId(brandId);
			List<Customer> customers = customerService.queryList(cs);
			if(customers.size()>0){
				handlerResponse.setResponseObj(false);
			}else{
				handlerResponse.setResponseObj(true);
			}
			handlerResponse.setResponseCode(RESPONSE_CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			handlerResponse.setResponseCode(RESPONSE_CODE_FAIL);
			handlerResponse.setResponseMessage(e.getMessage());
		} finally {
			this.writeJson(response, handlerResponse);
		}
	}
	
	
	
	public void toRegister(HttpServletResponse response)throws Exception{
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			// 接收并打印请求参数
			PageData pageData = this.getPageData();
			logger.info("请求参数 >>>>> " + pageData);
			String phone = pageData.getString("phone");
			String authCode = pageData.getString("authCode");
			String brandId = pageData.getString("brandId");
			String password = pageData.getString("password");
			String parentCustomerId = pageData.getString("parentCustomerId");
			if (StringUtil.isEmpty(phone)||StringUtil.isEmpty(authCode)||StringUtil.isEmpty(password)||StringUtil.isEmpty(brandId)) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			Customer customer = customerService.getCustomerByBrandAndPhone(brandId, phone);
			Customer parentCustomer = customerService.get(parentCustomerId);
			if(customer!=null)throw new Exception("该手机号已经注册！");
			if(parentCustomer==null)throw new Exception("查无此推荐人！");
			List<CustomerDefaultRate> initRates= customerDefaultRateService.getInitRates(brandId);
			customer = new Customer();
			customer.setBrandId(brandId);
			customer.setLoginPassword(password);
			customer.setParentCustomerId(parentCustomerId);
			customer.setPhone(phone);
			customer.setType(initRates.get(0).getCustomerType());
			customer.setCompanyId(parentCustomer.getCompanyId());
			this.customerService.save(customer);
			List<CustomerDefaultRate> highLevelRates= customerDefaultRateService.getHighLevelRates(parentCustomer);
			if(highLevelRates.size()>0){
				customerRateService.saveOrupdateCustomerRate(customer, highLevelRates);
				//推送消息
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
