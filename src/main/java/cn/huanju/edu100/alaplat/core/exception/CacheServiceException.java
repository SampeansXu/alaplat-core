package cn.huanju.edu100.alaplat.core.exception;

/**
 * 通用的缓存服务异常类(redis、本地缓存等)
 * 该异常对应错误码枚举中的 CACHE_SERVICE_ERROR_C0130("C0130", "缓存服务出错")
 * @author lidelin 20200815
 */
public class CacheServiceException extends BaseException {
    public CacheServiceException(final String message) {
        super(message);
    }

    public CacheServiceException(final String message, Class srcClass) {
        super(message, srcClass);
    }

    public CacheServiceException(final String message, Class srcClass, final String showMessage) {
        super(message, srcClass, showMessage);
    }

    public CacheServiceException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message, srcClass, showMessage, printErrorLogFlag);
    }
}