/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.api.saler.response;
/**
 * 
 * @ClassName: BaseShopResp 
 * @Description: 门店信息
 * @author: xiongshikang
 * @date: 2018年1月8日 上午10:45:44
 */
public class BaseShopResp {
	
	 //门店编号
    private String shopCode;
    //门店名称
    private String shopName;
    //经度
    private String shopLongitude;
    //纬度
    private String shopLatitude;
    //省份编号
    private String provinceNo ;
    //城市编号
    private String cityNo ;
    //地区编号
    private String townNo;
    //公司id
    private String companyCode;
    //联系人
    private String contacts;
    //联系电话
    private String phone;
    //商铺地址
    private String shopAddress;
    //创建时间
    private String createTime;
    //更新时间
    private String updateTime ;
    //版本号(默认值：1，同步递增修改)
    private String version ;
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopLongitude() {
		return shopLongitude;
	}
	public void setShopLongitude(String shopLongitude) {
		this.shopLongitude = shopLongitude;
	}
	public String getShopLatitude() {
		return shopLatitude;
	}
	public void setShopLatitude(String shopLatitude) {
		this.shopLatitude = shopLatitude;
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
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
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
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
 
}
