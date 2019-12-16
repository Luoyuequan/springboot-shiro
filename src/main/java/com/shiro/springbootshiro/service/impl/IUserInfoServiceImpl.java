package com.shiro.springbootshiro.service.impl;

import com.shiro.springbootshiro.dao.UserInfoDao;
import com.shiro.springbootshiro.entity.UserInfo;
import com.shiro.springbootshiro.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author luoyuequan
 * @time 2019/12/11 12:59
 */
@Service
public class IUserInfoServiceImpl implements IUserInfoService {
    private final
    UserInfoDao userInfoDao;

    public IUserInfoServiceImpl(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }
}
