/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;

import cn.guludai.api.code.BaseCode;
import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.app.api.AppUserApi;
import cn.guludai.app.api.ApplyShopApi;
import cn.guludai.app.api.request.ApplyExcelModelReq;
import cn.guludai.app.api.response.ApiApplyShopResponse;
import cn.guludai.app.api.response.AppUserInvitationRelationResponse;
import cn.guludai.app.api.response.AppUserResponse;
import cn.guludai.app.api.response.ApplyExcelModelResp;
import cn.guludai.app.web.request.ApplyShopRequest;
import cn.guludai.app.web.response.ApplyShopResponse;
import cn.guludai.app.web.response.TableResultResponse;
import cn.guludai.framework.toolkit.id.GUID;
import cn.guludai.market.common.constants.BaseConstant;
import cn.guludai.market.common.constants.FlowNodeConstant;
import cn.guludai.market.common.model.CommentsModel;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.common.util.DateUtils;
import cn.guludai.market.common.util.ExcelUtil;
import cn.guludai.market.domain.dao.ApproveApplyCustomerEntityMapper;
import cn.guludai.market.domain.dao.ApproveApplyLoanEntityMapper;
import cn.guludai.market.domain.dao.ApproveApplyResultEntityMapper;
import cn.guludai.market.domain.dao.ApproveApplyTransactEntityMapper;
import cn.guludai.market.domain.dao.ApproveSecurityUserMapper;
import cn.guludai.market.domain.entity.ApproveApplyCustomerEntity;
import cn.guludai.market.domain.entity.ApproveApplyLoanEntity;
import cn.guludai.market.domain.entity.ApproveApplyResultEntity;
import cn.guludai.market.domain.entity.ApproveApplyTransactEntity;
import cn.guludai.market.service.saler.service.ApproveApplyRecordService;
import cn.guludai.market.service.saler.service.ApproveApplyResultService;
import cn.guludai.market.service.saler.service.WorkflowTraceService;
import cn.guludai.market.web.code.MarketBaseCode;
import cn.guludai.market.web.request.ApplyShopReq;
import cn.guludai.market.web.request.ApproveApplyCustomerReq;
import cn.guludai.market.web.request.ApproveApplyResultReq;
import cn.guludai.market.web.response.ApproveApplyResultResponse;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.saler.request.ApplyExcelModelRequest;
import cn.guludai.market.web.saler.response.ApplyExcelModelResponse;
import cn.guludai.resource.api.BaseShopApi;
import cn.guludai.resource.api.request.BaseShopRequest;
import cn.guludai.resource.api.response.BaseShopCompanyResponse;
import cn.guludai.resource.api.response.BaseShopResponse;

@Service
public class ApproveApplyResultServiceImpl implements ApproveApplyResultService {
	@Autowired
	private ApproveApplyResultEntityMapper approveApplyResultEntityMapper;
	@Autowired
	private ApplyShopApi applyShopApi;
	@Autowired
	private BaseShopApi baseShopApi;
	@Autowired
	private AppUserApi appUserApi;
	@Autowired
	private ApproveApplyRecordService approveApplyRecordEntityService;
	@Autowired
	private ApproveSecurityUserMapper approveSecurityUserMapper;
	@Autowired
	private WorkflowTraceService workflowTraceService;
	@Autowired
	private ApproveApplyLoanEntityMapper approveApplyLoanEntityMapper;
	@Autowired
	private ApproveApplyCustomerEntityMapper approveApplyCustomerEntityMapper;
	@Autowired
	private ApproveApplyTransactEntityMapper approveApplyTransactEntityMapper;
	
	
	public TableResponse<ApproveApplyResultResponse> selectNodeInfoByNodeCodePage(ApproveApplyResultReq record)
			throws Exception {
		TableResponse<ApproveApplyResultResponse> table = new TableResponse<ApproveApplyResultResponse>();
		List<ApproveApplyResultResponse> resp = new ArrayList<ApproveApplyResultResponse>();
		List<ApproveApplyResultEntity> ls = approveApplyResultEntityMapper.selectNodeInfoByNodeCodePage(record);
		Integer total = approveApplyResultEntityMapper.selectNodeInfoByNodeCodePageCount(record);
		for (ApproveApplyResultEntity entity : ls) {
			ApproveApplyResultResponse model = new  ApproveApplyResultResponse();
			Request<String> request = new Request<String>();
			request.setData(entity.getApplyCode());
			Response<ApiApplyShopResponse> response = applyShopApi.select(request);
			if (response.getCode().equals(BaseCode.SUCCESS.getCode())) {
				BeanUtils.copyProperties(model,response.getData());
				BeanUtils.copyProperties(model, entity);
				if (model.getDataStatus().equals(BaseConstant.DATA_STATUS_Y)) {
					model.setDataStatus("正常");
				} else {
					model.setDataStatus("物理册除");
				}
				if (model.getDiskStatus().equals(BaseConstant.DISK_STATUS_Y)) {
					model.setDiskStatus("正常");
				} else {
					model.setDiskStatus("逻辑册除");
				}
				if (model.getApproveStatus().equals(BaseConstant.APPROVE_STATUS_Y)) {
					model.setApproveStatus("<h5 style='color:green;'> 已审批</h5>");
				} else if (model.getApproveStatus().equals(BaseConstant.APPROVE_STATUS_N)) {
					model.setApproveStatus("<h5 style='color:red;'>未审批</h5>");
				} else {
					model.setApproveStatus("<h5 style='color:#A9A9A9;'>审批中</h5>");
				}
				if (model.getApproveResult().equals(BaseConstant.APPROVE_RESULT_Y)) {
					model.setApproveResult("<h5 style='color:green;'>同意（绑定）</h5>");
				} else if (model.getApproveResult().equals(BaseConstant.APPROVE_RESULT_N)) {
					model.setApproveResult("<h5 style='color:red;'>拒绝（解绑）</h5>");
				} else {
					model.setApproveResult("<h5 style='color:red;'>待定（未绑）</h5>");
				}
				if (model.getActivitiCode().equals("NIL")) {
					model.setActivitiCode("<h5 style='color:green;'>未被领取</h5>");
				} else {
					model.setActivitiCode("<h5 style='color:red;'>已被领取</h5>");
				}
				/**
				 * 获取所属公司
				 */
				String shopCode = entity.getShopCode();
				if(StringUtils.isNotBlank(shopCode)) {
					Request<String> request2 = new Request<String>();
					request2.setData(shopCode);
					Response<BaseShopCompanyResponse> response2 = baseShopApi.selectBaseShopCompanyByShopCode(request2);
					BaseShopCompanyResponse baseShopCompanyResponse = response2.getData();
					model.setCompanyName(baseShopCompanyResponse.getCompanyName());
				}
				model.setApproveStartTime(entity.getApproveStartTime());
				model.setApproveEndTime(entity.getApproveEndTime());
				resp.add(model);
			}else {
				throw new Exception("远程调用失败");
			}
		}
		table.setRows(resp);
		table.setTotal(total);
		return table;
	}
	
	public TableResponse<ApproveApplyResultResponse> selectNodeInfoFOrIsNoPage(ApproveApplyResultReq record)
			throws Exception {
		TableResponse<ApproveApplyResultResponse> table = new TableResponse<ApproveApplyResultResponse>();
		List<ApproveApplyResultResponse> resp = new ArrayList<ApproveApplyResultResponse>();
		List<ApproveApplyResultEntity> ls = approveApplyResultEntityMapper.selectNodeInfoForResultIsNo(record);
		Integer total = approveApplyResultEntityMapper.selectNodeInfoForResultIsNoCount(record);
		for (ApproveApplyResultEntity entity : ls) {
			ApproveApplyResultResponse model = new  ApproveApplyResultResponse();
			Request<String> request = new Request<String>();
			request.setData(entity.getApplyCode());
			Response<ApiApplyShopResponse> response = applyShopApi.select(request);
			if (response.getCode().equals(BaseCode.SUCCESS.getCode())) {
				BeanUtils.copyProperties(model,response.getData());
				BeanUtils.copyProperties(model, entity);
				if (model.getDataStatus().equals(BaseConstant.DATA_STATUS_Y)) {
					model.setDataStatus("正常");
				} else {
					model.setDataStatus("物理册除");
				}
				if (model.getDiskStatus().equals(BaseConstant.DISK_STATUS_Y)) {
					model.setDiskStatus("正常");
				} else {
					model.setDiskStatus("逻辑册除");
				}
				if (model.getApproveStatus().equals(BaseConstant.APPROVE_STATUS_Y)) {
					model.setApproveStatus("<h5 style='color:green;'> 已审批</h5>");
				} else if (model.getApproveStatus().equals(BaseConstant.APPROVE_STATUS_N)) {
					model.setApproveStatus("<h5 style='color:red;'>未审批</h5>");
				} else {
					model.setApproveStatus("<h5 style='color:#A9A9A9;'>审批中</h5>");
				}
				if (model.getApproveResult().equals(BaseConstant.APPROVE_RESULT_Y)) {
					model.setApproveResult("<h5 style='color:green;'>同意（绑定）</h5>");
				} else if (model.getApproveResult().equals(BaseConstant.APPROVE_RESULT_N)) {
					model.setApproveResult("<h5 style='color:red;'>拒绝（解绑）</h5>");
				} else {
					model.setApproveResult("<h5 style='color:red;'>待定（未绑）</h5>");
				}
				if (model.getActivitiCode().equals("NIL")) {
					model.setActivitiCode("<h5 style='color:green;'>未被领取</h5>");
				} else {
					model.setActivitiCode("<h5 style='color:red;'>已被领取</h5>");
				}
				/**
				 * 获取所属公司
				 */
				String shopCode = entity.getShopCode();
				if(StringUtils.isNotBlank(shopCode)) {
					Request<String> request2 = new Request<String>();
					request2.setData(shopCode);
					Response<BaseShopCompanyResponse> response2 = baseShopApi.selectBaseShopCompanyByShopCode(request2);
					BaseShopCompanyResponse baseShopCompanyResponse = response2.getData();
					model.setCompanyName(baseShopCompanyResponse.getCompanyName());
				}
				model.setApproveStartTime(entity.getApproveStartTime());
				model.setApproveEndTime(entity.getApproveEndTime());
				resp.add(model);
			}else {
				throw new Exception("远程调用失败");
			}
		}
		table.setRows(resp);
		table.setTotal(total);
		return table;
	}

	public TableResponse<ApproveApplyResultResponse> selectPluginLicenseList(ApproveApplyResultReq record)
			throws Exception {
		TableResponse<ApproveApplyResultResponse> table = new TableResponse<ApproveApplyResultResponse>();
		TableResponse<ApproveApplyResultResponse> applyShopPage = getApplyShopPage(record.getApplyCode(),
				record.getOffset(), record.getLimit());
		List<ApproveApplyResultResponse> ls = applyShopPage.getRows();
		long total = applyShopPage.getTotal();
		table.setRows(ls);
		table.setTotal(total);
		return table;
	}
	/**
	 * 根据流水账号分页查询【调用APP接口】
	 * @param applyCode
	 * @param offset
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	private TableResponse<ApproveApplyResultResponse> getApplyShopPage(String applyCode, int offset, int limit)
			throws Exception {
		Request<ApplyShopRequest> request = new Request<>();
		ApplyShopRequest applyShopRequest = new ApplyShopRequest();
		applyShopRequest.setLimit(limit);
		applyShopRequest.setOffset(offset);
		applyShopRequest.setApplyCode(applyCode);
		request.setData(applyShopRequest);
		Response<TableResultResponse<ApplyShopResponse>> response = applyShopApi
				.selectApplyShopPage(request);
		List<ApproveApplyResultResponse> approveApplyResultResponseList = new ArrayList<>();
		TableResultResponse<ApplyShopResponse> data = response.getData();
		List<ApplyShopResponse> list = data.getRows();
		for (int i = 0; i < list.size(); i++) {
			ApplyShopResponse applyShopResponse = list.get(i);
			ApproveApplyResultEntity approveApplyResultEntity = approveApplyResultEntityMapper
					.selectApproveApplyResultByApplyCode(applyShopResponse.getApplyCode());
			ApproveApplyResultResponse approveApplyResultResponse = new ApproveApplyResultResponse();
			BeanUtils.copyProperties(approveApplyResultResponse, applyShopResponse);
			BeanUtils.copyProperties(approveApplyResultResponse, approveApplyResultEntity);
			if (approveApplyResultResponse.getDataStatus().equals(BaseConstant.DATA_STATUS_Y)) {
				approveApplyResultResponse.setDataStatus("正常");
			} else {
				approveApplyResultResponse.setDataStatus("物理册除");
			}
			if (approveApplyResultResponse.getDiskStatus().equals(BaseConstant.DISK_STATUS_Y)) {
				approveApplyResultResponse.setDiskStatus("正常");
			} else {
				approveApplyResultResponse.setDiskStatus("逻辑册除");
			}
			if (approveApplyResultResponse.getApproveStatus().equals(BaseConstant.APPROVE_STATUS_Y)) {
				approveApplyResultResponse.setApproveStatus("<h5 style='color:green;'> 已审批</h5>");
			} else if (approveApplyResultResponse.getApproveStatus().equals(BaseConstant.APPROVE_STATUS_N)) {
				approveApplyResultResponse.setApproveStatus("<h5 style='color:red;'>未审批</h5>");
			} else {
				approveApplyResultResponse.setApproveStatus("<h5 style='color:#A9A9A9;'>审批中</h5>");
			}
			if (approveApplyResultResponse.getApproveResult().equals(BaseConstant.APPROVE_RESULT_Y)) {
				approveApplyResultResponse.setApproveResult("<h5 style='color:green;'>同意（绑定）</h5>");
			} else if (approveApplyResultResponse.getApproveResult().equals(BaseConstant.APPROVE_RESULT_N)) {
				approveApplyResultResponse.setApproveResult("<h5 style='color:red;'>拒绝（解绑）</h5>");
			} else {
				approveApplyResultResponse.setApproveResult("<h5 style='color:red;'>待定（未绑）</h5>");
			}
			if (approveApplyResultResponse.getActivitiCode().equals("NIL")) {
				approveApplyResultResponse.setActivitiCode("<h5 style='color:green;'>未被领取</h5>");
			} else {
				approveApplyResultResponse.setActivitiCode("<h5 style='color:red;'>已被领取</h5>");
			}
			approveApplyResultResponse.setApproveStartTime(approveApplyResultEntity.getApproveStartTime());
			approveApplyResultResponse.setApproveEndTime(approveApplyResultEntity.getApproveEndTime());
			approveApplyResultResponseList.add(approveApplyResultResponse);
		}
		TableResponse<ApproveApplyResultResponse> tableResultResponse = new TableResponse<>();
		tableResultResponse.setTotal(data.getTotal());
		tableResultResponse.setRows(approveApplyResultResponseList);
		return tableResultResponse;
	}
	/**
	 * @author: xiongshikang
	 * @date: 2017年11月28日 上午10:57:20
	 * @Title: select
	 * @Description: 通过流水号查询申请信息
	 * @param applyCode 流水号
	 * @return
	 */
	public ResultModel<ApproveApplyResultResponse> select(ApproveApplyResultReq req2) {
		ResultModel<ApproveApplyResultResponse> result = new ResultModel<ApproveApplyResultResponse>();
		ApproveApplyResultResponse req = new ApproveApplyResultResponse();
		Request<String> request = new Request<String>();
		request.setData(req2.getApplyCode());
		Response<ApiApplyShopResponse> response = applyShopApi.select(request);
		if (response.getCode().equals(BaseCode.SUCCESS.getCode())) {
			ApproveApplyResultEntity entity = approveApplyResultEntityMapper
					.selectApproveApplyResultByApplyCode(req2.getApplyCode());
			try {
				BeanUtils.copyProperties(req, response.getData());
				BeanUtils.copyProperties(req, entity);
				if (req.getDataStatus().equals(BaseConstant.DATA_STATUS_Y)) {
					req.setDataStatus("正常");
				} else {
					req.setDataStatus("物理册除");
				}
				if (req.getDiskStatus().equals(BaseConstant.DISK_STATUS_Y)) {
					req.setDiskStatus("正常");
				} else {
					req.setDiskStatus("逻辑册除");
				}
				if (req.getApproveStatus().equals(BaseConstant.APPROVE_STATUS_Y)) {
					req.setApproveStatus("已审批");
				} else if (req.getApproveStatus().equals(BaseConstant.APPROVE_STATUS_N)) {
					req.setApproveStatus("未审批");
				} else {
					req.setApproveStatus("审批中");
				}
				if (req.getApproveResult().equals(BaseConstant.APPROVE_RESULT_Y)) {
					req.setApproveResult("同意（绑定）");
				} else if (req.getApproveResult().equals(BaseConstant.APPROVE_RESULT_N)) {
					req.setApproveResult("拒绝（解绑");
				} else {
					req.setApproveResult("待定（未绑）");
				}
				/**
				 * 把任务id从页面带到详情页面
				 */
				if (StringUtils.isNotBlank(req2.getId())) {
					req.setId(req2.getId());
					/**
					 * 任务批注信息
					 */
					List<CommentsModel> arr = getCommentByActivitiCodeAndApplyCode(req2.getApplyCode());
					result.setLs2(arr);
				}
				/**
				 * 推荐链路关系
				 */
				Request<String> requestUser = new Request<String>();
				
				requestUser.setData(req.getAccount());
				Response<List<AppUserResponse>> userListResponse = appUserApi.getUserListForMarket(requestUser);
				result.setLs3(userListResponse.getData());
				result.setResult(req);
				result.setCode(MarketBaseCode.SUCCESS.getCode());
				return result;
			} catch (Exception e) {
				result.setCode(MarketBaseCode.COPY_PROPERTIES_ERROR.getCode());
				return result;
			}
		} else {
			result.setCode(MarketBaseCode.APP_USER_APPLY_SHOP_ERROR.getCode());
			return result;
		}
	}
	@Transactional
	public ResultModel<String> acceptApplicatiYon(Request<ApproveApplyResultReq> request, String userCode) throws Exception {
		ResultModel<String> result = new ResultModel<String>();
		ApproveApplyResultReq req = request.getData();
		if (StringUtils.isBlank(req.getId())) {
			result.setCode(MarketBaseCode.ERROR_REQ_A002.getCode());
			return result;
		}
		Task task = workflowTraceService.getTaskById(req.getId());
		String nodeName = task.getName();
		if (nodeName.equals(FlowNodeConstant.ACCEPTAPPLICATION_NAME)) {
			/**
			 * 接受申请
			 */
			acceptapplicationToDo(req, userCode);
		} else if (nodeName.equals(FlowNodeConstant.CALL_BACK_NAME)) {
			/**
			 * 电话回访
			 */
			callBackToDo(req, userCode);
		} else if (nodeName.equals(FlowNodeConstant.PRE_LOAN_REVIEW_NAME)) {
			/**
			 * 贷前审核
			 */
			preLoanReviewToDao(req, userCode);
		} else if (nodeName.equals(FlowNodeConstant.CLOSE_TO_THE_DOOR_NAME)) {
			/**
			 * 上门尽调
			 */
			closeToTheDoorToDo(req, userCode);
		} else if (nodeName.equals(FlowNodeConstant.MATERIAL_APPROVAL_NAME)) {
			/**
			 * 材料审批
			 */
			materialApprovalDoTo(req, userCode);
		} else if (nodeName.equals(FlowNodeConstant.BOTH_PARTIES_SIGNED_A_CONTRACT_NAME)) {
			/**
			 * 双方签约
			 */
			bothPartiesSignedAContractToDo(req, userCode);
		} else if (nodeName.equals(FlowNodeConstant.FUNDS_APPROPRIATION_NAME)) {
			/**
			 * 资金拨款
			 */
			fundsAppropriationToDo(req, userCode);
		}
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}
	/**
	 * @author: xiongshikang
	 * @date: 2017年12月3日 下午2:54:17
	 * @Title: acceptapplicationToDo
	 * @Description: 接受申请
	 */
	private void acceptapplicationToDo(ApproveApplyResultReq req, String userCode ) {
		if (req.getYesOrNo().equals("Y")) {
			/**
			 * 接受申请
			 */
			String pid = workflowTraceService.saveSubmitTask(req, true, userCode);
			okAcceptApplication(req, pid, BaseConstant.APPROVE_STATUS_O, BaseConstant.APPROVE_RESULT_O, new Date(),
					null, FlowNodeConstant.ACCEPTAPPLICATION, true,userCode);// 业物处理
			/**
			 * 修改申请审批信息为，O-待定（未绑）、O-审批中
			 */
			approveApplyRecordEntityService.updateApplyShop(req.getApplyCode(), BaseConstant.APPROVE_RESULT_O,
					BaseConstant.APPROVE_STATUS_O);
		} else if (req.getYesOrNo().equals("N")) {
			/**
			 * 拒绝申请
			 */
			String pid = workflowTraceService.saveSubmitTask(req, false, userCode);
			noAcceptApplication(req, pid, BaseConstant.APPROVE_STATUS_Y, BaseConstant.APPROVE_RESULT_N, new Date(),
					new Date(), FlowNodeConstant.ACCEPTAPPLICATION,userCode);// 业物处理
			
			/**
			 * 远程同步申请审批信息
			 */
			approveApplyRecordEntityService.updateApplyShop(req.getApplyCode(), BaseConstant.APPROVE_RESULT_N,
					BaseConstant.APPROVE_STATUS_Y);
		}
	}
	/**
	 * @author: xiongshikang
	 * @date: 2017年12月3日 下午3:02:42
	 * @Title: CallBackToDo
	 * @Description: 电话回访
	 * @param req
	 * @param userCode 用户编号
	 */
	private void callBackToDo(ApproveApplyResultReq req, String userCode ) {
		if (req.getYesOrNo().equals("Y")) {
			/**
			 * 电话回访--接受
			 */
			String pid = workflowTraceService.saveSubmitTask(req, true, userCode);
			okAcceptApplication(req, pid, BaseConstant.APPROVE_STATUS_O, BaseConstant.APPROVE_RESULT_O, null, null,
					FlowNodeConstant.CALL_BACK, true,userCode);// 业物处理
		} else if (req.getYesOrNo().equals("N")) {
			/**
			 * 电话回访--拒绝
			 */
			String pid = workflowTraceService.saveSubmitTask(req, false, userCode);
			noAcceptApplication(req, pid, BaseConstant.APPROVE_STATUS_Y, BaseConstant.APPROVE_RESULT_N, null,
					new Date(), FlowNodeConstant.CALL_BACK,userCode);// 业物处理
			
			/**
			 * 远程同步申请审批信息
			 */
			approveApplyRecordEntityService.updateApplyShop(req.getApplyCode(), BaseConstant.APPROVE_RESULT_N,
					BaseConstant.APPROVE_STATUS_Y);
		}
	}
	/**
	 * @author: xiongshikang
	 * @date: 2017年12月3日 下午3:03:46
	 * @Title: PreLoanReviewToDao
	 * @Description: 贷前审核
	 * @param req
	 * @param userCode 用户编号
	 * @throws Exception 
	 */
	
	private void preLoanReviewToDao(ApproveApplyResultReq req, String userCode) throws Exception {
		if (req.getYesOrNo().equals("Y")) {		
			/**
			 * 添加公司、门店信息
			 */
			addOrUpateShop(req);
			/**
			 * 贷前审核--接受
			 */
			String pid = workflowTraceService.saveSubmitTask(req, true, userCode);
			okAcceptApplication(req, pid, BaseConstant.APPROVE_STATUS_O, BaseConstant.APPROVE_RESULT_O, null, null,
					FlowNodeConstant.PRE_LOAN_REVIEW, true,userCode);// 业物处理
		} else if (req.getYesOrNo().equals("N")) {
			/**
			 * 贷前审核--拒绝
			 */
			String pid = workflowTraceService.saveSubmitTask(req, false, userCode);
			noAcceptApplication(req, pid, BaseConstant.APPROVE_STATUS_Y, BaseConstant.APPROVE_RESULT_N, null,
					new Date(), FlowNodeConstant.PRE_LOAN_REVIEW,userCode);// 业物处理
			
			/**
			 * 远程同步申请审批信息
			 */
			approveApplyRecordEntityService.updateApplyShop(req.getApplyCode(), BaseConstant.APPROVE_RESULT_N,
					BaseConstant.APPROVE_STATUS_Y);
		}
	}
	/**
	 * @author: xiongshikang
	 * @date: 2017年12月3日 下午3:05:38
	 * @Title: closeToTheDoorToDo
	 * @Description: 上门尽调 (绑定)
	 * @param req
	 * @param userCode 用户编号
	 * @throws Exception 
	 */
	private void closeToTheDoorToDo(ApproveApplyResultReq req, String userCode) throws Exception {
		if (req.getYesOrNo().equals("Y")) {
			/**
			 * 添加公司、门店信息
			 */
			addOrUpateShop(req);
			/**
			 * 上门尽调--接受
			 */
			String pid = workflowTraceService.saveSubmitTask(req, true, userCode);
			okAcceptApplication(req, pid, BaseConstant.APPROVE_STATUS_O, BaseConstant.APPROVE_RESULT_Y, null, null,
					FlowNodeConstant.CLOSE_TO_THE_DOOR, true,userCode);// 业物处理
			/**
			 * 修改申请审批信息为，Y-同意（绑定）、O-审批中
			 */
			approveApplyRecordEntityService.updateApplyShop(req.getApplyCode(), BaseConstant.APPROVE_RESULT_Y,
					BaseConstant.APPROVE_STATUS_O);
			/**
			 * 创建erp、erpversion、shop信息
			 */
		} else if (req.getYesOrNo().equals("N")) {
			/**
			 * 上门尽调--拒绝
			 */
			String pid = workflowTraceService.saveSubmitTask(req, false, userCode);
			noAcceptApplication(req, pid, BaseConstant.APPROVE_STATUS_Y, BaseConstant.APPROVE_RESULT_N, null,
					new Date(), FlowNodeConstant.CLOSE_TO_THE_DOOR,userCode);// 业物处理
			
			/**
			 * 远程同步申请审批信息
			 */
			approveApplyRecordEntityService.updateApplyShop(req.getApplyCode(), BaseConstant.APPROVE_RESULT_N,
					BaseConstant.APPROVE_STATUS_Y);
		}
	}
	/**
	 * @author: xiongshikang
	 * @date: 2017年12月3日 下午3:06:46
	 * @Title: materialApprovalDoTo
	 * @Description: 材料审批
	 * @param req
	 * @param userCode 用户编号
	 * @throws Exception 
	 */
	private void materialApprovalDoTo(ApproveApplyResultReq req, String userCode) throws Exception {
		if (req.getYesOrNo().equals("Y")) {
			/**
			 * 添加公司、门店信息
			 */
			addOrUpateShop(req);
			/**
			 * 批量添加--> 申请审批客户信息表
			 */
			addOrUpdateApproveApplyCustomerEntity(req);
			/**
			 * 材料审批--接受
			 */
			String pid = workflowTraceService.saveSubmitTask(req, true, userCode);
			okAcceptApplication(req, pid, BaseConstant.APPROVE_STATUS_O, BaseConstant.APPROVE_RESULT_Y, null, null,
					FlowNodeConstant.MATERIAL_APPROVAL, true,userCode);// 业物处理
		} else if (req.getYesOrNo().equals("N")) {
			/**
			 * 材料审批--拒绝
			 */
			String pid = workflowTraceService.saveSubmitTask(req, false, userCode);
			noAcceptApplication(req, pid, BaseConstant.APPROVE_STATUS_Y, BaseConstant.APPROVE_RESULT_N, null,
					new Date(), FlowNodeConstant.MATERIAL_APPROVAL,userCode);// 业物处理
			
			/**
			 * 远程同步申请审批信息
			 */
			approveApplyRecordEntityService.updateApplyShop(req.getApplyCode(), BaseConstant.APPROVE_RESULT_N,
					BaseConstant.APPROVE_STATUS_Y);
		}
	}
	/**
	 * @author: xiongshikang
	 * @date: 2017年12月3日 下午3:08:12
	 * @Title: bothPartiesSignedAContractToDo
	 * @Description: 双方签约
	 * @param req
	 * @param userCode 用户编号
	 * @throws Exception 
	 */
	private void bothPartiesSignedAContractToDo(ApproveApplyResultReq req, String userCode ) throws Exception {
		if (req.getYesOrNo().equals("Y")) {
			/**
			 * 添加公司、门店信息
			 */
			addOrUpateShop(req);
			/**
			 * 批量修改或添加--> 申请审批客户信息表
			 */
			addOrUpdateApproveApplyCustomerEntity(req);
			/**
			 * 双方签约--接受
			 */
			String pid = workflowTraceService.saveSubmitTask(req, true, userCode);
			okAcceptApplication(req, pid, BaseConstant.APPROVE_STATUS_O, BaseConstant.APPROVE_RESULT_Y, null, null,
					FlowNodeConstant.BOTH_PARTIES_SIGNED_A_CONTRACT, true,userCode);// 业物处理
		} else if (req.getYesOrNo().equals("N")) {
			/**
			 * 双方签约--拒绝
			 */
			String pid = workflowTraceService.saveSubmitTask(req, false, userCode);
			noAcceptApplication(req, pid, BaseConstant.APPROVE_STATUS_Y, BaseConstant.APPROVE_RESULT_N, null,
					new Date(), FlowNodeConstant.BOTH_PARTIES_SIGNED_A_CONTRACT,userCode);// 业物处理
			
			/**
			 * 远程同步申请审批信息
			 */
			approveApplyRecordEntityService.updateApplyShop(req.getApplyCode(), BaseConstant.APPROVE_RESULT_N,
					BaseConstant.APPROVE_STATUS_Y);
		}
	}
	
	/**
	 * @author: xiongshikang
	 * @date: 2017年12月3日 下午3:09:33
	 * @Title: fundsAppropriationToDo
	 * @Description: 资金拨款
	 * @param req
	 * @param userCode 用户编号
	 */
	private void fundsAppropriationToDo(ApproveApplyResultReq req, String userCode) {
		if (req.getYesOrNo().equals("Y")) {
			/**
			 * 添加-->申请审批放款信息表
			 */
		   addApproveApplyLoanEntity(req);
			/**
			 * 资金拨款--接受
			 */
		    String pid = workflowTraceService.saveSubmitTask(req, true, userCode);
			okAcceptApplication(req, pid, BaseConstant.APPROVE_STATUS_Y, BaseConstant.APPROVE_RESULT_Y, null,
					new Date(), FlowNodeConstant.FUNDS_APPROPRIATION, true,userCode);// 业物处理
			/**
			 * 远程同步申请审批信息为，Y-同意（绑定）、O-审批中
			 */
			approveApplyRecordEntityService.updateApplyShop(req.getApplyCode(), BaseConstant.APPROVE_RESULT_Y,
					BaseConstant.APPROVE_STATUS_Y);
		} else if (req.getYesOrNo().equals("N")) {
			/**
			 * 资金拨款--拒绝
			 */
			String pid = workflowTraceService.saveSubmitTask(req, true, userCode);
			noAcceptApplication(req, pid, BaseConstant.APPROVE_STATUS_Y, BaseConstant.APPROVE_RESULT_N, null,
					new Date(), FlowNodeConstant.FUNDS_APPROPRIATION,userCode);// 业物处理
			
			/**
			 * 远程同步申请审批信息
			 */
			approveApplyRecordEntityService.updateApplyShop(req.getApplyCode(), BaseConstant.APPROVE_RESULT_N,
					BaseConstant.APPROVE_STATUS_Y);
		}
		
	}
	
	/**
	 * @author: xiongshikang
	 * @date: 2017年12月3日 下午3:24:13
	 * @Title: okAcceptApplication
	 * @Description: 同意
	 * @param req
	 * @param pid 流程实例id
	 * @param startTime 任务开始时间
	 * @param endTime 任务结束时间
	 * @param nodeCode 节点code
	 * @param status 审批状态
	 * @param result 审批结果
	 * @param bl 是否持行更改申请审批结果状态
	 */
	private void okAcceptApplication(ApproveApplyResultReq req, String pid, String status, String result,
			Date startTime, Date endTime, String nodeCode, boolean bl,String userCode) {
		/**
		 * 记录流程人员操作路线
		 */
		addApplyTransactEntity(req,userCode,nodeCode,pid);
		
		/**
		 * 更改申请审批结果状态
		 */
		if (bl == true) {
			updateApproveApplyResultEntity(nodeCode,req.getApplyCode(), status, result, startTime, endTime);
		}
		/**
		 * 添加申请审批进度记录
		 */
		approveApplyRecordEntityService.addApproveApplyRecordEntity(BaseConstant.FLOW_NODE_STATUS_Y,
				req.getFlowNodeResult(), req.getFlowCode(),req.getApplyCode(),pid,nodeCode,userCode);
	}
	/**
	 * @author: xiongshikang
	 * @date: 2017年12月3日 下午3:24:54
	 * @Title: noAcceptApplication
	 * @Description: 拒绝
	 * @param pid 流程实例id
	 * @param startTime 任务开始时间
	 * @param endTime 任务结束时间
	 * @param nodeCode 节点code
	 * @param status 审批状态
	 * @param result 审批结果
	 */
	private void noAcceptApplication(ApproveApplyResultReq req, String pid, String status, String result,
			Date startTime, Date endTime, String nodeCode,String userCode) {
		/**
		 * 记录流程人员操作路线
		 */
		addApplyTransactEntity(req,userCode,nodeCode,pid);
		/**
		 * 更改申请审批结果状态
		 */
		updateApproveApplyResultEntity(nodeCode,req.getApplyCode(), status, result, startTime, endTime);
		
		/**
		 * 添加申请审批进度记录
		 */
		approveApplyRecordEntityService.addApproveApplyRecordEntity(BaseConstant.FLOW_NODE_STATUS_N,
				req.getFlowNodeResult(), req.getFlowCode(), req.getApplyCode(), pid, nodeCode,userCode);
	}
	/**
	 * @author: xiongshikang
	 * @date: 2017年11月30日 下午3:31:50
	 * @Title: updateApproveApplyResultEntity
	 * @Description: 更改申请审批结果状态
	 * @param applyCode 申请流水编号
	 * @param approveStatus 审批状态
	 * @param approveResult 审批结果
	 */
	private void updateApproveApplyResultEntity(String nodeCode,String applyCode, String approveStatus, String approveResult,
			Date startTime, Date endTime) {
		ApproveApplyResultEntity model = new ApproveApplyResultEntity();
		model.setApplyCode(applyCode);
		/**
		 * 设置状态为已审批
		 */
		model.setApproveStatus(approveStatus);
		model.setApproveResult(approveResult);
		model.setApproveStartTime(startTime);
		model.setApproveEndTime(endTime);
		model.setNodeCode(nodeCode);
		/**
		 * 更新状态为已审批
		 */
		approveApplyResultEntityMapper.updateByApplyCode(model);
	}
	
	/**
	 * @author: xiongshikang
	 * @date: 2017年12月1日 下午4:28:01
	 * @Title: updateActivitiCodeByApplyCode
	 * @Description: 通过流水号修改审批信息的工作流程id
	 * @param applyCode
	 * @param activitiCode
	 */
	@Transactional
	public void updateActivitiCodeByApplyCode(String applyCode, String activitiCode) {
		ApproveApplyResultEntity record = new ApproveApplyResultEntity();
		record.setActivitiCode(activitiCode);
		record.setApplyCode(applyCode);
		approveApplyResultEntityMapper.updateByApplyCode(record);
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月7日 下午4:41:58
	 * @Title: selectPluginLicenseAllList 
	 * @Description: 查找所有未册除的流水信息
	 * @param record
	 * @return
	 * @throws Exception
	 *
	 */
	public TableResponse<ApproveApplyResultResponse> selectPluginLicenseAllList(ApplyShopReq record)
			throws Exception {
		TableResponse<ApproveApplyResultResponse> table = new TableResponse<ApproveApplyResultResponse>();
		TableResponse<ApproveApplyResultResponse> applyShopPage = getAllPage(record,
				record.getOffset(), record.getLimit());
		List<ApproveApplyResultResponse> ls = applyShopPage.getRows();
		long total = applyShopPage.getTotal();
		table.setRows(ls);
		table.setTotal(total);
		return table;
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月7日 下午4:39:50
	 * @Title: getAllPage 
	 * @Description: 查找所有未册除的流水信息
	 * @param shopName
	 * @param offset
	 * @param limit
	 * @return
	 * @throws Exception
	 *
	 */
	private TableResponse<ApproveApplyResultResponse> getAllPage(ApplyShopReq record, int offset, int limit)
			throws Exception {
		Request<ApplyShopRequest> request = new Request<>();
		ApplyShopRequest applyShopRequest = new ApplyShopRequest();
		applyShopRequest.setLimit(limit);
		applyShopRequest.setOffset(offset);
		applyShopRequest.setShopName(record.getShopName());
		applyShopRequest.setBossMobile(record.getBossMobile());
		applyShopRequest.setApproveResult(record.getApproveResult());
		request.setData(applyShopRequest);
		Response<TableResultResponse<ApplyShopResponse>> response = applyShopApi
				.selectAllPage(request);
		List<ApproveApplyResultResponse> approveApplyResultResponseList = new ArrayList<>();
		TableResultResponse<ApplyShopResponse> data = response.getData();
		List<ApplyShopResponse> list = data.getRows();
		for (int i = 0; i < list.size(); i++) {
			ApplyShopResponse applyShopResponse = list.get(i);
			ApproveApplyResultEntity approveApplyResultEntity = approveApplyResultEntityMapper
					.selectApproveApplyResultByApplyCode(applyShopResponse.getApplyCode());
			ApproveApplyResultResponse approveApplyResultResponse = new ApproveApplyResultResponse();
			BeanUtils.copyProperties(approveApplyResultResponse, applyShopResponse);
			BeanUtils.copyProperties(approveApplyResultResponse, approveApplyResultEntity);
			if (approveApplyResultResponse.getDataStatus().equals(BaseConstant.DATA_STATUS_Y)) {
				approveApplyResultResponse.setDataStatus("正常");
			} else {
				approveApplyResultResponse.setDataStatus("物理册除");
			}
			if (approveApplyResultResponse.getDiskStatus().equals(BaseConstant.DISK_STATUS_Y)) {
				approveApplyResultResponse.setDiskStatus("正常");
			} else {
				approveApplyResultResponse.setDiskStatus("逻辑册除");
			}
			if (approveApplyResultResponse.getApproveStatus().equals(BaseConstant.APPROVE_STATUS_Y)) {
				approveApplyResultResponse.setApproveStatus("<h5 style='color:green;'> 已审批</h5>");
			} else if (approveApplyResultResponse.getApproveStatus().equals(BaseConstant.APPROVE_STATUS_N)) {
				approveApplyResultResponse.setApproveStatus("<h5 style='color:red;'>未审批</h5>");
			} else {
				approveApplyResultResponse.setApproveStatus("<h5 style='color:#A9A9A9;'>审批中</h5>");
			}
			if (approveApplyResultResponse.getApproveResult().equals(BaseConstant.APPROVE_RESULT_Y)) {
				approveApplyResultResponse.setApproveResult("<h5 style='color:green;'>同意（绑定）</h5>");
			} else if (approveApplyResultResponse.getApproveResult().equals(BaseConstant.APPROVE_RESULT_N)) {
				approveApplyResultResponse.setApproveResult("<h5 style='color:red;'>拒绝（解绑）</h5>");
			} else {
				approveApplyResultResponse.setApproveResult("<h5 style='color:red;'>待定（未绑）</h5>");
			}
			if (approveApplyResultResponse.getActivitiCode().equals("NIL")) {
				approveApplyResultResponse.setActivitiCode("<h5 style='color:green;'>未被领取</h5>");
			} else {
				approveApplyResultResponse.setActivitiCode("<h5 style='color:red;'>已被领取</h5>");
			}
			approveApplyResultResponse.setApproveStartTime(approveApplyResultEntity.getApproveStartTime());
			approveApplyResultResponse.setApproveEndTime(approveApplyResultEntity.getApproveEndTime());
			approveApplyResultResponseList.add(approveApplyResultResponse);
		}
		TableResponse<ApproveApplyResultResponse> tableResultResponse = new TableResponse<>();
		tableResultResponse.setTotal(data.getTotal());
		tableResultResponse.setRows(approveApplyResultResponseList);
		return tableResultResponse;
	}

	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月18日 下午3:45:17
	 * @Title: addShop 
	 * @Description: 添加门店信息
	 * @param req
	 * @throws Exception 
	 *
	 */
	private void addOrUpateShop(ApproveApplyResultReq req) throws Exception {
		Request<BaseShopRequest> requestTwo = new Request<BaseShopRequest>();
		if(StringUtils.isNotBlank(req.getShopCode())) {
			BaseShopRequest entitytwo = new BaseShopRequest();
			entitytwo.setShopCode(req.getShopCode());
			entitytwo.setCompanyCode(req.getCompanyCode());
			requestTwo.setData(entitytwo);
			Response<List<BaseShopResponse>> responseTwo = baseShopApi.findBaseShop(requestTwo);
			if(responseTwo.getCode().equals(BaseCode.SUCCESS.getCode())) {
				List<BaseShopResponse> arr = responseTwo.getData();
				if(!arr.get(0).getShopName().equals(req.getShopName())) {
					entitytwo.setShopName(req.getShopName());
					entitytwo.setCompanyCode(req.getCompanyCode());
					entitytwo.setShopCode(null);
					requestTwo.setData(entitytwo);
					Response<List<BaseShopResponse>> response = baseShopApi.findBaseShop(requestTwo);
					if(response.getCode().equals(BaseCode.SUCCESS.getCode())) {
						List<BaseShopResponse> ls = response.getData();
						if(null!=ls && ls.size()>0) {
							throw new Exception("已有相同的门店名！");
						}
					}else {
						throw new Exception("远程调用失败");
					}
					
				}
			}else {
				throw new Exception("远程调用失败");
			}
		}
 
		if(StringUtils.isNotBlank(req.getShopCode())) {
			Request<BaseShopRequest> request = new Request<BaseShopRequest>();
			BaseShopRequest param = new BaseShopRequest();
			BeanUtils.copyProperties(param, req);
			request.setData(param);
			Response<Void> result = baseShopApi.updateBaseShop(request);
			if(!result.getCode().equals(BaseCode.SUCCESS.getCode())) {
				throw new Exception("远程调用失败");
			}
		}else {
			String shopCode = "";
			BaseShopRequest entitytwo = new BaseShopRequest();
			entitytwo.setShopName(req.getShopName());
			entitytwo.setCompanyCode(req.getCompanyCode());
			requestTwo.setData(entitytwo);
			Response<List<BaseShopResponse>> responseTwo = baseShopApi.findBaseShop(requestTwo);
			List<BaseShopResponse> arr = responseTwo.getData();
			if(null!=arr && arr.size()>0) {
				shopCode = req.getShopCode();
			}else {
				Request<BaseShopRequest> request = new Request<BaseShopRequest>();
				BaseShopRequest entity = new BaseShopRequest();
				shopCode = GUID.randomGUID();
				entity.setCityNo(req.getCityNo());
				entity.setShopCode(shopCode);
				entity.setCompanyCode(req.getCompanyCode());
				entity.setShopName(req.getShopName());
				entity.setContacts(req.getContacts());
				entity.setPhone(req.getPhone());
				entity.setShopAddress(req.getShopAddress());
				entity.setProvinceNo(req.getProvinceNo());
				entity.setTownNo(req.getTownNo());
				request.setData(entity);
				Response<Void> result = baseShopApi.insertBaseShop(request);
				if(!result.getCode().equals(BaseCode.SUCCESS.getCode())) {
					throw new Exception("添加门店失败");
				}
			}
			ApproveApplyResultEntity record = new ApproveApplyResultEntity();
			record.setShopCode(shopCode);
			record.setApplyCode(req.getApplyCode());
			approveApplyResultEntityMapper.updateByApplyCode(record);
		}
		/**
		 * 远程更新流水门店名与地址信息
		 */
		Request<ApplyShopRequest> rq = new Request<ApplyShopRequest>();
		ApplyShopRequest data = new ApplyShopRequest();
		data.setApplyCode(req.getApplyCode());
		data.setShopName(req.getShopName());
		data.setShopAddress(req.getShopAddress());
		data.setShopAddress(req.getShopAddress());
		data.setProvinceNo(req.getProvinceNo());
		data.setTownNo(req.getTownNo());
		rq.setData(data);
		applyShopApi.updateApplyShopByKey(rq);
		
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月30日 下午4:44:44
	 * @Title: addApproveApplyLoanEntity 
	 * @Description: 添加-->申请审批放款信息表
	 * @param req
	 *
	 */
	private void addApproveApplyLoanEntity(ApproveApplyResultReq req) {
		String applyCode = req.getApplyCode();
		ApproveApplyResultEntity model = approveApplyResultEntityMapper.selectApproveApplyResultByApplyCode(applyCode);
		ApproveApplyLoanEntity entity = new ApproveApplyLoanEntity();
		entity.setActivitiCode(model.getActivitiCode());
		entity.setApplyCode(model.getApplyCode());
		entity.setFlowCode(model.getFlowCode());
		entity.setInterestEndTime(req.getInterestEndTime());
		entity.setInterestStartTime(req.getInterestStartTime());
		entity.setLoanActualMoney(req.getLoanActualMoney());
		entity.setLoanCode(GUID.randomGUID());
		entity.setLoanMoney(req.getLoanMoney());
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		entity.setVersion(1L);
		entity.setDataStatus(BaseConstant.DATA_STATUS_Y);
		entity.setDiskStatus(BaseConstant.DISK_STATUS_Y);
		approveApplyLoanEntityMapper.insert(entity);
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月30日 下午6:08:07
	 * @Title: addApproveApplyCustomerEntity 
	 * @Description: 批量添加--> 申请审批客户信息表
	 * @param req
	 *
	 */
	private void addOrUpdateApproveApplyCustomerEntity(ApproveApplyResultReq req) {
		String applyCode = req.getApplyCode();
		List<ApproveApplyCustomerReq> ls = req.getApproveApplyCustomerReqs();
		ApproveApplyResultEntity model = approveApplyResultEntityMapper.selectApproveApplyResultByApplyCode(applyCode);
		for (ApproveApplyCustomerReq a : ls) {
			if(StringUtils.isNotBlank(a.getCustomerCode())) {
				ApproveApplyCustomerEntity entity = new ApproveApplyCustomerEntity();
				entity.setCustomerCode(a.getCustomerCode());
				entity.setCustomerIdcard(a.getCustomerIdcard());
				entity.setCustomerName(a.getCustomerName());
				approveApplyCustomerEntityMapper.updateByPrimaryKeySelective(entity);
			}else {
				ApproveApplyCustomerEntity entity = new ApproveApplyCustomerEntity();
				entity.setActivitiCode(model.getActivitiCode());
				entity.setApplyCode(model.getApplyCode());
				entity.setCustomerCode(GUID.randomGUID());
				entity.setCustomerIdcard(a.getCustomerIdcard());
				entity.setCustomerName(a.getCustomerName());
				entity.setFlowCode(model.getFlowCode());
				entity.setCreateTime(new Date());
				entity.setUpdateTime(new Date());
				entity.setVersion(1L);
				entity.setDataStatus(BaseConstant.DATA_STATUS_Y);
				entity.setDiskStatus(BaseConstant.DISK_STATUS_Y);
				approveApplyCustomerEntityMapper.insert(entity);
			}
		}
	}
	
	public List<ApplyExcelModelResponse> applyExcel(ApplyExcelModelRequest model) throws Exception{
		if(StringUtils.isBlank(model.getAccount())) {
		    List<ApplyExcelModelResponse> resultLs = new ArrayList<ApplyExcelModelResponse>();  
		    Request<ApplyExcelModelReq> request = new Request<ApplyExcelModelReq>();
		    ApplyExcelModelReq param = new ApplyExcelModelReq();
		    request.setData(param);
		    Response<List<AppUserInvitationRelationResponse>> response = applyShopApi.selectLevelExecl(request);
			if(response.getCode().equals(BaseCode.SUCCESS.getCode())) {
				List<AppUserInvitationRelationResponse> ls = response.getData();
				for (AppUserInvitationRelationResponse entity : ls) {
					model.setAccount(entity.getAccount());
					model.setMobile(entity.getMobile());
					model.setName(entity.getName());
					ApplyExcelModelResponse result = applyExcelOne(model);
					result.setParentDes("一级");
					result.setAccount(entity.getAccount());
					result.setParentAccount("-1");
					boolean bl = false;
					if(null!=entity.getLs() && entity.getLs().size()>0) {
						 List<AppUserInvitationRelationResponse> childs = entity.getLs();
						 for (AppUserInvitationRelationResponse children : childs) {
							    model.setAccount(children.getAccount());
								model.setMobile(children.getMobile());
								model.setName(children.getName());
								ApplyExcelModelResponse resultTow = applyExcelOne(model);
								resultTow.setChildrenDes("二级");
								resultTow.setAccount(children.getAccount());
								resultTow.setParentAccount(entity.getAccount());
								if(resultTow.getApplyCount()>0) {
									bl =true;
									resultLs.add(resultTow);
								}
						}
					}	
					if(result.getApplyCount()>0) {
						/**
						 * 自已有进件的情况，必需展示
						 */
						resultLs.add(result);
					}else if(bl==true) {
						/**
						 * 自已没有展示，但下线有，也要展示
						 */
						resultLs.add(result);
					}
				}
				/**
				 * 重新倒序
				 */
				   Collections.reverse(resultLs); // 倒序排列 
				return resultLs;
			}else {
				throw new Exception("远程调用失败");
			}
		}else {
			return null;
		}	
		
	}
	
	public void ApplyExcelLoad(ApplyExcelModelRequest model,ServletOutputStream out) throws Exception {
		List<ApplyExcelModelResponse> ls = applyExcel(model);
		JSONArray jsonArray = new JSONArray();
		for (ApplyExcelModelResponse m : ls) {
			jsonArray.add(m);
		}
		String search ="";
		String title = "每个销售负责的渠道销售成果";
		if(null!=model.getStartTime() && null!=model.getEndTime()) {
			search += DateUtils.changeStringToDate(model.getStartTime())+" 到 "+DateUtils.changeStringToDate(model.getEndTime());
		}else if(null!=model.getStartTime()) {
			search += DateUtils.changeStringToDate(model.getStartTime());
		}else {
			search += DateUtils.changeStringToDate(model.getEndTime());
		}
		
        Map<String,String> headMap = new LinkedHashMap<String,String>();  
        headMap.put("parentDes", "上级");
        headMap.put("childrenDes", "下线");
        headMap.put("name", "名称");
        headMap.put("mobile", "联系电话");
        headMap.put("applyCount", "进件数");
        headMap.put("dealCount", "成交数");
        headMap.put("refuseCount", "拒绝件数");
        headMap.put("HaveInHandCount", "审查中件数");
        headMap.put("loanMoneySum", "审批批款金额");
        headMap.put("loanActualMoneySum", "实际放款金额");
        ExcelUtil.exportExcelX(title,search,headMap, jsonArray, null, 0, out);
	}
	
	private  ApplyExcelModelResponse applyExcelOne(ApplyExcelModelRequest model) throws Exception {
		ApplyExcelModelResponse res = new ApplyExcelModelResponse();
		Request<ApplyExcelModelReq> request = new Request<ApplyExcelModelReq>();
		ApplyExcelModelReq param = new ApplyExcelModelReq();
		param.setAccount(model.getAccount());
		param.setEndTime(model.getEndTime());
		param.setStartTime(model.getStartTime());
		request.setData(param);
		Response<ApplyExcelModelResp> response = applyShopApi.getApplyExcelModel(request);
		if(response.getCode().equals(BaseCode.SUCCESS.getCode())) {
			ApplyExcelModelResp resp = response.getData();
			BeanUtils.copyProperties(res, resp);
		}else {
			throw new Exception("远程调用失败");
		}
		/**
		 * 继续统计批款金额- 实际放款金额
		 */
		
		Response<List<ApiApplyShopResponse>> responseTow = applyShopApi.selectApplyShopByAccount(request);
		if(responseTow.getCode().equals(BaseCode.SUCCESS.getCode())) {
			List<ApiApplyShopResponse> respTow = responseTow.getData();
			/**
			 * 审批批款金额
			 */
			BigDecimal loanMoneySum = new BigDecimal(0);
			 /**
		     * 实际放款金额
		     */
		    BigDecimal loanActualMoneySum = new BigDecimal(0);
			for (ApiApplyShopResponse m : respTow) {
				String applyCode = m.getApplyCode();
				ApproveApplyLoanEntity loanModel = approveApplyLoanEntityMapper.selectApplyLoanApplyCode(applyCode);
				if(null!=loanModel) {
					loanMoneySum = loanMoneySum.add(loanModel.getLoanMoney());
					loanActualMoneySum = loanActualMoneySum.add(loanModel.getLoanActualMoney());
				}
			}
			res.setLoanMoneySum(loanMoneySum);
			res.setLoanActualMoneySum(loanActualMoneySum);
			res.setMobile(model.getMobile());
			res.setName(model.getName());
			return res;
		}else {
			throw new Exception("远程调用失败");
		}
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月18日 上午10:21:52
	 * @Title: addApplyTransactEntity 
	 * @Description: 添加办理或转交任务关联信息
	 * @param req
	 * @param userCode
	 *
	 */
	private void addApplyTransactEntity(ApproveApplyResultReq req,String userCode,String nodeCode,String activitiCode) {
		ApproveApplyTransactEntity entity = new ApproveApplyTransactEntity();
		entity.setApplyCode(req.getApplyCode());
		entity.setTransactCode(GUID.randomGUID());
		entity.setFlowCode(req.getFlowCode());
		entity.setNodeCode(nodeCode);
		entity.setActivitiCode(activitiCode);
		entity.setTransactAcceptor(req.getTaskActionUserCode());
		entity.setTransactUser(userCode);
		entity.setTransactComment(req.getFlowNodeResult());
		entity.setTransactType(BaseConstant.TRANSACT_STATUS_Y);
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		entity.setVersion(1L);
		entity.setDataStatus(BaseConstant.DATA_STATUS_Y);
		entity.setDiskStatus(BaseConstant.DISK_STATUS_Y);
		entity.setTransactParentUser(req.getTransactUser());
		approveApplyTransactEntityMapper.insert(entity);
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年3月12日 下午7:05:11
	 * @Title: getCommentByActivitiCodeAndApplyCode 
	 * @Description: 通过流水编号，查找流程备注信息
	 * @param applyCode 流水编号
	 * @return
	 *
	 */
	public List<CommentsModel> getCommentByActivitiCodeAndApplyCode(String applyCode){
		List<CommentsModel> commentModels = new ArrayList<CommentsModel>();
		List<ApproveApplyTransactEntity> ls =approveApplyTransactEntityMapper.selectApproveApplyTransactByApplyCode(applyCode);
		for (ApproveApplyTransactEntity a : ls) {
			CommentsModel m = new CommentsModel();
			m.setUserName(approveSecurityUserMapper.selectUserByUserCode(a.getTransactUser()).getUserName());
			m.setTime(a.getCreateTime());
			m.setMessageParts(a.getTransactComment());
			commentModels.add(m);
		}
		return commentModels;
	}
	
}
