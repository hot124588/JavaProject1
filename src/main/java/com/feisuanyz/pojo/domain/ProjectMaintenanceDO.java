package com.feisuanyz.pojo.domain;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 项目维护信息
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@TableName("project_maintenance")
public class ProjectMaintenanceDO {

    // 主键ID:主键ID
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键ID:主键ID")
    private Integer id;

    // 维护唯一标识:维护唯一标识
    @Schema(description = "维护唯一标识:维护唯一标识")
    private String maintenanceId;

    // 维护操作类型:维护操作类型，如升级、回滚、备份
    @Schema(description = "维护操作类型:维护操作类型，如升级、回滚、备份")
    private String actionType;

    // 维护操作时间:维护操作时间
    @Schema(description = "维护操作时间:维护操作时间")
    private Date actionTime;

    // 维护操作状态:维护操作状态
    @Schema(description = "维护操作状态:维护操作状态")
    private String status;

    // 创建人:创建人
    @Schema(description = "创建人:创建人")
    private String createBy;

    // 创建时间:创建时间
    @Schema(description = "创建时间:创建时间")
    private Date createTime;

    // 修改人:修改人
    @Schema(description = "修改人:修改人")
    private String updateBy;

    // 修改时间:修改时间
    @Schema(description = "修改时间:修改时间")
    private Date updateTime;
}
