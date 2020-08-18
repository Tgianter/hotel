package com.example.hotel.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShirConfig{

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean factoryBean=new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager());

        factoryBean.setLoginUrl("/view/login");
        factoryBean.setSuccessUrl("/view/index");
        factoryBean.setUnauthorizedUrl("/view/unAuthor");

        Map<String,String> filterChainMap=new HashMap<>();
        filterChainMap.put("/home/**","anon");
        filterChainMap.put("/manage/**","roles[root]");
        filterChainMap.put("/check/**","perms[check]");
        filterChainMap.put("/client/**","perms[client]");
        filterChainMap.put("/employee/**","perms[employee]");
        filterChainMap.put("/room/**","perms[room]");

        filterChainMap.put("/**","anon");
        factoryBean.setFilterChainDefinitionMap(filterChainMap);
        return factoryBean;

    }
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher=new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(2);
        return matcher;
    }
    @Bean
    public ShirRealm shirRealm(){
        ShirRealm shirRealm=new ShirRealm();
        shirRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return shirRealm;
    }
    @Bean
    public DefaultSecurityManager securityManager(){
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(shirRealm());
        return manager;
    }

}
