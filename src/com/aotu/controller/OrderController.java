package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.Order;
import com.aotu.entity.Page;
import com.aotu.service.IOrderService;

/**
 * 订单信息 Controller
 * @author Teddy
 */
@Controller
@RequestMapping(value="/order")
public class OrderController extends BaseController {
	
	@Resource(name="orderService")
	private IOrderService orderService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(Order order, Page page, Model model) throws Exception {
		page = this.orderService.queryPage(page, order);
		model.addAttribute("page", page);
		model.addAttribute("order", order);
		return "order/orderList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "order/orderAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(Order order, Model model) throws Exception {
		this.orderService.save(order);
		return "redirect:/order/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		Order order = (Order)this.orderService.get(id);
		model.addAttribute("order", order);
		return "order/orderUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(Order order, Model model) throws Exception {
		this.orderService.update(order);
		return "redirect:/order/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.orderService.delete(id);
		return "redirect:/order/queryList.do";
	}
	
}
