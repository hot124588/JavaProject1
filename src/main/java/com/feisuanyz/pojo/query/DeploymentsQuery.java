package com.feisuanyz.pojo.query;

import javax.validation.constraints.NotEmpty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import jakarta.validation.constraints.NotBlank;

/**
 * 部署信息查询条件
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class DeploymentsQuery {

    // 服务器环境:服务器环境
    @NotEmpty(groups = QueryGroup.class, message = "服务器环境不能为空")
    @Schema(description = "服务器环境:服务器环境")
    private String serverEnvironment;

    // 开始时间:部署开始时间
    @NotNull(groups = QueryGroup.class, message = "开始时间不能为空")
    @Schema(description = "开始时间:部署开始时间")
    private Date startTime;

    // 结束时间:部署结束时间
    @NotNull(groups = QueryGroup.class, message = "结束时间不能为空")
    @Schema(description = "结束时间:部署结束时间")
    private Date endTime;

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
     * 部署状态
     */
    @NotBlank(groups = { QueryGroup.class, Default.class }, message = "部署状态不能为空")
    @Schema(description = "部署状态")
    private String status;
}
