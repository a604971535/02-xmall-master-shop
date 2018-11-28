package com.ehl.manager.shiro;

import com.ehl.xmall.bean.TbUser;
import com.ehl.xmall.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * @className:MyRealm
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/28 11:23
 */
public class MyRealm extends AuthorizingRealm {
    private static final Logger logger = Logger.getLogger(MyRealm.class);


    @Autowired
    UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();

        Set<String> roles = userService.getRoles(username);
        Set<String> permissions = userService.getPermissions(username);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获取用户名
        String username = authenticationToken.getPrincipal().toString();

        //获取TbUser
        TbUser tbUser = userService.getUserByUsername(username);

        if(tbUser!=null)
        {
            //得到用户账号和密码存放到authenticationInfo中用于Controller层的权限判断 第三个参数随意不能为null
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(tbUser.getUsername(),tbUser.getPassword(),tbUser.getUsername());

            return authenticationInfo;
        }

        return null;
    }
}
