package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 错误日志DTO
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class ErrorLogDTO {

    /**
     * 日志级别
     */
    @NotBlank(groups = { CreateGroup.class }, message = "日志级别不能为空")
    @Schema(description = "日志级别")
    private String logLevel;

    /**
     * 异常信息
     */
    @NotBlank(groups = { CreateGroup.class }, message = "异常信息不能为空")
    @Schema(description = "异常信息")
    private String exceptionMessage;

    /**
     * 模块名称
     */
    @Schema(description = "模块名称")
    private String moduleName;
}
