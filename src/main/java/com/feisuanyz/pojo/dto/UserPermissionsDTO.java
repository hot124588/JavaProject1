package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户权限分配入参
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
public class UserPermissionsDTO {

    /**
     * 用户ID:必填
     */
    @NotNull(groups = { CreateGroup.class, DeleteGroup.class }, message = "用户ID不能为空")
    @Schema(description = "用户ID:必填")
    private Integer userId;

    /**
     * 角色:必填
     */
    @NotBlank(groups = { CreateGroup.class, DeleteGroup.class }, message = "角色不能为空")
    @Size(max = 50, message = "角色长度不能超过50")
    @Schema(description = "角色:必填")
    private String role;

    /**
     * 权限列表:可选
     */
    @Size(max = 255, message = "权限列表长度不能超过255")
    @Schema(description = "权限列表:可选")
    private String permissions;
}
