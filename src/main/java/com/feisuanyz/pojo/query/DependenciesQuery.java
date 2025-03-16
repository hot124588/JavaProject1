package com.feisuanyz.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 项目依赖库查询条件
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class DependenciesQuery {

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
     * 依赖库状态
     */
    @NotBlank(groups = { QueryGroup.class, Default.class }, message = "依赖库状态不能为空")
    @Schema(description = "依赖库状态")
    private String status;
}
