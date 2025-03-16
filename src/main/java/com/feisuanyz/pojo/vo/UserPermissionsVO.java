package com.feisuanyz.pojo.vo;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户权限视图对象
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPermissionsVO {

    /**
     * 用户ID:可选
     */
    @Schema(description = "用户ID:可选")
    private Integer userId;

    /**
     * 角色:可选
     */
    @Schema(description = "角色:可选")
    private String role;

    /**
     * 权限列表:可选
     */
    @Schema(description = "权限列表:可选")
    private String permissions;
}
