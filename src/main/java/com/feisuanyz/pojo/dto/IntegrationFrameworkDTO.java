package com.feisuanyz.pojo.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.feisuanyz.pojo.query.QueryGroup;
import jakarta.validation.groups.Default;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 测试框架集成信息DTO
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegrationFrameworkDTO {

    /**
     * 测试框架名称
     */
    @NotBlank(groups = { CreateGroup.class, UpdateGroup.class, Default.class }, message = "测试框架名称不能为空")
    @Schema(description = "测试框架名称")
    private String frameworkName;

    /**
     * 环境类型
     */
    @NotBlank(groups = { CreateGroup.class, UpdateGroup.class, DeleteGroup.class, QueryGroup.class, Default.class }, message = "环境类型不能为空")
    @Schema(description = "环境类型")
    private String environmentType;

    /**
     * 状态
     */
    @NotBlank(groups = { UpdateGroup.class, Default.class }, message = "状态不能为空")
    @Schema(description = "状态")
    private String status;
}
