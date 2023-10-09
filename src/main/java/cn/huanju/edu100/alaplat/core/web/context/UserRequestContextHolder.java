package cn.huanju.edu100.alaplat.core.web.context;


import cn.huanju.edu100.alaplat.core.exception.TokenInvalidException;
import cn.huanju.edu100.alaplat.core.shared.jwt.AuthToken;

/**
 * 用户会话上下文
 * <p>
 * 这里用可继承的ThreadLocal(即InheritableThreadLocal),而不是ThreadLocal，这样 子线程可以继承父线程的LoginUser,
 * getCurrentUser()只允许在在同步线程或同步同线程的子线程中使用，典型的场景：前端请求线程(与当前登陆用户绑定的线程)
 * 业务代码里可以通过getCurrentUser()直接获取当前登陆用户，或业务代码里新创建的子线程里 也可以正常获取用户登陆信息
 * 有以下两种场景不能使用上下文方式获取用户登陆信息
 * 1：由Task发起的线程，这种场景没有当前登陆用户上下文
 * 2：带 {@Async}(由Spring线程池创建的线程)注解的方法体里不能通过这种方式获取用户信息
 * 以上两者方式如果调用getCurrentUser()都会throw CurrentUserNotFundException异常
 *
 * @Author hexiangtao
 * @create 2020/7/3 11:45
 */
public class UserRequestContextHolder {
    private static final InheritableThreadLocal<AuthToken> authTokenThreadLocal = new InheritableThreadLocal<>();

    /**
     * 将当前登陆用户信息绑定到当前线程上下文中，方便在各层直接获取，避免层层传递用户信息
     *
     * @param authToken
     */
    public static void setAuthToken(AuthToken authToken) {
        if (authToken == null) {
            throw new TokenInvalidException("认证信息为空", UserRequestContextHolder.class, "认证信息为空, 请重新登录");
        }

        authTokenThreadLocal.set(authToken);
    }

    /**
     * 该方法不对外公开，防止调用错误
     * @return
     */
    public static AuthToken getAuthToken() {
        AuthToken authToken = authTokenThreadLocal.get();
        if (authToken == null) {
            throw new TokenInvalidException("未授权的认证", UserRequestContextHolder.class, "未授权的认证, 请重新登录");
        }

        return authToken;
    }

    /**
     * 从当前线程上下文中删除用户认证授权信息
     */
    public static void removeAuthToken() {
        authTokenThreadLocal.remove();
    }
}
