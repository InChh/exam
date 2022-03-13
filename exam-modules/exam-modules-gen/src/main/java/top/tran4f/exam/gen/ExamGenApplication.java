package top.tran4f.exam.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.tran4f.exam.common.security.annotation.EnableCustomConfig;
import top.tran4f.exam.common.security.annotation.EnableRyFeignClients;
import top.tran4f.exam.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 代码生成
 *
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class ExamGenApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamGenApplication.class, args);
    }
}
