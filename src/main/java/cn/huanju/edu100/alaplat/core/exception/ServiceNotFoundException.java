package cn.huanju.edu100.alaplat.core.exception;

/**
 * 通用服务未找到异常类
 * 该异常对应错误码枚举中的 SERVICE_NOT_FOUND_H0100("H0100", "服务未找到"),
 * 使用示例  throw new ServiceNotFoundException("XXX服务未找到", this.getClass());
 * @author lidl 20200708
 */
public class ServiceNotFoundException extends BaseException {
    public ServiceNotFoundException(final String message) {
        super(message);
    }

    public ServiceNotFoundException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public ServiceNotFoundException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public ServiceNotFoundException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}