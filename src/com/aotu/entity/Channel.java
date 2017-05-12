package com.aotu.entity;

import java.math.BigDecimal;

/**
 * 支付通道
 * @author zhoujj
 *
 */
public class Channel extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	public static final String STATUS_NORMAL = "1";// 正常
	public static final String STATUS_FORBIDEN = "2";// 禁用
	
	private String channelNo;//通道编号
	private String channelName;//通道名称
	private String logoPictureId;//logo图片id
	private String channelDesc;//通道简介
	private BigDecimal tradeRate;//交易费率晚间结算费用
	private BigDecimal normalFee;//正常结算费用
	private BigDecimal nightFee;//晚间结算费用
	private BigDecimal holidayFee;//节假日结算费用
	private BigDecimal cashMax;//结算上限
	private String status;//通道状态(1-在用;2-禁用)
	private Integer settleDayThird;//第三方结算周期（天）
	private Integer settleDay;//本系统结算周期（天）
	private String settleType;//是否人工结算
	private String type;//通道类型
	
	public String getChannelNo() {
		return channelNo;
	}
	
	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}
	
	public String getChannelName() {
		return channelName;
	}
	
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	public String getLogoPictureId() {
		return logoPictureId;
	}
	
	public void setLogoPictureId(String logoPictureId) {
		this.logoPictureId = logoPictureId;
	}
	
	public String getChannelDesc() {
		return channelDesc;
	}
	
	public void setChannelDesc(String channelDesc) {
		this.channelDesc = channelDesc;
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
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getSettleDayThird() {
		return settleDayThird;
	}
	
	public void setSettleDayThird(int settleDayThird) {
		this.settleDayThird = settleDayThird;
	}
	

	
	public String getSettleType() {
		return settleType;
	}
	
	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}
	
	public Integer getSettleDay() {
		return settleDay;
	}

	public void setSettleDay(Integer settleDay) {
		this.settleDay = settleDay;
	}

	public void setSettleDayThird(Integer settleDayThird) {
		this.settleDayThird = settleDayThird;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}
