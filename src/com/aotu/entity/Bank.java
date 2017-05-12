package com.aotu.entity;

/**
 * 银行基础信息
 * @author zhoujj
 *
 */
public class Bank extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String province;//省名称
	private String city;//市名称
	private String headOffice;//总行名称
	private String subbranch;//支行名称
	private String contactNo;//联行号
	
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
	
	public String getHeadOffice() {
		return headOffice;
	}
	
	public void setHeadOffice(String headOffice) {
		this.headOffice = headOffice;
	}
	
	public String getSubbranch() {
		return subbranch;
	}
	
	public void setSubbranch(String subbranch) {
		this.subbranch = subbranch;
	}
	
	public String getContactNum() {
		return contactNo;
	}
	
	public void setContactNum(String contactNum) {
		this.contactNo = contactNum;
	}
	
}
