package com.feisuanyz.service;

import com.feisuanyz.pojo.query.ConfigQuery;
import java.lang.String;

/**
 * DocService
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface DocService {

    /**
     * generate-api-doc
     *
     * @param configQuery 配置项查询对象
     * @return
     */
    String generateApiDoc(ConfigQuery configQuery);

    /**
     * generate-internal-doc
     *
     * @param configQuery 配置项查询对象
     * @return
     */
    String generateInternalDoc(ConfigQuery configQuery);
}
