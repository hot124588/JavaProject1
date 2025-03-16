package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import jakarta.validation.groups.Default;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 新增依赖库和动态加载依赖库的入参
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@NoArgsConstructor
public class DependencyAddDTO {

    /**
     * 依赖库名称:必填
     */
    @NotBlank(groups = { CreateGroup.class, Default.class }, message = "依赖库名称不能为空")
    @Size(max = 255, message = "依赖库名称长度不能超过255")
    @Schema(description = "依赖库名称:必填")
    private String dependencyName;

    /**
     * 依赖库版本:必填
     */
    @NotBlank(groups = { CreateGroup.class, Default.class }, message = "依赖库版本不能为空")
    @Size(max = 50, message = "依赖库版本长度不能超过50")
    @Schema(description = "依赖库版本:必填")
    private String version;

    /**
     * 依赖库状态:必填
     */
    @NotBlank(groups = { CreateGroup.class, Default.class }, message = "依赖库状态不能为空")
    @Size(max = 50, message = "依赖库状态长度不能超过50")
    @Schema(description = "依赖库状态:必填")
    private String status;
}
