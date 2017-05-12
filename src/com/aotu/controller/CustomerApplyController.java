package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.CustomerApply;
import com.aotu.entity.Page;
import com.aotu.entity.system.Dept;
import com.aotu.service.ICustomerApplyService;
import com.aotu.util.Const;

/**
 * 客户申请信息 Controller
 * @author Teddy
 */
@Controller
@RequestMapping(value="/customerApply")
public class CustomerApplyController extends BaseController {
	
	@Resource(name="customerApplyService")
	private ICustomerApplyService customerApplyService;
	
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
		return "customerApply/customerApplyTree";
	}
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(CustomerApply customerApply, Page page, Model model) throws Exception {
		Page pageList = this.customerApplyService.queryPage(page, customerApply);
		model.addAttribute("pageList", pageList);
		model.addAttribute("customerApply", customerApply);
		return "customerApply/customerApplyList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "customerApply/customerApplyAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(CustomerApply customerApply, Model model) throws Exception {
		this.customerApplyService.save(customerApply);
		return "redirect:/customerApply/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		CustomerApply customerApply = (CustomerApply)this.customerApplyService.get(id);
		model.addAttribute("customerApply", customerApply);
		return "customerApply/customerApplyUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(CustomerApply customerApply, Model model) throws Exception {
		this.customerApplyService.update(customerApply);
		return "redirect:/customerApply/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.customerApplyService.delete(id);
		return "redirect:/customerApply/queryList.do";
	}
	
	/**
	 * 跳转到审批界面
	 */
	@RequestMapping("/toApprove.do")
	public String toApprove(String id, Model model) throws Exception {
		CustomerApply customerApply = (CustomerApply)this.customerApplyService.get(id);
		model.addAttribute("customerApply", customerApply);
		return "customerApply/customerApplyApprove";
	}
	
}
