/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.common.util;

import cn.guludai.framework.cache.client.RedisClient;
import cn.guludai.framework.toolkit.util.ByteUtil;
/**
 * 
 * @ClassName: RedisUtils
 * @Description: redis帮助类
 * @author: xiongshikang
 * @date: 2017年11月7日 下午1:59:08 
 * @param <T>
 */
public class RedisUtils<T> {
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月7日 下午1:58:13
	 * @Title: getTByKey 
	 * @Description: redis keyvalue 写入值
	 * @param key 键值
	 * @param client redis client
	 * @param modelClass class类名
	 * @return
	 *
	 */
	public static <T> T get(String key,RedisClient client,Class<T> modelClass) {
		byte[] pluginByte = client.get(ByteUtil.rawKey(key));
		if(null!=pluginByte && pluginByte.length>0) {
			 T t = ByteUtil.convertOfT(client.get(ByteUtil.rawKey(key)), modelClass);
			return t;
		}else{
			return null;
		}
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月7日 下午2:01:53
	 * @Title: set 
	 * @Description: redis keyvalue 获取值
	 * @param key
	 * @param client
	 * @param t
	 *
	 */
	public static <T> void set(String key,RedisClient client,T t) {
		 client.set(ByteUtil.rawKey(key), ByteUtil.rawVal(t));

	}

	public static long del(String key , RedisClient client){
		return  client.del(key);
	}

}
