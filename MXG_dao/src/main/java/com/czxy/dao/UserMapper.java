package com.czxy.dao;

import com.czxy.domain.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

    /**
     * 注册
     * @param user
     * @return
     */
    @Select("select * from user where username=#{username}")
    public User register(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    @Select("select * from user where username=#{username} and password=#{password} ")
    public User login(User user);
}
