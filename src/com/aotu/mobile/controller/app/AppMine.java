package com.aotu.mobile.controller.app;



import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.allinpay.ets.client.StringUtil;
import com.aotu.entity.Customer;
import com.aotu.entity.CustomerBankCard;
import com.aotu.entity.token.AuthCodeToken;
import com.aotu.entity.token.UserToken;
import com.aotu.exception.TokenOutTimeException;
import com.aotu.mobile.controller.base.HandlerResponse;
import com.aotu.mobile.controller.base.MobileBaseController;
import com.aotu.service.ICustomerBankCardService;
import com.aotu.service.ICustomerService;
import com.aotu.service.ISmsService;
import com.aotu.service.token.ITokenService;
import com.aotu.util.PageData;


@Controller
@RequestMapping(value = "/app/mine")

public class AppMine extends MobileBaseController{
		
	@Resource(name="tokenService")
	private ITokenService tokenService;
	
	@Resource(name="customerService")
	private ICustomerService customerService;
	
	@Resource(name="customerBankCardService")
	private ICustomerBankCardService customerBankCardService;
	

	@Resource(name="smsService")
	private ISmsService smsService;
	
	@RequestMapping(value = "/toUserAuth")
	public void toUserAuth(HttpServletResponse response) throws Exception {
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			// 接收并打印请求参数
			PageData pageData = this.getPageData();
			logger.info("请求参数 >>>>> " + pageData);
			String token = pageData.getString("token");
			String name = pageData.getString("name");
			String cardNo = pageData.getString("cardNo");
			if (StringUtil.isEmpty(name)||StringUtil.isEmpty(token)||StringUtil.isEmpty(cardNo)) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			if(!this.tokenService.isVaild(token)) throw new TokenOutTimeException(handlerResponse);
			UserToken userToken = tokenService.getUserToken(token);
			if(StringUtil.isEmpty(userToken.getName())&&StringUtil.isEmpty(userToken.getCardNo())){
				Customer customer = customerService.get(userToken.getUserId());
				if(customer == null) {
					throw new Exception("该用户未注册！");
				}else{
					if(true){//todo实名认证接口
						customer.setRealName(name);
						customer.setIdcardNo(cardNo);
						userToken.setName(name);
						userToken.setCardNo(cardNo);
						this.tokenService.updateToken(userToken);
						this.customerService.update(customer);
						handlerResponse.setResponseCode(RESPONSE_CODE_SUCCESS);
						handlerResponse.setResponseMessage("认证成功");
					}else{
						throw new Exception("实名信息不正确！");
					}
				}
			}else{
				throw new Exception("已经实名认证过！");
			}
		} catch (TokenOutTimeException e){
			
		} catch (Exception e) {
			handlerResponse.setResponseCode(RESPONSE_CODE_FAIL);
			handlerResponse.setResponseMessage("登录未成功，请联系客服人员");
		}finally{
			this.writeJson(response, handlerResponse);
		}
	}
	
	
	@RequestMapping(value = "/toBankCardAuth")
	public void toBankCardAuth(HttpServletResponse response) throws Exception {
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			// 接收并打印请求参数
			PageData pageData = this.getPageData();
			logger.info("请求参数 >>>>> " + pageData);
			String token = pageData.getString("token");
			String cardNo = pageData.getString("cardNo");
			String bankCardNo = pageData.getString("bankCardNo");
			String authCode = pageData.getString("authCode");
			String deposit = pageData.getString("deposit");
			String province = pageData.getString("province");
			String city = pageData.getString("city");
			if (StringUtil.isEmpty(token)||StringUtil.isEmpty(cardNo)||
					StringUtil.isEmpty(bankCardNo)||StringUtil.isEmpty(authCode)||
							StringUtil.isEmpty(deposit)||StringUtil.isEmpty(province)||StringUtil.isEmpty(city)) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			if(!this.tokenService.isVaild(token)) throw new TokenOutTimeException(handlerResponse);
			UserToken userToken = tokenService.getUserToken(token);
			AuthCodeToken authCodeToken = new AuthCodeToken(userToken.getMobile(),authCode);
			if(this.smsService.isValidCode(authCodeToken)){
				CustomerBankCard customerBankCard = new CustomerBankCard();
				customerBankCard.setCustomerId(userToken.getUserId());
				List<CustomerBankCard> cards =customerBankCardService.queryList(customerBankCard);
				if(cards.size()>0) throw new Exception("已经绑定过了收款卡！");
				else{
					if(true){//四要素验证
						customerBankCard.setCustomerId(userToken.getUserId());
						customerBankCard.setCardNo(bankCardNo);
						customerBankCard.setDeposit(deposit);
						customerBankCard.setProvince(province);
						customerBankCard.setName(userToken.getName());
						this.customerBankCardService.save(customerBankCard);;
					}else{
						throw new Exception("银行卡验证失败！请输入正确的收款信息！");
					}
				}
			}
		} catch (TokenOutTimeException e){
			
		} catch (Exception e) {
			handlerResponse.setResponseCode(RESPONSE_CODE_FAIL);
			handlerResponse.setResponseMessage("登录未成功，请联系客服人员");
		}finally{
			this.writeJson(response, handlerResponse);
		}
	}
	/**
	 * @Description: 获取支付费率 
	 * @author ZLB   
	 * @date 2016年8月1日 上午9:25:57
	 */
	@RequestMapping(value="/getPayeeRate")
    public void getPayeeRate(HttpServletResponse response)throws Exception{
    	
    	
    	
    }
	/**
	 * @Description: 收款码
	 * @author ZLB   
	 * @date 2016年8月1日 上午9:28:11
	 */
	@RequestMapping(value="/getPayeeCode")
	public void getPayeeCode(HttpServletResponse response)throws Exception{
		
		
		
	}
	/**
	 * @Description:获取用户信息
	 * @author ZLB   
	 * @date 2016年8月1日 上午9:29:40
	 */
	@RequestMapping(value="getUserInfo")
	public void getUserInfo(HttpServletResponse response)throws Exception{
		
		
		
	}
	
	
}
