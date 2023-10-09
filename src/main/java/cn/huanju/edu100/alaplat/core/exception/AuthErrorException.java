package cn.huanju.edu100.alaplat.core.exception;

/**
 * 通用 授权出错异常类, 比如 未授权异常
 * 该异常对应错误码枚举中的  USER_AUTH_ACCESS_ERROR_A0300("A0300", "访问权限异常")
 * 使用示例  throw new AuthErrorException("XXX操作未授权", this.getClass(), "XXX操作未授权");
 * @author lidl 20200708
 */
public class AuthErrorException extends BaseException {
    public AuthErrorException(final String message) {
        super(message);
    }

    public AuthErrorException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public AuthErrorException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public AuthErrorException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}