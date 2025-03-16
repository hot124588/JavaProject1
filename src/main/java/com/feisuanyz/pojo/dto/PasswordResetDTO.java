package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

/**
 * 密码重置请求入参
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
public class PasswordResetDTO {

    @NotNull(groups = { CreateGroup.class, UpdateGroup.class }, message = "用户ID不能为空")
    private Integer userId;

    @Size(max = 100, message = "长度不能超过100")
    private String email;

    @Size(max = 20, message = "长度不能超过20")
    private String phone;

    @NotBlank(groups = { UpdateGroup.class }, message = "重置令牌不能为空")
    @Size(max = 255, groups = { UpdateGroup.class }, message = "长度不能超过255")
    private String resetToken;
}
