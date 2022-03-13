package top.tran4f.exam.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import top.tran4f.exam.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 文件服务
 *
 * @author ruoyi
 */
@EnableCustomSwagger2
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ExamFileApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamFileApplication.class, args);
    }
}
