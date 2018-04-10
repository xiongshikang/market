/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service;

import java.util.List;

import javax.servlet.ServletOutputStream;

import cn.guludai.api.data.Request;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.web.request.ApplyShopReq;
import cn.guludai.market.web.request.ApproveApplyResultReq;
import cn.guludai.market.web.response.ApproveApplyResultResponse;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.saler.request.ApplyExcelModelRequest;
import cn.guludai.market.web.saler.response.ApplyExcelModelResponse;
/**
 * 
 * @ClassName: ApproveApplyResultService 
 * @Description: 申请审批服务类
 * @author: xiongshikang
 * @date: 2017年11月27日 下午4:07:44
 */
public interface ApproveApplyResultService {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月24日 下午3:02:29
	 * @Title: selectNodeInfoByNodeCodePage 
	 * @Description: 查询节点活动的流水信息
	 * @param record
	 * @return
	 * @throws Exception
	 *
	 */
	public TableResponse<ApproveApplyResultResponse> selectNodeInfoByNodeCodePage(ApproveApplyResultReq record)
			throws Exception;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月24日 下午3:21:44
	 * @Title: selectNodeInfoFOrIsNoPage 
	 * @Description: 
	 * @param record
	 * @return
	 * @throws Exception
	 *
	 */
	public TableResponse<ApproveApplyResultResponse> selectNodeInfoFOrIsNoPage(ApproveApplyResultReq record)
			throws Exception;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月27日 下午4:07:30
	 * @Title: selectPluginLicenseList 
	 * @Description: 通过多条件查询申请审批数据
	 * @param record
	 * @return
	 * @throws Exception
	 *
	 */
	public TableResponse<ApproveApplyResultResponse> selectPluginLicenseList(ApproveApplyResultReq record) throws Exception;
	
	 /**
	  * 
	  * @author: xiongshikang
	  * @date: 2017年11月28日 上午10:57:20
	  * @Title: select 
	  * @Description: 通过流水号查询申请信息
	  * @param applyCode 流水号
	  * @return
	  *
	  */
	public ResultModel<ApproveApplyResultResponse> select(ApproveApplyResultReq req);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月29日 下午2:00:55
	 * @Title: acceptApplication 
	 * @Description: 接受申请(节点)
	 * @param req
	 * @param userName 用户名
	 * @param taskActionUserCode 指派持行的任务人员
	 * @return
	 *
	 */
	public ResultModel<String> acceptApplicatiYon(Request<ApproveApplyResultReq> req,String userName)throws Exception ;
	

	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月1日 下午4:28:01
	 * @Title: updateActivitiCodeByApplyCode
	 * @Description:  通过流水号修改审批信息的工作流程id
	 * @param applyCode
	 * @param activitiCode
	 *
	 */
	public void updateActivitiCodeByApplyCode(String applyCode,String activitiCode);
	
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
			throws Exception;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月3日 下午3:33:28
	 * @Title: ApplyExcel 
	 * @Description: 对每个销售负责的渠道销售成果，在选取的时间段中进行统计 (导出excel)
	 * @param model 两个日期时间
	 * @param out
	 * @return
	 * @throws Exception
	 *
	 */
	public void ApplyExcelLoad(ApplyExcelModelRequest model,ServletOutputStream out) throws Exception;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月3日 下午4:27:46
	 * @Title: applyExcel 
	 * @Description: 对每个销售负责的渠道销售成果，在选取的时间段中进行统计(查询，树节点展示)
	 * @param model
	 * @return
	 * @throws Exception
	 *
	 */
	public List<ApplyExcelModelResponse> applyExcel(ApplyExcelModelRequest model) throws Exception;
 
}
