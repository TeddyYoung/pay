package com.aotu.entity;

import java.util.Date;

/**
 * 客户待审核信息
 * @author zhoujj
 *
 */
public class CustomerApply extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String customerId;//被审核客户编号
	private String customerType;//客户类型
	private String approveUserId;//审核人
	private String approveResult;//审核结果
	private Date approveTime;//审核时间
	private String approveOpinion;//审核意见
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerType() {
		return customerType;
	}
	
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	public String getApproveUserId() {
		return approveUserId;
	}
	
	public void setApproveUserId(String approveUserId) {
		this.approveUserId = approveUserId;
	}
	
	public String getApproveResult() {
		return approveResult;
	}
	
	public void setApproveResult(String approveResult) {
		this.approveResult = approveResult;
	}
	
	public Date getApproveTime() {
		return approveTime;
	}
	
	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}
	
	public String getApproveOpinion() {
		return approveOpinion;
	}
	
	public void setApproveOpinion(String approveOpinion) {
		this.approveOpinion = approveOpinion;
	}
	
}
