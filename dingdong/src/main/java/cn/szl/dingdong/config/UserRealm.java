package cn.szl.dingdong.config;

import cn.szl.dingdong.pojo.User;
import cn.szl.dingdong.service.UserServiceImp;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImp userServiceImp;

    //授权   给用户授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //得到SimpleAuthorizationInfo对象用于给用户授权
        //SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前登陆的这个对象 subject可以操作整个shiro里面的各种方法得到各种值
        //Subject subject = SecurityUtils.getSubject();
        //User user = (User) subject.getPrincipal();

        //设置当前用户的权限
        //info.addStringPermission(user.getPerms());

        //千万记得这里是返回info
        return null;
    }



    //认证   点击登陆这个方法就会调用，认证用户名和密码是否正确  这个参数token 可以接受controller封装的用户数据
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //得到controller中封装好的用户登陆数据
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //从数据库中查找用户
        User user = userServiceImp.queryByusername(userToken.getUsername());

        if(user==null){
            return null;   //说明该用户不存在，抛出UnknownAccountException异常给controller
        }




        //还有密码认证是shiro自己做，一点都不用管,把密码传进去即可       第一个参数是传给上面那个方法给这个用户授权
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
