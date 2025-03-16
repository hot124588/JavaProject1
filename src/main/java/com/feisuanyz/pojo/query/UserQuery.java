package com.feisuanyz.pojo.query;

import lombok.Data;
import javax.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

/**
 * 用户查询数据传输对象
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
public class UserQuery {

    // 用户ID:用户唯一标识
    @NotNull(groups = QueryGroup.class, message = "用户ID不能为空")
    @Schema(description = "用户ID:用户唯一标识")
    private Integer userId;

    // 分页索引:分页查询的索引
    @Schema(description = "分页索引:分页查询的索引")
    private Integer pageIndex;

    // 分页大小:分页查询的大小
    @Schema(description = "分页大小:分页查询的大小")
    private Integer pageSize;
}
