package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.Company;
import com.aotu.entity.Page;
import com.aotu.entity.system.Dept;
import com.aotu.service.ICompanyService;
import com.aotu.util.Const;

/**
 * 公司信息 Controller
 * @author zhoujj
 */
@Controller
@RequestMapping(value="/company")
public class CompanyController extends BaseController {
	
	@Resource(name="companyService")
	private ICompanyService companyService;
	
	/**
	 * 查询部门树
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryTree")
	public String queryTree(Model model,Page page,Dept dept) throws Exception {
		Dept currentDept = (Dept)this.getSession().getAttribute(Const.SESSION_DEPT);// 当前用户所属部门
		String json = this.queryDeptTree(currentDept);// 获取机构数
		json = json.replaceAll("dept/queryList", "company/queryList");// 替换子机构列表
		model.addAttribute("zTreeNodes", json);
		return "company/companyTree";
	}
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(Company company, Page page, Model model) throws Exception {
		String pid = getRequest().getParameter("pid");
		// 通过部门Id获取公司的ID及其下属ID
		String companyIds = this.companyService.getCompanyIds(pid);
		company.setCompanyIds(companyIds);
		Page pageList = this.companyService.queryPage(page, company);
		
		model.addAttribute("pageList", pageList);
		model.addAttribute("company", company);
		return "company/companyList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "company/companyAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(Company company, Model model) throws Exception {
		this.companyService.save(company);
		return "redirect:/company/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		Company company = (Company)this.companyService.get(id);
		model.addAttribute("company", company);
		return "company/companyUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(Company company, Model model) throws Exception {
		this.companyService.update(company);
		return "redirect:/company/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.companyService.delete(id);
		return "redirect:/company/queryList.do";
	}
	
}
