package top.tran4f.exam.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import top.tran4f.exam.common.security.annotation.EnableRyFeignClients;

/**
 * 认证授权中心
 *
 * @author ruoyi
 */
@EnableRyFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ExamAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamAuthApplication.class, args);
    }
}
