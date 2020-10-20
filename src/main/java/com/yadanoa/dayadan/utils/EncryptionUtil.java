package com.yadanoa.dayadan.utils;

import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.HashMap;
import java.util.Map;

public class EncryptionUtil {

    /***
     * md5加密2次
     * @param pwd
     * @return
     */
    public String encryption (String pwd,String username){
        //String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        String password = new Md5Hash(pwd,username,2).toString();
        //String password = new Md5Hash(pwd,2).toString();
        Map<String,String> map = new HashMap<String,String>();
        //map.put("salt",salt);
        //map.put("password",password);
        return password;
    }
}
