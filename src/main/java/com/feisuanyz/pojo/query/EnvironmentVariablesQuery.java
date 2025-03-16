package com.feisuanyz.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 项目环境变量查询条件
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class EnvironmentVariablesQuery {

    /**
     * 分页索引，从1开始
     */
    @NotNull(groups = { QueryGroup.class, Default.class }, message = "分页索引不能为空")
    @Schema(description = "分页索引，从1开始")
    private Integer pageIndex;

    /**
     * 每页大小，默认10
     */
    @NotNull(groups = { QueryGroup.class, Default.class }, message = "每页大小不能为空")
    @Schema(description = "每页大小，默认10")
    private Integer pageSize;

    /**
     * 环境类型，如开发、测试、生产
     */
    @NotBlank(groups = { QueryGroup.class, Default.class }, message = "环境类型不能为空")
    @Schema(description = "环境类型，如开发、测试、生产")
    private String environmentType;
}
