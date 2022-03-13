package top.tran4f.exam.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.tran4f.exam.common.security.annotation.EnableCustomConfig;
import top.tran4f.exam.common.security.annotation.EnableRyFeignClients;
import top.tran4f.exam.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 *
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class ExamJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamJobApplication.class, args);
    }
}
