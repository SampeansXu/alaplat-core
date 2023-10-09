package cn.huanju.edu100.alaplat.core.exception;

/**
 * 通用的MQ消息服务异常类
 * 该异常对应错误码枚举中的 MESSAGE_SERVICE_ERROR_C0120("C0120", "消息服务出错")
 * @author lidelin 20200815
 */
public class MessageServiceException extends BaseException {
    public MessageServiceException(final String message) {
        super(message);
    }

    public MessageServiceException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public MessageServiceException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public MessageServiceException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}