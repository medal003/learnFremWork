package com.example.learnfremwork.Service;

import com.example.learnfremwork.model.po.CustomerPo;
import com.example.learnfremwork.model.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author meideng.zh <br/>
 * date: 2020/2/16/0016 18:00 <br/>
 * comment:
 */
@Service
public class CustomerServerImpl implements CustomerServer {

    @Qualifier("customerRepo")
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<CustomerPo> getAllCustomers() {
        return (List<CustomerPo>) customerRepo.findAll();
    }
}
