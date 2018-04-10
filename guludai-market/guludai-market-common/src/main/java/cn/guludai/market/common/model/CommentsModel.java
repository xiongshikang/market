/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.common.model;

import java.util.Date;

/**
 * 
 * @ClassName: CommentsModel 
 * @Description: 任务注备
 * @author: xiongshikang
 * @date: 2018年1月17日 下午6:59:57
 */
public class CommentsModel {
	/**
	 * 注备人
	 */
	private String userName;
	/**
	 * 注备时间
	 */
	private Date time;
	/**
	 * 批注内容
	 */
	private String messageParts;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
 
	public String getMessageParts() {
		return messageParts;
	}
	public void setMessageParts(String messageParts) {
		this.messageParts = messageParts;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
