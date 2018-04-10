/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.common.model;

import java.util.List;

import cn.guludai.app.api.response.AppUserResponse;

/**
 * 
 * @ClassName: ResultModel 
 * @Description: 返回结果类
 * @author: xiongshikang
 * @date: 2017年11月3日 下午5:02:34 
 * @param <T>
 */
public class ResultModel<T> {
	
	/**
	 * 状态码
	 */
	private String code;

	/**
	 * 文件流
	 */
	private String bytes;
	
	/**
	 * 结果数据
	 */
	private T result;
	/**
	 * 结果集
	 */
	private List<T> ls;
	
 
	/**
	 * 批注
	 */
	private List<CommentsModel> ls2;
	
	/**
	 * 推荐链路
	 */
	private List<AppUserResponse> ls3;
	
	/**
	 * 签名
	 */
	private String sign;
	
	public List<AppUserResponse> getLs3() {
		return ls3;
	}

	public void setLs3(List<AppUserResponse> ls3) {
		this.ls3 = ls3;
	}

	public List<T> getLs() {
		return ls;
	}

	public void setLs(List<T> ls) {
		this.ls = ls;
	}


	public List<CommentsModel> getLs2() {
		return ls2;
	}

	public void setLs2(List<CommentsModel> ls2) {
		this.ls2 = ls2;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getBytes() {
		return bytes;
	}

	public void setBytes(String bytes) {
		this.bytes = bytes;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}
