/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.user.request;

import java.util.Date;

import cn.guludai.market.web.request.BaseReq;
/**
 * 
 * @ClassName: ApproveSecurityRoleEntityReq 
 * @Description: 角色传参类
 * @author: xiongshikang
 * @date: 2017年12月13日 下午6:23:10
 */
public class ApproveSecurityRoleEntityReq extends BaseReq {
	
	 /**
	 * @author: xiongshikang
	 * @date: 2017年12月18日 下午2:43:35
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 角色编号
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 排序
     */
    private Integer roleOrder;

    /**
     * 备注
     */
    private String roleDescription;

    /**
     * 版本号 默认值：1，同步递增修改
     */
    private Long version;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 逻辑状态 常量值：Y-逻辑保留，N-逻辑删除，默认值：Y
     */
    private String dataStatus;

    /**
     * 物理状态 常量值：Y-物理保留，N-物理删除，默认值：Y
     */
    private String diskStatus;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleOrder() {
		return roleOrder;
	}

	public void setRoleOrder(Integer roleOrder) {
		this.roleOrder = roleOrder;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
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
