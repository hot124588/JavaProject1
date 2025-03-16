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
 * 系统监控信息实体类
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("system_monitoring")
public class SystemMonitoringDO {

    /**
     * 监控ID:监控ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "监控ID:监控ID")
    private Integer monitorId;

    /**
     * 响应时间:响应时间
     */
    @Schema(description = "响应时间:响应时间")
    private Double responseTime;

    /**
     * 内存使用情况:内存使用情况
     */
    @Schema(description = "内存使用情况:内存使用情况")
    private Double memoryUsage;

    /**
     * CPU使用情况:CPU使用情况
     */
    @Schema(description = "CPU使用情况:CPU使用情况")
    private Double cpuUsage;

    /**
     * 监控时间:监控时间
     */
    @Schema(description = "监控时间:监控时间")
    private Date monitorTime;

    /**
     * 创建人:创建人
     */
    @Schema(description = "创建人:创建人")
    private Integer createBy;

    /**
     * 创建时间:创建时间
     */
    @Schema(description = "创建时间:创建时间")
    private Date createTime;

    /**
     * 修改人:修改人
     */
    @Schema(description = "修改人:修改人")
    private Integer updateBy;

    /**
     * 修改时间:修改时间
     */
    @Schema(description = "修改时间:修改时间")
    private Date updateTime;
}
