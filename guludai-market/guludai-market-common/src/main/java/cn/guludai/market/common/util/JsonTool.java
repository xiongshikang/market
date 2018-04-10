/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.common.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
/**
 * 
 * @ClassName: JsonTool 
 * @Description: json与对象互转帮助类
 * @author: xiongshikang
 * @date: 2018年1月29日 上午9:51:12
 */
public class JsonTool {

	/**
	 * 把对象转换成JSON字符串
	 * @param value
	 * @return
	 */
	public static String createJsonString(Object value) {
		String str = JSON.toJSONString(value);
		return str;
	}
	
	/**
	 * JSON解析成实体对象
	 * @param jsonString
	 * @param cls 实体对象Class类
	 * @return
	 */
 	public static <T> T json2povo(String jsonString, Class<T> cls) {
        T t = null;
        try {
            t = JSON.parseObject(jsonString, cls);
        } catch (Exception e) {
        }
        return t;
    }
	
 	/**
 	 * JSON解析成对象List
 	 * @param jsonString
 	 * @param cls 实体对象Class类
 	 * @return
 	 */
	public static <T> List<T> json2list(String jsonString, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        try {
            list = JSON.parseArray(jsonString, cls);
        } catch (Exception e) {
        }
        return list;
    }
	
	/**
	 * JSON解析成MapList
	 * @param jsonString
	 * @return
	 */
	public static List<Map<String,Object>> json2maplist(String jsonString) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        try {
            list = JSON.parseObject(jsonString,new TypeReference<List<Map<String,Object>>>(){});
        } catch (Exception e) {
        }
        return list;
    }
	/**
	 * JSON解析成Map
	 * @param jsonString
	 * @return
	 */
	public static Map<String,Object> json2mapObj(String jsonString) {
		Map<String,Object> map = new HashMap<String,Object>();
        try {
        	map = JSON.parseObject(jsonString,new TypeReference<Map<String,Object>>(){});
        } catch (Exception e) {
        }
        return map;
    }
	/**
	 * JSON解析成Map
	 * @param jsonString
	 * @return
	 */
	public static Map<String,String> json2mapStr(String jsonString) {
		Map<String,String> map = new HashMap<String,String>();
        try {
        	map = JSON.parseObject(jsonString,new TypeReference<Map<String,String>>(){});
        } catch (Exception e) {
        }
        return map;
    }
	
	public static void main(String[] args) {
		String str="{\"aa\":\"bb\",\"cc\":\"dd\"}";
		Map<String,String> map=JsonTool.json2mapStr(str);
		System.out.println(map);
		
		
		String a =JsonTool.createJsonString(map);
		
		System.out.println(a);
		
	}
	
	
}
