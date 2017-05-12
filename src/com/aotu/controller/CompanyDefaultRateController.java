package com.aotu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.Channel;
import com.aotu.entity.CompanyDefaultRate;
import com.aotu.entity.Page;
import com.aotu.service.IChannelService;
import com.aotu.service.ICompanyDefaultRateService;

/**
 * 公司默认费率配置 Controller
 * @author zhoujj
 */
@Controller
@RequestMapping(value="/companyDefaultRate")
public class CompanyDefaultRateController extends BaseController {
	
	@Resource(name="channelService")
	private IChannelService channelService;
	@Resource(name="companyDefaultRateService")
	private ICompanyDefaultRateService companyDefaultRateService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(CompanyDefaultRate companyDefaultRate, String brandId, Page page, Model model) throws Exception {
		companyDefaultRate.setBrandId(brandId);
		Page pageList = this.companyDefaultRateService.queryPage(page, companyDefaultRate);
		model.addAttribute("pageList", pageList);
		model.addAttribute("companyDefaultRate", companyDefaultRate);
		return "companyDefaultRate/companyDefaultRateList";
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
		return "companyDefaultRate/companyDefaultRateAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(CompanyDefaultRate companyDefaultRate, Model model) throws Exception {
		this.companyDefaultRateService.save(companyDefaultRate);
		return "redirect:/companyDefaultRate/queryList.do?brandId=" + companyDefaultRate.getBrandId();
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
		CompanyDefaultRate companyDefaultRate = (CompanyDefaultRate)this.companyDefaultRateService.get(id);
		
		model.addAttribute("companyDefaultRate", companyDefaultRate);
		model.addAttribute("channelList", channelList);
		return "companyDefaultRate/companyDefaultRateUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(CompanyDefaultRate companyDefaultRate, Model model) throws Exception {
		this.companyDefaultRateService.update(companyDefaultRate);
		return "redirect:/companyDefaultRate/queryList.do?brandId=" + companyDefaultRate.getBrandId();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model,String brandId) throws Exception {
		this.companyDefaultRateService.delete(id);
		return "redirect:/companyDefaultRate/queryList.do?brandId=" + brandId;
	}
	
}
