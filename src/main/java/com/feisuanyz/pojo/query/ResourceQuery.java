package com.feisuanyz.pojo.query;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 资源查询入参实体类
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class ResourceQuery {

    /**
     * 资源名称:资源名称，非必填
     */
    @Schema(description = "资源名称:资源名称，非必填")
    private String resourceName;

    /**
     * 资源类型:资源类型，非必填
     */
    @Schema(description = "资源类型:资源类型，非必填")
    private String resourceType;

    /**
     * 资源分配状态:资源分配状态，非必填
     */
    @Schema(description = "资源分配状态:资源分配状态，非必填")
    private String allocationStatus;

    /**
     * 分页索引:分页索引，必填
     */
    @Schema(description = "分页索引:分页索引，必填")
    private long pageIndex;

    /**
     * 每页大小:每页大小，必填
     */
    @Schema(description = "每页大小:每页大小，必填")
    private long pageSize;
}
