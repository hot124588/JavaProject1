package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 资源分配入参实体类
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class ResourceAllocationDTO {

    /**
     * 资源名称:资源名称，必填
     */
    @NotBlank(groups = { CreateGroup.class }, message = "资源名称不能为空")
    @Size(max = 255, message = "资源名称长度不能超过255")
    @Schema(description = "资源名称:资源名称，必填")
    private String resourceName;

    /**
     * 资源类型:资源类型，必填
     */
    @NotBlank(groups = { CreateGroup.class }, message = "资源类型不能为空")
    @Size(max = 50, message = "资源类型长度不能超过50")
    @Schema(description = "资源类型:资源类型，必填")
    private String resourceType;

    /**
     * 资源分配状态:资源分配状态，必填
     */
    @NotBlank(groups = { CreateGroup.class }, message = "资源分配状态不能为空")
    @Size(max = 50, message = "资源分配状态长度不能超过50")
    @Schema(description = "资源分配状态:资源分配状态，必填")
    private String allocationStatus;

    /**
     * 创建人:创建人
     */
    @Size(max = 50, message = "创建人长度不能超过50")
    @Schema(description = "创建人:创建人")
    private String createBy;
}
