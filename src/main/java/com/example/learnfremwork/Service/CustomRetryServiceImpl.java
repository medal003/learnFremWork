package com.example.learnfremwork.Service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author medal <br/>
 * date: 2020/8/2/0002 11:38:48 <br/>
 * comment: 
 */
@Slf4j
public class CustomRetryServiceImpl implements CustomRetryService {
    @Override
    public void simpleRetry() {
        log.info("simpleRetry:11");

    }

    @Override
    public void recoveryCallback() {
        log.info("recoveryCallback:20  :[{}]");

    }

    @Override
    public void simpleRetryPolicy() {
        log.info("simpleRetryPolicy:26  :[{}]");
    }

    @SneakyThrows
    @Override
    public void timeoutRetryPolicy() {
        log.info("timeoutRetryPolicy:39  :[{}]");
    }

    @Override
    public void exceptionClassifierRetryPolicy() {

    }

    @Override
    public void circuitBreakerRetryPolicy() {

    }

    @Override
    public void compositeRetryPolicy() {

    }

    @Override
    public void backOffPolicy() {

    }

    @Override
    public void retryTemplate() {
        log.info("retryTemplate:58  :[{}]");
    }
}
