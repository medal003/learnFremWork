package com.example.learnfremwork.Service;

/**
 * @author medal <br/>
 * date: 2020/8/2/0002 11:27:31 <br/>
 * comment: spring的重试机制
 */
public interface CustomRetryService {
    void simpleRetry();
    void recoveryCallback();
    void simpleRetryPolicy();
    void timeoutRetryPolicy();
    void exceptionClassifierRetryPolicy();
    void circuitBreakerRetryPolicy();
    void compositeRetryPolicy();
    void backOffPolicy();
    void retryTemplate();

}
