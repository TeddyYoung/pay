package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.ChannelPlugin;
import com.aotu.entity.Page;
import com.aotu.service.IChannelPluginService;

/**
 * 客户信息 Controller
 * @author Teddy
 */
@Controller
@RequestMapping(value="/channelPlugin")
public class ChannelPluginController extends BaseController {
	
	@Resource(name="channelPluginService")
	private IChannelPluginService channelPluginService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(ChannelPlugin channelPlugin, Page page, Model model,String channelId) throws Exception {
		channelPlugin.setChannelId(channelId);
		Page pageList = this.channelPluginService.queryPage(page, channelPlugin);
		model.addAttribute("pageList", pageList);
		model.addAttribute("channelPlugin", channelPlugin);
		return "channelPlugin/channelPluginList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model, String channelId) throws Exception {
		model.addAttribute("channelId", channelId);
		return "channelPlugin/channelPluginAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(ChannelPlugin channelPlugin, Model model) throws Exception {
		this.channelPluginService.save(channelPlugin);
		return "redirect:/channelPlugin/queryList.do?channelId=" + channelPlugin.getChannelId();
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		ChannelPlugin channelPlugin = (ChannelPlugin)this.channelPluginService.get(id);
		model.addAttribute("channelPlugin", channelPlugin);
		return "channelPlugin/channelPluginUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(ChannelPlugin channelPlugin, Model model) throws Exception {
		this.channelPluginService.update(channelPlugin);
		return "redirect:/channelPlugin/queryList.do?channelId=" + channelPlugin.getChannelId();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model, String channelId) throws Exception {
		this.channelPluginService.delete(id);
		return "redirect:/channelPlugin/queryList.do?channelId=" + channelId;
	}
	
}
