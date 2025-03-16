package com.feisuanyz.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户权限查询入参
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
public class UserPermissionsQuery {

    /**
     * 用户ID:必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "用户ID不能为空")
    @Schema(description = "用户ID:必填")
    private Integer userId;

    /**
     * 角色:必填
     */
    @NotBlank(groups = { QueryGroup.class }, message = "角色不能为空")
    @Size(max = 50, message = "角色长度不能超过50")
    @Schema(description = "角色:必填")
    private String role;

    /**
     * 权限:必填
     */
    @NotBlank(groups = { QueryGroup.class }, message = "权限不能为空")
    @Size(max = 255, message = "权限长度不能超过255")
    @Schema(description = "权限:必填")
    private String permission;

    /**
     * 分页参数:可选
     */
    @Schema(description = "分页参数:可选")
    private Integer pageIndex;

    private Integer pageSize;
}
