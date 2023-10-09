package cn.huanju.edu100.alaplat.core.exception;

/**
 * 基础的验证异常类, 比如 XXX值不能为空
 * @author lidl 20200624
 */
public class ValidationException extends BaseException {
    public ValidationException(final String message) {
        super(message);
    }

    public ValidationException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public ValidationException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public ValidationException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}
