package com.aotu.controller;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aotu.entity.Picture;
import com.aotu.service.IPictureService;
import com.aotu.util.CommonConstant;
import com.aotu.util.ShortUUID;

/**图片上传 异步提交
 * @author lijn
 *
 */
@Controller
@RequestMapping("/common")
public class CommonController {

	@Autowired
	private IPictureService pictureService;
	
//	/**图片上传 base 64
//	 * @param file
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("/uploadpicBase64.do") 
//	//使用  MultipartFile 接口    需要  @RequestParam
//	public void uploadpicBase64(String imgData,HttpServletRequest request,HttpServletResponse response) throws Exception{
//			String realPath = request.getSession().getServletContext().getRealPath("/");
//			Picture picture = pictureService.uploadImageBase64(realPath,imgData);
//			//json对象
//			JSONObject js=new JSONObject();
//			//json中添加  数据   key  value 形式   返回图片路径
//			js.put("path", picture.getLargeUrl());
//			js.put("smallUrl", picture.getSmallUrl());
//			js.put("pictureId", picture.getId());
//			//更改编码
//			response.setContentType("application/json;charset=UTF-8");
//			
//			//发送数据到页面
//			response.getWriter().write(js.toString());
//	}
	
	/**
	 * 图片上传 - ajax
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/uploadpic.do") 
	//使用  MultipartFile 接口    需要  @RequestParam
	public void uploadpic(@RequestParam(required=false) MultipartFile[] pic,String type,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		String realPath = request.getSession().getServletContext().getRealPath("/");
		if(pic.length>0){
			Picture picture = pictureService.uploadImage(realPath,pic[pic.length-1],request);
			if(CommonConstant.FLAG_1.equals(type)){
				StringBuffer requestURL=request.getRequestURL(); 
				String path = requestURL.toString();
				String servletPath=request.getServletPath(); 
				path=path.replace(servletPath, "");
				//获取图片url地址
		        String imgUrl = path + picture.getLargeUrl();
		        response.setContentType("text/text;charset=utf-8");
		        PrintWriter out = response.getWriter();
		        out.print(imgUrl);  //返回url地址
		        out.flush();
		        out.close();
			}else{
				//json对象
				JSONObject js=new JSONObject();
				//json中添加  数据   key  value 形式   返回图片路径
				js.put("path", picture.getLargeUrl());
				js.put("smallUrl", picture.getSmallUrl());
				js.put("mediumUrl", picture.getMediumUrl());
				js.put("pictureId", picture.getId());
				/*js.put("url", url);*/
				//更改编码
				response.setContentType("application/json;charset=UTF-8");
				//发送数据到页面
				response.getWriter().write(js.toString());
			}
		}
	}
//	/**计算年龄
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("/countAge.do") 
//	//使用  MultipartFile 接口    需要  @RequestParam
//	public void countAge(String birth,HttpServletRequest request,HttpServletResponse response) throws Exception{
//		if(null!=birth && !"".equals(birth)){
//			birth = birth.replace(",", "");
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			//得到当前的年份
//			String cYear = sdf.format(new Date()).substring(0,4);
//			//得到生日年份
//			String birthYear = birth.substring(0,4);
//
//			int age = Integer.parseInt(cYear) - Integer.parseInt(birthYear);
//			
//			JSONObject js=new JSONObject();
//			//json中添加  数据   key  value 形式   返回图片路径
//			js.put("age", age);
//			js.put("birth", birth);
//			//更改编码
//			response.setContentType("application/json;charset=UTF-8");
//			
//			//发送数据到页面
//			response.getWriter().write(js.toString());
//		}
//	}
	
	@RequestMapping("/getUUID.do") 
	//获取UUID
	public void getUUID(HttpServletResponse response) {
		JSONObject js=new JSONObject();
		try {
			js.put("result", ShortUUID.genId());
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(js.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
