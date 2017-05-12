package com.aotu.mobile.controller.app;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aotu.mobile.controller.base.MobileBaseController;
import com.aotu.service.ICustomerBankCardService;
import com.aotu.service.ICustomerService;
import com.aotu.service.token.ITokenService;

@Controller
@RequestMapping(value="app/pay")
public class AppPay extends MobileBaseController{
	/**
	 * @Description:申请收款码 
	 * @author ZLB   
	 * @date 2016年8月1日 上午9:53:52
	 */
    @RequestMapping(value="toApplyPayCode")
	public void toApplyPayCode(HttpServletResponse response)throws Exception{
		
		
	}
	/**
	 * @Description: 即时到账收款码
	 * @author ZLB   
	 * @date 2016年8月1日 上午9:55:41
	 */
    @RequestMapping(value="getIApayeeCode")
    public void getIApayeeCode(HttpServletResponse response)throws Exception{
    	
    	
    }
    /**
     * @Description:隔天到账收款码
     * @author ZLB   
     * @date 2016年8月1日 上午9:57:04
     */
	@RequestMapping(value="getNApayeeCode")
	public void getNApayeeCode(HttpServletResponse response)throws Exception{
	  
		
		
	}
	
	
	
	
	
	
	
}
