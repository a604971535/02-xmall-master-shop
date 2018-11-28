package com.ehl.manager.shiro;

import com.ehl.xmall.bean.TbShiroFilter;
import com.ehl.xmall.service.SystemService;
import org.apache.log4j.Logger;
import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @className:MyShiroFilterFactoryBean
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/28 11:28
 */
public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {

    private static final Logger logger = Logger.getLogger(MyShiroFilterFactoryBean.class);


    //配置中的过滤链
    private static String definitions;

    @Autowired
    SystemService systemService;
    /**
     * create by: 王明飞 102365
     * description:从数据库动态获取过滤器链
     * create time:2018/11/28 12:09 
     * @param 
     * @return 
     */
    @Override
    public void setFilterChainDefinitions(String definitions) {

        logger.info("从数据库获取前的definitions值："+definitions);
        MyShiroFilterFactoryBean.definitions=definitions;

        List<TbShiroFilter> shiroFilterList = systemService.getShiroFilter();

        for(TbShiroFilter shiroFilter:shiroFilterList)
        {
            definitions=definitions+shiroFilter.getName()+" = "+shiroFilter.getPerms()+"\n";
        }
        logger.info("从数据库获取后的definitions值："+definitions);
        Ini ini = new Ini();
        ini.load(definitions);
        Ini.Section section = ini.getSection("urls");
        if (CollectionUtils.isEmpty(section)) {
            section = ini.getSection("");
        }

        this.setFilterChainDefinitionMap(section);
    }

}
