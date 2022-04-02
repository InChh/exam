package top.tran4f.exam.common.core.exception.auth;

import org.apache.commons.lang3.StringUtils;

/**
 * 未能通过的角色认证异常
 *
 * @author ruoyi
 */
public class NoRoleException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoRoleException(String role) {
        super(role);
    }

    public NoRoleException(String[] roles) {
        super(StringUtils.join(roles, ","));
    }
}
