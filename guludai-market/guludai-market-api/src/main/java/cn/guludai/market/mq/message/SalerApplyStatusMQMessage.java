/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.mq.message;

import java.io.Serializable;

/**
 * @author gaopeng
 */
public class SalerApplyStatusMQMessage implements Serializable {

	static final long serialVersionUID = 9131657810371723834L;

	/** 申请流水编号 */
	private String applyCode;

	/** 审批状态 */
	private String approveStatus;

	/** 审批结果 */
	private String approveResult;

	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getApproveResult() {
		return approveResult;
	}

	public void setApproveResult(String approveResult) {
		this.approveResult = approveResult;
	}

}