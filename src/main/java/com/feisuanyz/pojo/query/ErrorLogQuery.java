package com.feisuanyz.pojo.query;

import lombok.Data;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 错误日志查询条件
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class ErrorLogQuery {

    /**
     * 日志级别
     */
    @Schema(description = "日志级别")
    private String logLevel;

    /**
     * 模块名称
     */
    @Schema(description = "模块名称")
    private String moduleName;

    /**
     * 开始时间
     */
    @Schema(description = "开始时间")
    private Date startTime;

    /**
     * 结束时间
     */
    @Schema(description = "结束时间")
    private Date endTime;

    /**
     * 当前页
     */
    @Schema(description = "当前页")
    private int pageIndex;

    /**
     * 每页大小
     */
    @Schema(description = "每页大小")
    private int pageSize;
}
