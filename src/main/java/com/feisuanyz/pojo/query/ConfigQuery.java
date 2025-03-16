package com.feisuanyz.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 配置项查询对象
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class ConfigQuery {

    /**
     * 配置项键:必填
     */
    @NotBlank(groups = { QueryGroup.class }, message = "配置项键不能为空")
    @Schema(description = "配置项键:必填")
    private String configKey;

    /**
     * 环境类型，必填
     */
    @NotBlank(groups = { QueryGroup.class }, message = "环境类型不能为空")
    @Schema(description = "环境类型，必填")
    private String environmentType;
}
