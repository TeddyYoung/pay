package com.aotu.entity;

import java.math.BigDecimal;

/**
 * 公司信息
 * @author zhoujj
 *
 */
public class CustomerAccount extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String customerId;//所属客户ID
	private BigDecimal balanceAmt;//账户余额
	private BigDecimal profitAmt;//分润余额
	private BigDecimal freezeAmt;//冻结余额
	private BigDecimal avaliableAmt;//可用余额
	private String type;//账户类型
	private String currency;//币种
	
	public CustomerAccount(){
		
	}
	
	public CustomerAccount(Customer customer){
		this.setCustomerId(customer.getId());
		this.setBalanceAmt(new BigDecimal(0));
		this.setAvaliableAmt(new BigDecimal(0));
		this.setFreezeAmt(new BigDecimal(0));
		this.setProfitAmt(new BigDecimal(0));
	}
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public BigDecimal getBalanceAmt() {
		return balanceAmt;
	}
	public void setBalanceAmt(BigDecimal balanceAmt) {
		this.balanceAmt = balanceAmt;
	}
	public BigDecimal getProfitAmt() {
		return profitAmt;
	}
	public void setProfitAmt(BigDecimal profitAmt) {
		this.profitAmt = profitAmt;
	}
	public BigDecimal getFreezeAmt() {
		return freezeAmt;
	}
	public void setFreezeAmt(BigDecimal freezeAmt) {
		this.freezeAmt = freezeAmt;
	}
	public BigDecimal getAvaliableAmt() {
		return avaliableAmt;
	}
	public void setAvaliableAmt(BigDecimal avaliableAmt) {
		this.avaliableAmt = avaliableAmt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}