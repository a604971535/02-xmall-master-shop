package com.ehl.xmall.service.impl;

import com.ehl.common.exception.XmallException;
import com.ehl.xmall.bean.TbPermission;
import com.ehl.xmall.bean.TbRole;
import com.ehl.xmall.bean.TbUser;
import com.ehl.xmall.bean.TbUserExample;
import com.ehl.xmall.mapper.TbUserMapper;
import com.ehl.xmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * @className:UserServiceImpl
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/28 15:53
 */
public class UserServiceImpl implements UserService {

    @Autowired
    TbUserMapper userMapper;

    @Override
    public TbUser getUserByUsername(String username) {

        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andStateEqualTo(1);
        List<TbUser> userList=null;
        try {
            userList = userMapper.selectByExample(example);
        }catch (Exception e)
        {
            throw  new XmallException("通过用户名获取用户信息失败");
        }
        if(!userList.isEmpty())
        {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public Set<String> getRoles(String username) {

        Set<String> rolelist = userMapper.getRoles(username);
        if (rolelist.isEmpty())
        {
            throw new XmallException("根据名字获取角色信息异常");
        }
        return rolelist;
    }

    @Override
    public Set<String> getPermissions(String username) {
        Set<String> permissions = userMapper.getPermissions(username);
        if (permissions.isEmpty())
        {
            throw  new XmallException("根据名字获取Permission信息异常");
        }
        return permissions;
    }
}
