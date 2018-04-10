/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.api.saler.request;

import java.io.Serializable;
import java.util.Date;

/**
* Author: lei.zhang
* Description: 销售门店信息
* Date: 2017/11/3 15:13
*/
public class ApplyShopRequest implements Serializable {

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
     * 申请时间
     */
    private Date createTime;
    /**
     * 申请状态
     */
    private String approvelStatus;
    /**
     * 申请结果
     */
    private String approvelResult;
    
    private int pageSize;
    private int pageNum;
    
    public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getApprovelStatus() {
		return approvelStatus;
	}

	public void setApprovelStatus(String approvelStatus) {
		this.approvelStatus = approvelStatus;
	}

	public String getApprovelResult() {
		return approvelResult;
	}

	public void setApprovelResult(String approvelResult) {
		this.approvelResult = approvelResult;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

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

   



    public String getApplyCode() {
        return applyCode;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }
}
