package cn.hg.demo.util;

import org.springframework.util.DigestUtils;

public class TokenFatory {

    public static String  createToken(){
        return DigestUtils.md5DigestAsHex((System.currentTimeMillis()+"").getBytes());
    }

}
