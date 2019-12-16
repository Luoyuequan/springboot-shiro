package com.shiro.springbootshiro.dao;

import com.shiro.springbootshiro.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author luoyuequan
 * @time 2019/12/11 13:27
 */
@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
    /**
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);
}
