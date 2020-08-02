package com.example.learnfremwork.base.config;

import com.example.learnfremwork.Service.CustomRetryService;
import com.example.learnfremwork.Service.CustomRetryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.listener.RetryListenerSupport;

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
    @Bean
    public RetryListener retryListener() {
        // fixme medal 2020/8/2/0002 20:10:51 暂时不支持捕获
        return new RetryListenerSupport() {
            @Override
            public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
                super.onError(context, callback, throwable);
                System.out.println("发生异常：" + context.getRetryCount());
            }
        };
    }

}
