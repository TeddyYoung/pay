package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.CustomerProfit;
import com.aotu.entity.Page;
import com.aotu.entity.system.Dept;
import com.aotu.service.ICustomerProfitService;
import com.aotu.util.Const;

/**
 * 客户信息 Controller
 * @author Teddy
 */
@Controller
@RequestMapping(value="/customerProfit")
public class CustomerProfitController extends BaseController {
	
	@Resource(name="customerProfitService")
	private ICustomerProfitService customerProfitService;
	
	/**
	 * 查询部门树
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryTree")
	public String queryTree(Model model,Page page,Dept dept) throws Exception {
		Dept currentDept = (Dept)this.getSession().getAttribute(Const.SESSION_DEPT);// 当前用户所属部门
		String json = this.queryDeptTree(currentDept);// 获取机构数
		model.addAttribute("zTreeNodes", json);
		return "customerProfit/customerProfitTree";
	}
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(CustomerProfit customerProfit, String customerId, Page page, Model model) throws Exception {
		customerProfit.setCutomerId(customerId);
		Page pageList = this.customerProfitService.queryPage(page, customerProfit);
		model.addAttribute("pageList", pageList);
		model.addAttribute("customerProfit", customerProfit);
		return "customerProfit/customerProfitList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model, String customerId) throws Exception {
		model.addAttribute("customerId", customerId);
		return "customerProfit/customerProfitAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(CustomerProfit customerProfit, Model model) throws Exception {
		this.customerProfitService.save(customerProfit);
		return "redirect:/customerProfit/queryList.do?customerId=" + customerProfit.getCutomerId();
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		CustomerProfit customerProfit = (CustomerProfit)this.customerProfitService.get(id);
		model.addAttribute("customerProfit", customerProfit);
		return "customerProfit/customerProfitUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(CustomerProfit customerProfit, Model model) throws Exception {
		this.customerProfitService.update(customerProfit);
		return "redirect:/customerProfit/queryList.do?customerId=" + customerProfit.getCutomerId();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model, String customerId) throws Exception {
		this.customerProfitService.delete(id);
		return "redirect:/customerProfit/queryList.do?customerId=" + customerId;
	}
	
}
