package com.feisuanyz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feisuanyz.pojo.domain.UserDO;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * UserMapper
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
public interface UserMapper extends BaseMapper<UserDO> {

    /**
     * 查询用户信息:根据用户ID查询用户信息
     *
     * @Param id 用户ID
     * @Return UserDO 用户信息实体
     */
    UserDO selectById(@Param("id") Integer id);

    /**
     * 插入用户信息:插入新用户信息
     *
     * @Param userDO 用户信息实体
     * @Return int 插入结果
     */
    int insert(UserDO userDO);

    /**
     * 更新用户信息:根据用户ID更新用户信息
     *
     * @Param userDO 用户信息实体
     * @Return int 更新结果
     */
    int updateById(UserDO userDO);

    /**
     * 删除用户信息:根据用户ID删除用户信息
     *
     * @Param id 用户ID
     * @Return int 删除结果
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据条件查询用户信息:根据条件查询用户信息，用于校验用户名和邮箱是否已存在
     *
     * @Param wrapper 查询条件封装
     * @Return UserDO 用户信息实体
     */
    UserDO selectOne(@Param("ew") QueryWrapper<UserDO> wrapper);
}
