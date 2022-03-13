package top.tran4f.exam.system.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import top.tran4f.exam.common.core.constant.SecurityConstants;
import top.tran4f.exam.common.core.constant.ServiceNameConstants;
import top.tran4f.exam.common.core.domain.R;
import top.tran4f.exam.system.api.domain.SysUser;
import top.tran4f.exam.system.api.factory.RemoteUserFallbackFactory;
import top.tran4f.exam.system.api.model.LoginUser;

/**
 * 用户服务
 *
 * @author ruoyi
 */
@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService {
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @param source   请求来源
     * @return 结果
     */
    @GetMapping("/user/info/{username}")
    R<LoginUser> getUserInfo(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 注册用户信息
     *
     * @param sysUser 用户信息
     * @param source  请求来源
     * @return 结果
     */
    @PostMapping("/user/register")
    R<Boolean> registerUserInfo(@RequestBody SysUser sysUser, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
