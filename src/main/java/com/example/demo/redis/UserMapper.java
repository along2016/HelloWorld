package com.example.demo.redis;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    @Insert("insert into user(name,age) values (#{name}, #{age})")
    int addUser(@Param("name") String name, @Param("age") String age);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") String id);

    @Update("update user set name=#{name}, age=#{age} where id=#{id}")
    int update(User user);

    @Delete("delete from user where id=#{id}")
    void deleteById(@Param("id") String id);
}
