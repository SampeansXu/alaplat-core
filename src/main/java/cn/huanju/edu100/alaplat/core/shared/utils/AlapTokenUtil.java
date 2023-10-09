package cn.huanju.edu100.alaplat.core.shared.utils;


import cn.huanju.edu100.alaplat.core.exception.TokenInvalidException;
import cn.huanju.edu100.alaplat.core.shared.jwt.AuthToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author hexiangtao
 * @create 2020/7/2 15:22
 */
public class AlapTokenUtil {

    /**
     * token请求头
     */
    private static final String TOKEN_HEADER = "alap-token";

    /**
     * token解密密钥
     */
    private static final String TOKEN_SECRET = "@!&alap-gateway-token^&*";

    /**
     * SUBJECT
     */
    private static final String JWT_SUBJECT = "alap-gateway-token";

    /**
     * 过期时间(单位：毫秒)
     */
    private static final long EXPIRE_MILLS = 2 * 24 * 60 * 60 * 1000L;

    interface ClaimKey {
        String TopSchId = "topSchId";
        String SchId = "schId";
        String AppId = "appId";
        String Platform = "platform";
        String Uid = "uid";
        String UName = "uName";
        String LoginTime = "loginTime";
    }

    private static Long getClaimsLong(Map<String, Object> claims, String key, Long defVal) {
        if (Objects.isNull(claims)
                || !claims.containsKey(key)
                || !StringUtils.isNumeric(claims.get(key).toString())) {
            return defVal;
        }

        return Long.valueOf(claims.get(key).toString());

    }

    private static String getClaimsStr(Map<String, Object> claims, String key, String defVal) {
        if (Objects.isNull(claims)
                || !claims.containsKey(key)) {
            return defVal;
        }

        return claims.get(key).toString();
    }

    /**
     * 解析授权的 alap-token 字符串
     *
     * @param alapToken
     * @return
     */
    public static AuthToken parseAlapToken(String alapToken) {
        Claims claims = parseAlapClaims(alapToken);

        AuthToken authToken = buildAuthTokenByInit(claims);

        parseAndFillAuthToken(authToken, claims);

        return authToken;
    }

    private static Claims parseAlapClaims(String alapToken) {
        if (StringUtils.isBlank(alapToken)) {
            throw new TokenInvalidException("认证信息不能为空", AlapTokenUtil.class);
        }
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(alapToken).getBody();
        } catch (ExpiredJwtException err) {
            throw new TokenInvalidException("认证已过期, 请重新登录", AlapTokenUtil.class);
        } catch (Exception err) {
//            log.error("parseJwtClaims_error, error: {}, token: {}", err.toString(), jwtToken);
            throw err;
        }

        if (claims == null) {
            throw new TokenInvalidException("解析认证信息失败", AlapTokenUtil.class);
        }

        return claims;
    }


    private static AuthToken buildAuthTokenByInit(Claims claims) {
        Long schId = getClaimsLong(claims, ClaimKey.SchId, 0L);
        Long uid = getClaimsLong(claims, ClaimKey.Uid, 0L);
        if (schId <= 0L || uid < 0L) {
            // uid 可以为0, 表示是公共访问的用户
            throw new TokenInvalidException("认证信息不完整", AlapTokenUtil.class);
        }

        return new AuthToken(schId, uid);
    }

    private static void parseAndFillAuthToken(AuthToken authToken, Claims claims) {
        String appId = getClaimsStr(claims, ClaimKey.AppId, "");
        String uName = getClaimsStr(claims, ClaimKey.UName, "");
        Long loginTime = getClaimsLong(claims, ClaimKey.LoginTime, 0L);

        authToken.setAppId(appId);
        authToken.setuName(uName);
        authToken.setLoginTime(loginTime);
    }

    public static boolean checkAlapToken(String alapToken){
        if(StringUtils.isBlank(alapToken)){
            return false;
        }

        try{
            parseAlapClaims(alapToken);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    /**
     * 根据用户认证授权信息生成 jwt-token 字符串
     *
     * @param authToken
     * @return
     */
    public static String generateJwtToken(AuthToken authToken) {
        if (authToken == null || authToken.getUid() == null || authToken.getSchId() == null) {
            throw new TokenInvalidException("认证信息不正确");
        }

        Map<String, Object> claims = new HashMap<>(20);
        claims.put(ClaimKey.TopSchId, authToken.getTopSchId());
        claims.put(ClaimKey.SchId, authToken.getSchId());
        claims.put(ClaimKey.AppId, authToken.getAppId());
        claims.put(ClaimKey.Platform, authToken.getPlatform());
        claims.put(ClaimKey.Uid, authToken.getUid());
        claims.put(ClaimKey.UName, authToken.getuName());
        if (authToken.getLoginTime() <= 0L) {
            claims.put(ClaimKey.LoginTime, System.currentTimeMillis());
        } else {
            claims.put(ClaimKey.LoginTime, authToken.getLoginTime());
        }

        String token = Jwts.builder()
                .setSubject(JWT_SUBJECT)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_MILLS))
                .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET).compact();
        return token;
    }

    private AlapTokenUtil() {
    }
}
