/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service;

import java.util.List;

import cn.guludai.market.web.request.ApproveApplyCommentReq;
import cn.guludai.market.web.response.ApproveApplyCommentResponse;

/**
 * 
 * @ClassName: ApproveApplyCommentService 
 * @Description: 流程节点备注信服务类
 * @author: xiongshikang
 * @date: 2018年1月16日 下午2:47:58
 */
public interface ApproveApplyCommentService {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午2:49:28
	 * @Title: addApproveApplyCommentEntity 
	 * @Description: 添加流程节点备注
	 * @param entity
	 *
	 */
	public void addApproveApplyCommentEntity(ApproveApplyCommentReq recond)throws Exception;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午2:54:58
	 * @Title: list 
	 * @Description: 通过流程编号查询本流程的所有
	 * @param applyCode 流程编号
	 * @return
	 *
	 */
	public List<ApproveApplyCommentResponse> list(String applyCode) throws Exception;
	
}
