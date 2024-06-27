package cn.hxzy.herbtool02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "cn.hxzy.herbtool02.Repository")
@EntityScan(basePackages = "cn.hxzy.herbtool02.Herb")
public class HerbTool02Application {

    public static void main(String[] args) {
        SpringApplication.run(HerbTool02Application.class, args);
    }

}
