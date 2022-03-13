package top.tran4f.exam.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 网关启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ExamGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamGatewayApplication.class, args);
    }
}
