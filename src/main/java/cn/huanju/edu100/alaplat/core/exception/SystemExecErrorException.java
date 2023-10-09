package cn.huanju.edu100.alaplat.core.exception;

/**
 * 系统执行出错异常类
 * 该异常对应错误码枚举中的 SYS_EXEC_ERROR_B0001("B0001", "系统执行出错"),
 * 使用示例  throw new SystemExecErrorException("系统执行出错", this.getClass(), "XXX处理执行出错");
 * @author lidl 20200708
 */
public class SystemExecErrorException extends BaseException {
    public SystemExecErrorException(final String message) {
        super(message);
    }

    public SystemExecErrorException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public SystemExecErrorException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public SystemExecErrorException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}
