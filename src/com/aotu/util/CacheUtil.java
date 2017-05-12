package com.aotu.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;




import com.aotu.entity.system.Param;
import com.aotu.service.IParamService;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: ab
 * Date: 15-9-5
 * Time: 下午6:27
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("all")
public class CacheUtil {

	@Autowired
	private IParamService iParamService;
	
    private static Log log = LogFactory.getLog(CacheUtil.class);

    private static final String PATH = "/ehcache.xml";

    private static URL url;

    private static CacheManager manager;

    public static CacheManager getCacheManager() {
        if (manager == null) {
            url = CacheUtil.class.getResource(PATH);
            manager = CacheManager.create(url);
        }
        return manager;
    }

    public static Cache getParamCache() {
        return getCacheManager().getCache("paramCache");
    }

    public static String getParamValueByName(String name) {
        String comment = "";
        Element element = getParamCache().get(name);
        if (element == null) {
        	 IParamService paramService = (IParamService)ApplicationContextUtil.getContext().getBean("paramService");
//            IParamService iParamService = (IParamService) SpringUtils.getBean("paramService");
            if (paramService != null) {
                comment = paramService.getParamValueByName(name);
                if (StringUtils.isNotEmpty(comment)) {
                    getParamCache().put(new Element(name, comment));
                }
            }
        }  else {
            comment = (String) element.getObjectValue();
        }

        return comment;
    }

    public static void refreshParamByValue(String value) {
        getParamCache().remove(value);
    }
 
    
}
