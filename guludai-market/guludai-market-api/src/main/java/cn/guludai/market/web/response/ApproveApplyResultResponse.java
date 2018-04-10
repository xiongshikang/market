/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.response;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * @ClassName: ApproveApplyResultReq 
 * @Description: 申请审批结果接参类
 * @author: xiongshikang
 * @date: 2017年11月27日 下午2:13:14
 */
public class ApproveApplyResultResponse {
	
	 //========================门店信息===================================
	 
    //联系人
    private String contacts;
    //联系电话
    private String phone;
    /**
     * 门店编号
     */
    private String shopCode;
 
	/**
	 * <pre>
	 * 审批开始时间
	 * 表字段 : approve_apply_result.approve_start_time
	 * </pre>
	 */
	private Date approveStartTime;
	
	/**
	 * 上个操作人审批开始时间
	 */
	private Date assignUerDate;

	/**
	 * <pre>
	 * 审批结束时间
	 * 表字段 : approve_apply_result.approve_end_time
	 * </pre>
	 */
	private Date approveEndTime;

	/**
	 * <pre>
	 * 审批状态(常量值：Y-已审批，N-未审批，O-审批中，默认值：N)
	 * 表字段 : approve_apply_result.approve_status
	 * </pre>
	 */
	private String approveStatus;

	/**
	 * <pre>
	 * 审批结果(常量值：Y-同意（绑定），N-拒绝（解绑），O-待定（未绑），默认值：O)
	 * 表字段 : approve_apply_result.approve_result
	 * </pre>
	 */
	private String approveResult;

	/**
	 * <pre>
	 * 申请时间
	 * 表字段 : approve_apply_result.apply_time
	 * </pre>
	 */
	private Date applyTime;

	/**
	 * <pre>
	 * 申请流水编号
	 * 表字段 : approve_apply_result.apply_code
	 * </pre>
	 */
	private String applyCode;

	/**
	 * <pre>
	 * Activiti流程编号
	 * 表字段 : approve_apply_result.activiti_code
	 * </pre>
	 */
	private String activitiCode;

	/**
	 * <pre>
	 * 流程编号
	 * 表字段 : approve_apply_result.flow_code
	 * </pre>
	 */
	private String flowCode;

	/**
	 * <pre>
	 * 版本号(默认值：1，同步递增修改)
	 * 表字段 : approve_apply_result.version
	 * </pre>
	 */
	private Long version;

	/**
	 * <pre>
	 * 创建时间
	 * 表字段 : approve_apply_result.create_time
	 * </pre>
	 */
	private Date createTime;

	/**
	 * <pre>
	 * 修改时间
	 * 表字段 : approve_apply_result.update_time
	 * </pre>
	 */
	private Date updateTime;

	/**
	 * <pre>
	 * 逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
	 * 表字段 : approve_apply_result.data_status
	 * </pre>
	 */
	private String dataStatus;

	/**
	 * <pre>
	 * 物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
	 * 表字段 : approve_apply_result.disk_status
	 * </pre>
	 */
	private String diskStatus;
	
	 /**
     * <pre>
     * 申请流水编号
     * 表字段 : app_user_apply_shop.apply_code
     * </pre>
     */
    private String accountName;

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
     * 老板姓名
     * 表字段 : app_user_apply_shop.boss_name
     * </pre>
     */
    private String bossName;

    /**
     * <pre>
     * 老板性别(常量值：Y-男，N-女)
     * 表字段 : app_user_apply_shop.boss_sex
     * </pre>
     */
    private String bossSex;

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
     * 门店地址经度
     * 表字段 : app_user_apply_shop.address_longitude
     * </pre>
     */
    private BigDecimal addressLongitude;

    /**
     * <pre>
     * 门店地址纬度
     * 表字段 : app_user_apply_shop.address_latitude
     * </pre>
     */
    private BigDecimal addressLatitude;

    /**
     * <pre>
     * 门店经营范围
     * 表字段 : app_user_apply_shop.business_scope
     * </pre>
     */
    private String businessScope;

    /**
     * <pre>
     * 身份证号
     * 表字段 : app_user_apply_shop.idcard
     * </pre>
     */
    private String idcard;

    /**
     * <pre>
     * 身份证正反面(存图片保存路径)
     * 表字段 : app_user_apply_shop.idcard_image
     * </pre>
     */
    private String idcardImage;

    /**
     * <pre>
     * 商户营业执照(存图片保存路径)
     * 表字段 : app_user_apply_shop.business_license
     * </pre>
     */
    private String businessLicense;

    /**
     * <pre>
     * 其他证明材料(存图片保存路径)
     * 表字段 : app_user_apply_shop.proof_material
     * </pre>
     */
    private String proofMaterial;
    /**
     * 任务id
     */
    private String id;
    /**
     * 任务名称
     */
    private String name;
    /**
     * 任务办理人
     */
    private String assignee;
    /**
     * 公司名
     */
    private String companyName;

    /**
     * <pre>
     * 用户账户
     * 表字段 : app_user_apply_shop.account
     * </pre>
     */
    private String account;
    
    /**
     * 进件次数
     */
    private Integer intoPieces;
    
    /**
     * 指派人
     */
    private String assignUser;
    
    /**
     * 指派人编号
     */
    private String transactUser;
    
    /**
     * 审批结果
     */
    private String flowNodeStatus;
    
    /**
     * 节点序号（在个人任务中展示节点的序号）
     */
    private int nodeIndex;
    
    /**
     * 备注
     */
    private String flowNodeResult;
    
    
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getAssignUerDate() {
		return assignUerDate;
	}

	public void setAssignUerDate(Date assignUerDate) {
		this.assignUerDate = assignUerDate;
	}

	public String getTransactUser() {
		return transactUser;
	}

	public void setTransactUser(String transactUser) {
		this.transactUser = transactUser;
	}

	public String getFlowNodeResult() {
		return flowNodeResult;
	}

	public void setFlowNodeResult(String flowNodeResult) {
		this.flowNodeResult = flowNodeResult;
	}

	public String getFlowNodeStatus() {
		return flowNodeStatus;
	}

	public void setFlowNodeStatus(String flowNodeStatus) {
		this.flowNodeStatus = flowNodeStatus;
	}

	public int getNodeIndex() {
		return nodeIndex;
	}

	public void setNodeIndex(int nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

	public String getAssignUser() {
		return assignUser;
	}

	public void setAssignUser(String assignUser) {
		this.assignUser = assignUser;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getIntoPieces() {
		return intoPieces;
	}

	public void setIntoPieces(Integer intoPieces) {
		this.intoPieces = intoPieces;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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

	public String getBossName() {
		return bossName;
	}

	public void setBossName(String bossName) {
		this.bossName = bossName;
	}

	public String getBossSex() {
		return bossSex;
	}

	public void setBossSex(String bossSex) {
		this.bossSex = bossSex;
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

	public BigDecimal getAddressLongitude() {
		return addressLongitude;
	}

	public void setAddressLongitude(BigDecimal addressLongitude) {
		this.addressLongitude = addressLongitude;
	}

	public BigDecimal getAddressLatitude() {
		return addressLatitude;
	}

	public void setAddressLatitude(BigDecimal addressLatitude) {
		this.addressLatitude = addressLatitude;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getIdcardImage() {
		return idcardImage;
	}

	public void setIdcardImage(String idcardImage) {
		this.idcardImage = idcardImage;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getProofMaterial() {
		return proofMaterial;
	}

	public void setProofMaterial(String proofMaterial) {
		this.proofMaterial = proofMaterial;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Date getApproveStartTime() {
		return approveStartTime;
	}

	public void setApproveStartTime(Date approveStartTime) {
		this.approveStartTime = approveStartTime;
	}

	public Date getApproveEndTime() {
		return approveEndTime;
	}

	public void setApproveEndTime(Date approveEndTime) {
		this.approveEndTime = approveEndTime;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getApproveResult() {
		return approveResult;
	}

	public void setApproveResult(String approveResult) {
		this.approveResult = approveResult;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public String getActivitiCode() {
		return activitiCode;
	}

	public void setActivitiCode(String activitiCode) {
		this.activitiCode = activitiCode;
	}

	public String getFlowCode() {
		return flowCode;
	}

	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	public String getDiskStatus() {
		return diskStatus;
	}

	public void setDiskStatus(String diskStatus) {
		this.diskStatus = diskStatus;
	}
 
}
