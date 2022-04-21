//package com.example.studentsystem.realm;
//
//import com.example.studentsystem.entity.Role;
//import com.example.studentsystem.entity.UserLogin;
//import com.example.studentsystem.service.RoleService;
//import com.example.studentsystem.service.UserLoginService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class LoginRealm extends AuthorizingRealm{
//
//    @Resource(name = "userloginServiceImpl")
//    private UserLoginService userloginService;
//
//    @Resource(name = "roleServiceImpl")
//    private RoleService roleService;
//
//
//    //get the identity information from the database.
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//
//        String username = (String) getAvailablePrincipal(principalCollection);
//
//        Role role = null;
//
//        try {
//            UserLogin userlogin = userloginService.findByUserName(username);
//            role = roleService.findByid(userlogin.getRole());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //get information from database using username
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        Set<String> r = new HashSet<String>();
//        if (role != null) {
//            r.add(role.getRolename());
//            info.setRoles(r);
//        }
//
//        return info;
//    }
//
//    //for login. identity identification
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        //username
//        String username = (String) token.getPrincipal();
//        //password
//        String password = new String((char[])token.getCredentials());
//
//        UserLogin userlogin = null;
//        try {
//            userlogin = userloginService.findByUserName(username);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (userlogin == null) {
//            //username not existed
//            throw new UnknownAccountException();
//        } else if (!password.equals(userlogin.getPassword())) {
//            //wrong password
//            throw new IncorrectCredentialsException();
//        }
//
//        //if the identification is available
//        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username,password,getName());
//
//        return aInfo;
//    }
//}
