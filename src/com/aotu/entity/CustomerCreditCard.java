package com.aotu.entity;

/**
 * 客户信用卡信息
 * @author zhoujj
 *
 */
public class CustomerCreditCard extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String customerId;//客户编号
	private String depositBank;//开户银行
	private String cardNo;//信用卡卡号
	private String cardName;//信用卡户名
	private String cardCvv;//信用卡cvv2码
	private String cardMonth;//信用卡有限期（XX月XX年）
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getDepositBank() {
		return depositBank;
	}
	
	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}
	
	public String getCardNo() {
		return cardNo;
	}
	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	public String getCardName() {
		return cardName;
	}
	
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	public String getCardCvv() {
		return cardCvv;
	}
	
	public void setCardCvv(String cardCvv) {
		this.cardCvv = cardCvv;
	}
	
	public String getCardMonth() {
		return cardMonth;
	}
	
	public void setCardMonth(String cardMonth) {
		this.cardMonth = cardMonth;
	}

}
