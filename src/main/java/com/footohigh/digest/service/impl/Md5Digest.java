package com.footohigh.digest.service.impl;

import com.footohigh.digest.service.Digest;
import org.apache.commons.codec.digest.DigestUtils;


public class Md5Digest implements Digest {
    @Override
    public String digest(String raw) {
        System.out.println("使用了md5算法加密");
        return DigestUtils.md5Hex(raw);
    }
}
