package cn.luoyanze.documentmanager.common.util;

import cn.luoyanze.documentmanager.common.model.TokenResult;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/3 10:09 PM
 */

public class TokenUtil {
    private static final byte[] SECRET = "77d81055-3f5e-4db3-ac33-8a5e58f14c22".getBytes();

    private static final long EXPIRE_TIME = 1000L * 60 * 60 * 24 * 30;

    public static String buildJWT(String account) {
        try {
            // 1.创建一个32-byte的密匙
            MACSigner macSigner = new MACSigner(SECRET);
            // 2. 建立payload 载体
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject("81699180-649b-4a7a-95e8-1687a5656b43")
                    .issuer("38e9d406-5820-4104-a637-f3138a84213e")
                    .expirationTime(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                    .claim("ACCOUNT",account)
                    .build();
            // 3. 建立签名
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(macSigner);

            // 生成token
            return signedJWT.serialize();
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static TokenResult vaildToken(String token, String username) {
        try {
            SignedJWT jwt = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(SECRET);
            //校验是否有效
            if (!jwt.verify(verifier)) {
                return TokenResult.ILLEGAL;
            }
            //校验超时
            Date expirationTime = jwt.getJWTClaimsSet().getExpirationTime();
            if (new Date().after(expirationTime)) {
                return TokenResult.EXPIRE;
            }
            //获取载体中的数据
            Object account = jwt.getJWTClaimsSet().getClaim("ACCOUNT");
            //是否有openUid
            if (Objects.isNull(account)){
                return TokenResult.ILLEGAL;
            }

            if (account.toString().equals(username)) {
                return TokenResult.SUCCESS;
            }
        } catch (ParseException | JOSEException e) {
            e.printStackTrace();
        }
        return TokenResult.FAIL;
    }

}
