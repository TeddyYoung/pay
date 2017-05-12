package com.aotu.mobile.controller.app;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.token.UserToken;
import com.aotu.exception.TokenOutTimeException;
import com.aotu.mobile.controller.base.HandlerResponse;
import com.aotu.mobile.controller.base.MobileBaseController;
import com.aotu.service.ICustomerBankCardService;
import com.aotu.service.ICustomerService;
import com.aotu.service.ISmsService;
import com.aotu.service.token.ITokenService;
import com.aotu.util.PageData;

import jodd.util.StringUtil;

@Controller
@RequestMapping(value = "app/packet")
public class AppPacket extends MobileBaseController {
	/**
	 * @Description:余额
	 * @author ZLB
	 * @date 2016年8月1日 上午9:32:30
	 */
	@RequestMapping(value = "/getAccount")
	public void getAccount(HttpServletResponse response) throws Exception {

	}
	/**
	 * @Description:累计收款
	 * @author ZLB   
	 * @date 2016年8月1日 上午9:34:17
	 */
    @RequestMapping(value="/getTotal")
	public void getTotal(HttpServletResponse response) throws Exception {

	}
    /**
     * @Description: 累计分润
     * @author ZLB   
     * @date 2016年8月1日 上午9:36:00
     */
    @RequestMapping(value="/getShareProfits")
    public void getShareProfits(HttpServletResponse response)throws Exception{
    	
    	
    }
    /**
     * @Description:获取提现信息
     * @author ZLB   
     * @date 2016年8月1日 上午9:39:01
     */
    @RequestMapping(value="getWithdrawInfo")
    public void getWithdrawInfo(HttpServletResponse response)throws Exception{
    	
    	
    }
    /**
     * @Description: 提现
     * @author ZLB   
     * @date 2016年8月1日 上午9:41:02
     */
    @RequestMapping(value="toWithdraw")
    public void toWithdraw(HttpServletResponse response)throws Exception{
    	
    	
    }
    /**
     * @Description:提现明细
     * @author ZLB   
     * @date 2016年8月1日 上午9:42:44
     */
    @RequestMapping(value="getWithdrawDetails")
    public void getWithdrawDetails(HttpServletResponse response)throws Exception{
    	
    	
    }
    /**
     * @Description: 查询支付明细
     * @author ZLB   
     * @date 2016年8月1日 上午9:44:13
     */
    @RequestMapping(value="getPayeeDetails")
    public void getPayeeDetails(HttpServletResponse response)throws Exception{
    	
    	
    }
    /**
     * @Description: 查询分润明细
     * @author ZLB   
     * @date 2016年8月1日 上午9:46:24
     */
    @RequestMapping(value="getProfitsDetails")
    public void getProfitsDetails(HttpServletResponse response)throws Exception{
    	
    	
    }
    /**
     * @Description:查询下级总览
     * @author ZLB   
     * @date 2016年8月1日 上午9:48:12
     */
    @RequestMapping(value="getBranchView")
    public void getBranchView(HttpServletResponse response)throws Exception{
    	
    }
    /**
     * @Description:查询下级明细
     * @author ZLB   
     * @date 2016年8月1日 上午9:49:58
     */
    @RequestMapping(value="getBranchDetails")
    public void getBranchDetails(HttpServletResponse response)throws Exception{
    	
    }
    /**
     * @Description:获取用户等级信息
     * @author ZLB   
     * @date 2016年8月1日 上午9:51:33
     */
    @RequestMapping(value="getLevelInfo")
    public void getLevelInfo(HttpServletResponse response)throws Exception{
    	
    	
    }
}
