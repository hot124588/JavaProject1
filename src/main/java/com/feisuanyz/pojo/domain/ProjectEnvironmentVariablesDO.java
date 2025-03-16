package com.feisuanyz.pojo.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

/**
 * 项目环境变量配置表
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("project_environment_variables")
public class ProjectEnvironmentVariablesDO {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String variableName;

    private String variableValue;

    private String environmentType;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}
