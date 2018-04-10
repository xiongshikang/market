package cn.guludai.market.service.saler.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.guludai.framework.rocketmq.standard.MQMessage;
import cn.guludai.framework.rocketmq.standard.MQProducer;
import cn.guludai.market.domain.dao.ApproveApplyResultEntityMapper;
import cn.guludai.market.domain.entity.ApproveApplyResultEntity;

@Service
public class SalerApplyStatusMQProducer {

	@Autowired
	private MQProducer producer;

	@Autowired
	private ApproveApplyResultEntityMapper approveApplyResultEntityMapper;

	public int updateApplyResultByApplyCode(ApproveApplyResultEntity applyResultEntity) {
		approveApplyResultEntityMapper.updateApplyResultByApplyCode(applyResultEntity);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("applyCode", applyResultEntity.getApplyCode());
		jsonObject.put("approveStatus", applyResultEntity.getApproveStatus());
		jsonObject.put("approveResult", applyResultEntity.getApproveResult());
		producer.send("applyShopV1", new MQMessage(jsonObject));
		return 0;
	}
}