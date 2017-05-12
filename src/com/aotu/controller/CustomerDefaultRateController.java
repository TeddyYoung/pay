package com.aotu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.Channel;
import com.aotu.entity.CustomerDefaultRate;
import com.aotu.entity.Page;
import com.aotu.service.IChannelService;
import com.aotu.service.ICustomerDefaultRateService;

/**
 * 客户信息 Controller
 * @author Teddy
 */
@Controller
@RequestMapping(value="/customerDefaultRate")
public class CustomerDefaultRateController extends BaseController {
	
	@Resource(name="channelService")
	private IChannelService channelService;
	@Resource(name="customerDefaultRateService")
	private ICustomerDefaultRateService customerDefaultRateService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(CustomerDefaultRate customerDefaultRate, String brandId, Page page, Model model) throws Exception {
		customerDefaultRate.setBrandId(brandId);
		Page pageList = this.customerDefaultRateService.queryPage(page, customerDefaultRate);
		model.addAttribute("pageList", pageList);
		model.addAttribute("customerDefaultRate", customerDefaultRate);
		return "customerDefaultRate/customerDefaultRateList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model, String brandId) throws Exception {
		// 查询通道列表
		Channel channel = new Channel();
		channel.setStatus(Channel.STATUS_NORMAL);
		List<Channel> channelList = this.channelService.queryList(channel);
		
		model.addAttribute("brandId", brandId);
		model.addAttribute("channelList", channelList);
		return "customerDefaultRate/customerDefaultRateAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(CustomerDefaultRate customerDefaultRate, Model model) throws Exception {
		this.customerDefaultRateService.save(customerDefaultRate);
		return "redirect:/customerDefaultRate/queryList.do?brandId=" + customerDefaultRate.getBrandId();
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		// 查询通道列表
		Channel channel = new Channel();
		channel.setStatus(Channel.STATUS_NORMAL);
		List<Channel> channelList = this.channelService.queryList(channel);
		CustomerDefaultRate customerDefaultRate = (CustomerDefaultRate)this.customerDefaultRateService.get(id);
		
		model.addAttribute("customerDefaultRate", customerDefaultRate);
		model.addAttribute("channelList", channelList);
		return "customerDefaultRate/customerDefaultRateUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(CustomerDefaultRate customerDefaultRate, Model model) throws Exception {
		this.customerDefaultRateService.update(customerDefaultRate);
		return "redirect:/customerDefaultRate/queryList.do?brandId=" + customerDefaultRate.getBrandId();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model, String brandId) throws Exception {
		this.customerDefaultRateService.delete(id);
		return "redirect:/customerDefaultRate/queryList.do?brandId=" + brandId;
	}
	
}
