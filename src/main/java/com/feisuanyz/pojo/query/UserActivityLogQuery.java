package com.feisuanyz.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户活动日志查询对象
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
public class UserActivityLogQuery {

    /**
     * 用户ID
     */
    @NotNull(groups = { QueryGroup.class }, message = "用户ID不能为空")
    @Schema(description = "用户ID")
    private Integer userId;

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
