package com.aotu.controller.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.controller.BaseController;
import com.aotu.entity.Page;
import com.aotu.entity.system.Role;
import com.aotu.entity.system.User;
import com.aotu.service.IRoleService;
import com.aotu.service.IUserService;

/**
 * 用户信息 Controller
 * @author Teddy
 */
@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController {
	
	@Resource(name="userService")
	private IUserService userService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(User user, Page page, Model model) throws Exception {
		page = this.userService.queryPage(page, user);
		model.addAttribute("page", page);
		return "system/user/userList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "system/user/userAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(User user, Model model) throws Exception {
		this.userService.save(user);
		return "redirect:/user/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		User user = (User)this.userService.get(id);
		model.addAttribute("user", user);
		return "system/user/userUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(User user, Model model) throws Exception {
		this.userService.update(user);
		return "redirect:/user/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.userService.delete(id);
		return "redirect:/user/queryList.do";
	}
	
}
