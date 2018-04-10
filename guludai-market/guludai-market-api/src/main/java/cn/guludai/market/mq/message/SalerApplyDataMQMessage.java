/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.mq.message;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gaopeng
 */
public class SalerApplyDataMQMessage implements Serializable {

	private static final long serialVersionUID = 8645757154259023891L;

	/** 申请流水编号 */
	private String applyCode;

	/** 申请时间 */
	private Date applyTime;

	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

}