package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "users")
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Cacheable(key = "#p0")
    public User selectUser(String id){
        System.out.println("select");
        return userMapper.findById(id);
    }

    @CachePut(key = "#p0")
    public void updateById(User user){
        System.out.println("update");
        userMapper.update(user);
    }

    // 如果 allEntries 指定为 true，则调用 CacheEvict 方法后将立即清除所有缓存
    @CacheEvict(key = "#p0", allEntries = true)
    public void deleteById(String id){
        System.out.println("delete");
        userMapper.deleteById(id);
    }
}
