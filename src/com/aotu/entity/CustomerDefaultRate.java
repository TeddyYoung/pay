package com.aotu.entity;

import java.math.BigDecimal;

/**
 * 客户默认费率配置
 * @author zhoujj
 *
 */
public class CustomerDefaultRate extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String customerType;//客户类型
	private String customerTypeName;//客户类型名称
	private Integer upgradeCondition;//条件
	private String channelId;//通道编号
	private BigDecimal tradeRate;//交易费率
	private BigDecimal normalFee;//正常结算费用
	private BigDecimal nightFee;//晚间结算费用
	private BigDecimal holidayFee;//节假日结算费用
	private BigDecimal cashMax;//结算上限
	private String brandId;//品牌id
	private String brandName;//品牌名称
	private String channelName;//通道编号
	
	
	public String getCustomerType() {
		return customerType;
	}
	
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	public String getCustomerTypeName() {
		return customerTypeName;
	}

	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}
	
	public Integer getUpgradeCondition() {
		return upgradeCondition;
	}

	public void setUpgradeCondition(Integer upgradeCondition) {
		this.upgradeCondition = upgradeCondition;
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	
	
}
