package com.feisuanyz.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 接口名称:获取环境变量配置
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class EnvironmentVariableQuery {

    /**
     * 环境类型，如开发、测试、生产
     */
    @NotBlank(groups = { QueryGroup.class }, message = "环境类型不能为空")
    @Schema(description = "环境类型，如开发、测试、生产")
    private String environmentType;

    /**
     * 分页索引
     */
    @Schema(description = "分页索引")
    private long pageIndex;

    /**
     * 分页大小
     */
    @Schema(description = "分页大小")
    private long pageSize;
}
