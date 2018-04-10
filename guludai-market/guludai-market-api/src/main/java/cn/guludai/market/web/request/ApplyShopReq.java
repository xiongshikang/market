/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.request;

import java.io.Serializable;

/**
* Author: lei.zhang
* Description: 销售门店信息
* Date: 2017/11/3 15:13
*/
public class ApplyShopReq extends BaseReq implements Serializable  {

    private static final long serialVersionUID = 574356225504459524L;

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
     * 审核结果
     * </pre>
     */
    private String approveResult;
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

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }


}
