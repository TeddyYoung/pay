package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.Customer;
import com.aotu.entity.Page;
import com.aotu.entity.system.Dept;
import com.aotu.service.ICompanyService;
import com.aotu.service.ICustomerService;
import com.aotu.util.Const;

/**
 * 客户信息 Controller
 * @author Teddy
 */
@Controller
@RequestMapping(value="/customer")
public class CustomerController extends BaseController {
	
	@Resource(name="customerService")
	private ICustomerService customerService;
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
		String json = this.queryDeptTree(currentDept);// 获取机构树
		json = json.replaceAll("dept/queryList", "customer/queryList");// 替换子机构列表
		model.addAttribute("zTreeNodes", json);
		return "customer/customerTree";
	}
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(Customer customer, Page page, Model model) throws Exception {
		String pid = getRequest().getParameter("pid");
		// 通过部门Id获取公司的ID及其下属ID
		String companyIds = this.companyService.getCompanyIds(pid);
		customer.setCompanyIds(companyIds);
		Page pageList = this.customerService.queryPage(page, customer);
		model.addAttribute("pageList", pageList);
		model.addAttribute("customer", customer);
		return "customer/customerList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "customer/customerAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(Customer customer, Model model) throws Exception {
		this.customerService.save(customer);
		return "redirect:/customer/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		Customer customer = (Customer)this.customerService.get(id);
		model.addAttribute("customer", customer);
		return "customer/customerUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(Customer customer, Model model) throws Exception {
		this.customerService.update(customer);
		return "redirect:/customer/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.customerService.delete(id);
		return "redirect:/customer/queryList.do";
	}
	
}
