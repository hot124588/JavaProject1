package com.feisuanyz.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 查询日志的入参对象
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class LogQuery {

    /**
     * 日志级别:日志级别
     */
    @Schema(description = "日志级别:日志级别")
    private String logLevel;

    /**
     * 模块名称:模块名称
     */
    @Schema(description = "模块名称:模块名称")
    private String moduleName;

    /**
     * 创建开始时间:创建开始时间
     */
    @Schema(description = "创建开始时间:创建开始时间")
    private Date createTimeStart;

    /**
     * 创建结束时间:创建结束时间
     */
    @Schema(description = "创建结束时间:创建结束时间")
    private Date createTimeEnd;

    /**
     * 当前页码:当前页码，必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "当前页码不能为空")
    @Schema(description = "当前页码:当前页码，必填")
    private Long pageIndex;

    /**
     * 每页数量:每页数量，必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "每页数量不能为空")
    @Schema(description = "每页数量:每页数量，必填")
    private Long pageSize;
}
