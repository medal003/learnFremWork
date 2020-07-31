package com.example.learnfremwork.controll;

import com.example.learnfremwork.Service.CustomerServerImpl;
import com.example.learnfremwork.model.po.CustomerPo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author: meideng.zh <br/>
 * date: 2020/2/16/0016 17:53 <br/>
 * comment:
 */
@RestController
@Api(value = "测试接口", tags = {"测试"})
@Slf4j
public class FirstControll {


    @Autowired
    private CustomerServerImpl server;

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "api comment", notes = "api comment")
    List<CustomerPo> getall(){
        if (log.isDebugEnabled()) {
            log.debug("getall:32 测试耗时 getTestTime():[{}]",getTestTime());
        }
        return server.getAllCustomers();
    }

    @SneakyThrows
    private String getTestTime() {
        //测试日志的打印耗时问题
        Thread.sleep(1000*30L);
        return "OK";
    }
}
