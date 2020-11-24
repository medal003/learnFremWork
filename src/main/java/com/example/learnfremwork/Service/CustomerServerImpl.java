package com.example.learnfremwork.Service;

import com.example.learnfremwork.model.po.CustomerPo;
import com.example.learnfremwork.model.repo.CustomerRepo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

/**
 * @author medal <br/>
 * date: 2020/2/16/0016 18:00 <br/>
 * comment:
 */
@Service
@Slf4j
public class CustomerServerImpl implements CustomerServer {

    @Qualifier("customerRepo")
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    @Transactional
    public List<CustomerPo> getAllCustomers() {
        log.info("getAllCustomers:31  :[{}],[{}]",TransactionSynchronizationManager.isActualTransactionActive(),TransactionSynchronizationManager.getCurrentTransactionName());
        getOneCustomer(100L);
        return (List<CustomerPo>) customerRepo.findAll();
    }

    @Override
    @Transactional
    public CustomerPo getOneCustomer(Long id) {
        log.info("getOneCustomer:35  :[{}],[{}]",TransactionSynchronizationManager.isActualTransactionActive(),TransactionSynchronizationManager.getCurrentTransactionName());

        return customerRepo.findById(id).orElse(null);
    }

    public static void main(String[] args){
        try {
            test1();
        } catch (Exception e) {
            System.out.println("e.printStackTrace();");
        } finally {
            System.out.println("fff");
        }
    }

    private static void test1() {
        try {
            throw new RuntimeException("测试");
        }catch (Exception e) {
            System.out.println("异常捕获");

            throw new RuntimeException("异常测试1");
        }finally {
            System.out.println("finally 测试");
        }
    }


    @SneakyThrows
    public String getTestTime() {
        //测试日志的打印耗时问题
        Thread.sleep(1000*30L);
        return "OK";
    }
}
