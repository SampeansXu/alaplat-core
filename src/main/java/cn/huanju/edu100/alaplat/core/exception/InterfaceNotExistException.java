package cn.huanju.edu100.alaplat.core.exception;

/**
 * 通用 接口不存在 异常类, 比如网关的接口转发、第三方调用等
 * 该异常对应错误码枚举中的  INTERFACE_NOT_EXIST_C0113("C0113", "接口不存在")
 * 使用示例  throw new InterfaceNotExistException("XXX接口不存在", this.getClass(), "接口地址不正确");
 * @author lidl 20200912
 */
public class InterfaceNotExistException extends BaseException {
    public InterfaceNotExistException(final String message) {
        super(message);
    }

    public InterfaceNotExistException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public InterfaceNotExistException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public InterfaceNotExistException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}
