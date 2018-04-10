/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.user.request;
/**
 * 
 * @ClassName: ZtreeRequest 
 * @Description: 设置用户或角色的权限接参类
 * @author: xiongshikang
 * @date: 2017年12月14日 下午3:26:18
 */
public class ZtreeRequest {
	
	/**
	 * 角色编号
	 */
	private String roleCode;
	
	/**
	 * 用户编号
	 */
	private String userCode;
	
	/**
	 * 资源code 字符串，以豆号隔开
	 */
	private String codeStr;
	
	/**
	 * 节点编号
	 */
	private String nodeCode;
	
	/**
	 * <pre>
	 * 流程编号
	 * 表字段 : approve_flow_user.flow_code
	 * </pre>
	 */
	private String flowCode;
	

	public String getFlowCode() {
		return flowCode;
	}

	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode;
	}

	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getCodeStr() {
		return codeStr;
	}

	public void setCodeStr(String codeStr) {
		this.codeStr = codeStr;
	}
 
}
