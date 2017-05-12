package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.Company;
import com.aotu.entity.CompanyAccount;
import com.aotu.entity.Page;
import com.aotu.service.ICompanyAccountService;

/**
 * 公司账户 Controller
 * @author zhoujj
 */
@Controller
@RequestMapping(value="/companyAccount")
public class CompanyAccountController extends BaseController {
	
	@Resource(name="companyAccountService")
	private ICompanyAccountService companyAccountService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(CompanyAccount companyAccount, Page page, Model model) throws Exception {
		Page pageList = this.companyAccountService.queryPage(page, companyAccount);
		model.addAttribute("pageList", pageList);
		model.addAttribute("companyAccount", companyAccount);
		return "companyAccount/companyAccountList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "companyAccount/companyAccountAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(CompanyAccount companyAccount, Model model) throws Exception {
		this.companyAccountService.save(companyAccount);
		return "redirect:/companyAccount/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		CompanyAccount companyAccount = (CompanyAccount)this.companyAccountService.get(id);
		model.addAttribute("companyAccount", companyAccount);
		return "companyAccount/companyAccountUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(CompanyAccount companyAccount, Model model) throws Exception {
		this.companyAccountService.update(companyAccount);
		return "redirect:/companyAccount/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.companyAccountService.delete(id);
		return "redirect:/companyAccount/queryList.do";
	}
	
}
