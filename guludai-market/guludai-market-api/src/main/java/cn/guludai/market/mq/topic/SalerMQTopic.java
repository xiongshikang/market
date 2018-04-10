/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.mq.topic;

/**
 * @author gaopeng
 */
public interface SalerMQTopic {

	/**
	 * 销售申请店铺资料数据提交MQ的TOPIC
	 */
	public static final String MQ_TOPIC_SALER_APPLY_DATA = "MARKET_SALER_APPLY_DATA";

	/**
	 * 销售申请店铺资料审批状态MQ的TOPIC
	 */
	public static final String MQ_TOPIC_SALER_APPLY_STATUS = "MARKET_SALER_APPLY_STATUS";
}
