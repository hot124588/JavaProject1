package com.feisuanyz.service;

import com.feisuanyz.pojo.dto.UserPermissionsDTO;
import com.feisuanyz.pojo.query.UserPermissionsQuery;
import java.lang.Boolean;

/**
 * 用户权限管理
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
public interface UserpermissionsService {

    /**
     * assign
     *
     * @param userPermissionsDTO 用户权限分配入参
     * @return
     */
    Boolean assignRolePermissions(UserPermissionsDTO userPermissionsDTO);

    /**
     * remove
     *
     * @param userPermissionsDTO 用户权限分配入参
     * @return
     */
    Boolean removeRolePermissions(UserPermissionsDTO userPermissionsDTO);

    /**
     * validate
     *
     * @param userPermissionsQuery 用户权限查询入参
     * @return
     */
    Boolean validateUserPermissions(UserPermissionsQuery userPermissionsQuery);
}
