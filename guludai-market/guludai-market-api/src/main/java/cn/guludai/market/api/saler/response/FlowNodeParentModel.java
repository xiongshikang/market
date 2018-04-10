/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.api.saler.response;

import java.io.Serializable;
import java.util.List;

public class FlowNodeParentModel implements Serializable{
	
	/**
	 * @author: xiongshikang
	 * @date: 2018年1月24日 下午6:36:56
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 状态 Y 进行中 ， N 拒绝
	 */
	private String status;
	
	/**
	 * 审批时间
	 */
	private String approveTime;
	
	private List<FlowNodeModel> ls;
	
	/**
	 * 最后批注信息
	 */
	private String remark;

	public String getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(String approveTime) {
		this.approveTime = approveTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<FlowNodeModel> getLs() {
		return ls;
	}

	public void setLs(List<FlowNodeModel> ls) {
		this.ls = ls;
	}
	
}
