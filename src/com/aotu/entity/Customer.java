package com.aotu.entity;

import java.util.List;

/**
 * 客户信息
 * @author zhoujj
 *
 */
public class Customer extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	public static final String STATUS_NORMAL = "1";
	public static final String STATUS_FORBIDEN = "0";
	
	private String customerNo;//客户编号
	private String realName;//真实姓名
	private String nickName;//客户昵称
	private String phone;//绑定手机号
	private String idcardNo;//身份证号码
	private String idcardAddress;//身份证地址
	private String idcardFrontPictureId;//身份证正面照ID
	private String idcardBackPictureId;//身份证反面照ID
	private String idcardHalfPictureId;//手持身份证半身照ID
	private String parentCustomerId;//推荐人客户编号
	private String loginPassword;//登陆密码
	private String payPassword;//支付密码
	private String type;//客户类型(1-老板；2-店长；3-店员)
	private String isCompany;//是否代理商
	private String status;//客户状态(1-正常；0-禁用；2-审核未通过)
	private String companyId;//所属公司
	private String fullName;//公司全称
	private String brandId;//品牌id
	private String brandName;//品牌id
	private String brandNo; 
	public String getBrandNo() {
		return brandNo;
	}

	public void setBrandNo(String brandNo) {
		this.brandNo = brandNo;
	}

	private List<Customer> subCustomerList;
	private String companyIds;// 查询条件

	public String getCustomerNo() {
		return customerNo;
	}
	
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	
	public String getRealName() {
		return realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getIdcardNo() {
		return idcardNo;
	}
	
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	
	public String getIdcardAddress() {
		return idcardAddress;
	}
	
	public void setIdcardAddress(String idcardAddress) {
		this.idcardAddress = idcardAddress;
	}
	
	public String getIdcardFrontPictureId() {
		return idcardFrontPictureId;
	}
	
	public void setIdcardFrontPictureId(String idcardFrontPictureId) {
		this.idcardFrontPictureId = idcardFrontPictureId;
	}
	
	public String getIdcardBackPictureId() {
		return idcardBackPictureId;
	}
	
	public void setIdcardBackPictureId(String idcardBackPictureId) {
		this.idcardBackPictureId = idcardBackPictureId;
	}
	
	public String getIdcardHalfPictureId() {
		return idcardHalfPictureId;
	}
	
	public void setIdcardHalfPictureId(String idcardHalfPictureId) {
		this.idcardHalfPictureId = idcardHalfPictureId;
	}
	
	public String getParentCustomerId() {
		return parentCustomerId;
	}
	
	public void setParentCustomerId(String parentCustomerId) {
		this.parentCustomerId = parentCustomerId;
	}
	
	public String getLoginPassword() {
		return loginPassword;
	}
	
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	public String getPayPassword() {
		return payPassword;
	}
	
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getIsCompany() {
		return isCompany;
	}
	
	public void setIsCompany(String isCompany) {
		this.isCompany = isCompany;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	public String getBrandId() {
		return brandId;
	}
	
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	
	public List<Customer> getSubCustomerList() {
		return subCustomerList;
	}
	
	public void setSubCustomerList(List<Customer> subCustomerList) {
		this.subCustomerList = subCustomerList;
	}

	public String getCompanyIds() {
		return companyIds;
	}

	public void setCompanyIds(String companyIds) {
		this.companyIds = companyIds;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
}
