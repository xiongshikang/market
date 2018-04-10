package cn.guludai.market.service.saler.mq;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.guludai.framework.datasource.constants.DBConstants;
import cn.guludai.framework.rocketmq.bind.RocketMQ;
import cn.guludai.framework.rocketmq.standard.MQConsumer;
import cn.guludai.framework.rocketmq.standard.MQMessage;
import cn.guludai.framework.rocketmq.standard.MQResult;
import cn.guludai.market.common.constants.FlowConstants;
import cn.guludai.market.common.constants.MQConstants;
import cn.guludai.market.domain.dao.ApproveApplyRecordEntityMapper;
import cn.guludai.market.domain.dao.ApproveApplyResultEntityMapper;
import cn.guludai.market.domain.dao.ApproveFlowEntityMapper;
import cn.guludai.market.domain.dao.ApproveFlowNodeEntityMapper;
import cn.guludai.market.domain.entity.ApproveApplyRecordEntity;
import cn.guludai.market.domain.entity.ApproveApplyResultEntity;
import cn.guludai.market.domain.entity.ApproveFlowEntity;
import cn.guludai.market.domain.entity.ApproveFlowNodeEntity;
import cn.guludai.market.mq.message.SalerApplyDataMQMessage;
import cn.guludai.market.mq.topic.SalerMQTopic;

@Service
@RocketMQ(group = MQConstants.MQ_CONSUMER_GROUP_SALER_APPLY_SHOP, topic = SalerMQTopic.MQ_TOPIC_SALER_APPLY_DATA)
public class SalerApplyShopMQConsumer implements MQConsumer {

	private static final Logger log = LoggerFactory.getLogger(SalerApplyShopMQConsumer.class);

	@Autowired
	private ApproveApplyResultEntityMapper approveApplyResultEntityMapper;

	@Autowired
	private ApproveApplyRecordEntityMapper approveApplyRecordEntityMapper;

	@Autowired
	private ApproveFlowNodeEntityMapper approveFlowNodeEntityMapper;

	@Autowired
	private ApproveFlowEntityMapper approveFlowEntityMapper;

	@Override
	@Transactional
	public MQResult receive(MQMessage message) {
		final Date time = new Date();
		try {
			final SalerApplyDataMQMessage data = message.getContent(SalerApplyDataMQMessage.class);
			if (approveApplyResultEntityMapper.selectApproveApplyResultByApplyCode(data.getApplyCode()) == null) {
				ApproveFlowEntity approveFlowEntity = approveFlowEntityMapper.selectFlowByStatus(FlowConstants.FLOW_TYPE_SALER);
				ApproveFlowNodeEntity approveFlowNodeEntity = approveFlowNodeEntityMapper.selectRootNodeByFlowCode(approveFlowEntity.getFlowCode());
				ApproveApplyResultEntity approveApplyResultEntity = new ApproveApplyResultEntity();
				approveApplyResultEntity.setDataStatus(DBConstants.DATA_ENABLE_STATUS);
				approveApplyResultEntity.setDiskStatus(DBConstants.DISK_ENABLE_STATUS);
				approveApplyResultEntity.setVersion(DBConstants.DATA_FIRST_VERSION);
				approveApplyResultEntity.setCreateTime(time);
				approveApplyResultEntity.setUpdateTime(time);
				approveApplyResultEntity.setActivitiCode(FlowConstants.FLOW_ACTIVITI_NULL);
				approveApplyResultEntity.setApproveResult(FlowConstants.FLOW_SUSPEND);
				approveApplyResultEntity.setApproveStatus(FlowConstants.FLOW_NO);
				approveApplyResultEntity.setFlowCode(approveFlowEntity.getFlowCode());
				approveApplyResultEntity.setNodeCode(approveFlowNodeEntity.getNodeCode());
				approveApplyResultEntity.setApplyCode(data.getApplyCode());
				approveApplyResultEntity.setApplyTime(data.getApplyTime());
				ApproveApplyRecordEntity approveApplyRecordEntity = new ApproveApplyRecordEntity();
				approveApplyRecordEntity.setDataStatus(DBConstants.DATA_ENABLE_STATUS);
				approveApplyRecordEntity.setDiskStatus(DBConstants.DISK_ENABLE_STATUS);
				approveApplyRecordEntity.setVersion(DBConstants.DATA_FIRST_VERSION);
				approveApplyRecordEntity.setCreateTime(time);
				approveApplyRecordEntity.setUpdateTime(time);
				approveApplyRecordEntity.setActivitiCode(FlowConstants.FLOW_ACTIVITI_NULL);
				approveApplyRecordEntity.setFlowNodeStatus(FlowConstants.FLOW_YES);
				approveApplyRecordEntity.setApplyCode(data.getApplyCode());
				approveApplyRecordEntity.setFlowCode(approveFlowEntity.getFlowCode());
				approveApplyRecordEntity.setNodeCode(approveFlowNodeEntity.getNodeCode());
				approveApplyResultEntityMapper.insertSelective(approveApplyResultEntity);
				approveApplyRecordEntityMapper.insertSelective(approveApplyRecordEntity);
			}
			return MQResult.success();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("[ MARKET ] 消费销售申请门店信息错误, error=" + e.getMessage(), e);
			}
			return MQResult.failure();
		}
	}
}