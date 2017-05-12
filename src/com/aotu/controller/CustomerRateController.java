package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.CustomerRate;
import com.aotu.entity.Page;
import com.aotu.service.ICustomerRateService;

/**
 * 客户信息 Controller
 * @author Teddy
 */
@Controller
@RequestMapping(value="/customerRate")
public class CustomerRateController extends BaseController {
	
	@Resource(name="customerRateService")
	private ICustomerRateService customerRateService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(CustomerRate customerRate, Page page, Model model, String customerId) throws Exception {
		customerRate.setCustomerId(customerId);
		Page pageList = this.customerRateService.queryPage(page, customerRate);
		model.addAttribute("pageList", pageList);
		model.addAttribute("customerRate", customerRate);
		return "customerRate/customerRateList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "customerRate/customerRateAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(CustomerRate customerRate, Model model) throws Exception {
		this.customerRateService.save(customerRate);
		return "redirect:/customerRate/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		CustomerRate customerRate = (CustomerRate)this.customerRateService.get(id);
		model.addAttribute("customerRate", customerRate);
		return "customerRate/customerRateUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(CustomerRate customerRate, Model model) throws Exception {
		this.customerRateService.update(customerRate);
		return "redirect:/customerRate/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.customerRateService.delete(id);
		return "redirect:/customerRate/queryList.do";
	}
	
}
