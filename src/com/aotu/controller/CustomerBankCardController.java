package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.CustomerBankCard;
import com.aotu.entity.Page;
import com.aotu.service.ICustomerBankCardService;

/**
 * 客户信息 Controller
 * @author Teddy
 */
@Controller
@RequestMapping(value="/customerBankCard")
public class CustomerBankCardController extends BaseController {
	
	@Resource(name="customerBankCardService")
	private ICustomerBankCardService customerBankCardService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(CustomerBankCard customerBankCard, Page page, Model model, String customerId) throws Exception {
		customerBankCard.setCustomerId(customerId);
		Page pageList = this.customerBankCardService.queryPage(page, customerBankCard);
		model.addAttribute("pageList", pageList);
		model.addAttribute("customerBankCard", customerBankCard);
		return "customerBankCard/customerBankCardList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model,String customerId) throws Exception {
		model.addAttribute("customerId", customerId);
		return "customerBankCard/customerBankCardAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(CustomerBankCard customerBankCard, Model model) throws Exception {
		this.customerBankCardService.save(customerBankCard);
		return "redirect:/customerBankCard/queryList.do?customerId"+customerBankCard.getCustomerId();
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		CustomerBankCard customerBankCard = (CustomerBankCard)this.customerBankCardService.get(id);
		model.addAttribute("customerBankCard", customerBankCard);
		return "customerBankCard/customerBankCardUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(CustomerBankCard customerBankCard, Model model) throws Exception {
		this.customerBankCardService.update(customerBankCard);
		return "redirect:/customerBankCard/queryList.do?customerId"+customerBankCard.getCustomerId();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model,String customerId) throws Exception {
		this.customerBankCardService.delete(id);
		return "redirect:/customerBankCard/queryList.do?customerId=" + customerId;
	}
	
}
