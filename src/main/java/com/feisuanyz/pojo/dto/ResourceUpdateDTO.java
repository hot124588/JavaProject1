package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 资源更新入参实体类
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class ResourceUpdateDTO {

    /**
     * 主键ID:主键ID，必填
     */
    @NotNull(groups = { UpdateGroup.class }, message = "主键ID不能为空")
    @Schema(description = "主键ID:主键ID，必填")
    private Integer id;

    /**
     * 资源名称:资源名称
     */
    @Size(max = 255, message = "资源名称长度不能超过255")
    @Schema(description = "资源名称:资源名称")
    private String resourceName;

    /**
     * 资源类型:资源类型
     */
    @Size(max = 50, message = "资源类型长度不能超过50")
    @Schema(description = "资源类型:资源类型")
    private String resourceType;

    /**
     * 资源分配状态:资源分配状态
     */
    @Size(max = 50, message = "资源分配状态长度不能超过50")
    @Schema(description = "资源分配状态:资源分配状态")
    private String allocationStatus;

    /**
     * 修改人:修改人
     */
    @Size(max = 50, message = "修改人长度不能超过50")
    @Schema(description = "修改人:修改人")
    private String updateBy;
}
