package com.aotu.entity;

import java.math.BigDecimal;

import java.util.Date;
/**
 * 公司分润
 * @author zhoujj
 *
 */
public class CompanyProfit extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String profitNo;//收入单号
	private String companyId;//公司编号
	private String channelId;//通道编号
	private BigDecimal tradeRate;//交易费率
	private BigDecimal companyRate;//公司费率
	private String type;//收入类型
	private BigDecimal tradeAmt;//交易金额
	private BigDecimal profitAmt;//收入金额
	private Date profitDate;//收入日期
	private String tradeCustomerId;//贡献人客户编号
	public String getProfitNo() {
		return profitNo;
	}
	public void setProfitNo(String profitNo) {
		this.profitNo = profitNo;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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
	public BigDecimal getCompanyRate() {
		return companyRate;
	}
	public void setCompanyRate(BigDecimal companyRate) {
		this.companyRate = companyRate;
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
	
	
}
