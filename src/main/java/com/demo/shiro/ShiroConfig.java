package com.demo.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Gangamtou
 * @date 2020/1/5 21:14
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        /**
         *设置安全管理器
         */
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /**
         * 添加Shiro内置过滤器
         *  常用过滤器：
         *      anon:无需认证
         *      authc:需要认证
         *      user:使用rememberMe的功能可以直接访问
         *      perms:资源权限
         *      role:角色权限
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        /*filterMap.put("/User/*", "authc");*/
        filterMap.put("/User/toLogin", "anon");
        /*filterMap.put("/User/*","perms[]");*/
        //跳转的页面
        /*shiroFilterFactoryBean.setUnauthorizedUrl("/adminLogin");*/
        shiroFilterFactoryBean.setLoginUrl("/User/toLogin");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        /**
         * 关联Realm
         */
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }

    /**
     * 配置ShiroDialect，用于thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
