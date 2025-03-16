package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 * 环境变量入参对象
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class EnvironmentVariableDTO {

    /**
     * 环境变量名称
     */
    @NotBlank(groups = { CreateGroup.class }, message = "环境变量名称不能为空")
    @Schema(description = "环境变量名称")
    private String variableName;

    /**
     * 环境变量值
     */
    @NotBlank(groups = { CreateGroup.class }, message = "环境变量值不能为空")
    @Schema(description = "环境变量值")
    private String variableValue;

    /**
     * 环境类型
     */
    @NotBlank(groups = { CreateGroup.class }, message = "环境类型不能为空")
    @Schema(description = "环境类型")
    private String environmentType;

    /**
     * 主键ID
     */
    @NotNull(groups = { UpdateGroup.class, DeleteGroup.class }, message = "主键ID不能为空")
    @Schema(description = "主键ID")
    private Integer id;

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
