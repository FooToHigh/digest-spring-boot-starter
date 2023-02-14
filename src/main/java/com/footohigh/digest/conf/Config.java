package com.footohigh.digest.conf;

import com.footohigh.digest.service.Digest;
import com.footohigh.digest.service.impl.Md5Digest;
import com.footohigh.digest.service.impl.ShaDigest;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(Settings.class)
public class Config {
    @Bean
    @ConditionalOnProperty(prefix = "digest",name = "type",havingValue = "md5")
    public Digest md5Digest(){
        System.out.println("md5加密准备就绪");
        return new Md5Digest();
    }


    @Bean
    @ConditionalOnProperty(prefix = "digest",name = "type",havingValue = "sha")
    public Digest shaDigest(){
        System.out.println("sha");
        return new ShaDigest();
    }
}
