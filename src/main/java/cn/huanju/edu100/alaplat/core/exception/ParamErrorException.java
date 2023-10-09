package cn.huanju.edu100.alaplat.core.exception;

/**
 * 请求参数不正确，比如格式不正确，取值范围不正确等
 * 该异常对应错误码枚举中的 REQUEST_PARAM_ERROR_A0400("A0400", "用户请求参数错误")
 * 使用示例  throw new ParamErrorException("开始时间格式不正确", this.getClass(), "开始时间格式不正确");
 *  @author lidl 20200708
 */
public class ParamErrorException extends BaseException {
    public ParamErrorException(final String message) {
        super(message);
    }

    public ParamErrorException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public ParamErrorException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public ParamErrorException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}