/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.shiro;

 
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.guludai.market.domain.dao.ApproveSecurityResourceEntityMapper;
import cn.guludai.market.domain.dao.ApproveSecurityUserMapper;
import cn.guludai.market.domain.entity.ApproveSecurityResourceEntity;
import cn.guludai.market.domain.entity.ApproveSecurityUser;
 
/**
 * Created by yangqj on 2017/4/21.
 */
@Service
public class MyShiroRealm extends AuthorizingRealm {
	
	@Autowired
	private ApproveSecurityUserMapper approveSecurityUserMapper;
	
	@Autowired
	private ApproveSecurityResourceEntityMapper approveSecurityResourceEntityMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    	ApproveSecurityUser user= (ApproveSecurityUser) SecurityUtils.getSubject().getPrincipal();//User{id=1, username='admin', password='3ef7164d1f6167cb9f2658c07d3c2f0a', enable=1}
        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<ApproveSecurityResourceEntity> ls = approveSecurityResourceEntityMapper.getResourceByUserCode(user.getUserCode(), null);
        for(ApproveSecurityResourceEntity resources: ls){
        	if(StringUtils.isNotBlank(resources.getResourcePath())) {
        		 info.addStringPermission(resources.getResourcePath());
        	}
        }
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        ApproveSecurityUser user = approveSecurityUserMapper.selectUserByUserName(username);
        if(user==null) throw new UnknownAccountException();
        
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getSalt()),
                getName()  //realm name
        );
        // 当验证都通过后，把用户信息放在session里
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession", user);
        session.setAttribute("userSessionId", user.getUserCode());
        return authenticationInfo;
    }

    /**
     * 指定principalCollection 清除
     */
  /*  public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {

        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
*/
}
