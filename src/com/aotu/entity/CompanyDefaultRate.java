package com.aotu.entity;

import java.math.BigDecimal;

/**
 * 公司默认费率配置
 * @author zhoujj
 *
 */
public class CompanyDefaultRate extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String companyType;//公司类型
	private String companyTypeName;//公司类型名称
	private String channelId;//通道编号
	private BigDecimal tradeRate;//交易费率
	private BigDecimal normalFee;//正常结算费用
	private BigDecimal nightFee;//晚间结算费用
	private BigDecimal holidayFee;//节假日结算费用
	private BigDecimal cashMax;//结算上限
	private String brandId;//品牌id
	private String brandName;//品牌名称
	private String channelName;//品牌id
	
	
	public String getCompanyType() {
		return companyType;
	}
	
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	
	public String getCompanyTypeName() {
		return companyTypeName;
	}

	public void setCompanyTypeName(String companyTypeName) {
		this.companyTypeName = companyTypeName;
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

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
}
