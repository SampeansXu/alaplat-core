package cn.huanju.edu100.alaplat.core.exception;

/**
 * 调用第三方服务异常类，调用外部系统时出错
 * 该异常对应错误码枚举中的  THIRD_SERVICE_CALL_ERROR_C0001("C0001", "调用第三方服务出错")
 * @author lidelin 20200815
 */
public class ThirdServiceCallException extends BaseException {
    public ThirdServiceCallException(final String message) {
        super(message);
    }

    public ThirdServiceCallException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public ThirdServiceCallException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public ThirdServiceCallException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}