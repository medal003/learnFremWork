package com.example.learnfremwork.Service;

import com.example.learnfremwork.model.po.CustomerPo;

import java.util.List;

/**
 * @author meideng.zh <br/>
 * date: 2020/2/16/0016 17:54 <br/>
 * comment:
 */
public interface CustomerServer {
    List<CustomerPo> getAllCustomers();
}
