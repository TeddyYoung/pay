package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.CompanyProfit;
import com.aotu.entity.Page;
import com.aotu.entity.system.Dept;
import com.aotu.service.ICompanyProfitService;
import com.aotu.util.Const;

/**
 * 公司分润 Controller
 * @author zhoujj
 */
@Controller
@RequestMapping(value="/companyProfit")
public class CompanyProfitController extends BaseController {
	
	@Resource(name="companyProfitService")
	private ICompanyProfitService companyProfitService;
	
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
		return "companyProfit/companyProfitTree";
	}
	
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(CompanyProfit companyProfit, Page page, Model model) throws Exception {
		Page pageList = this.companyProfitService.queryPage(page, companyProfit);
		model.addAttribute("pageList", pageList);
		model.addAttribute("companyProfit", companyProfit);
		return "companyProfit/companyProfitList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "companyProfit/companyProfitAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(CompanyProfit companyProfit, Model model) throws Exception {
		this.companyProfitService.save(companyProfit);
		return "redirect:/companyProfit/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		CompanyProfit companyProfit = (CompanyProfit)this.companyProfitService.get(id);
		model.addAttribute("companyProfit", companyProfit);
		return "companyProfit/companyProfitUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(CompanyProfit companyProfit, Model model) throws Exception {
		this.companyProfitService.update(companyProfit);
		return "redirect:/companyProfit/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.companyProfitService.delete(id);
		return "redirect:/companyProfit/queryList.do";
	}
	
}
