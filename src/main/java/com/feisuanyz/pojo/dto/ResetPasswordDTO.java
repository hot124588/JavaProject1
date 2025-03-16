package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

/**
 * 重置密码入参
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
public class ResetPasswordDTO {

    @NotBlank(groups = { UpdateGroup.class }, message = "重置令牌不能为空")
    private String resetToken;

    @NotBlank(groups = { UpdateGroup.class }, message = "新密码不能为空")
    private String newPassword;
}
