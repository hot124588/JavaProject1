package com.feisuanyz.pojo.dto;

import javax.validation.constraints.Pattern;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

/**
 * 用户数据传输对象
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
public class UserDTO {

    /**
     * 用户ID:用户唯一标识
     */
    @NotNull(groups = { UpdateGroup.class, DeleteGroup.class }, message = "用户ID不能为空")
    @Schema(description = "用户ID:用户唯一标识")
    private Integer userId;

    /**
     * 用户名:用户名，必填
     */
    @NotBlank(groups = { CreateGroup.class, UpdateGroup.class }, message = "用户名不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9_]{3,50}$", groups = { CreateGroup.class, UpdateGroup.class }, message = "用户名格式错误")
    @Schema(description = "用户名:用户名，必填")
    private String username;

    /**
     * 新用户名:新用户名，必填
     */
    @NotNull(groups = UpdateGroup.class, message = "新用户名不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9_]{3,50}$", groups = UpdateGroup.class, message = "新用户名格式错误")
    @Schema(description = "新用户名:新用户名，必填")
    private String newUsername;

    // 密码:密码，必填
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class }, message = "密码不能为空")
    @Schema(description = "密码:密码，必填")
    private String password;

    // 新密码:新密码，必填
    @NotNull(groups = UpdateGroup.class, message = "新密码不能为空")
    @Schema(description = "新密码:新密码，必填")
    private String newPassword;

    // 邮箱:邮箱，必填
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class }, message = "邮箱不能为空")
    @Email(groups = { CreateGroup.class, UpdateGroup.class }, message = "邮箱格式错误")
    @Schema(description = "邮箱:邮箱，必填")
    private String email;

    // 新邮箱:新邮箱，必填
    @NotNull(groups = UpdateGroup.class, message = "新邮箱不能为空")
    @Email(groups = UpdateGroup.class, message = "新邮箱格式错误")
    @Schema(description = "新邮箱:新邮箱，必填")
    private String newEmail;

    /**
     * 旧密码:旧密码，必填
     */
    @NotBlank(groups = { UpdateGroup.class }, message = "旧密码不能为空")
    @Size(max = 255, message = "旧密码长度不能超过255")
    @Schema(description = "旧密码:旧密码，必填")
    private String oldPassword;

    /**
     * 密码哈希:密码哈希，必填
     */
    @NotBlank(groups = { CreateGroup.class }, message = "密码哈希不能为空")
    @Size(max = 255, message = "密码哈希长度不能超过255")
    @Schema(description = "密码哈希:密码哈希，必填")
    private String passwordHash;
}
