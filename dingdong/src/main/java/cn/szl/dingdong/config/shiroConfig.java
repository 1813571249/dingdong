package cn.szl.dingdong.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

//这些都是死代码。就和xml配置文件一样   这个configuration就是设置请求的过滤的
@Configuration
public class shiroConfig {


    //第三步：创建ShiroFilterFactoryBean   请求过滤都在这里  权限操作都在Realm中，两个类进行联动，需要通过debug进行观察
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(securityManager);


        //配置shiro的内置过滤器
        /*
            anon:无需认证就可以访问
            authc：必须认证了才可以访问
            user:必须有 记住我  功能才可以使用
            perms：拥有对某个资源的权限才可以访问
            Role：拥有某个角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();

        filterMap.put("/personal.html","authc");   //配置 /add 请求 需要认证了才可以访问，被拦截了会跳转到登陆页面，默认是走/login.jsp请求，只是shiro没有自制的登陆页面，需要自己定制登陆页面。
        filterMap.put("/shop_car.html","authc");
        filterMap.put("/buy.html","authc");
        filterMap.put("/fill_order.html","authc");

        //filterMap.put("/add","perms[user:add]"); //配置 /add 请求 需要有权限才可以访问，失败了默认跳转到未授权页面
        //filterMap.put("/update","perms[user:update]");

        bean.setFilterChainDefinitionMap(filterMap);
        //设置认证失败跳转的页面
        bean.setLoginUrl("/");
        //未授权就访失败问跳转的页面
        //bean.setUnauthorizedUrl("/unauthorized");

        return bean;
    }


    //第二步：创建DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);

        return securityManager;
    }

    //创建realm对象，需要自定类 第一步
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //整合shiroDialect:用来整合thymeleaf和shiro
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
