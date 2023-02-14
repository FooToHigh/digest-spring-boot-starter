package com.footohigh.digest.conf;

import com.footohigh.digest.service.Digest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ConfigTest {

    @Autowired
    private Digest md5;
    @Test
    public void test1(){
        System.out.println(md5.digest("nihao"));
    }

}