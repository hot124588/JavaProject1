package com.feisuanyz.pojo.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户登录数据传输对象
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
public class UserLoginDTO {

    /**
     * 用户名或邮箱:用户名或邮箱，必填
     */
    @NotBlank(message = "用户名或邮箱不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9_]{3,50}$|^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "用户名或邮箱格式错误")
    @Schema(description = "用户名或邮箱:用户名或邮箱，必填")
    private String usernameOrEmail;

    /**
     * 密码:密码，必填
     */
    @NotBlank(message = "密码不能为空")
    @Schema(description = "密码:密码，必填")
    private String password;
}
