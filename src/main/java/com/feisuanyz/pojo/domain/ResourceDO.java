package com.feisuanyz.pojo.domain;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 资源实体类
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@TableName("project_resources")
public class ResourceDO {

    /**
     * 主键ID:主键ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键ID:主键ID")
    private Integer id;

    /**
     * 资源名称:资源名称
     */
    @Schema(description = "资源名称:资源名称")
    private String resourceName;

    /**
     * 资源类型:资源类型
     */
    @Schema(description = "资源类型:资源类型")
    private String resourceType;

    /**
     * 资源分配状态:资源分配状态
     */
    @Schema(description = "资源分配状态:资源分配状态")
    private String allocationStatus;

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
