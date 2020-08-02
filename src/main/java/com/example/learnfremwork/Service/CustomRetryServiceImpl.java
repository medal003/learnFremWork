package com.example.learnfremwork.Service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
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

    @Retryable(maxAttemptsExpression = "${retry.maxAttempts:5}",
            backoff = @Backoff(delayExpression = "${retry.delay:100}",
                    maxDelayExpression = "${retry.maxDelay:2000}",
                    multiplierExpression = "${retry.multiplier:2}"))
    @Override
    public int simpleRetry(AtomicInteger counter) {
        log.info("simpleRetry:25  counter:[{}]",counter);
        if (counter.incrementAndGet() < 10) {
            throw new IllegalStateException();
        }

        return counter.intValue();

    }
    /**
     使用注解的可重试方法，如果重试次数达到后还是继续失败的就会抛出异常，它可以通过@Recover标记同一Class中的一个方法作为RecoveryCallback。@Recover标记的方法的返回类型必须与@Retryable标记的方法一样。方法参数可以与@Retryable标记的方法一致，也可以不带参数，带了参数就会传递过来。
     */
    @Recover
    public int simpleRetryRecover(AtomicInteger counter) {

        counter.set(1000);
        log.warn("simpleRetryRecover:41  counter:[{}]",counter);
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
