package com.aotu.entity;

import java.math.BigDecimal;

/**
 * 客户费率信息
 * @author zhoujj
 *
 */
public class CustomerRate extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private String customerId;//客户编号
	private String channelId;//通道编号
	private BigDecimal tradeRate;//交易费率
	private BigDecimal normalFee;//正常结算费用
	private BigDecimal nightFee;//晚间结算费用
	private BigDecimal holidayFee;//节假日结算费用
	private BigDecimal cashMax;//结算上限
	private BigDecimal accountAmt;//通道帐户余额
	private BigDecimal profitAmt;//通道分润余额
	private BigDecimal totalProfitAmt;//通道累计分润
	private BigDecimal totalAccountAmt;//通道累计收入
	
	public CustomerRate(){
		
	}
	public CustomerRate(CustomerDefaultRate defaultRate,Customer cutomer){
		this.setAccountAmt(new BigDecimal(0));
		this.setCashMax(defaultRate.getCashMax());
		this.setChannelId(defaultRate.getChannelId());
		this.setCustomerId(cutomer.getId());
		this.setHolidayFee(defaultRate.getHolidayFee());
		this.setNightFee(defaultRate.getNightFee());
		this.setNormalFee(defaultRate.getNormalFee());
		this.setProfitAmt(new BigDecimal(0));
		this.setTotalAccountAmt(new BigDecimal(0));
		this.setTotalProfitAmt(new BigDecimal(0));
		this.setTradeRate(defaultRate.getTradeRate());
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	
	public BigDecimal getNormalFee() {
		return normalFee;
	}
	
	public void setNormalFee(BigDecimal normalFee) {
		this.normalFee = normalFee;
	}
	
	public BigDecimal getNightFee() {
		return nightFee;
	}
	
	public void setNightFee(BigDecimal nightFee) {
		this.nightFee = nightFee;
	}
	
	public BigDecimal getHolidayFee() {
		return holidayFee;
	}
	
	public void setHolidayFee(BigDecimal holidayFee) {
		this.holidayFee = holidayFee;
	}
	
	public BigDecimal getCashMax() {
		return cashMax;
	}
	
	public void setCashMax(BigDecimal cashMax) {
		this.cashMax = cashMax;
	}
	
	public BigDecimal getAccountAmt() {
		return accountAmt;
	}
	
	public void setAccountAmt(BigDecimal accountAmt) {
		this.accountAmt = accountAmt;
	}
	
	public BigDecimal getProfitAmt() {
		return profitAmt;
	}
	
	public void setProfitAmt(BigDecimal profitAmt) {
		this.profitAmt = profitAmt;
	}
	
	public BigDecimal getTotalProfitAmt() {
		return totalProfitAmt;
	}
	
	public void setTotalProfitAmt(BigDecimal totalProfitAmt) {
		this.totalProfitAmt = totalProfitAmt;
	}
	
	public BigDecimal getTotalAccountAmt() {
		return totalAccountAmt;
	}
	
	public void setTotalAccountAmt(BigDecimal totalAccountAmt) {
		this.totalAccountAmt = totalAccountAmt;
	}
	
}
