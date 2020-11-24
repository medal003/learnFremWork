package com.example.learnfremwork;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@SpringBootTest
class LearnfremworkApplicationTests {

    @Test
    void contextLoads() {
        String s ="number(18,2)";
        Pattern compile = Pattern.compile("(?<=(\\()|(,))\\d+");
        Matcher matcher = compile.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
        System.out.println(matcher.toString());
        System.out.println(ChronoUnit.DAYS.between(LocalDateTime.now(), LocalDateTime.now().plusMinutes(+30)));
        System.out.println(LocalDateTime.now().toLocalDate().equals(LocalDateTime.of(2020, 8, 14, 14, 38).toLocalDate()));

    }

}
