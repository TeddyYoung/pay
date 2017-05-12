package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.Channel;
import com.aotu.entity.Page;
import com.aotu.service.IChannelService;

/**
 * 客户信息 Controller
 * @author Teddy
 */
@Controller
@RequestMapping(value="/channel")
public class ChannelController extends BaseController {
	
	@Resource(name="channelService")
	private IChannelService channelService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(Channel channel, Page page, Model model) throws Exception {
		Page pageList = this.channelService.queryPage(page, channel);
		model.addAttribute("pageList", pageList);
		model.addAttribute("channel", channel);
		return "channel/channelList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "channel/channelAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(Channel channel, Model model) throws Exception {
		this.channelService.save(channel);
		return "redirect:/channel/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		Channel channel = (Channel)this.channelService.get(id);
		model.addAttribute("channel", channel);
		return "channel/channelUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(Channel channel, Model model) throws Exception {
		this.channelService.update(channel);
		return "redirect:/channel/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.channelService.delete(id);
		return "redirect:/channel/queryList.do";
	}
	
}
