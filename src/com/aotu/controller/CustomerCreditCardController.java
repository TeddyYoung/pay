package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.CustomerCreditCard;
import com.aotu.entity.Page;
import com.aotu.service.ICustomerCreditCardService;

/**
 * 客户信息 Controller
 * @author Teddy
 */
@Controller
@RequestMapping(value="/customerCreditCard")
public class CustomerCreditCardController extends BaseController {
	
	@Resource(name="customerCreditCardService")
	private ICustomerCreditCardService customerCreditCardService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(CustomerCreditCard customerCreditCard, Page page, Model model, String customerId) throws Exception {
		customerCreditCard.setCustomerId(customerId);
		Page pageList = this.customerCreditCardService.queryPage(page, customerCreditCard);
		model.addAttribute("pageList", pageList);
		model.addAttribute("customerCreditCard", customerCreditCard);
		return "customerCreditCard/customerCreditCardList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "customerCreditCard/customerCreditCardAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(CustomerCreditCard customerCreditCard, Model model) throws Exception {
		this.customerCreditCardService.save(customerCreditCard);
		return "redirect:/customerCreditCard/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		CustomerCreditCard customerCreditCard = (CustomerCreditCard)this.customerCreditCardService.get(id);
		model.addAttribute("customerCreditCard", customerCreditCard);
		return "customerCreditCard/customerCreditCardUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(CustomerCreditCard customerCreditCard, Model model) throws Exception {
		this.customerCreditCardService.update(customerCreditCard);
		return "redirect:/customerCreditCard/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.customerCreditCardService.delete(id);
		return "redirect:/customerCreditCard/queryList.do";
	}
	
}
