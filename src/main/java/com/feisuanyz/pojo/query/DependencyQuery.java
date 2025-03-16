package com.feisuanyz.pojo.query;

import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 查询依赖库的入参
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@NoArgsConstructor
public class DependencyQuery {

    /**
     * 依赖库id:必填
     */
    @Schema(description = "依赖库id:必填")
    private Integer dependencyId;

    /**
     * 环境类型:非必填
     */
    @Schema(description = "环境类型:非必填")
    private String environmentType;

    /**
     * 页码:非必填，默认1
     */
    @Schema(description = "页码:非必填，默认1")
    private Integer pageIndex = 1;

    /**
     * 每页条数:非必填，默认10
     */
    @Schema(description = "每页条数:非必填，默认10")
    private Integer pageSize = 10;
}
