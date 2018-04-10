/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.api.saler.response;

import java.io.Serializable;

/**
 * 
 * @ClassName: FlowNodeModel 
 * @Description: 流程进程model
 * @author: xiongshikang
 * @date: 2017年11月22日 下午7:23:20
 */
/** 
 * @ClassName: FlowNodeModel 
 * @Description: 
 * @author: xiongshikang
 * @date: 2017年12月11日 下午6:41:26  
 */
public class FlowNodeModel implements Serializable{
	/**
	 * @author: xiongshikang
	 * @date: 2017年11月22日 下午7:28:47
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 常量值：Y-同意，N-拒绝，O-审批中
	 */
	private String flowNodeStatus;
	
	/**
	 * 审批时间
	 */
	private String approveTime;
	/**
	 * 进度节点简称
	 */
	private String nodeName;
	
	/**
	 * 流程进度审批结果备注
	 */
	private String flowNodeResult;
	
	/**
	 * 审批人
	 */
	private String userName ;
	
	/**
	 * 最后节点下标
	 */
	private int indexEnd;
 
	public int getIndexEnd() {
		return indexEnd;
	}
	public void setIndexEnd(int indexEnd) {
		this.indexEnd = indexEnd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFlowNodeResult() {
		return flowNodeResult;
	}
	public void setFlowNodeResult(String flowNodeResult) {
		this.flowNodeResult = flowNodeResult;
	}
	public String getFlowNodeStatus() {
		return flowNodeStatus;
	}
	public void setFlowNodeStatus(String flowNodeStatus) {
		this.flowNodeStatus = flowNodeStatus;
	}
	public String getApproveTime() {
		return approveTime;
	}
	public void setApproveTime(String approveTime) {
		this.approveTime = approveTime;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
}
