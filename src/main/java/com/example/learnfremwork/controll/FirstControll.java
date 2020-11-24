package com.example.learnfremwork.controll;

import com.example.learnfremwork.Service.CustomRetryService;
import com.example.learnfremwork.Service.CustomerServerImpl;
import com.example.learnfremwork.model.po.CustomerPo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: medal <br/>
 * date: 2020/2/16/0016 17:53 <br/>
 * comment:
 */
@RestController
@Api(value = "测试接口", tags = {"测试"})
@Slf4j
public class FirstControll {


    @Autowired
    private CustomerServerImpl server;
    @Autowired
    CustomRetryService customRetryService;

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "api comment", notes = "测试api",nickname = "mmdd",authorizations = @Authorization("medal"))
    List<CustomerPo> getall(){
        if (log.isDebugEnabled()) {
            log.debug("getall:32 测试耗时 getTestTime():[{}]", server.getTestTime());
        }
        return server.getAllCustomers();
    }
    @GetMapping(value = "/getOne/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "api comment", notes = "测试api",nickname = "mmdd",authorizations = @Authorization("medal"))
    CustomerPo getOne(@ApiParam(name = "id", value = "id", required = true) @PathVariable("id") Long id){
        CustomerPo oneCustomer = server.getOneCustomer(id);
        Date birthDay = oneCustomer.getBirthDay();
        birthDay.toString();
        log.info(birthDay.toString());
        return oneCustomer;
    }


    @GetMapping(value = "/retryServuce/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "retry test", notes = "测试注解形式的retry机制")
    public int retryServuce(@ApiParam(name = "id", value = "id",defaultValue = "0") @PathVariable("id") int id) {
        return customRetryService.simpleRetry(new AtomicInteger(id));
    }

    @PostMapping(value = "/testParallelStream", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "parallelStream test", notes = "测试并行流内存问题")
    public void parallelStreamJvm() {
        server.getAllCustomers();
        //server.getOneCustomer(100L);
    }

}
