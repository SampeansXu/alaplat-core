package cn.huanju.edu100.alaplat.core.exception;

/**
 * 通用 数据未找到异常类, 比如关联的数据不存在或找不到
 * 该异常对应错误码枚举中的  DATA_NOT_FOUND_H0200("H0200", "数据未找到")
 * 使用示例  throw new DataNotFoundException("XXX数据未找到", this.getClass(), "找不到关联的作业");
 * @author lidl 20200708
 */
public class DataNotFoundException extends BaseException {
    public DataNotFoundException(final String message) {
        super(message);
    }

    public DataNotFoundException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public DataNotFoundException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public DataNotFoundException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}