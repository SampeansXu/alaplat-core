package cn.huanju.edu100.alaplat.core.exception;

/**
 * 访问未授权/未授权访问异常, 访问接口或数据没有权限异常, 比 AuthErrorException 更详细更明确
 * 该异常对应错误码枚举中的  USER_NO_AUTH_ACCESS_A0301("A0301", "访问未授权")
 * 使用示例  throw new AccessNoAuthException("访问未授权", this.getClass(), "访问未授权");
 * @author lidl 20200923
 */
public class AccessNoAuthException extends BaseException {
    public AccessNoAuthException(final String message) {
        super(message);
    }

    public AccessNoAuthException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public AccessNoAuthException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public AccessNoAuthException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}