package cn.cps.springbootexample.bdqn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.cps.springbootexample.bdqn.dao")
@SpringBootApplication
public class SpringbootExampleBdqnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootExampleBdqnApplication.class, args);
    }

}
