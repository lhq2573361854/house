package com.tianling.house.web.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tianling
 * @create 2020/9/16
 **/
@ConfigurationProperties(prefix = "spring.httpclient")
@Data
public class HttpClientProperties {
    private Integer connectTimeOut = 1000;
    private Integer socketTimeOut = 1000;
    private String agency = "agency";
    private Integer maxConnPerRoute = 10;
    private Integer maxConnTotaol = 50;
}
