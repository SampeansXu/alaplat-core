package cn.huanju.edu100.alaplat.core.exception;

/**
 * token无效异常, 需要重新登录
 * 该异常对应错误码枚举中的  TOKEN_INVALID_H0401("H0401", "认证令牌无效")
 * 使用示例  throw new TokenInvalidException("认证已过期，请重新登录", this.getClass(), "认证已过期，请重新登录");
 * @author lidl 20200923
 */
public class TokenInvalidException extends BaseException {
    public TokenInvalidException(final String message) {
        super(message);
    }

    public TokenInvalidException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public TokenInvalidException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public TokenInvalidException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}