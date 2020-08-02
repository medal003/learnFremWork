package com.example.learnfremwork.base.config;

import com.example.learnfremwork.Service.CustomRetryService;
import com.example.learnfremwork.Service.CustomRetryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author medal <br/>
 * date: 2020/8/2/0002 16:22:46 <br/>
 * comment: Spring Retry支持对Spring bean使用声明式的重试，在需要重试的bean方法上加上@Retryable。使用这种机制需要在@Configuration类上加上@EnableRetry
 */
@EnableRetry
@Configuration
public class RetryConfiguration {
    @Bean
    public CustomRetryService customRetryService() {
        return new CustomRetryServiceImpl();
    }

}
