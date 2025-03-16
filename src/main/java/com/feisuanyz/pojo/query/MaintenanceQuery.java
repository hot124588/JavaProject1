package com.feisuanyz.pojo.query;

import javax.validation.constraints.NotEmpty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.groups.Default;

/**
 * 维护信息查询条件
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class MaintenanceQuery {

    // 维护操作类型:维护操作类型，如升级、回滚、备份
    @NotEmpty(groups = QueryGroup.class, message = "维护操作类型不能为空")
    @Schema(description = "维护操作类型:维护操作类型，如升级、回滚、备份")
    private String actionType;

    // 开始时间:维护操作开始时间
    @NotNull(groups = QueryGroup.class, message = "开始时间不能为空")
    @Schema(description = "开始时间:维护操作开始时间")
    private Date startTime;

    // 结束时间:维护操作结束时间
    @NotNull(groups = QueryGroup.class, message = "结束时间不能为空")
    @Schema(description = "结束时间:维护操作结束时间")
    private Date endTime;

    /**
     * 维护唯一标识:维护唯一标识，必填
     */
    @NotBlank(groups = { QueryGroup.class }, message = "维护唯一标识不能为空")
    @Schema(description = "维护唯一标识:维护唯一标识，必填")
    private String maintenanceId;

    /**
     * 分页索引:分页索引，必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "分页索引不能为空")
    @Schema(description = "分页索引:分页索引，必填")
    private Integer pageIndex;

    /**
     * 分页大小:分页大小，必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "分页大小不能为空")
    @Schema(description = "分页大小:分页大小，必填")
    private Integer pageSize;

    /**
     * 维护操作状态
     */
    @NotBlank(groups = { QueryGroup.class, Default.class }, message = "维护操作状态不能为空")
    @Schema(description = "维护操作状态")
    private String status;
}
