package top.tran4f.exam.modules.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 监控中心
 *
 * @author ruoyi
 */
@EnableAdminServer
@SpringBootApplication
public class ExamMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamMonitorApplication.class, args);
    }
}
