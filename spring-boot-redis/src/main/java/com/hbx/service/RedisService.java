package com.hbx.service;

public interface RedisService {

    String saveValue(String key, String value);

    String getValue(String key);


}
