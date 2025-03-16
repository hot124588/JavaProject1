package com.feisuanyz.pojo.domain;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 依赖库信息实体
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@NoArgsConstructor
@TableName("project_dependencies")
public class DependencyDO {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键ID")
    private Integer id;

    /**
     * 依赖库名称
     */
    @TableField("dependency_name")
    @Schema(description = "依赖库名称")
    private String dependencyName;

    /**
     * 依赖库版本
     */
    @TableField("version")
    @Schema(description = "依赖库版本")
    private String version;

    /**
     * 依赖库状态
     */
    @TableField("status")
    @Schema(description = "依赖库状态")
    private String status;

    /**
     * 创建人
     */
    @TableField("create_by")
    @Schema(description = "创建人")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @TableField("update_by")
    @Schema(description = "修改人")
    private String updateBy;

    /**
     * 修改时间
     */
    @TableField("update_time")
    @Schema(description = "修改时间")
    private Date updateTime;
}
