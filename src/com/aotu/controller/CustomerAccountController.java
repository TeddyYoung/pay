package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.CustomerAccount;
import com.aotu.entity.Page;
import com.aotu.service.ICustomerAccountService;

/**
 * 客户信息 Controller
 * @author Teddy
 */
@Controller
@RequestMapping(value="/customerAccount")
public class CustomerAccountController extends BaseController {
	
	@Resource(name="customerAccountService")
	private ICustomerAccountService customerAccountService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(CustomerAccount customerAccount, Page page, Model model) throws Exception {
		Page pageList = this.customerAccountService.queryPage(page, customerAccount);
		model.addAttribute("pageList", pageList);
		model.addAttribute("customerAccount", customerAccount);
		return "customerAccount/customerAccountList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "customerAccount/customerAccountAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(CustomerAccount customerAccount, Model model) throws Exception {
		this.customerAccountService.save(customerAccount);
		return "redirect:/customerAccount/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		CustomerAccount customerAccount = (CustomerAccount)this.customerAccountService.get(id);
		model.addAttribute("customerAccount", customerAccount);
		return "customerAccount/customerAccountUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(CustomerAccount customerAccount, Model model) throws Exception {
		this.customerAccountService.update(customerAccount);
		return "redirect:/customerAccount/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.customerAccountService.delete(id);
		return "redirect:/customerAccount/queryList.do";
	}
	
}
