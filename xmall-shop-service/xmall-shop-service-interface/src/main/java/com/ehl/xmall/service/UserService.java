package com.ehl.xmall.service;

import com.ehl.xmall.bean.TbUser;

import java.util.List;
import java.util.Set;

/**
 * @interfaceName:UserService
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/28 15:51
 */
public interface UserService {

    TbUser getUserByUsername(String username);

    Set<String> getRoles(String username);
    Set<String> getPermissions(String username);
}
