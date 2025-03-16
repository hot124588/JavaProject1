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
 * 环境变量实体对象
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("project_environment_variables")
public class EnvironmentVariableDO {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键ID")
    private Integer id;

    /**
     * 环境变量名称
     */
    @Schema(description = "环境变量名称")
    private String variableName;

    /**
     * 环境变量值
     */
    @Schema(description = "环境变量值")
    private String variableValue;

    /**
     * 环境类型
     */
    @Schema(description = "环境类型")
    private String environmentType;

    /**
     * 创建人
     */
    @Schema(description = "创建人")
    private String createBy;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @Schema(description = "修改人")
    private String updateBy;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private Date updateTime;
}
