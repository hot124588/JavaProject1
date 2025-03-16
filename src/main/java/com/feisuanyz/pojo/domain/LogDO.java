package com.feisuanyz.pojo.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 日志信息的数据对象
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("project_logs")
public class LogDO {

    /**
     * 主键ID:主键ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键ID:主键ID")
    private Integer id;

    /**
     * 日志级别:日志级别
     */
    @Schema(description = "日志级别:日志级别")
    private String logLevel;

    /**
     * 日志信息:日志信息
     */
    @Schema(description = "日志信息:日志信息")
    private String logMessage;

    /**
     * 日志时间:日志时间
     */
    @Schema(description = "日志时间:日志时间")
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
