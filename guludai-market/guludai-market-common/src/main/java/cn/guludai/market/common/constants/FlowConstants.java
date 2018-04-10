/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.common.constants;

/**
 * @author gaopeng
 */
public class FlowConstants {

	/** ACTIVITI流程未开启默认值 */
	public static final String FLOW_ACTIVITI_NULL = "NIL";

	/** 流程根节点默认值 */
	public static final String FLOW_ROOT_NOT = "ROOT";

	/** 流程审批结果：已审批/同意（绑定） */
	public static final String FLOW_YES = "Y";

	/** 流程审批结果：未审批/拒绝（解绑） */
	public static final String FLOW_SUSPEND = "O";

	/** 流程审批状态：审批中/待定（未绑） */
	public static final String FLOW_NO = "N";

	/** 流程类型：销售审批流程 */
	public static final String FLOW_TYPE_SALER = "1";

	/** 流程类型：风控审批流程 */
	public static final String FLOW_TYPE_RISKER = "2";
}
