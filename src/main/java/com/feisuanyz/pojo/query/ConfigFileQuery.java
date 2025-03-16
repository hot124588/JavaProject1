package com.feisuanyz.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 配置文件查询对象
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class ConfigFileQuery {

    /**
     * 配置文件名称
     */
    @NotBlank(groups = { QueryGroup.class }, message = "配置文件名称不能为空")
    @Schema(description = "配置文件名称")
    private String fileName;

    /**
     * 环境类型
     */
    @NotBlank(groups = { QueryGroup.class }, message = "环境类型不能为空")
    @Schema(description = "环境类型")
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
