package top.tran4f.exam.common.core.exception.auth;

import org.apache.commons.lang3.StringUtils;

/**
 * 未能通过的权限认证异常
 *
 * @author ruoyi
 */
public class NoPermissionException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoPermissionException(String permission) {
        super(permission);
    }

    public NoPermissionException(String[] permissions) {
        super(StringUtils.join(permissions, ","));
    }
}
