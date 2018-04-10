/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.api.saler.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author gaopeng
 */
public class ApplyShopResponse implements Serializable {

    private static final long serialVersionUID = -7303822844150859888L;

    /**
     * <pre>
     * 申请流水编号
     * 表字段 : app_user_apply_shop.apply_code
     * </pre>
     */
    private String accountName;

    /**
     * <pre>
     * 申请流水编号
     * 表字段 : app_user_apply_shop.apply_code
     * </pre>
     */
    private String applyCode;

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
    private String nodeName;
    private String node_description;
    
    

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
     * <pre>
     * 用户账户
     * 表字段 : app_user_apply_shop.account
     * </pre>
     */
    private String account;

    /**
     * <pre>
     * 审批状态(常量值：Y-已审批，N-未审批，O-审批中，默认值：N)
     * 表字段 : app_user_apply_shop.approve_status
     * </pre>
     */
    private String approveStatus;

    /**
     * <pre>
     * 审批结果(常量值：Y-同意（绑定），N-拒绝（解绑），O-待定（未绑），默认值：O)
     * 表字段 : app_user_apply_shop.approve_result
     * </pre>
     */
    private String approveResult;
    private String flowCode;
    /**
     * <pre>
     * 版本号(默认值：1，同步递增修改)
     * 表字段 : app_user_apply_shop.version
     * </pre>
     */
    private String version;

    /**
     * <pre>
     * 创建时间
     * 表字段 : app_user_apply_shop.create_time
     * </pre>
     */
    private Date createTime;

    /**
     * <pre>
     * 修改时间
     * 表字段 : app_user_apply_shop.update_time
     * </pre>
     */
    private Date updateTime;

    /**
     * <pre>
     * 逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
     * 表字段 : app_user_apply_shop.data_status
     * </pre>
     */
    private String dataStatus;

    /**
     * <pre>
     * 物理状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
     * 表字段 : app_user_apply_shop.disk_status
     * </pre>
     */
    private String diskStatus;

	/*以下为扩展字段
	* Author:lei.zhang
	* UpdateTime:2017年11月6日14:46:51
	*
	**/
   
    /**
     * <pre>
     * 省份名称
     * 表字段 : app_user_apply_shop.province_no
     * </pre>
     */
    private String provinceName;

    /**
     * <pre>
     * 城市名称
     * 表字段 : app_user_apply_shop.city_no
     * </pre>
     */
    private String cityName;
    
    public String getFlowCode() {
		return flowCode;
	}

	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode;
	}

	/**
     * <pre>
     * 镇区名称
     * 表字段 : app_user_apply_shop.town_no
     * </pre>
     */
    private String townName;
    private String flowNodeResult;
    
    public String getFlowNodeResult() {
		return flowNodeResult;
	}

	public void setFlowNodeResult(String flowNodeResult) {
		this.flowNodeResult = flowNodeResult;
	}

	public String getApplyCode() {
        return applyCode;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
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

    

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    public String getNodeName() {
  		return nodeName;
  	}

  	public void setNodeName(String nodeName) {
  		this.nodeName = nodeName;
  	}

  	public String getNode_description() {
  		return node_description;
  	}

  	public void setNode_description(String node_description) {
  		this.node_description = node_description;
  	}
}
