package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 系统错误日志入参对象
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
public class ErrorHandlingDTO {

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Integer userId;

    /**
     * 错误代码
     */
    @NotBlank(groups = { CreateGroup.class }, message = "错误代码不能为空")
    @Size(max = 50, groups = { CreateGroup.class }, message = "* 错误代码长度不能超过50")
    @Schema(description = "错误代码")
    private String errorCode;

    /**
     * 错误信息
     */
    @NotBlank(groups = { CreateGroup.class }, message = "错误信息不能为空")
    @Schema(description = "错误信息")
    private String errorMessage;
}
