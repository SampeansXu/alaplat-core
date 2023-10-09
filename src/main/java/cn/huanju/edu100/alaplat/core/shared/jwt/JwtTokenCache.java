package cn.huanju.edu100.alaplat.core.shared.jwt;


import java.io.Serializable;

/**
 * jwt token在redis等缓存中的存储结构
 * @author lidelin 20200908
 */
public class JwtTokenCache implements Serializable {

    /**
     * 访问应用ID
     */
    private String appId;

    private String jwtToken;

    /**
     * 在缓存中的刷新时间
     */
    private long refreshTime;

    public JwtTokenCache() {
    }

    public JwtTokenCache(String jwtToken) {
        this.jwtToken = jwtToken;
        this.refreshTime = System.currentTimeMillis();
    }

    public JwtTokenCache(String appId, String jwtToken) {
        this.appId = appId;
        this.jwtToken = jwtToken;
        this.refreshTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "JwtTokenCache{" +
                "appId='" + appId + '\'' +
                ", jwtToken='" + jwtToken + '\'' +
                ", refreshTime=" + refreshTime +
                '}';
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public long getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(long refreshTime) {
        this.refreshTime = refreshTime;
    }
}
