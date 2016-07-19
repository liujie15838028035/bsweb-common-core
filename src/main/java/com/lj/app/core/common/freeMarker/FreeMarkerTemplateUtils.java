package com.lj.app.core.common.freeMarker;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lj.app.core.common.properties.PropertiesUtil;
import com.lj.app.core.common.util.ClassUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerTemplateUtils {

	private static Log log = LogFactory.getLog(FreeMarkerTemplateUtils.class);
	
	private Configuration configuration = null;
	
	 public FreeMarkerTemplateUtils() {  
         configuration = new Configuration();  
         configuration.setDefaultEncoding("UTF-8");  
     }  
	 
	public Configuration getDirectoryForTemplateLoading(File file) throws Exception {
		configuration.setDirectoryForTemplateLoading(file);
		return configuration;
	}
	
	public static String processTemplateIntoString(Template template, Object model)
			throws IOException, TemplateException {
		StringWriter result = new StringWriter();
		template.process(model, result);
		return result.toString();
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	
	/**
	 * 获得公共的配置变量
	 * @return
	 */
	public static Map getShareVars() {
		Map templateModel = new HashMap();
		templateModel.putAll(System.getProperties());
		templateModel.put("env", System.getenv());
		templateModel.put("now", new Date());
		templateModel.putAll(getToolsMap());
		return templateModel;
	}

	/** 得到模板可以引用的工具类  */
	public static Map getToolsMap() {
	    Map toolsMap = new HashMap();
	    String[] tools = PropertiesUtil.getPropertyArray("template_tools_class");
	    for(String className : tools) {
	        try {
	            Object instance = ClassUtil.newInstance(className);
	            toolsMap.put(Class.forName(className).getSimpleName(), instance);
	            log.debug("put tools class:"+className+" with key:"+Class.forName(className).getSimpleName());
	        }catch(Exception e) {
	        	log.error("cannot load tools by className:"+className+" cause:"+e);
	        }
	    }
	    return toolsMap;
	}

	
}
