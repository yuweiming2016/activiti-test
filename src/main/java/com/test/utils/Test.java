package com.test.utils;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.activation.FileDataSource;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.test.common.Config;

public class Test {

	
	public static void main(String[] args){
		Field fields = null;
		try{
		    fields = Config.class.getField("abc");
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(fields.getGenericType());
	}
	
	
	
	
	public static <T> T tranform(Class<T> clz,List<String> result,String[] fieldNames) throws Exception{
		
		T t = clz.newInstance();
		
		for(int i=0;i<fieldNames.length;i++){
			Field field = clz.getField(fieldNames[i]);
			String fieldClass = field.getGenericType().toString();
			
			if(fieldClass.equals("class java.util.String")){
				//字符串
				field.set(t,result.get(i));
			}else if(fieldClass.equals("class java.util.Long") || fieldClass.equals("long")){
				//长整型
				field.set(t,result.get(i));
			}else if(fieldClass.equals("class java.util.Integer") || fieldClass.equals("int")){
				//整形
				field.set(t,result.get(i));
			}else if(fieldClass.equals("class java.util.Date")){
				//日期型
				field.set(t,result.get(i));
			}
		}
		
		
		return t;
		
	}
	
	
}
