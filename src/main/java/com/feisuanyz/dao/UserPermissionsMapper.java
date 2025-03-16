package com.feisuanyz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.feisuanyz.pojo.domain.UserPermissionsDO;

/**
 * UserPermissionsMapper
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
public interface UserPermissionsMapper extends BaseMapper<UserPermissionsDO> {

    /**
     * 根据用户ID和角色查询用户权限
     *
     * @Param userId 用户ID
     * @Param role 角色
     * @Return 用户权限数据对象
     */
    UserPermissionsDO selectByUserIdAndRole(@Param("userId") Integer userId, @Param("role") String role);
}
