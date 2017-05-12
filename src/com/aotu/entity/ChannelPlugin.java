package com.aotu.entity;

import java.math.BigDecimal;

/**
 * 通道配置表
 * @author zhoujj
 *
 */
public class ChannelPlugin extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String channelId;//所属通道id
	private String pluginKey;//配置key
	private String pluginValue;//配置值
	private String pluginName;//配置名称
	
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getPluginKey() {
		return pluginKey;
	}
	public void setPluginKey(String pluginKey) {
		this.pluginKey = pluginKey;
	}
	public String getPluginValue() {
		return pluginValue;
	}
	public void setPluginValue(String pluginValue) {
		this.pluginValue = pluginValue;
	}
	public String getPluginName() {
		return pluginName;
	}
	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}
	
	
}
