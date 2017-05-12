package com.aotu.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单信息
 * @author zhoujj
 *
 */
public class Order extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String orderNo;//订单号
	private String customerId;//客户编号
	private String channelId;//通道编号
	private BigDecimal tradeFeeRate;//交易费率
	private BigDecimal settleFeeNormal;//结算费用
	private BigDecimal settleMax;//结算上限
	private BigDecimal tradeAmt;//交易金额
	private BigDecimal takeAmt;//实得金额
	private Date tradeTime;//交易时间
	private String tradeStatus;//订单状态(0-未支付;1-已支付;2-已结算)
	
	public String getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
	
	public BigDecimal getTradeFeeRate() {
		return tradeFeeRate;
	}
	
	public void setTradeFeeRate(BigDecimal tradeFeeRate) {
		this.tradeFeeRate = tradeFeeRate;
	}
	
	public BigDecimal getSettleFeeNormal() {
		return settleFeeNormal;
	}
	
	public void setSettleFeeNormal(BigDecimal settleFeeNormal) {
		this.settleFeeNormal = settleFeeNormal;
	}
	
	public BigDecimal getSettleMax() {
		return settleMax;
	}
	
	public void setSettleMax(BigDecimal settleMax) {
		this.settleMax = settleMax;
	}
	
	public BigDecimal getTradeAmt() {
		return tradeAmt;
	}
	
	public void setTradeAmt(BigDecimal tradeAmt) {
		this.tradeAmt = tradeAmt;
	}
	
	public BigDecimal getTakeAmt() {
		return takeAmt;
	}
	
	public void setTakeAmt(BigDecimal takeAmt) {
		this.takeAmt = takeAmt;
	}
	
	public Date getTradeTime() {
		return tradeTime;
	}
	
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	
	public String getTradeStatus() {
		return tradeStatus;
	}
	
	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	
}
