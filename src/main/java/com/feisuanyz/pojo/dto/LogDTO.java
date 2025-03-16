package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 日志信息的入参对象
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class LogDTO {

    /**
     * 日志ID:日志ID，必填
     */
    @NotNull(groups = { DeleteGroup.class, UpdateGroup.class }, message = "日志ID不能为空")
    @Schema(description = "日志ID:日志ID，必填")
    private Integer logId;

    /**
     * 日志级别:日志级别，必填
     */
    @NotBlank(groups = { CreateGroup.class }, message = "日志级别不能为空")
    @Schema(description = "日志级别:日志级别，必填")
    private String logLevel;

    /**
     * 日志信息:日志信息，必填
     */
    @NotBlank(groups = { CreateGroup.class }, message = "日志信息不能为空")
    @Schema(description = "日志信息:日志信息，必填")
    private String logMessage;

    /**
     * 日志时间:日志时间，必填
     */
    @NotNull(groups = { CreateGroup.class }, message = "日志时间不能为空")
    @Schema(description = "日志时间:日志时间，必填")
    private Date logTime;

    /**
     * 模块名称:模块名称
     */
    @Schema(description = "模块名称:模块名称")
    private String moduleName;

    /**
     * 创建人:创建人
     */
    @Schema(description = "创建人:创建人")
    private String createBy;

    /**
     * 创建时间:创建时间
     */
    @Schema(description = "创建时间:创建时间")
    private Date createTime;

    /**
     * 修改人:修改人
     */
    @Schema(description = "修改人:修改人")
    private String updateBy;

    /**
     * 修改时间:修改时间
     */
    @Schema(description = "修改时间:修改时间")
    private Date updateTime;
}
