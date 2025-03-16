package com.feisuanyz.service.impl;

import com.feisuanyz.dao.UserPermissionsMapper;
import com.feisuanyz.pojo.dto.UserPermissionsDTO;
import com.feisuanyz.pojo.query.UserPermissionsQuery;
import com.feisuanyz.service.UserpermissionsService;
import java.lang.Boolean;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.feisuanyz.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import com.feisuanyz.constant.ResultCodeConstant;
import com.feisuanyz.pojo.domain.UserPermissionsDO;
import java.util.Date;

/**
 * 用户权限管理的实现
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Service
public class UserpermissionsServiceImpl implements UserpermissionsService {

    @Autowired
    private UserPermissionsMapper userPermissionsMapper;

    @Override
    public Boolean assignRolePermissions(UserPermissionsDTO userPermissionsDTO) {
        UserPermissionsDO userPermissionsDO = new UserPermissionsDO();
        userPermissionsDO.setUserId(userPermissionsDTO.getUserId());
        userPermissionsDO.setRole(userPermissionsDTO.getRole());
        userPermissionsDO.setPermissions(userPermissionsDTO.getPermissions());
        // 这里假设创建人id为1，实际应用中可能需要从上下文中获取
        userPermissionsDO.setCreateBy(1);
        userPermissionsDO.setCreateTime(new Date());
        int result = userPermissionsMapper.insert(userPermissionsDO);
        return result > 0;
    }

    @Override
    public Boolean removeRolePermissions(UserPermissionsDTO userPermissionsDTO) {
        QueryWrapper<UserPermissionsDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("user_id", userPermissionsDTO.getUserId()).eq("role", userPermissionsDTO.getRole());
        int result = userPermissionsMapper.delete(queryWrapper);
        return result > 0;
    }

    @Override
    public Boolean validateUserPermissions(UserPermissionsQuery userPermissionsQuery) {
        QueryWrapper<UserPermissionsDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("user_id", userPermissionsQuery.getUserId()).eq("role", userPermissionsQuery.getRole());
        UserPermissionsDO userPermissionsDO = userPermissionsMapper.selectOne(queryWrapper);
        if (userPermissionsDO != null && userPermissionsDO.getPermissions().contains(userPermissionsQuery.getPermission())) {
            return true;
        } else {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
    }
}
