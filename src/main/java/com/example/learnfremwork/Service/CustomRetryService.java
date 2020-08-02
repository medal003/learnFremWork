package com.example.learnfremwork.Service;

import org.springframework.retry.annotation.Retryable;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author medal <br/>
 * date: 2020/8/2/0002 11:27:31 <br/>
 * comment: spring的重试机制
 */
public interface CustomRetryService {
    void simpleRetry();

    @Retryable
    int simpleRetry(AtomicInteger counter);

    void recoveryCallback();
    void simpleRetryPolicy();
    void timeoutRetryPolicy();
    void exceptionClassifierRetryPolicy();
    void circuitBreakerRetryPolicy();
    void compositeRetryPolicy();
    void backOffPolicy();
    void retryTemplate();

}
