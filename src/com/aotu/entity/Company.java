package com.aotu.entity;

import java.util.List;

/**
 * 公司信息
 * @author zhoujj
 *
 */
public class Company extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	public static final String STATUS_NORMAL = "1";
	public static final String STATUS_FORBIDEN = "2";
	
	private String companyNo;//公司编号
	private String shortName;//公司简称
	private String fullName;//公司全称
	private String address;//公司地址
	private String president;//法人代表
	private String phone;//联系电话
	private String url;//公司网址
	private String logo;//公司LOGO
	private String type;//公司类型(1-总部;2-代理公司)
	private String parentCompanyId;//上级公司编号
	private String status;//公司状态(1-正常;2-注销)
	private String brandId;//品牌id
	private String brandName;//品牌
	private String deptId;// 所属部门
	
	private List<Company> subCompanyList;// 下级公司
	
	private String companyIds;// 查询条件
	
	public String getCompanyNo() {
		return companyNo;
	}
	
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPresident() {
		return president;
	}
	
	public void setPresident(String president) {
		this.president = president;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLogo() {
		return logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getParentCompanyId() {
		return parentCompanyId;
	}
	
	public void setParentCompanyId(String parentCompanyId) {
		this.parentCompanyId = parentCompanyId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getBrandId() {
		return brandId;
	}
	
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public List<Company> getSubCompanyList() {
		return subCompanyList;
	}

	public void setSubCompanyList(List<Company> subCompanyList) {
		this.subCompanyList = subCompanyList;
	}

	public String getCompanyIds() {
		return companyIds;
	}

	public void setCompanyIds(String companyIds) {
		this.companyIds = companyIds;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
}
