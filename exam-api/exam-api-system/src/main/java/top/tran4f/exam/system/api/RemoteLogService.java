package top.tran4f.exam.system.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import top.tran4f.exam.common.core.constant.SecurityConstants;
import top.tran4f.exam.common.core.constant.ServiceNameConstants;
import top.tran4f.exam.common.core.domain.R;
import top.tran4f.exam.system.api.domain.SysLogininfor;
import top.tran4f.exam.system.api.domain.SysOperLog;
import top.tran4f.exam.system.api.factory.RemoteLogFallbackFactory;

/**
 * 日志服务
 *
 * @author ruoyi
 */
@FeignClient(contextId = "remoteLogService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteLogFallbackFactory.class)
public interface RemoteLogService {
    /**
     * 保存系统日志
     *
     * @param sysOperLog 日志实体
     * @param source     请求来源
     * @return 结果
     */
    @PostMapping("/operlog")
    R<Boolean> saveLog(@RequestBody SysOperLog sysOperLog, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 保存访问记录
     *
     * @param sysLogininfor 访问实体
     * @param source        请求来源
     * @return 结果
     */
    @PostMapping("/logininfor")
    R<Boolean> saveLogininfor(@RequestBody SysLogininfor sysLogininfor, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
