package com.aotu.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.Brand;
import com.aotu.entity.Company;
import com.aotu.entity.Page;
import com.aotu.entity.system.Dept;
import com.aotu.entity.system.User;
import com.aotu.service.IBrandService;
import com.aotu.service.ICompanyService;
import com.aotu.service.IDeptService;
import com.aotu.service.IUserService;
import com.aotu.util.Const;
import com.aotu.util.Encrypt;
import com.aotu.util.SysConstant;

/**
 * 客户信息 Controller
 * @author Teddy
 */
@Controller
@RequestMapping(value="/brand")
public class BrandController extends BaseController {
	
	@Resource(name="deptService")
	private IDeptService deptService;
	@Resource(name="brandService")
	private IBrandService brandService;
	@Resource(name="userService")
	private IUserService userService;
	@Resource(name="companyService")
	private ICompanyService companyService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(Brand brand, Page page, Model model) throws Exception {
		page = this.brandService.queryPage(page, brand);
		model.addAttribute("page", page);
		model.addAttribute("brand", brand);
		return "brand/brandList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "brand/brandAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(Brand brand, Model model) throws Exception {
		this.brandService.save(brand);// TODO 还需要保存Dept，User，company、customer信息 需要放到service中进行事务控制
		
		Dept dept = new Dept();
//		dept.setDeptLevel(deptLevel);
		dept.setDeptName(brand.getBrandName());
//		dept.setDeptType(deptType);
		Dept currentDept = (Dept)this.getSession().getAttribute(Const.SESSION_DEPT);
		dept.setParentDeptId(currentDept.getId());
		dept.setStatus(Dept.STATUS_NORMAL);
//		dept.setTarget(target);
//		dept.setUrl(url);
		this.deptService.save(dept);
		
		Company currentCompany = (Company)this.getSession().getAttribute(Const.SESSION_COMPANY);
		Company company = new Company();
//		company.setAddress(address);
		company.setBrandId(brand.getId());
//		company.setCompanyIds(companyIds);
//		company.setCompanyNo(companyNo);
		company.setDeptId(dept.getId());
		company.setFullName(brand.getFullName());
//		company.setLogo(logo);
		company.setParentCompanyId(currentCompany.getId());
//		company.setPhone(phone);
//		company.setPresident(president);
		company.setShortName(brand.getBrandName());
		company.setStatus(Company.STATUS_NORMAL);
//		company.setType(type);
//		company.setUrl(url);
		this.companyService.save(company);
		
		User user = new User();
		user.setUserName(brand.getPhone());
		user.setPassword(Encrypt.md5(SysConstant.CURRENT_USER_PASSWORD, user.getUserName())); //密码加密
		user.setName(brand.getBrandName());
		user.setDeptId(dept.getId());
		user.setPhone(brand.getPhone());
//		user.setRoleId(roleId);// TODO
		user.setStatus(User.STATUS_NORMAL);
		this.userService.save(user);
		return "redirect:/brand/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		Brand brand = (Brand)this.brandService.get(id);
		model.addAttribute("brand", brand);
		return "brand/brandUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(Brand brand, Model model) throws Exception {
		brand.setModifyDate(new Date());
		this.brandService.update(brand);
		return "redirect:/brand/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.brandService.delete(id);
		return "redirect:/brand/queryList.do";
	}
	
}
