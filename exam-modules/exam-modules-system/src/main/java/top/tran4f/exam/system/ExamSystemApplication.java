package top.tran4f.exam.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.tran4f.exam.common.security.annotation.EnableCustomConfig;
import top.tran4f.exam.common.security.annotation.EnableRyFeignClients;
import top.tran4f.exam.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 系统模块
 *
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class ExamSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamSystemApplication.class, args);
    }
}
