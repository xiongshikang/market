/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.request;

import java.io.Serializable;
/**
 * 
 * @ClassName: BaseReq 
 * @Description: req共有属性
 * @author: xiongshikang
 * @date: 2017年11月20日 下午1:42:39
 */
public class BaseReq implements Serializable {

	/**
	 * @author: xiongshikang
	 * @date: 2017年11月20日 下午1:42:26
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 页面大小
	 */
	private int limit; 
	
	/**
	 * 页码
	 */
	private int offset;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	
}
