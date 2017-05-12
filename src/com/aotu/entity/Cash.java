package com.aotu.entity;

import java.math.BigDecimal;

import java.util.Date;
/**
 * 提现申请
 * @author zhoujj
 *
 */
public class Cash extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String cashNo;//提现单号
	private String customerId;//客户编号
	private BigDecimal tradeRate;//交易费率
	private BigDecimal cashFee;//结算费用手续费
	private BigDecimal cashMax;//结算上限
	private BigDecimal cashAmt;//提现金额
	private String cashType;//结算方式
	private String status;//结算状态
	private Date applyDate;//申请日期
	private String dealUserId;//处理人
	private Date dealDate;//处理日期
	private String depositBank;//开户银行
	private String bankName;//开户行名称
	private String accountNo;//银行帐号
	private String name;//银行户名
	
	public String getCashNo() {
		return cashNo;
	}
	
	public void setCashNo(String cashNo) {
		this.cashNo = cashNo;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public BigDecimal getTradeRate() {
		return tradeRate;
	}
	
	public void setTradeRate(BigDecimal tradeRate) {
		this.tradeRate = tradeRate;
	}
	
	public BigDecimal getCashFee() {
		return cashFee;
	}
	
	public void setCashFee(BigDecimal cashFee) {
		this.cashFee = cashFee;
	}
	
	public BigDecimal getCashMax() {
		return cashMax;
	}
	
	public void setCashMax(BigDecimal cashMax) {
		this.cashMax = cashMax;
	}
	
	public BigDecimal getCashAmt() {
		return cashAmt;
	}
	
	public void setCashAmt(BigDecimal cashAmt) {
		this.cashAmt = cashAmt;
	}
	
	public String getCashType() {
		return cashType;
	}
	
	public void setCashType(String cashType) {
		this.cashType = cashType;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getApplyDate() {
		return applyDate;
	}
	
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	
	public String getDealUserId() {
		return dealUserId;
	}
	
	public void setDealUserId(String dealUserId) {
		this.dealUserId = dealUserId;
	}
	
	public Date getDealDate() {
		return dealDate;
	}
	
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	
	public String getDepositBank() {
		return depositBank;
	}
	
	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
