package org.aptech.t2311e.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.aptech.t2311e.exception.BussinessException;
import org.springframework.http.HttpStatus;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.lang.invoke.MethodHandles;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class JWTUtils {

    private static final String SECRET_KEY = "t2311emysecretkey423523556352353453344444444444444";

    public static void main(String[] args) throws BussinessException, NoSuchAlgorithmException, InvalidKeyException {
//        String genToken  = genToken("admin");
//        System.err.println("token generate : "+ genToken);
//        validateToken(genToken);
    }
    public static String genToken(String username){
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 900000)) // hết hạn sau 15 phút
                .signWith(SignatureAlgorithm.HS256 , SECRET_KEY) // deprecated
                .compact();
    }
    public static void validateToken(String token) throws BussinessException {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            System.err.println(claims.getSubject());
            System.err.println(claims.getIssuedAt());
            System.err.println(claims.getExpiration());
        } catch (Exception ex) {
            System.err.println("Invalid token ");
            throw new BussinessException("Invalid Credential", "500", HttpStatus.BAD_REQUEST);
        }
    }
    /*
    UC ĐĂNG NHẬP
      user nhập username và password -> trả ra accessToken (dùng để truy cập trong phiên
     ) + refreshToken  (dùng khi phiên đã hết hạn để xin accesstoken và refreshToken mới)
     refresh token bao h cũng có ttl lớn hơn so với accessToken.
    nhận accessToken  -> get subject (username) -> username tồn tại
    -> check  signature valid hay ko -> check expired hay chưa -> nếu expire trả ra lỗi expired
     */

    // mã hóa sử dụng HS256  ,THƯỜNG SỬ DỤNG MÃ HÓA CHỒNG


    public static byte[] hs256(byte[] key, String data) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac macHs256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec spec = new SecretKeySpec(key,"HmacSHA256");
        macHs256.init(spec);
        return macHs256.doFinal(data.getBytes(StandardCharsets.UTF_8));
    }
    private static String base64Encode(byte[] input){
        return Base64.getUrlEncoder().withoutPadding().encodeToString(input);
    }
    private static String base64Encode(String input){
        return base64Encode(input.getBytes(StandardCharsets.UTF_8));
    }
    public static String genAccessToken(String[] strs){
        return "";
    }


    public static boolean verifyToken(String token) throws NoSuchAlgorithmException, InvalidKeyException {
        String[] tokenPart = token.split("\\.");

        // neu khac 3 phan  -> loi
        if(tokenPart.length != 3){
            return false;
        }

        String header = tokenPart[0];
        String payloadB64 = tokenPart[1];
        String signature = tokenPart[3];
        String headerPayload = header + "."+payloadB64;
        // nhan header lay thuat  toan  + email  .....
        byte[] expectedSignature = hs256(SECRET_KEY.getBytes(StandardCharsets.UTF_8),headerPayload);
        // fix : sử dụng độ phức tạp mã hóa cao hơn  -> mã hóa chồng với 1 thuật toán mã hóa mạnh hơn

        String B64encodeStr = base64Encode(expectedSignature);
        // check xem B64encodeStr va signature co y het nhau hay ko ???
        if(!compareTwoString(B64encodeStr,signature)){
            return false;
        }

        // todo -> signature client truyền lên là valid

        // check xem username co ton tai hay ko
        String username  = getUsernameFromJson(payloadB64);

        // check expired

        byte[] payloadBytes = Base64.getUrlDecoder().decode(payloadB64);
        String payloadJson  = new String (payloadBytes,StandardCharsets.UTF_8);
        /*
        {
            "sub": "admin",
            "iat": 1759757685,
            "exp": 1759758585
        }
         */
        Long expireTime = getExpireTimeFromJson(payloadJson);
        if(expireTime == null){
            return false;
        }

        if(System.currentTimeMillis() > expireTime){
            return false;
        }
        return true;
    }
    private static boolean compareTwoString(String a, String b){
        if(a.length() != b.length()) return false;
        for (int i = 0 ; i  < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                return false;
            }
        }
        return true;
    }

    private static Long getExpireTimeFromJson(String jsonStr){
        // todo : viet function parse string ra json va lay ra gia tri expire time

        return System.currentTimeMillis();
    }
    private static String getUsernameFromJson(String jsonStr){
        // todo : viet function parse string ra json va lay ra gia tri subject

        return null;
    }


    public static String getUsernameFromToken(String token){
        // todo : write code
        return "";
    }



}
