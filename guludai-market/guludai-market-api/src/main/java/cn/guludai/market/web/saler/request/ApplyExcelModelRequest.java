/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.saler.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @ClassName: ApplyExcelModelReq 
 * @Description: 对每个销售负责的渠道销售成果，在选取的时间段中进行统计(接参类)
 * @author: xiongshikang
 * @date: 2018年1月3日 上午10:12:29
 */
public class ApplyExcelModelRequest {
	
	/**
	 * 查询开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date startTime;
	
	/**
	 * 查询结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date endTime;
	
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 用户手机号
	 */
	private String mobile;
	
	/**
	 * 用户帐号编号
	 */
	private String account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
}
