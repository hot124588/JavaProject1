package com.feisuanyz.controller;

import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.query.ConfigQuery;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.service.DocService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.com.feisuanyz.constant.ResultCodeConstant;

/**
 * DocController
 *
 * @author 95978
 * @date 2025-03-16 12:07:59
 */
@Tag(name = "DocController")
@RequestMapping("doc")
@RestController
public class DocController {

    @Autowired
    private DocService docService;

    /**
     * generate-api-doc
     *
     * @param configQuery 配置项查询对象
     * @return
     */
    @RequestMapping(value = "/generate-api-doc", method = RequestMethod.GET)
    @Operation(summary = "generate-api-doc")
    public RestResult<String> generateApiDoc(@Validated(QueryGroup.class) ConfigQuery configQuery) {
        String result = docService.generateApiDoc(configQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * generate-internal-doc
     *
     * @param configQuery 配置项查询对象
     * @return
     */
    @RequestMapping(value = "/generate-internal-doc", method = RequestMethod.GET)
    @Operation(summary = "generate-internal-doc")
    public RestResult<String> generateInternalDoc(@Validated(QueryGroup.class) ConfigQuery configQuery) {
        String result = docService.generateInternalDoc(configQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}
