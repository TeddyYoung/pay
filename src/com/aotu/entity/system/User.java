package com.aotu.entity.system;

import java.util.Date;

import com.aotu.entity.BaseEntity;

/**
 * 系统用户
 * @author zhoujj
 *
 */
public class User extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	public static final String STATUS_NORMAL = "1";
	public static final String STATUS_FORBIDEN = "0";

	private String userName;// 用户名
	private String password;//密码
	private String name;//名称
	private Date lastLoginDate;//最后登入时间
	private String loginIp;//登入IP
	private String status;//状态(1-可用；0-禁用)
	private String phone;//手机号码
	private String deptId;//所属部门ID
	private String roleId;// 所属角色ID
	public String getRoleId() {
		return roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
