package com.example.learnfremwork;

import com.example.learnfremwork.base.init.AccessingDataJpaApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnfremworkApplication {
    public static void main(String[] args) {
        //AccessingDataJpaApplication作为初始化夹杂类作为程序启动的参数，也即启动类，第一时间启动
        // 启动类是指****SpringApplication.run()参数中的类，该类才为启动类****
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

}
