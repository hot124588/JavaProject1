package com.feisuanyz.pojo.query;

import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import jakarta.validation.constraints.NotBlank;
import com.feisuanyz.pojo.dto.DeleteGroup;

/**
 * 数据初始化信息查询条件
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class DataInitializationQuery {

    // 开始时间:初始化数据开始时间
    @NotNull(groups = QueryGroup.class, message = "开始时间不能为空")
    @Schema(description = "开始时间:初始化数据开始时间")
    private Date startTime;

    // 结束时间:初始化数据结束时间
    @NotNull(groups = QueryGroup.class, message = "结束时间不能为空")
    @Schema(description = "结束时间:初始化数据结束时间")
    private Date endTime;

    /**
     * 分页索引，从1开始
     */
    @NotNull(groups = { QueryGroup.class, Default.class }, message = "分页索引不能为空")
    @Schema(description = "分页索引，从1开始")
    private Integer pageIndex;

    /**
     * 每页大小，默认10
     */
    @NotNull(groups = { QueryGroup.class, Default.class }, message = "每页大小不能为空")
    @Schema(description = "每页大小，默认10")
    private Integer pageSize;

    /**
     * 初始化状态
     */
    @NotBlank(groups = { QueryGroup.class, Default.class }, message = "初始化状态不能为空")
    @Schema(description = "初始化状态")
    private String status;

    /**
     * 初始化唯一标识: 初始化唯一标识，必填
     */
    @NotBlank(groups = { QueryGroup.class, DeleteGroup.class }, message = "初始化唯一标识不能为空")
    @Schema(description = "初始化唯一标识: 初始化唯一标识，必填")
    private String initializationId;
}
