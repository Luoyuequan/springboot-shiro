package com.shiro.springbootshiro.service;

import com.shiro.springbootshiro.entity.UserInfo;

/**
 * @author luoyuequan
 * @time 2019/12/11 12:58
 */
public interface IUserInfoService {
    UserInfo findByUsername(String username);
}
