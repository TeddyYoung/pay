package com.aotu.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.util.JSONPObject;

public class AppUtil  {
	
	protected static Logger logger = Logger.getLogger(AppUtil.class);
	
	public static void main(String[] args) {
		PageData pd = new PageData();
		pd.put("username", "zhangsan");
		
		checkParam("registered", pd);
	}
	//检查参数是否完整
	public static boolean checkParam(String method, PageData pd){
		boolean result = false;
		
		int falseCount = 0;
		String[] paramArray = new String[20];
		String[] valueArray = new String[20];
		String[] tempArray  = new String[20];  //临时数组
		
		if(method=="registered"){// 注册
			paramArray = Const.APP_REGISTERED_PARAM_ARRAY;  //参数
			valueArray = Const.APP_REGISTERED_VALUE_ARRAY;  //参数名称
			
		}else if(method=="getAppuserByUsernmae"){//根据用户名获取会员信息
			paramArray = Const.APP_GETAPPUSER_PARAM_ARRAY;  
			valueArray = Const.APP_GETAPPUSER_VALUE_ARRAY;
		}
		
		
		int size = paramArray.length;
		for(int i=0;i<size;i++){
			String param = paramArray[i];
			if(!pd.containsKey(param)){
				tempArray[falseCount] = valueArray[i]+"--"+param;
				falseCount += 1;
			}
		}
		
		if(falseCount>0){
			logger.error(method+"接口，请求协议中缺少 "+falseCount+"个 参数");
			for(int j=1;j<=falseCount;j++){
				logger.error("   第"+j+"个："+ tempArray[j-1]);
			}
		} else {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * 设置分页的参数
	 * @param pd
	 * @return
	 */
	public static PageData setPageParam(PageData pd){
		String page_now_str = pd.get("page_now").toString();
		int pageNowInt = Integer.parseInt(page_now_str)-1;
		String page_size_str = pd.get("page_size").toString(); //每页显示记录数
		int pageSizeInt = Integer.parseInt(page_size_str);
		
		String page_now = pageNowInt+"";
		String page_start = (pageNowInt*pageSizeInt)+"";
		
		pd.put("page_now", page_now);
		pd.put("page_start", page_start);
		
		return pd;
	}
	

	
	public static Object returnObject(PageData pd, Map map){
		if(pd.containsKey("callback")){
			String callback = pd.get("callback").toString();
			return new JSONPObject(callback, map);
		}else{
			return map;
		}
	}
}
