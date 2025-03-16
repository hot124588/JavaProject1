package com.feisuanyz.pojo.query;

import lombok.Data;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import jakarta.validation.groups.Default;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 测试框架查询信息
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegrationFrameworkQuery {

    /**
     * 环境类型
     */
    @NotBlank(groups = { QueryGroup.class, Default.class }, message = "环境类型不能为空")
    @Schema(description = "环境类型")
    private String environmentType;

    /**
     * 页码
     */
    @NotNull(groups = { QueryGroup.class, Default.class }, message = "页码不能为空")
    @Schema(description = "页码")
    private Integer pageIndex;

    /**
     * 每页大小
     */
    @NotNull(groups = { QueryGroup.class, Default.class }, message = "每页大小不能为空")
    @Schema(description = "每页大小")
    private Integer pageSize;
}
