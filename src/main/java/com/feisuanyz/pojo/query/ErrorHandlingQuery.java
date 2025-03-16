package com.feisuanyz.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 系统错误日志查询对象
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
public class ErrorHandlingQuery {

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Integer userId;

    /**
     * 错误代码
     */
    @Size(max = 50, message = "* 错误代码长度不能超过50")
    @Schema(description = "错误代码")
    private String errorCode;

    /**
     * 页码
     */
    @Schema(description = "页码")
    private Integer pageIndex;

    /**
     * 每页大小
     */
    @Schema(description = "每页大小")
    private Integer pageSize;
}
