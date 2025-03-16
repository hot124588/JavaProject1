package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import jakarta.validation.groups.Default;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 删除依赖库的入参
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@NoArgsConstructor
public class DependencyDeleteDTO {

    /**
     * 依赖库id:必填
     */
    @NotNull(groups = { DeleteGroup.class, Default.class }, message = "依赖库id不能为空")
    @Schema(description = "依赖库id:必填")
    private Integer dependencyId;
}
