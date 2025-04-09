package org.dows.tenant;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description: </br>
 * @author: lait.zhang@gmail.com
 * @date: 3/20/2024 10:41 AM
 * @history: </br>
 * <author>      <time>      <version>    <desc>
 * 修改人姓名      修改时间        版本号       描述
 */
@Configuration
@ComponentScan(basePackages = {"org.dows.apm.mapper", "org.dows.apm.repository",
        "org.dows.apm.config", "org.dows.apm.biz", "org.dows.apm.handler", "org.dows.apm.rest.tenant"})
public class ApmTenantAutoConfig {
}


