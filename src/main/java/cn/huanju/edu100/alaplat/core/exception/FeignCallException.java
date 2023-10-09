package cn.huanju.edu100.alaplat.core.exception;

/**
 * Feign接口调用异常类
 * 该异常对应错误码枚举中的  FEIGN_CALL_ERROR_H0300("H0300", "Feign接口调用异常")
 * @author lidelin 20200815
 */
public class FeignCallException extends BaseException {
    public FeignCallException(final String message) {
        super(message);
    }

    public FeignCallException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public FeignCallException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public FeignCallException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}