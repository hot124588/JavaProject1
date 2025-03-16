package com.feisuanyz.pojo.query;

import javax.validation.constraints.NotEmpty;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;

/**
 * 应用上下文信息查询条件
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class ApplicationContextQuery {

    // 环境类型:环境类型，如开发、测试、生产
    @NotEmpty(groups = QueryGroup.class, message = "环境类型不能为空")
    @Schema(description = "环境类型:环境类型，如开发、测试、生产")
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
