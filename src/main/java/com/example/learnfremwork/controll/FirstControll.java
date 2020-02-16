package com.example.learnfremwork.controll;

import com.example.learnfremwork.Service.CustomerServerImpl;
import com.example.learnfremwork.model.po.CustomerPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author: meideng.zh <br/>
 * date: 2020/2/16/0016 17:53 <br/>
 * comment:
 */
@RestController
public class FirstControll {


    @Autowired
    private CustomerServerImpl server;

    @GetMapping(path = "/getall")
    List<CustomerPo> getall(){
        return server.getAllCustomers();
    }
}
