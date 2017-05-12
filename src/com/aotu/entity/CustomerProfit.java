package com.aotu.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户分润收入
 * @author zhoujj
 *
 */
public class CustomerProfit extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private String profitNo;//收入单号
	private String cutomerId;//客户编号
	private String channelId;//通道编号
	private BigDecimal tradeRate;//交易费率
	private BigDecimal customerRate;//客户本人费率
	private String type;//收入类型((1-分润收入;2-提现收入))
	private BigDecimal tradeAmt;//交易金额
	private BigDecimal profitAmt;//收入金额
	private Date profitDate;//收入日期
	private String tradeCustomerId;//交易客户
	private String orderId;//订单编号
	public String getProfitNo() {
		return profitNo;
	}
	public void setProfitNo(String profitNo) {
		this.profitNo = profitNo;
	}
	public String getCutomerId() {
		return cutomerId;
	}
	public void setCutomerId(String cutomerId) {
		this.cutomerId = cutomerId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public BigDecimal getTradeRate() {
		return tradeRate;
	}
	public void setTradeRate(BigDecimal tradeRate) {
		this.tradeRate = tradeRate;
	}
	public BigDecimal getCustomerRate() {
		return customerRate;
	}
	public void setCustomerRate(BigDecimal customerRate) {
		this.customerRate = customerRate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getTradeAmt() {
		return tradeAmt;
	}
	public void setTradeAmt(BigDecimal tradeAmt) {
		this.tradeAmt = tradeAmt;
	}
	public BigDecimal getProfitAmt() {
		return profitAmt;
	}
	public void setProfitAmt(BigDecimal profitAmt) {
		this.profitAmt = profitAmt;
	}
	public Date getProfitDate() {
		return profitDate;
	}
	public void setProfitDate(Date profitDate) {
		this.profitDate = profitDate;
	}
	public String getTradeCustomerId() {
		return tradeCustomerId;
	}
	public void setTradeCustomerId(String tradeCustomerId) {
		this.tradeCustomerId = tradeCustomerId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
	
}
