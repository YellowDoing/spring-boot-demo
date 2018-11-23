package cn.hg.demo.util;

import org.springframework.util.DigestUtils;

public class TokenFactory {

    public static String  createToken(){
        return DigestUtils.md5DigestAsHex((System.currentTimeMillis()+"").getBytes());
    }
}
