package com.aotu.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.aotu.entity.Picture;

/**
 * 图片信息 Service
 * @author zhoujj
 */
public interface IPictureService {

	public Picture uploadImage(String realPath , MultipartFile file,HttpServletRequest request);
	
	/**
	 * 根据  PictureId 查询  Picture
	 */
	public Picture findPictureByPictureId(String pictureId);
	/**   
	  * @Title:base64 字符串上传图片
	  * @Description:  
	  * @author ljn   
	  * @date 2016-3-20 
	  * @return
	  */
	public Picture uploadImageBase64(String realPath,String imgData);
}
	

