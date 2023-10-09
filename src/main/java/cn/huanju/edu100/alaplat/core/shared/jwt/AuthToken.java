package cn.huanju.edu100.alaplat.core.shared.jwt;


import java.io.Serializable;

/**
 * 存放(通用)用户认证后的授权信息, 对应于jwt-token中的payload
 * 部分最重要的属性值只能构造不能set
 *
 * @author lidelin 20200907
 */
public class AuthToken implements Serializable {
    /**
     * 登录应用ID, 来源应用ID
     */
    protected String appId;

    /**
     * platform
     */
    protected String platform;

    /**
     * 顶级机构id
     */
    protected Long topSchId;

    /**
     * 所属机构ID
     */
    protected Long schId;

    /**
     * 用户ID, 记操作日志用这个用户ID
     */
    protected Long uid;

    /**
     * 登陆用户帐号名
     */
    protected String uName;

    /**
     * 登录时间, 第一次记录时间
     */
    protected long loginTime;

    public AuthToken(Long schId, Long uid) {
        this.schId = schId;
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "AuthToken{" +
                "appId='" + appId + '\'' +
                ", platform='" + platform + '\'' +
                ", topSchId=" + topSchId +
                ", schId=" + schId +
                ", uid=" + uid +
                ", uName='" + uName + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Long getTopSchId() {
        return topSchId;
    }

    public void setTopSchId(Long topSchId) {
        this.topSchId = topSchId;
    }

    public Long getSchId() {
        return schId;
    }

    public void setSchId(Long schId) {
        this.schId = schId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }
}
