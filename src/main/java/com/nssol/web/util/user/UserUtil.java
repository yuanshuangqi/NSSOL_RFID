package com.nssol.web.util.user;

import com.nssol.model.SecurityUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
public class UserUtil {
    /**
     * 获得加密后的密码
     * @return 加密后的密码
     */
    public static String getEncryptPassword(){
        return getEncryptPassword("111111");
    }

    /**
     * 生成32位md5码
     * @param password
     * @return
     */
    public static String getEncryptPassword(String password) {

        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
    /**
     * 生成32位编码
     * @return string
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }

    /**
     * 获取当前登录用户信息
     */
    public static SecurityUser getLoginInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        SecurityUser credentials = (SecurityUser) authentication.getCredentials();
        return credentials;
    }
}
