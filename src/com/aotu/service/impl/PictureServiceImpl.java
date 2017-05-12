package com.aotu.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.java_websocket.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aotu.dao.PictureDAO;
import com.aotu.entity.Page;
import com.aotu.entity.Picture;
import com.aotu.service.IPictureService;
import com.aotu.util.ShortUUID;

import net.coobird.thumbnailator.Thumbnails;
import net.wit.Setting;
import net.wit.util.SettingUtils;

/**
 * 图片信息  Service实现类
 * @author zhoujj
 */
@Service("pictureService")
public class PictureServiceImpl implements IPictureService {

	@Autowired
	private PictureDAO pictureDAO;
	
	/**
	 * 新增
	 * @param picture
	 * @throws Exception
	 */
	public void save(Picture picture) throws Exception {
		this.pictureDAO.save(picture);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.pictureDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param order
	 * @throws Exception
	 */
	public void update(Picture picture) throws Exception {
		this.pictureDAO.update(picture);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Picture get(String id) throws Exception {
		return (Picture)this.pictureDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Picture picture) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = pictureDAO.queryCount(picture);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<Picture> records = pictureDAO.queryPage(page.getPageSize(), page.getStartIndex(), picture);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Picture> queryList(Picture picture) throws Exception {
		List<Picture> records = pictureDAO.queryList(picture);
		return records;
	}
	
	public Picture uploadImage(String realPath,String imgData) {
		
		try {
			String uuid = ShortUUID.genId();
			Picture pic = new Picture();
			pic.setId(uuid);
			pic.setCreateDate(new Date());
			Setting setting = SettingUtils.get();
			String uploadPath = realPath+setting.getImageUploadPath()
					+ new SimpleDateFormat("yyyyMM").format(new Date())
					+ "/";
			File dir = new File(uploadPath);
			if (!dir.exists()) { // 如果该文件目录不存在, 创建它
				dir.mkdirs();
			}
			String largePath = uploadPath + uuid + "-large."
					+ Picture.DEST_EXTENSION;
			String mediumPath = uploadPath + uuid + "-medium."
					+ Picture.DEST_EXTENSION;
			String thumbnailPath = uploadPath + uuid + "-thumbnail."
					+ Picture.DEST_EXTENSION;
			
			//数据库 存储 截取 之后路径  文件夹名 + 文件名
			String spiltUploadPath=setting.getImageUploadPath()
					+ new SimpleDateFormat("yyyyMM").format(new Date())
					+ "/";
			String dbLargePath = spiltUploadPath + uuid + "-large."
					+ Picture.DEST_EXTENSION;
			String dbMediumPath = spiltUploadPath + uuid + "-medium."
					+ Picture.DEST_EXTENSION;
			String dbThumbnailPath = spiltUploadPath + uuid + "-thumbnail."
					+ Picture.DEST_EXTENSION;
			
			pic.setLargeUrl(dbLargePath);
			pic.setMediumUrl(dbMediumPath);
			pic.setSmallUrl(dbThumbnailPath);
			
			//文件名给定 UUID
//			String filename=ShortUUID.genId();
			String filename = spiltUploadPath + uuid;
			pic.setPicName(filename);
			InputStream ins =null;
			if (imgData != null && imgData.length() > 0) {
				// 将字符串转换成二进制，用于显示图片
				// 将上面生成的图片格式字符串 imgStr，还原成图片显示
				byte[] imgByte = Base64.decode(imgData);

				ins=new ByteArrayInputStream(imgByte);
			}
			this.save(pic);
			this.addTask(pic, largePath, mediumPath, thumbnailPath, ins);
			return pic;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private void addTask(Picture pic, String largePath, String mediumPath,
			String thumbnailPath, InputStream ins) {
		try {
			Setting setting = SettingUtils.get();
			try {
				BufferedImage bi = ImageIO.read(ins);
				int resouceHeight = bi.getHeight();
				int resouceWidht = bi.getWidth();
				double scale = (double) resouceHeight / (double) resouceWidht;

				int mediumWidth = setting.getMediumProductImageWidth();
				int mediumHeight = (int) ((double) setting
						.getMediumProductImageHeight() * scale);
				int thumbnailWidth = setting.getThumbnailProductImageWidth();
				int thumbnailHeight = (int) ((double) setting
						.getThumbnailProductImageHeight() * scale);
				pic.setLargeHeight(resouceHeight);
				pic.setLargeWidth(resouceWidht);
				pic.setMediumWidth(mediumWidth);
				pic.setMediumHeight(mediumHeight);
				pic.setSmallWidth(thumbnailWidth);
				pic.setSmallHeight(thumbnailHeight);
				Thumbnails.of(bi).scale(1.0)
						.outputFormat(Picture.DEST_EXTENSION).toFile(largePath);
				Thumbnails.of(bi).forceSize(mediumWidth, mediumHeight)
						.outputFormat(Picture.DEST_EXTENSION)
						.toFile(mediumPath);
				Thumbnails.of(bi).forceSize(thumbnailWidth, thumbnailHeight)
						.outputFormat(Picture.DEST_EXTENSION)
						.toFile(thumbnailPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据  PictureId 查询  Picture
	 */
	public Picture findPictureByPictureId(String pictureId) {
		
//		Picture picture = (Picture) pictureDao.get(Picture.class, pictureId);
//		return picture;
		return null;
		
	}

	@Override
	public Picture uploadImage(String realPath, MultipartFile file, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Picture uploadImageBase64(String realPath, String imgData) {
		// TODO Auto-generated method stub
		return null;
	}

}
