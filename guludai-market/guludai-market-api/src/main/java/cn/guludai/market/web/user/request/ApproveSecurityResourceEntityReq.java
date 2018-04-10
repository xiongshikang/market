/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.user.request;

import java.util.Date;

import cn.guludai.market.web.request.BaseReq;

/**
 * .
 * @ClassName: ApproveSecurityResourceEntity 
 * @Description: 资源实体参数类
 * @author: xiongshikang
 * @date: 2017年12月12日 下午3:11:03
 */
public class ApproveSecurityResourceEntityReq {
     
	/**
     * 资源编号
     */
    private String resourceCode;

    /**
     * 父资源编号
     */
    private String resourceParentCode;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 资源地址
     */
    private String resourcePath;

    /**
     * 排序字段
     */
    private Integer resourceOrder;

    /**
     * 类型(常量值：0-功能，1-菜单，默认为：0)
     */
    private Integer resourceType;

    /**
     * 资源符号
     */
    private String resourceItem;

    /**
     * 跳转地址
     */
    private String resourceHref;

    /**
     * 显示图标
     */
    private String resourceIcon;

    /**
     * 备注
     */
    private String resourceDescription;

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
     * 获取资源编号
     *
     * @return resource_code - 资源编号
     */
    public String getResourceCode() {
        return resourceCode;
    }

    /**
     * 设置资源编号
     *
     * @param resourceCode 资源编号
     */
    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    /**
     * 获取父资源编号
     *
     * @return resource_parent_code - 父资源编号
     */
    public String getResourceParentCode() {
        return resourceParentCode;
    }

    /**
     * 设置父资源编号
     *
     * @param resourceParentCode 父资源编号
     */
    public void setResourceParentCode(String resourceParentCode) {
        this.resourceParentCode = resourceParentCode;
    }

    /**
     * 获取资源名称
     *
     * @return resource_name - 资源名称
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 设置资源名称
     *
     * @param resourceName 资源名称
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * 获取资源地址
     *
     * @return resource_path - 资源地址
     */
    public String getResourcePath() {
        return resourcePath;
    }

    /**
     * 设置资源地址
     *
     * @param resourcePath 资源地址
     */
    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    /**
     * 获取排序字段
     *
     * @return resource_order - 排序字段
     */
    public Integer getResourceOrder() {
        return resourceOrder;
    }

    /**
     * 设置排序字段
     *
     * @param resourceOrder 排序字段
     */
    public void setResourceOrder(Integer resourceOrder) {
        this.resourceOrder = resourceOrder;
    }

    /**
     * 获取类型(常量值：0-功能，1-菜单，默认为：0)
     *
     * @return resource_type - 类型(常量值：0-功能，1-菜单，默认为：0)
     */
    public Integer getResourceType() {
        return resourceType;
    }

    /**
     * 设置类型(常量值：0-功能，1-菜单，默认为：0)
     *
     * @param resourceType 类型(常量值：0-功能，1-菜单，默认为：0)
     */
    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * 获取资源符号
     *
     * @return resource_item - 资源符号
     */
    public String getResourceItem() {
        return resourceItem;
    }

    /**
     * 设置资源符号
     *
     * @param resourceItem 资源符号
     */
    public void setResourceItem(String resourceItem) {
        this.resourceItem = resourceItem;
    }

    /**
     * 获取跳转地址
     *
     * @return resource_href - 跳转地址
     */
    public String getResourceHref() {
        return resourceHref;
    }

    /**
     * 设置跳转地址
     *
     * @param resourceHref 跳转地址
     */
    public void setResourceHref(String resourceHref) {
        this.resourceHref = resourceHref;
    }

    /**
     * 获取显示图标
     *
     * @return resource_icon - 显示图标
     */
    public String getResourceIcon() {
        return resourceIcon;
    }

    /**
     * 设置显示图标
     *
     * @param resourceIcon 显示图标
     */
    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
    }

    /**
     * 获取备注
     *
     * @return resource_description - 备注
     */
    public String getResourceDescription() {
        return resourceDescription;
    }

    /**
     * 设置备注
     *
     * @param resourceDescription 备注
     */
    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
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