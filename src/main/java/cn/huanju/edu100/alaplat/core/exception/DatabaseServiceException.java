package cn.huanju.edu100.alaplat.core.exception;

/**
 * 通用 数据库服务异常, 比如保存数据失败，SQL异常
 * 该异常对应错误码枚举中的  DATABASE_SERVICE_ERROR_C0300("C0300", "数据库服务出错")
 * 使用示例  throw new DatabaseServiceException("XXX SQL异常", this.getClass(), "数据库服务出错");
 * @author lidl 20200715
 */
public class DatabaseServiceException extends BaseException {
    public DatabaseServiceException(final String message) {
        super(message);
    }

    public DatabaseServiceException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public DatabaseServiceException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public DatabaseServiceException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}
