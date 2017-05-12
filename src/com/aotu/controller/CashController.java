package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.Cash;
import com.aotu.entity.Page;
import com.aotu.service.ICashService;

/**
 * 客户信息 Controller
 * @author Teddy
 */
@Controller
@RequestMapping(value="/cash")
public class CashController extends BaseController {
	
	@Resource(name="cashService")
	private ICashService cashService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(Cash cash, Page page, Model model) throws Exception {
		Page pageList = this.cashService.queryPage(page, cash);
		model.addAttribute("pageList", pageList);
		model.addAttribute("cash", cash);
		return "cash/cashList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "cash/cashAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(Cash cash, Model model) throws Exception {
		this.cashService.save(cash);
		return "redirect:/cash/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		Cash cash = (Cash)this.cashService.get(id);
		model.addAttribute("cash", cash);
		return "cash/cashUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(Cash cash, Model model) throws Exception {
		this.cashService.update(cash);
		return "redirect:/cash/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.cashService.delete(id);
		return "redirect:/cash/queryList.do";
	}
	
}
