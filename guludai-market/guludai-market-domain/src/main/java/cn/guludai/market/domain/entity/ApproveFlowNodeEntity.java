/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.entity;

import java.util.Date;

/**
 * @author gaopeng
 */
public class ApproveFlowNodeEntity {
	/**
	 * <pre>
	 * 默认主键自增
	 * 表字段 : approve_flow_node.id
	 * </pre>
	 */
	private Long id;

	/**
	 * <pre>
	 * 进度节点编号
	 * 表字段 : approve_flow_node.node_code
	 * </pre>
	 */
	private String nodeCode;

	/**
	 * <pre>
	 * 进度节点类型(常量值：Y-根节点，N-子节点)
	 * 表字段 : approve_flow_node.node_type
	 * </pre>
	 */
	private String nodeType;

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
	 * 进度父节点编号(默认值：ROOT（根节点），上下节点引用只能一对一
	 * 表字段 : approve_flow_node.node_parent_code
	 * </pre>
	 */
	private String nodeParentCode;

	/**
	 * <pre>
	 * 流程编号
	 * 表字段 : approve_flow_node.flow_code
	 * </pre>
	 */
	private String flowCode;

	/**
	 * <pre>
	 * 版本号(默认值：1，同步递增修改)
	 * 表字段 : approve_flow_node.version
	 * </pre>
	 */
	private Long version;

	/**
	 * <pre>
	 * 创建时间
	 * 表字段 : approve_flow_node.create_time
	 * </pre>
	 */
	private Date createTime;

	/**
	 * <pre>
	 * 修改时间
	 * 表字段 : approve_flow_node.update_time
	 * </pre>
	 */
	private Date updateTime;

	/**
	 * <pre>
	 * 逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
	 * 表字段 : approve_flow_node.data_status
	 * </pre>
	 */
	private String dataStatus;

	/**
	 * <pre>
	 * 物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
	 * 表字段 : approve_flow_node.disk_status
	 * </pre>
	 */
	private String diskStatus;

	/**
	 * <pre>
	 * 获取：默认主键自增
	 * 表字段：approve_flow_node.id
	 * </pre>
	 * 
	 * @return 默认主键自增 : {@link java.lang.Long}
	 */
	public Long getId() {
		return id;
	}

	/**
	 * <pre>
	 * 设置：默认主键自增
	 * 表字段：approve_flow_node.id
	 * </pre>
	 * 
	 * @param id
	 *              默认主键自增 : {@link java.lang.Long}
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * 获取：进度节点类型(常量值：Y-根节点，N-子节点)
	 * 表字段：approve_flow_node.node_type
	 * </pre>
	 * 
	 * @return 进度节点类型(常量值：Y-根节点，N-子节点) : {@link java.lang.String}
	 */
	public String getNodeType() {
		return nodeType;
	}

	/**
	 * <pre>
	 * 设置：进度节点类型(常量值：Y-根节点，N-子节点)
	 * 表字段：approve_flow_node.node_type
	 * </pre>
	 * 
	 * @param nodeType
	 *              进度节点类型(常量值：Y-根节点，N-子节点) : {@link java.lang.String}
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType == null ? null : nodeType.trim();
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

	/**
	 * <pre>
	 * 获取：进度父节点编号(默认值：ROOT（根节点），上下节点引用只能一对一
	 * 表字段：approve_flow_node.node_parent_code
	 * </pre>
	 * 
	 * @return 进度父节点编号(默认值：ROOT（根节点），上下节点引用只能一对一 : {@link java.lang.String}
	 */
	public String getNodeParentCode() {
		return nodeParentCode;
	}

	/**
	 * <pre>
	 * 设置：进度父节点编号(默认值：ROOT（根节点），上下节点引用只能一对一
	 * 表字段：approve_flow_node.node_parent_code
	 * </pre>
	 * 
	 * @param nodeParentCode
	 *              进度父节点编号(默认值：ROOT（根节点），上下节点引用只能一对一 : {@link java.lang.String}
	 */
	public void setNodeParentCode(String nodeParentCode) {
		this.nodeParentCode = nodeParentCode == null ? null : nodeParentCode.trim();
	}

	/**
	 * <pre>
	 * 获取：流程编号
	 * 表字段：approve_flow_node.flow_code
	 * </pre>
	 * 
	 * @return 流程编号 : {@link java.lang.String}
	 */
	public String getFlowCode() {
		return flowCode;
	}

	/**
	 * <pre>
	 * 设置：流程编号
	 * 表字段：approve_flow_node.flow_code
	 * </pre>
	 * 
	 * @param flowCode
	 *              流程编号 : {@link java.lang.String}
	 */
	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode == null ? null : flowCode.trim();
	}

	/**
	 * <pre>
	 * 获取：版本号(默认值：1，同步递增修改)
	 * 表字段：approve_flow_node.version
	 * </pre>
	 * 
	 * @return 版本号(默认值：1，同步递增修改) : {@link java.lang.Long}
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * <pre>
	 * 设置：版本号(默认值：1，同步递增修改)
	 * 表字段：approve_flow_node.version
	 * </pre>
	 * 
	 * @param version
	 *              版本号(默认值：1，同步递增修改) : {@link java.lang.Long}
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * <pre>
	 * 获取：创建时间
	 * 表字段：approve_flow_node.create_time
	 * </pre>
	 * 
	 * @return 创建时间 : {@link java.util.Date}
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * <pre>
	 * 设置：创建时间
	 * 表字段：approve_flow_node.create_time
	 * </pre>
	 * 
	 * @param createTime
	 *              创建时间 : {@link java.util.Date}
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * <pre>
	 * 获取：修改时间
	 * 表字段：approve_flow_node.update_time
	 * </pre>
	 * 
	 * @return 修改时间 : {@link java.util.Date}
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * <pre>
	 * 设置：修改时间
	 * 表字段：approve_flow_node.update_time
	 * </pre>
	 * 
	 * @param updateTime
	 *              修改时间 : {@link java.util.Date}
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * <pre>
	 * 获取：逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
	 * 表字段：approve_flow_node.data_status
	 * </pre>
	 * 
	 * @return 逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y) : {@link java.lang.String}
	 */
	public String getDataStatus() {
		return dataStatus;
	}

	/**
	 * <pre>
	 * 设置：逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
	 * 表字段：approve_flow_node.data_status
	 * </pre>
	 * 
	 * @param dataStatus
	 *              逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y) : {@link java.lang.String}
	 */
	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus == null ? null : dataStatus.trim();
	}

	/**
	 * <pre>
	 * 获取：物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
	 * 表字段：approve_flow_node.disk_status
	 * </pre>
	 * 
	 * @return 物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y) : {@link java.lang.String}
	 */
	public String getDiskStatus() {
		return diskStatus;
	}

	/**
	 * <pre>
	 * 设置：物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
	 * 表字段：approve_flow_node.disk_status
	 * </pre>
	 * 
	 * @param diskStatus
	 *              物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y) : {@link java.lang.String}
	 */
	public void setDiskStatus(String diskStatus) {
		this.diskStatus = diskStatus == null ? null : diskStatus.trim();
	}
}