package com.feisuanyz.pojo.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 系统监控信息添加/更新/删除对象
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemMonitoringDTO {

    /**
     * 监控ID:监控ID，必填
     */
    @NotNull(groups = { UpdateGroup.class, DeleteGroup.class }, message = "监控ID不能为空")
    @Schema(description = "监控ID:监控ID，必填")
    private Integer monitorId;

    /**
     * 响应时间:响应时间，必填
     */
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class }, message = "响应时间不能为空")
    @Schema(description = "响应时间:响应时间，必填")
    private Double responseTime;

    /**
     * 内存使用情况:内存使用情况，必填
     */
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class }, message = "内存使用情况不能为空")
    @Schema(description = "内存使用情况:内存使用情况，必填")
    private Double memoryUsage;

    /**
     * CPU使用情况:CPU使用情况，必填
     */
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class }, message = "CPU使用情况不能为空")
    @Schema(description = "CPU使用情况:CPU使用情况，必填")
    private Double cpuUsage;
}
