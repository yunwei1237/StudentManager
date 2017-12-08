package com.tcf.util;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcf.entity.Clazz;

public class Convert {
	
	//用于存储数据集合
	private Map map;
	private ObjectMapper mapper; //转换器 
	//不允许其它用户创建
	private Convert(Map map) {
		super();
		this.map = map;
		this.mapper = new ObjectMapper(); //转换器 
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//忽略与实体不对应的属性
	}
	//通过该方法创建
	public static Convert getConvert(Map map){
		return new Convert(map);
	}
	//获得String对象
	public String getString(String key){
		if(!map.containsKey(key)) return null;
		return map.get(key).toString();
	}
	//获得Boolean对象
	public Boolean getBoolean(String key){
		if(!map.containsKey(key)) return null;
		return Boolean.parseBoolean(map.get(key).toString());
	}
	//获得Byte对象
	public Byte getByte(String key){
		if(!map.containsKey(key)) return null;
		return Byte.parseByte(map.get(key).toString());
	}
	//获得Short对象
	public Short getShort(String key){
		if(!map.containsKey(key)) return null;
		return Short.parseShort(map.get(key).toString());
	}
	//获得Integer对象
	public Integer getInt(String key){
		if(!map.containsKey(key)) return null;
		return Integer.parseInt(map.get(key).toString());
	}
	//获得Long对象
	public Long getLong(String key){
		if(!map.containsKey(key)) return null;
		return Long.parseLong(map.get(key).toString());
	}
	//获得Long对象
	public Float getFloat(String key){
		if(!map.containsKey(key)) return null;
		return Float.parseFloat(map.get(key).toString());
	}
	//获得Long对象
	public Double getDouble(String key){
		if(!map.containsKey(key)) return null;
		return Double.parseDouble(map.get(key).toString());
	}
	
	private static List<SimpleDateFormat> sdfs = new ArrayList<SimpleDateFormat>();
	static{
		sdfs.add(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
		sdfs.add(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss"));
		sdfs.add(new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒"));
		sdfs.add(new SimpleDateFormat("yyyy.MM.dd"));
		sdfs.add(new SimpleDateFormat("yyyy-MM-dd"));
		sdfs.add(new SimpleDateFormat("yyyy/MM/dd"));
		sdfs.add(new SimpleDateFormat("MM-dd-yyyy"));
	}
	//获得Date对象
	public java.util.Date getUtilDate(String key){
		if(!map.containsKey(key)) return null;
		
		Object obj = map.get(key);
		if(obj instanceof java.util.Date){
			return (java.util.Date) obj;
		}else if(obj instanceof java.sql.Date){
			return new java.util.Date(((java.sql.Date)obj).getTime());
		}else if(obj instanceof String){
			java.util.Date date = null;
			for(SimpleDateFormat sdf : sdfs){
				try {
					date = sdf.parse(obj.toString());
					break;
				} catch (ParseException e) {
					// 转换日期出错时
				}
			}
			if(date == null) throw new RuntimeException("无法识别日期："+obj);
			return date;
		}
		throw new RuntimeException(String.format("无法将与%s对应的值转换成日期类型：", key));
	}
	//获得Date对象
	public java.sql.Date getSqlDate(String key){
		if(!map.containsKey(key)) return null;
		
		Object obj = map.get(key);
		if(obj instanceof java.util.Date){
			return new java.sql.Date(((java.util.Date)obj).getTime());
		}else if(obj instanceof java.sql.Date){
			return (java.sql.Date) obj;
		}else if(obj instanceof String){
			java.sql.Date date = null;
			for(SimpleDateFormat sdf : sdfs){
				try {
					date = new java.sql.Date(sdf.parse(obj.toString()).getTime());
					break;
				} catch (ParseException e) {
					// 转换日期出错时
				}
			}
			if(date == null) throw new RuntimeException("无法识别日期："+obj);
			return date;
		}
		throw new RuntimeException(String.format("无法将与%s对应的值转换成日期类型：", key));
	}
	/**
	 * 获得Object对象
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object getClass(Class clazz){
		try {
			return mapper.readValue(mapper.writeValueAsString(map), clazz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Object getObject(Class clazz,String key){
		String name = clazz.getName();
		if("java.lang.String".equals(name)){
			return getString(key);
		}else if("java.lang.Integer".equals(name) || "int".equals(name)){
			return getInt(key);
		}else if("java.lang.Boolean".equals(name) || "boolean".equals(name)){
			return getBoolean(key);
		}else if("java.lang.Byte".equals(name) || "byte".equals(name)){
			return getByte(key);
		}else if("java.lang.Short".equals(name) || "short".equals(name)){
			return getShort(key);
		}else if("java.lang.Long".equals(name) || "long".equals(name)){
			return getLong(key);
		}else if("java.lang.Float".equals(name) || "float".equals(name)){
			return getFloat(key);
		}else if("java.lang.Double".equals(name) || "double".equals(name)){
			return getDouble(key);
		}else if("java.sql.Date".equals(name)){
			return getSqlDate(key);
		}else if("java.util.Date".equals(name)){
			return getUtilDate(key);
		}else{
			return getClass(clazz);
		}
	}
	public static void main(String[] args) {
		Convert con = Convert.getConvert(null);
		/*System.out.println(con.isBaseType(String.class));*/
		/*System.out.println(con.getPropery("name", "root.grade"));*/
	}
}
