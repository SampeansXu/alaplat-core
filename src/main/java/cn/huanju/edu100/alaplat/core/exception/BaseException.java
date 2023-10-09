package cn.huanju.edu100.alaplat.core.exception;

import java.io.Serializable;

/**
 * 业务平台 基础异常基类，每个业务服务可以继承定义自己的异常类，如 ResourceCommonException GatewayCommonException 等
 * 具体服务中自定义异常类可参考如下示例:
 *     public class BizSelfException extends BaseException {
 *         public BizSelfException(final String message) {
 *             super(message);
 *         }
 *         public BizSelfException(final String message, Class srcClass) {
 *             super(message, srcClass);
 *         }
 *         public BizSelfException(final String message, Class srcClass, final String showMessage) {
 *             super(message, srcClass, showMessage);
 *         }
 *         public BizSelfException(final String message, Class srcClass, final String showMessage, printErrorLogFlag) {
 *             super(message, srcClass, showMessage, printErrorLogFlag);
 *         }
 *     }
 *
 *     throw new BizSelfException("参数等等错误信息", this.getClass(), "显示给前端的信息");
 *     推荐写法
 *     throw new BizSelfException("参数等等错误信息", this.getClass());
 *
 * @author  lidl 20200619
 */
public abstract class BaseException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;

    /**
     * 抛出异常的业务类，可使用 this.getClass() 获取
     */
    protected Class srcClass;
    /**
     * 隐藏属性, 来源模块编号或业务编号等，具体定位
     */
    private String srcCode;
    /**
     * 显示给前端或调用方的第一层展示信息，对应 ResoponseBean.getMessage() 信息
     */
    protected String showMessage;
    /**
     * 是否要求打印/记录错误日志，可强制要求记录 log.error(...) 日志
     */
    protected boolean printErrorLogFlag;

    public BaseException(final String message) {
        super(message);
    }

    public BaseException(final String message, Class srcClass) {
        super(message);
        this.srcClass = srcClass;
    }

    public BaseException(final String message, Class srcClass, final String showMessage) {
        super(message);
        this.srcClass = srcClass;
        this.showMessage = showMessage;
    }

    public BaseException(final String message, Class srcClass, final String showMessage, boolean printErrorLogFlag) {
        super(message);
        this.srcClass = srcClass;
        this.showMessage = showMessage;
        this.printErrorLogFlag = printErrorLogFlag;
    }

    @Override
    public String toString() {
        StringBuffer info = new StringBuffer(200);
        info.append(super.toString());
        if (srcClass != null) {
            info.append(", srcClass: ").append(srcClass.getName());
        }
        if (showMessage != null && showMessage.length() > 0) {
            info.append(", showMessage: ").append(showMessage);
        }
        return info.toString();
    }

    public Class getSrcClass() {
        return srcClass;
    }

    public String getSrcCode() {
        if (srcClass != null) {
            return srcClass.getSimpleName();
        }

        return "";
    }

    public String getShowMessage() {
        return showMessage;
    }

    public boolean isPrintErrorLogFlag() {
        return printErrorLogFlag;
    }
}
