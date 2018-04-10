/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.common.constants;

/**
 * 
 * @ClassName: BaseConstant 
 * @Description: 定义常量类
 * @author: xiongshikang
 * @date: 2017年11月27日 下午4:13:56
 */
public class BaseConstant {
	
	public static String ASSIGNEE_ = "";
	
	/**
	 * Y-逻辑保留
	 */
	public static final String DATA_STATUS_Y = "Y";
	
	/**
	 * N-逻辑删除
	 */
	public static final String DATA_STATUS_N = "N";
	
	/**
	 * Y-物理保留
	 */
	public static final String DISK_STATUS_Y = "Y";
	
	/**
	 * N-物理删除
	 */
	public static final String DISK_STATUS_N = "N";
	
	/**
	 * 插件是否升级(常量值：Y-已升级，N-未升级，O-升级中)
	 */
	public static final String UPGRADE_Y = "Y";
	
	public static final String UPGRADE_N = "N";
	
	public static final String UPGRADE_O = "O";
	
	/**
	 * 审批状态(常量值：Y-已审批，N-未审批，O-审批中，默认值：N)
	 */
	public static final String APPROVE_STATUS_Y="Y";
	
	public static final String APPROVE_STATUS_N="N";
	
	public static final String APPROVE_STATUS_O="O";
 
	/**
	 * 审批结果(常量值：Y-同意（绑定），N-拒绝（解绑），O-待定（未绑），默认值：O)
	 */
	public static final String APPROVE_RESULT_Y="Y";
	
	public static final String APPROVE_RESULT_N="N";
	
	public static final String APPROVE_RESULT_O="O";
	
	/**
	 * 流程进度审批状态(常量值：Y-同意，N-拒绝，O-审批中)
	 */
	public static final String FLOW_NODE_STATUS_Y="Y";
	
	public static final String FLOW_NODE_STATUS_N="N";
	
	public static final String FLOW_NODE_STATUS_O="O";
	
	/**
	 * （权限表）顶级爷节点
	 */
	public static final String FAST_PARENT_ID ="-1";

	public static final String ERP_VERSION_NAEM_DEFAULT="v1";
	
	 /**
	  * 办理类型(Y代表办理任务,N代有转交任务)
	  */
	public static final String TRANSACT_STATUS_Y="Y";
	
	public static final String TRANSACT_STATUS_N="N";
	
	
}
