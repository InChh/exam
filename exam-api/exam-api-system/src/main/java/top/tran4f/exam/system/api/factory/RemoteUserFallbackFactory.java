package top.tran4f.exam.system.api.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import top.tran4f.exam.common.core.domain.R;
import top.tran4f.exam.system.api.RemoteUserService;
import top.tran4f.exam.system.api.domain.SysUser;
import top.tran4f.exam.system.api.model.LoginUser;

/**
 * 用户服务降级处理
 *
 * @author ruoyi
 */
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteUserFallbackFactory.class);

    @Override
    public RemoteUserService create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new RemoteUserService() {
            @Override
            public R<LoginUser> getUserInfo(String username, String source) {
                return R.fail("获取用户失败:" + throwable.getMessage());
            }

            @Override
            public R<Boolean> registerUserInfo(SysUser sysUser, String source) {
                return R.fail("注册用户失败:" + throwable.getMessage());
            }
        };
    }
}
