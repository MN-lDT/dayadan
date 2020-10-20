package com.yadanoa.dayadan.shiroConfig;

import com.yadanoa.dayadan.entity.Permission;
import com.yadanoa.dayadan.entity.Role;
import com.yadanoa.dayadan.entity.User;
import com.yadanoa.dayadan.service.IPermissionService;
import com.yadanoa.dayadan.service.IRoleService;
import com.yadanoa.dayadan.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    IUserService userService;
    @Autowired
    IRoleService roleService;
    @Autowired
    IPermissionService permissionService;

    /***
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // HttpServletRequest request = (HttpServletRequest) ((WebSubject) SecurityUtils
        // .getSubject()).getServletRequest();//这个可以用来获取在登录的时候提交的其他额外的参数信息
        String username = (String) principalCollection.getPrimaryPrincipal();
        // 受理权限
        // 角色
        Set<String> roles = new HashSet<String>();
        Role role = roleService.getRoleInfoByUserName(username);
        System.out.println(role.getRoleName());
        roles.add(role.getRoleName());
        authorizationInfo.setRoles(roles);
        // 权限
        Set<String> permissions = new HashSet<String>();
        List<Permission> querypermissions = permissionService.getPermissionsByRoleId(role.getId());
        for (Permission permission : querypermissions) {
            permissions.add(permission.getPermissionName());
        }
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /***
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String loginName = (String) authenticationToken.getPrincipal();
        // 获取用户密码
        User user = userService.getUser(loginName);
        if (user == null) {
            // 没找到帐号
            throw new UnknownAccountException();
        }
        /*String password = new String((char[]) authenticationToken.getCredentials());
        String inpass = (new Md5Hash(password, user.getUsername(),2)).toString();
        if (!user.getPassword().equals(inpass)) {
            throw new IncorrectCredentialsException();
        }*/
        // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginName, user.getPassword(),
                ByteSource.Util.bytes(loginName), getName());

        return authenticationInfo;

    }
}
