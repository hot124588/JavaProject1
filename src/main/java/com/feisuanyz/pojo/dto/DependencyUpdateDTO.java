package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import jakarta.validation.groups.Default;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 修改依赖库的入参
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@NoArgsConstructor
public class DependencyUpdateDTO {

    /**
     * 依赖库id:必填
     */
    @NotNull(groups = { UpdateGroup.class, Default.class }, message = "依赖库id不能为空")
    @Schema(description = "依赖库id:必填")
    private Integer dependencyId;

    /**
     * 依赖库名称:非必填
     */
    @Size(max = 255, message = "依赖库名称长度不能超过255")
    @Schema(description = "依赖库名称:非必填")
    private String dependencyName;

    /**
     * 依赖库版本:非必填
     */
    @Size(max = 50, message = "依赖库版本长度不能超过50")
    @Schema(description = "依赖库版本:非必填")
    private String version;

    /**
     * 依赖库状态:非必填
     */
    @Size(max = 50, message = "依赖库状态长度不能超过50")
    @Schema(description = "依赖库状态:非必填")
    private String status;
}
