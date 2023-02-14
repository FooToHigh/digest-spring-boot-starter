package com.footohigh.digest.service.impl;

import com.footohigh.digest.service.Digest;
import org.apache.commons.codec.digest.DigestUtils;


public class ShaDigest implements Digest {
    @Override
    public String digest(String raw) {
        System.out.println("使用了sha算法加密");
        return DigestUtils.sha256Hex(raw);
    }
}
