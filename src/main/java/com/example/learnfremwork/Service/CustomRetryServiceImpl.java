package com.example.learnfremwork.Service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author medal <br/>
 * date: 2020/8/2/0002 11:38:48 <br/>
 * comment: 
 */
@Slf4j
public class CustomRetryServiceImpl implements CustomRetryService {
    @Override
    public void simpleRetry() {

    }

    @Retryable
    @Override
    public int simpleRetry(AtomicInteger counter) {
        log.info("simpleRetry:25  counter:[{}]",counter);
        if (counter.incrementAndGet() < 2) {
            throw new IllegalStateException();
        }

        return counter.intValue();

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
