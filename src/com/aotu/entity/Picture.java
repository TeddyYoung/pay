package com.aotu.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.aotu.entity.BaseEntity;

/**
 * 图片信息表
 */
@Entity
@Table(name="biz_picture")
public class Picture extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	public static final String DEST_EXTENSION = "png";           // 目标扩展名
	public static final String DEST_CONTENT_TYPE = "image/jpeg"; // 目标文件类型
	
	private String picName;//图片名称
	private String largeUrl;//大图地址
	private String mediumUrl;//中图地址
	private String smallUrl;//小图地址
	private int largeHeight;//大图高度
	private int largeWidth;//大图宽度
	private int mediumHeight;//中图高度
	private int mediumWidth;//中图宽度
	private int smallHeight;//小图高度
	private int smallWidth;//小图宽度
	
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	
	public String getLargeUrl() {
		return largeUrl;
	}
	public void setLargeUrl(String largeUrl) {
		this.largeUrl = largeUrl;
	}
	public String getMediumUrl() {
		return mediumUrl;
	}
	public void setMediumUrl(String mediumUrl) {
		this.mediumUrl = mediumUrl;
	}
	public String getSmallUrl() {
		return smallUrl;
	}
	public void setSmallUrl(String smallUrl) {
		this.smallUrl = smallUrl;
	}
	public int getLargeHeight() {
		return largeHeight;
	}
	public void setLargeHeight(int largeHeight) {
		this.largeHeight = largeHeight;
	}
	public int getLargeWidth() {
		return largeWidth;
	}
	public void setLargeWidth(int largeWidth) {
		this.largeWidth = largeWidth;
	}
	public int getMediumHeight() {
		return mediumHeight;
	}
	public void setMediumHeight(int mediumHeight) {
		this.mediumHeight = mediumHeight;
	}
	public int getMediumWidth() {
		return mediumWidth;
	}
	public void setMediumWidth(int mediumWidth) {
		this.mediumWidth = mediumWidth;
	}
	public int getSmallHeight() {
		return smallHeight;
	}
	public void setSmallHeight(int smallHeight) {
		this.smallHeight = smallHeight;
	}
	public int getSmallWidth() {
		return smallWidth;
	}
	public void setSmallWidth(int smallWidth) {
		this.smallWidth = smallWidth;
	}
	
	
}
