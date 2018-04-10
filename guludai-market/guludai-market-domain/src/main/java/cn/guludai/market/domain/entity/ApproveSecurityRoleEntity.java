/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.entity;

import java.util.Date;
/**
 * 
 * @ClassName: ApproveSecurityRoleEntity 
 * @Description: 角色实体
 * @author: xiongshikang
 * @date: 2017年12月12日 下午3:11:19
 */
public class ApproveSecurityRoleEntity {
    /**
     * 自增id
     */
    private Long id;

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

    /**
     * 获取自增id
     *
     * @return id - 自增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取角色编号
     *
     * @return role_code - 角色编号
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 设置角色编号
     *
     * @param roleCode 角色编号
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取排序
     *
     * @return role_order - 排序
     */
    public Integer getRoleOrder() {
        return roleOrder;
    }

    /**
     * 设置排序
     *
     * @param roleOrder 排序
     */
    public void setRoleOrder(Integer roleOrder) {
        this.roleOrder = roleOrder;
    }

    /**
     * 获取备注
     *
     * @return role_description - 备注
     */
    public String getRoleDescription() {
        return roleDescription;
    }

    /**
     * 设置备注
     *
     * @param roleDescription 备注
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    /**
     * 获取版本号 默认值：1，同步递增修改
     *
     * @return version - 版本号 默认值：1，同步递增修改
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 设置版本号 默认值：1，同步递增修改
     *
     * @param version 版本号 默认值：1，同步递增修改
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取逻辑状态 常量值：Y-逻辑保留，N-逻辑删除，默认值：Y
     *
     * @return data_status - 逻辑状态 常量值：Y-逻辑保留，N-逻辑删除，默认值：Y
     */
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * 设置逻辑状态 常量值：Y-逻辑保留，N-逻辑删除，默认值：Y
     *
     * @param dataStatus 逻辑状态 常量值：Y-逻辑保留，N-逻辑删除，默认值：Y
     */
    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * 获取物理状态 常量值：Y-物理保留，N-物理删除，默认值：Y
     *
     * @return disk_status - 物理状态 常量值：Y-物理保留，N-物理删除，默认值：Y
     */
    public String getDiskStatus() {
        return diskStatus;
    }

    /**
     * 设置物理状态 常量值：Y-物理保留，N-物理删除，默认值：Y
     *
     * @param diskStatus 物理状态 常量值：Y-物理保留，N-物理删除，默认值：Y
     */
    public void setDiskStatus(String diskStatus) {
        this.diskStatus = diskStatus;
    }
}