package com.t;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.core.Configurable;
import freemarker.template.*;
/**
 * freemarker 根据模板生成静态网页
 * 
 * 
 * @author sff
 *
 */
public class TestDemo {
public static void main(String[] args) throws IOException, TemplateException {
	//配置
	Configuration cfg = new Configuration();
	//文件夹
	File dir = new File("E:\\MyEclipse\\spring-\\freemarker\\ftl");
	//导入模板
	cfg.setDirectoryForTemplateLoading(dir);
	//获取模板
	Template tmp = cfg.getTemplate("tmp.html");
	//数据
	Map<String, Object> map = new HashMap<String, Object>();
	
	map.put("name","lala");
	
	//输出流
	Writer out = new FileWriter(new File("d:\\hello.html"));
	//生成静态页面
	tmp.process(map, out);
	out.flush();
	out.close();
	System.out.println("success!");
}
}
