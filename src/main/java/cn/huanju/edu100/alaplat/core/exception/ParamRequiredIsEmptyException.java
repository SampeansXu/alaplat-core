package cn.huanju.edu100.alaplat.core.exception;

/**
 * 缺少必填参数异常类
 * 该异常对应错误码枚举中的 REQUEST_PARAM_REQUIRED_IS_EMPTY_A0410("A0410", "请求必填参数为空")
 * 使用示例  throw new ParamRequiredIsEmptyException("订单ID不能为空", this.getClass());
 * @author lidl 20200708
 */
public class ParamRequiredIsEmptyException extends BaseException {
    public ParamRequiredIsEmptyException(final String message) {
        super(message);
    }

    public ParamRequiredIsEmptyException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public ParamRequiredIsEmptyException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public ParamRequiredIsEmptyException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}
