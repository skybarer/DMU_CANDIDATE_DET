package com.hcl.dmu.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author : akashdhar
 * @date : 02-02-2020
 * @time : 01:34 PM
 */
public class QuickPasswordEncodingGenerator {
    public static void main(String[] args) {
        String password = "abc123";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(password));
    }
}
