/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.common.entity;

import java.util.Date;
import java.util.Map;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
/**
 * 
 * @ClassName: ShopLoanResponse 
 * @Description: 申请审批放款页面展示类
 * @author: xiongshikang
 * @date: 2018年1月29日 上午9:42:21
 */
public class ShopLoanResponse {
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private String processInstanceId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 流程编号
     */
    private String flowCode;
    /**
     * 节点名称
     */
    private String nodeName;
    /**
     * 备注
     */
    private String flowNodeResult;
    

	/**
	 * 开始时间
	 */
	private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 审批开始时间
     */
    private Date realityStartTime;

    /**
     * 审批结束时间
     */
    private Date realityEndTime;
    /**
     *  申请时间
     */
    private Date applyTime;
 
    /**
     * <pre>
     * 门店code
     * 表字段 : app_user_apply_shop.apply_code
     * </pre>
     */
    private String applyCode;

    /**
     * <pre>
     * 老板姓名
     * 表字段 : app_user_apply_shop.boss_name
     * </pre>
     */
    private String bossName;

    /**
     * <pre>
     * 老板电话
     * 表字段 : app_user_apply_shop.boss_mobile
     * </pre>
     */
    private String bossMobile;

    /**
     * <pre>
     * 老板微信
     * 表字段 : app_user_apply_shop.boss_wechat
     * </pre>
     */
        private String bossWechat;

    /**
     * <pre>
     * 门店名称
     * 表字段 : app_user_apply_shop.shop_name
     * </pre>
     */
    private String shopName;

    /**
     * <pre>
     * 门店地址
     * 表字段 : app_user_apply_shop.shop_address
     * </pre>
     */
    private String shopAddress;

    /**
     * <pre>
     * 省份编号
     * 表字段 : app_user_apply_shop.province_no
     * </pre>
     */
    private String provinceNo;

    /**
     * <pre>
     * 城市编号
     * 表字段 : app_user_apply_shop.city_no
     * </pre>
     */
    private String cityNo;

    /**
     * <pre>
     * 镇区编号
     * 表字段 : app_user_apply_shop.town_no
     * </pre>
     */
    private String townNo;

    /**
     * <pre>
     * 页码数
     * </pre>
     */
    private Integer page;

    /**
     * <pre>
     * 每页显示多少条
     * </pre>
     */
    private Integer pageSize;

    /**
     * <pre>
     * 总条数
     * </pre>
     */
    private Integer totalCount;

    /**
     * <pre>
     * 审核状态
     * </pre>
     */
    private String approveStatus;

    /**
     * <pre>
     * 审核时间
     * </pre>
     */
    private String approveTime;


    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public String getBossMobile() {
        return bossMobile;
    }

    public void setBossMobile(String bossMobile) {
        this.bossMobile = bossMobile;
    }

    public String getBossWechat() {
        return bossWechat;
    }

    public void setBossWechat(String bossWechat) {
        this.bossWechat = bossWechat;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getProvinceNo() {
        return provinceNo;
    }

    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    public String getTownNo() {
        return townNo;
    }

    public void setTownNo(String townNo) {
        this.townNo = townNo;
    }

    public Integer getPage() {
        if(this.page==null || this.page < 1) {
            return 1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        if(this.pageSize==null || this.pageSize < 1) {
            return 10;
        }
        return pageSize;
    }


    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getApplyCode() {
        return applyCode;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(String approveTime) {
        this.approveTime = approveTime;
    }
    
    //-- 临时属性 --//

    // 流程任务
    private Task task;

    private Map<String, Object> variables;

    // 运行中的流程实例
    private ProcessInstance processInstance;

    // 历史的流程实例
    private HistoricProcessInstance historicProcessInstance;

    // 流程定义
    private ProcessDefinition processDefinition;

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getRealityStartTime() {
		return realityStartTime;
	}

	public void setRealityStartTime(Date realityStartTime) {
		this.realityStartTime = realityStartTime;
	}

	public Date getRealityEndTime() {
		return realityEndTime;
	}

	public void setRealityEndTime(Date realityEndTime) {
		this.realityEndTime = realityEndTime;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Map<String, Object> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}

	public ProcessInstance getProcessInstance() {
		return processInstance;
	}

	public void setProcessInstance(ProcessInstance processInstance) {
		this.processInstance = processInstance;
	}

	public HistoricProcessInstance getHistoricProcessInstance() {
		return historicProcessInstance;
	}

	public void setHistoricProcessInstance(HistoricProcessInstance historicProcessInstance) {
		this.historicProcessInstance = historicProcessInstance;
	}

	public ProcessDefinition getProcessDefinition() {
		return processDefinition;
	}

	public void setProcessDefinition(ProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
	}
    public String getFlowCode() {
		return flowCode;
	}

	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getFlowNodeResult() {
		return flowNodeResult;
	}

	public void setFlowNodeResult(String flowNodeResult) {
		this.flowNodeResult = flowNodeResult;
	}
    
}
