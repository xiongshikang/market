/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import cn.guludai.market.domain.entity.ApproveSecurityUserLoginLogEntity;

public interface ApproveSecurityUserLoginLogEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ApproveSecurityUserLoginLogEntity record);

    int insertSelective(ApproveSecurityUserLoginLogEntity record);

    ApproveSecurityUserLoginLogEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApproveSecurityUserLoginLogEntity record);

    int updateByPrimaryKey(ApproveSecurityUserLoginLogEntity record);
}