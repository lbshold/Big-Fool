package top.lconcise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate
 * <p>
 * RestTemplate 是从Spring3.0开始支持的一个HTTP请求工具，它提供了常见的REST请求方案的模板，
 * 例如GET请求、POST请求、PUT请求、DELETE请求以及一些通用的请求执行方法。
 *
 * @author liusj
 * @date 2020/11/10
 */
@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
