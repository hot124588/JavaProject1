package com.feisuanyz.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 获取系统监控信息查询对象
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
public class SystemMonitoringQuery {

    /**
     * 监控ID:监控ID，选填
     */
    @Schema(description = "监控ID:监控ID，选填")
    private Integer monitorId;

    /**
     * 页码:页码，必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "页码不能为空")
    @Schema(description = "页码:页码，必填")
    private Integer pageIndex;

    /**
     * 每页数量:每页数量，必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "每页数量不能为空")
    @Schema(description = "每页数量:每页数量，必填")
    private Integer pageSize;
}
