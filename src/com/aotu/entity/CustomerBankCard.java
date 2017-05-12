package com.aotu.entity;

/**
 * 客户银行卡信息
 * @author zhoujj
 *
 */
public class CustomerBankCard extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String customerId;//客户编号
	private String province;//开户行所在省
	private String city;//开户行所在市
	private String deposit;//开户银行
	private String bankName;//开户行名称
	private String cardNo;//银行帐号
	private String name;//银行户名
	private String defaultFlag;//是否主卡
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getDeposit() {
		return deposit;
	}
	
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getCardNo() {
		return cardNo;
	}
	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDefaultFlag() {
		return defaultFlag;
	}
	
	public void setDefaultFlag(String defaultFlag) {
		this.defaultFlag = defaultFlag;
	}
	
}
