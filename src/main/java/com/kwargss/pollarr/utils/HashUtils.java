package com.kwargss.pollarr.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Component
public class HashUtils {

    public String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
