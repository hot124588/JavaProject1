package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户活动日志入参对象
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
public class UserActivityLogDTO {

    /**
     * 用户ID
     */
    @NotNull(groups = { CreateGroup.class }, message = "用户ID不能为空")
    @Schema(description = "用户ID")
    private Integer userId;

    /**
     * 活动描述
     */
    @NotBlank(groups = { CreateGroup.class }, message = "活动描述不能为空")
    @Size(max = 255, groups = { CreateGroup.class }, message = "* 活动描述长度不能超过255")
    @Schema(description = "活动描述")
    private String activityDescription;
}
