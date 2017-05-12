package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.ChannelDAO;
import com.aotu.entity.Channel;
import com.aotu.entity.Order;
import com.aotu.entity.Page;
import com.aotu.service.IChannelService;

/**
 * 支付通道 Service实现类
 * @author zhoujj
 */
@Service("channelService")
public class ChannelServiceImpl implements IChannelService {

	@Autowired
	private ChannelDAO channelDAO;
	
	/**
	 * 新增
	 * @param channel
	 * @throws Exception
	 */
	public void save(Channel channel) throws Exception {
		this.channelDAO.save(channel);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.channelDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param channel
	 * @throws Exception
	 */
	public void update(Channel channel) throws Exception {
		this.channelDAO.update(channel);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Channel get(String id) throws Exception {
		return (Channel)this.channelDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Channel channel) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = channelDAO.queryCount(channel);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<Channel> records = channelDAO.queryPage(page.getPageSize(), page.getStartIndex(), channel);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Channel> queryList(Channel channel) throws Exception {
		List<Channel> records = channelDAO.queryList(channel);
		return records;
	}

}
