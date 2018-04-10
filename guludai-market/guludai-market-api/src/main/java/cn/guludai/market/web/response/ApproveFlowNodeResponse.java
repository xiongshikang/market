/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.response;

/**
 * @author gaopeng
 */
public class ApproveFlowNodeResponse {
	 

	/**
	 * <pre>
	 * 进度节点编号
	 * 表字段 : approve_flow_node.node_code
	 * </pre>
	 */
	private String nodeCode;
 
	/**
	 * <pre>
	 * 进度节点简称
	 * 表字段 : approve_flow_node.node_name
	 * </pre>
	 */
	private String nodeName;

	/**
	 * <pre>
	 * 进度节点描述
	 * 表字段 : approve_flow_node.node_description
	 * </pre>
	 */
	private String nodeDescription;

	/**
	 * <pre>
	 * 获取：进度节点编号
	 * 表字段：approve_flow_node.node_code
	 * </pre>
	 * 
	 * @return 进度节点编号 : {@link java.lang.String}
	 */
	public String getNodeCode() {
		return nodeCode;
	}

	/**
	 * <pre>
	 * 设置：进度节点编号
	 * 表字段：approve_flow_node.node_code
	 * </pre>
	 * 
	 * @param nodeCode
	 *              进度节点编号 : {@link java.lang.String}
	 */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode == null ? null : nodeCode.trim();
	}
 
	/**
	 * <pre>
	 * 获取：进度节点简称
	 * 表字段：approve_flow_node.node_name
	 * </pre>
	 * 
	 * @return 进度节点简称 : {@link java.lang.String}
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * <pre>
	 * 设置：进度节点简称
	 * 表字段：approve_flow_node.node_name
	 * </pre>
	 * 
	 * @param nodeName
	 *              进度节点简称 : {@link java.lang.String}
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName == null ? null : nodeName.trim();
	}

	/**
	 * <pre>
	 * 获取：进度节点描述
	 * 表字段：approve_flow_node.node_description
	 * </pre>
	 * 
	 * @return 进度节点描述 : {@link java.lang.String}
	 */
	public String getNodeDescription() {
		return nodeDescription;
	}

	/**
	 * <pre>
	 * 设置：进度节点描述
	 * 表字段：approve_flow_node.node_description
	 * </pre>
	 * 
	 * @param nodeDescription
	 *              进度节点描述 : {@link java.lang.String}
	 */
	public void setNodeDescription(String nodeDescription) {
		this.nodeDescription = nodeDescription == null ? null : nodeDescription.trim();
	}

}