package cn.guludai.market.api.saler.request;

public class FlowShowRequest {
	private String applyCode;
	private String flowCode;
	private String nodeName;
	private String nodeType;
	private String flowType;
	private String nodeDescription;
	private String flowStatus;
	private String version;
	private String createTime;
	private String updateTime;
	private String nodeCode;
	private String flowNodeStatus;
	private String parentNodeCode;
	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public String getFlowCode() {
		return flowCode;
	}

	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getFlowType() {
		return flowType;
	}

	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}

	public String getNodeDescription() {
		return nodeDescription;
	}

	public void setNodeDescription(String nodeDescription) {
		this.nodeDescription = nodeDescription;
	}

	public String getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getParentNodeCode() {
		return parentNodeCode;
	}

	public void setParentNodeCode(String parentNodeCode) {
		this.parentNodeCode = parentNodeCode;
	}
	
	public String getFlowNodeStatus() {
		return flowNodeStatus;
	}

	public void setFlowNodeStatus(String flowNodeStatus) {
		this.flowNodeStatus = flowNodeStatus;
	}

	public FlowShowRequest(String applyCode, String flowCode, String nodeName, String nodeType, String flowType,
			String nodeDescription, String flowStatus, String version, String createTime, String updateTime,
			String nodeCode, String parentNodeCode) {
		super();
		this.applyCode = applyCode;
		this.flowCode = flowCode;
		this.nodeName = nodeName;
		this.nodeType = nodeType;
		this.flowType = flowType;
		this.nodeDescription = nodeDescription;
		this.flowStatus = flowStatus;
		this.version = version;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.nodeCode = nodeCode;
		this.parentNodeCode = parentNodeCode;
	}

	public FlowShowRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
